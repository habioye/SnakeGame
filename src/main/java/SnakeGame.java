
import java.util.Scanner;
import java.io.IOException;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JFrame;

public class SnakeGame {
    // deque snake body
    // ArrayList<ArrayList<int>> grid;
    //snake direction
    public static int direction;


    // public void display(Arraylist grid) {
//   }


    
//    // generate fruit logic
    public FruitData generatefruits();
    // generate obstacles logic
    public ObstacleData generateobstacles();
    public PowerupData generatePowerup();
    public inputData getInput();
    public collisionData detectCollision();
    public void generateDebuffs();

    public float frametime;

    public static class Dir {
        int direction;

    }

    public static void main (String[] args) {
        JFrame window = new JFrame();
        final Dir direction = new Dir();

        direction.direction = 2;

        KeyAdapter keylisener = new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();
                if (keyCode == KeyEvent.VK_UP) {
                    direction.direction = 0;
                    System.out.println("Up Arrrow-Key is pressed!"+direction);
                } else if (keyCode == KeyEvent.VK_DOWN) {
                    direction.direction = 1;
                    System.out.println("Down Arrrow-Key is pressed!"+direction);
                } else if (keyCode == KeyEvent.VK_LEFT) {
                    direction.direction = 2;
                    System.out.println("Left Arrrow-Key is pressed!"+direction);
                } else if (keyCode == KeyEvent.VK_RIGHT) {
                    direction.direction = 3;
                    System.out.println("Right Arrrow-Key is pressed!"+direction);
                }

            }
        };
        window.addKeyListener(keylisener);




        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("Snake Game");

        DisplayPanel panel = new DisplayPanel(direction);
        window.add(panel);

        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);

        panel.startGameThread();


    }
}