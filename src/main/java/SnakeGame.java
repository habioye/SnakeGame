import java.util.Scanner;
import java.io.IOException;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;

class SnakeGame {

    // deque snake body
    // ArrayList<ArrayList<int>> grid;
    //snake direction
    public static int direction;


    public void display(Arraylist grid) {

    }
//    // generate fruit logic
    public FruitData generatefruits();
    // generate obstacles logic
    public ObstacleData generateobstacles();
    public PowerupData generatePowerup();
    public inputData getInput();
    public collisionData detectCollision();
    public void generateDebuffs();
    public float frametime;


    public static void main (String[] args) {
        JFrame myJFrame = new JFrame();

                    myJFrame.addKeyListener(new KeyAdapter() {
                        public void keyPressed(KeyEvent e) {
                            int keyCode = e.getKeyCode();
                            if (keyCode == KeyEvent.VK_UP) {
                                direction = 0;
                                System.out.println("Up Arrrow-Key is pressed!"+direction);
                            } else if (keyCode == KeyEvent.VK_DOWN) {
                                direction = 1;
                                System.out.println("Down Arrrow-Key is pressed!"+direction);
                            } else if (keyCode == KeyEvent.VK_LEFT) {
                                direction = 2;
                                System.out.println("Left Arrrow-Key is pressed!"+direction);
                            } else if (keyCode == KeyEvent.VK_RIGHT) {
                                direction = 3;
                                System.out.println("Right Arrrow-Key is pressed!"+direction);
                            }

                        }
                    });



        myJFrame.setVisible(true);

    }
}