import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

@SuppressWarnings("serial")
public class MainMenuWindow extends JFrame implements ActionListener {

	static final int FRAME_SIZE = 500;
	static final Font BUTTON_FONT = new Font("Arial", Font.BOLD, 24);

	MainMenuWindow() {
		super("Snake Game"); // Sets window text

		// Configure window settings
		setSize(FRAME_SIZE, FRAME_SIZE);
		setLayout(new BorderLayout());
		setResizable(false); // Disables resizing window
		setLocationRelativeTo(null); // Centers window
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Terminates program when window is closed

		// Instantiate Swing components for north section
		JPanel northPanel = new JPanel();
		JLabel headerText = new JLabel("🐍  Snake  🐍");
		headerText.setFont(headerText.getFont().deriveFont(36f));

		northPanel.add(headerText);

		add(northPanel, BorderLayout.NORTH);

		// Instantiate Swing components for center section
		JPanel centerPanel = new JPanel();
		JButton easyButton = new JButton("Easy");
		JButton mediumButton = new JButton("Medium");
		JButton hardButton = new JButton("Hard");
		JButton[] buttons = { easyButton, mediumButton, hardButton };

		// Configure buttons
		for (JButton b : buttons) {
			b.setFont(BUTTON_FONT);
			b.addActionListener(e -> startGame(b));
			centerPanel.add(b);
		}

		add(centerPanel, BorderLayout.CENTER);

		// Draw the window
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		System.out.println();
	}

	public void startGame(JButton button) {
		if (button.getText() == "Easy") {
			System.out.println("Start easy game");
		} else if (button.getText() == "Medium") {
			System.out.println("Start medium game");
		} else if (button.getText() == "Hard") {
			System.out.println("Start hard game");
		}
	}

	public static void main(String[] args) {
		new MainMenuWindow();
	}

}
