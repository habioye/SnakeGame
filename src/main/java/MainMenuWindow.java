import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

@SuppressWarnings("serial")
public class MainMenuWindow extends JFrame implements ActionListener {

	final int FRAME_SIZE = 500;
	final Font BUTTON_FONT = new Font("Arial", Font.BOLD, 24);

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

		centerPanel.add(easyButton);
		centerPanel.add(mediumButton);
		centerPanel.add(hardButton);

		add(centerPanel, BorderLayout.CENTER);

		setVisible(true); // Draw the window
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();

	}

	public static void main(String[] args) {
		new MainMenuWindow();
	}

}
