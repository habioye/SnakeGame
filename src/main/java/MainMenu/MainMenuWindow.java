package MainMenu;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

@SuppressWarnings("serial")
public class MainMenuWindow extends JFrame implements ActionListener {

	static final int FRAME_X = 750;
	static final int FRAME_Y = FRAME_X;
	static final Font HEADER_FONT = new Font("Dialog", Font.BOLD, 48);
	static final Font BUTTON_FONT = new Font("Dialog", Font.BOLD, 24);

	// Swing components we'll be using
	JPanel northPanel, centerPanel, southPanel;
	JLabel headerText;
	JButton easyButton, mediumButton, hardButton;
	JSlider musicSlider, soundSlider;

	MainMenuWindow() {
		super("Snake Game"); // Sets window text

		// Configure window settings
		setSize(FRAME_X, FRAME_Y);
		setLayout(new BorderLayout());
		// setResizable(false); // Disables resizing window
		setLocationRelativeTo(null); // Centers window
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Terminates program when window is closed

		// Instantiate Swing components for north section
		northPanel = new JPanel();
		headerText = new JLabel("🐍  Snake  🐍");
		headerText.setFont(HEADER_FONT);

		northPanel.add(headerText);

		add(northPanel, BorderLayout.NORTH);

		// Instantiate Swing components for center section
		centerPanel = new JPanel();
		easyButton = new JButton("Easy");
		mediumButton = new JButton("Medium");
		hardButton = new JButton("Hard");

		centerPanel.setLayout(new GridLayout(3, 1));

		// Configure buttons
		JButton[] buttons = { easyButton, mediumButton, hardButton };
		for (JButton btn : buttons) {
			btn.setPreferredSize(new Dimension(200, 50));
			btn.setFont(BUTTON_FONT);
			btn.setFocusable(false); // Disables highlight when button is clicked
			btn.setRolloverEnabled(false); // Disables hover effect
			btn.addActionListener(e -> startGame(btn));
			centerPanel.add(btn);
		}

		easyButton.setBackground(Color.GREEN);
		mediumButton.setBackground(Color.YELLOW);
		hardButton.setBackground(Color.RED);

		add(centerPanel, BorderLayout.CENTER);

		// Instantiate Swing components for south section
		southPanel = new JPanel();
		musicSlider = new JSlider(0, 100, 80);
		soundSlider = new JSlider(0, 100, 80);

		musicSlider.setValue(80);
		soundSlider.setValue(80);

		southPanel.add(musicSlider);
		southPanel.add(soundSlider);

		add(southPanel, BorderLayout.SOUTH);

		// Draw the window
		setVisible(true);
	}

	public void startGame(JButton button) {
		if (button == easyButton) {
			System.out.println("Start easy game");
			System.out.println(musicSlider.getValue());
		} else if (button == mediumButton) {
			System.out.println("Start medium game");
		} else if (button == hardButton) {
			System.out.println("Start hard game");
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		System.out.println(source);
	}

	public static void main(String[] args) {
		new MainMenuWindow();
	}

}
