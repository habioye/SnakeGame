import java.util.ArrayList;

public class FoodGeneration {
    
    private static int currentPosition = -1;

    public static boolean foodExists() {
        if(currentPosition == -1) return false;
        else return true;
    }

    public static int generateFood(ArrayList<Integer> unoccupiedTiles, int scaledTileSize) {
        if(!foodExists()) {
            int position = (int) (Math.random()*unoccupiedTiles.size());
            System.out.println(position + " " + unoccupiedTiles.size());
            currentPosition = position;
            return unoccupiedTiles.get(position);
        }
        return -1;
    }

    public static int getCurrentPosition() {
        return currentPosition;
    }
}
