import javax.swing.JFrame;

public class SnakeGame {
    // deque snake body
    // ArrayList<ArrayList<int>> grid;


    // public void display(Arraylist grid) {

    // }
    // // generate fruit logic
    // public FruitData generatefruits() {

    // }
    // // generate obstacles logic
    // public ObstacleData generateobstacles() {

    // }
    // public PowerupData generatePowerup() {

    // }
    // public inputData getInput() {

    // }
    // public collisionData detectCollision() {

    // }
    // public void generateDebuffs() {

    // }
    public float frametime;


    public static void main (String[] args) {

        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("Snake Game");

        DisplayPanel panel = new DisplayPanel();
        window.add(panel);

        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);

    }
}