public class SnakeTile extends Tile {
    
    private int position;

    SnakeTile(int scaledSize, int position) {
        super(scaledSize);
        this.position = position;
    }

    public int getPosition() {
        return position;
    }
}
