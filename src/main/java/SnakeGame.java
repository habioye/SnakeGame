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


    public static void main (String[] args) throws Exception {
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


//        for (int i = 0; i < 10; i++) {
//
//        };
//        System.out.println("stamp");
//
        myJFrame.setVisible(true);
//        System.out.println("Press arrow keys (↑ ↓ ← →) or 'q' to quit:");
//
//        while (true) {
//            int input = System.in.read(); // Read a single character from standard input
//
//            if (input == 27) { // Check if the character is the escape character
//                // Read the next two characters to identify arrow key sequences
//                int next1 = System.in.read();
//                int next2 = System.in.read();
//
//                if (next1 == 91) { // ASCII code for '['
//                    switch (next2) {
//                        case 65:
//                            System.out.println("Up arrow key pressed");
//                            break;
//                        case 66:
//                            System.out.println("Down arrow key pressed");
//                            break;
//                        case 67:
//                            System.out.println("Right arrow key pressed");
//                            break;
//                        case 68:
//                            System.out.println("Left arrow key pressed");
//                            break;
//                        default:
//                            System.out.println("Unknown escape sequence");
//                            break;
//                    }
//                }
//            } else if (input == 'q' || input == 'Q') { // Quit if 'q' or 'Q' is pressed
//                break;
//            }
//        }
//        Scanner scanner = new Scanner(System.in);
//        String input = "some";
//        input = scanner.nextLine();
//        System.out.println(input);
//        System.out.println(input.length());

//        input = "something";
//        System.out.println(input);

//        int direction = 0;
//        Thread checkinput = new Thread(()-> {
//            while (true) {
//                try {
//                    Thread.sleep(166);
//
//                } catch (InterruptedException e) {
//                    System.err.println(e);
//                }
//            }
//        });

        // main game loop
//        while (true) {
//
//
//        }

    }
}