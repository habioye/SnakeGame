import java.util.ArrayList;

public class Snake {
    int snakeX;
    int snakeY;

    int scaledTileSize;
    ArrayList<SnakeTile> tilePositions;

    int snakeSpeed;
    
    SnakeGame.Dir direction;
    TilePosition head;
    TilePosition tail;


    class TilePosition {
        int position;
        int next;
    }

    public Snake(int x, int y, int speed, int scaledTileSize, int startPosition, SnakeGame.Dir direction) {
        snakeX = x;
        snakeY = y;
        this.scaledTileSize = scaledTileSize;
        tilePositions = new ArrayList<>();

        tilePositions.add(new SnakeTile(scaledTileSize, startPosition));

    }


    public int getSnakeX() {
        // todo x = p % r
        return snakeX;
    }

    public int getSnakeY() {
        // todo y = p //r
        return snakeY;
    }


    public ArrayList<SnakeTile> getTilePositions() {

        return tilePositions;
    }

    // todo
    public void addTilePosition(int position) {
        tilePositions.add(new SnakeTile(scaledTileSize, position));
    }

    public void addTileToHead(int position) {
        tilePositions.add(0, new SnakeTile(scaledTileSize, position));
    }

    public void removeTailTile() {
        tilePositions.remove(tilePositions.size()-1);
    }
}
