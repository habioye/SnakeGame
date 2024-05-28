import java.util.ArrayList;

public class FoodGeneration {
    
    private static int currentPosition;

    public static boolean foodExists() {
        if(currentPosition == -1) return false;
        else return true;
    }

    public static void generateFood(ArrayList<Tile> tiles) {
        if(!foodExists()) {
            for(Tile t: tiles) {
                if()
            }
        }
        return;
    }
}
