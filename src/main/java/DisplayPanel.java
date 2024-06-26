import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyAdapter;
import java.util.ArrayList;
import java.awt.Color;

import javax.swing.JPanel;

/**
 * DisplayPanel
 */
public class DisplayPanel extends JPanel implements Runnable {

    // Game Loop Thread
    Thread gameLoop;

    // SCREEN SETTINGS 
    final int tileSize = 16; // 16x16 tiles
    final int scale = 3;

    final int scaledTileSize = tileSize * scale; // 48x48 tiles
    final int maxScreenColumns = 17;
    final int maxScreenRows = 13;
    final int screenWidth = (scaledTileSize * maxScreenColumns); // 768 px
    final int screenHeight = scaledTileSize * maxScreenRows;   // 576 px

    // DEFAULT SNAKE SETTINGS
    int snakeX = 0;   // used to update snake x position.
    int snakeY = 0;   // used to update snake y position.
    int snakeSpeed = 4; // used to adjust snake default speed.
    int snakeStartPosition = (maxScreenRows*maxScreenColumns)/2;
    Snake snake;
    int movedir;

    // GAME LOOP SETTINGS
    final int FPS = 30;

    // KEY HANDLER
    MoveHandler movement = new MoveHandler();

    // TILE ARRAY
    ArrayList<Tile> allTiles = new ArrayList<>();

    public DisplayPanel(SnakeGame.Dir direction) {


        for(int i = 0; i < maxScreenColumns*maxScreenRows; i++) {
            allTiles.add(new Tile(scaledTileSize));
        }
        allTiles.remove(snakeStartPosition);
        allTiles.add(snakeStartPosition, new SnakeTile(scaledTileSize, snakeStartPosition));

        this.snake = new Snake(snakeX, snakeY, snakeSpeed, 
        scaledTileSize, snakeStartPosition, direction);
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true); // all drawing from this component will be
                                            // done in an offscreen painting buffer
        this.addKeyListener(movement);
        this.setFocusable(true);
        this.setVisible(true);

    }

    public void startGameThread() {
        // Thread created to run game loop.
        gameLoop = new Thread(this);
        gameLoop.start();
    }

    public void run() {

        // Make the thread draw only at a certain
        // speed aka FPS. If FPS set at 60, then 
        // draw only 60 times a second.
        double redrawInterval = 1000000000/FPS;
        double delta = 0;
        long lastTimeDrawn = System.nanoTime();
        long currentTime;





        while(gameLoop != null) {

            currentTime = System.nanoTime();
            delta += (currentTime - lastTimeDrawn) / redrawInterval;
            lastTimeDrawn = currentTime;

            if(delta >= 1) {

                // Spawn food if needed.
                checkFoodSpawn();
                
                // Update position of snake, food, and moving enemies.
                updatePosition();
                
                // Repaint the component every iteration of the loop.
                repaint();
                delta--;
            }
        }

    }
    public boolean opposites(int x, int y) {
        if (y < x) {
            int tmp  = y;
            y = x;
            x = tmp;
        }
        if (x == 0 && y == 3) {
            return true;
        }
        if (x ==1 && y ==2) return true;
        return false;
    }

    public void checkFoodSpawn() {
        int newFoodPos = FoodGeneration.generateFood(getUnoccupiedTiles(), scaledTileSize);
        if(newFoodPos <= -1) return;
        else {
            allTiles.remove(newFoodPos);
            allTiles.add(newFoodPos, new FoodTile(scaledTileSize, newFoodPos));
        }
    }

    public void tryToMove(int newPos) {

        if(newPos < 0 || newPos > allTiles.size()-1) return;

        snake.addTileToHead(newPos);

        if(allTiles.get(newPos) instanceof FoodTile) {
            FoodGeneration.resetFoodPosition();
            allTiles.remove(newPos);
            allTiles.add(newPos, new SnakeTile(scaledTileSize, newPos));
            return;
        }
        
        allTiles.remove(newPos);
        allTiles.add(newPos, new SnakeTile(scaledTileSize, newPos));

        int tailPosition = snake.getTilePositions().get(snake.getTilePositions().size()-1).getPosition();
        snake.removeTailTile();
        allTiles.remove(tailPosition);
        allTiles.add(tailPosition, new Tile(scaledTileSize));
        return;
    }

    // updatePosition() will update the snakes position,
    // the food position, powerup position, moving enemies,
    // etc.
    public void updatePosition() {

        if(movement.getUp() == true) {
            int headPos = snake.getTilePositions().get(0).getPosition();
            int newPos = headPos-maxScreenColumns;
            tryToMove(newPos);
        }
        else if(movement.getDown() == true) {
            int headPos = snake.getTilePositions().get(0).getPosition();
            int newPos = headPos+maxScreenColumns;
            tryToMove(newPos);
        }
        else if(movement.getLeft() == true) {
            int headPos = snake.getTilePositions().get(0).getPosition();
            int newPos = headPos-1;
            if(headPos%maxScreenColumns == 0) return;
            tryToMove(newPos);
        }
        else if(movement.getRight() == true) {
            int headPos = snake.getTilePositions().get(0).getPosition();
            int newPos = headPos+1;
            if((headPos+1)%maxScreenColumns == 0) return;
            tryToMove(newPos);


        }
        return;
    }

    // paintComponent() will be used to redraw the graphics
    // of the component on every tick to respond to changes
    // made such as moving enemies or new food positions.
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D)g;

        // Draw every single tile on the map.
        for(int i = 0; i < allTiles.size(); i++) {
            int row = i/maxScreenColumns;
            int column = i%maxScreenColumns;
            g2.setColor(Color.WHITE);
            g2.fillRect(column*scaledTileSize, row*scaledTileSize, scaledTileSize, scaledTileSize);
            g2.setColor(Color.BLACK);
            g2.fillRect(column*scaledTileSize+2, row*scaledTileSize+2, scaledTileSize-4, scaledTileSize-4);

        }
        
        // Draw over every single tile that
        // the snake inhabits. 
        // for(SnakeTile t: snake.getTilePositions()) {
        //     int row = t.getPosition()/16;
        //     int column = t.getPosition()%16;
        //     g2.fillRect(column*scaledTileSize, row*scaledTileSize, scaledTileSize, scaledTileSize);
        // }

        for(Tile t: allTiles) {
            if(t instanceof SnakeTile) {
                g2.setColor(Color.GREEN);
                int row = ((SnakeTile)t).getPosition()/maxScreenColumns;
                int column = ((SnakeTile)t).getPosition()%maxScreenColumns;
                g2.fillRect(column*scaledTileSize, row*scaledTileSize, scaledTileSize, scaledTileSize);
            }
            else if(t instanceof FoodTile) {
                g2.setColor(Color.ORANGE);
                int row = ((FoodTile)t).getPosition()/maxScreenColumns;
                int column = ((FoodTile)t).getPosition()%maxScreenColumns;
                g2.fillRect(column*scaledTileSize, row*scaledTileSize, scaledTileSize-6, scaledTileSize-6);
            }
        }

        g2.dispose();
    }

    public ArrayList<Integer> getUnoccupiedTiles() {
        ArrayList<Integer> listOfPositions = new ArrayList<>();
        for(int i = 0; i < allTiles.size(); i++) {
            Tile t = allTiles.get(i);
            if(!(t instanceof SnakeTile) && !(t instanceof FoodTile)) {
                listOfPositions.add(i);
            }
        }
        return listOfPositions;
    }

}