public class SnakeTile extends Tile {
    
    int position;

    SnakeTile(int scaledSize, int position) {
        super(scaledSize);
        this.position = position;
    }

    public int getPosition() {
        return position;
    }
}
