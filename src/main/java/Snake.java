import java.util.ArrayList;

public class Snake {
    int snakeX;
    int snakeY;
    int snakeSpeed;
    ArrayList<Integer> tilePositions; // todo instead of integers we could use the tileposition class
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
        snakeSpeed = speed;
        tilePositions = new ArrayList<>();
        tilePositions.add(startPosition);
        this.direction = direction;
        // todo I wanted to add the head and tail with the tileposition and the next one
    }

    public int getSnakeSpeed() {
        return snakeSpeed;
    }

    public int getSnakeX() {
        // todo x = p % r
        return snakeX;
    }

    public int getSnakeY() {
        // todo y = p //r
        return snakeY;
    }

    public ArrayList<Integer> getTilePositions() {
        // todo we can get the class instead of the integer
        return tilePositions;
    }

    // todo
    public void addTilePosition(int position) {
        tilePositions.add(position);
    }
}
