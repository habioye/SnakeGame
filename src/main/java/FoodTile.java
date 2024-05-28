public class FoodTile extends Tile {
    
    int position;

    FoodTile(int scaledSize, int position) {
        super(scaledSize);
        this.position = position;
    }

    public int getPosition() {
        return position;
    }
}
