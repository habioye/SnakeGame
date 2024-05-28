import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

@SuppressWarnings("serial")
public class MainMenuWindow extends JFrame implements ActionListener {

	static final int FRAME_X = 800;
	static final int FRAME_Y = 300;
	static final Font HEADER_FONT = new Font("Dialog", Font.BOLD, 48);
	static final Font BUTTON_FONT = new Font("Dialog", Font.BOLD, 24);
	static final Font SOUTH_FONT = new Font("Dialog", Font.BOLD, 24);

	// Swing components we'll be using
	JPanel northPanel, centerPanel, southPanel;
	JLabel headerLabel, musicLabel, soundLabel;
	JButton easyButton, mediumButton, hardButton, exitButton;
	JSlider musicSlider, soundSlider;

	MainMenuWindow() {
		super("Snake Launcher"); // Sets window text

		// Configure window settings
		setSize(FRAME_X, FRAME_Y);
		setLayout(new BorderLayout());
		setResizable(false); // Disables resizing window
		setLocationRelativeTo(null); // Centers window
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Terminates program when window is closed

		// Instantiate Swing components for north section
		northPanel = new JPanel();
		headerLabel = new JLabel("🐍   Snake Launcher   🐍");
		headerLabel.setFont(HEADER_FONT);

		northPanel.add(headerLabel);

		add(northPanel, BorderLayout.NORTH);

		// Instantiate Swing components for center section
		centerPanel = new JPanel();
		easyButton = new JButton("Easy");
		mediumButton = new JButton("Medium");
		hardButton = new JButton("Hard");
		exitButton = new JButton("Exit");

		// centerPanel.setLayout(new GridLayout(4, 1));

		// Configure buttons
		JButton[] buttons = { easyButton, mediumButton, hardButton, exitButton };
		for (JButton btn : buttons) {
			btn.setPreferredSize(new Dimension(200, 50));
			btn.setFont(BUTTON_FONT);
			btn.setFocusable(false); // Disables highlight when button is clicked
			// btn.setRolloverEnabled(false); // Disables hover effect
			btn.addActionListener(e -> actionPerformed(e));
			centerPanel.add(btn);
		}

		easyButton.setBackground(Color.GREEN);
		mediumButton.setBackground(Color.YELLOW);
		hardButton.setBackground(Color.RED);
		exitButton.setBackground(Color.WHITE);

		add(centerPanel, BorderLayout.CENTER);

		// Instantiate Swing components for south section
		southPanel = new JPanel();
		musicSlider = new JSlider(0, 100, 70);
		soundSlider = new JSlider(0, 100, 70);

		musicLabel = new JLabel("Music " + String.format("%03d", musicSlider.getValue()));
		soundLabel = new JLabel("Sound " + String.format("%03d", soundSlider.getValue()));

		musicLabel.setFont(SOUTH_FONT);
		soundLabel.setFont(SOUTH_FONT);

		// Updates UI when slider is moved
		musicSlider.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				musicLabel.setText("Music " + String.format("%03d", musicSlider.getValue()));
			}
		});

		soundSlider.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				soundLabel.setText("Sound " + String.format("%03d", soundSlider.getValue()));
			}
		});

		southPanel.add(musicLabel);
		southPanel.add(musicSlider);
		southPanel.add(soundLabel);
		southPanel.add(soundSlider);

		add(southPanel, BorderLayout.SOUTH);

		// Draw this window
		setVisible(true);
	}

	public void startGame(JButton button) {
		String difficulty = "";
		if (button == easyButton) {
			difficulty = "easy";
		} else if (button == mediumButton) {
			difficulty = "medium";
		} else if (button == hardButton) {
			difficulty = "hard";
		}

		GameSettings settings = new GameSettings(difficulty, musicSlider.getValue(), soundSlider.getValue());
		System.out.println(settings);

		// Hide this window and start the game
		setVisible(false);
		SnakeGame.main(null);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if (source == easyButton || source == mediumButton || source == hardButton) {
			startGame((JButton) source);
		} else if (source == exitButton) {
			System.exit(0); // Terminate program
		}
	}

	public static void main(String[] args) {
		new MainMenuWindow();
	}

}
