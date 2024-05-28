import java.util.ArrayList;

public class Snake {
    int snakeX;
    int snakeY;
    int snakeSpeed;
    ArrayList<Integer> tilePositions;

    public Snake(int x, int y, int speed, int scaledTileSize, int startPosition) {
        snakeX = x;
        snakeY = y;
        snakeSpeed = speed;
        tilePositions = new ArrayList<>();
        tilePositions.add(startPosition);
    }

    public int getSnakeSpeed() {
        return snakeSpeed;
    }

    public int getSnakeX() {
        return snakeX;
    }

    public int getSnakeY() {
        return snakeY;
    }

    public ArrayList<Integer> getTilePositions() {
        return tilePositions;
    }

    public void addTilePosition(int position) {
        tilePositions.add(position);
    }
}
