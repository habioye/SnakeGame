import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
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
    int snakeStartPosition = (maxScreenRows*(maxScreenColumns/2));
    Snake snake;

    // GAME LOOP SETTINGS
    final int FPS = 30;

    // TILE ARRAY
    ArrayList<Tile> allTiles = new ArrayList<>();

    public DisplayPanel() {

        for(int i = 0; i < maxScreenColumns*maxScreenRows; i++) {
            allTiles.add(new Tile(scaledTileSize));
        }

        this.snake = new Snake(snakeX, snakeY, snakeSpeed, 
        scaledTileSize, snakeStartPosition);
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true); // all drawing from this component will be
                                            // done in an offscreen painting buffer
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
                // Update position of snake, food, and moving enemies.
                updatePosition();
                
                // Repaint the component every iteration of the loop.
                repaint();
            }
        }

    }

    // updatePosition() will update the snakes position,
    // the food position, powerup position, moving enemies,
    // etc.
    public void updatePosition() {
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
        g2.setColor(Color.GREEN);
        for(int position: snake.getTilePositions()) {
            int row = position/16;
            int column = position%16;
            g2.fillRect(column*scaledTileSize, row*scaledTileSize, scaledTileSize, scaledTileSize);
        }
        g2.dispose();
    }

}