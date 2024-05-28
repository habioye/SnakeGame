import java.util.ArrayList;

public class Snake {
    int snakeX;
    int snakeY;
    int scaledTileSize;
    ArrayList<SnakeTile> tilePositions;

    public Snake(int x, int y, int speed, int scaledTileSize, int startPosition) {
        snakeX = x;
        snakeY = y;
        this.scaledTileSize = scaledTileSize;
        tilePositions = new ArrayList<>();
        tilePositions.add(new SnakeTile(scaledTileSize, startPosition));
    }


    public int getSnakeX() {
        return snakeX;
    }

    public int getSnakeY() {
        return snakeY;
    }

    public ArrayList<SnakeTile> getTilePositions() {
        return tilePositions;
    }

    public void addTilePosition(int position) {
        tilePositions.add(new SnakeTile(scaledTileSize, position));
    }

    public void addTileToHead(int position) {
        tilePositions.add(0, new SnakeTile(scaledTileSize, position));
    }
}
