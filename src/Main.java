import javax.swing.*;
import java.awt.*;
import java.net.URL;
import java.util.Random;

public class Main extends JFrame {
    // Array of possible choices.
    private final String[] choices = {"Rock", "Paper", "Scissors"};
    private final Random random = new Random();

    // ImageIcons for each choice.
    private final ImageIcon rockIcon;
    private final ImageIcon paperIcon;
    private final ImageIcon scissorsIcon;

    // Labels to display game results and the computer's choice image.
    private final JLabel resultLabel;
    private final JLabel playerChoiceLabel;
    private final JLabel computerChoiceLabel;

    public Main() {
        super("Rock Paper Scissors Game");

        rockIcon = new ImageIcon("src/pngtree-monochrome-rock-clip-art-png-image_2689540.jpg");
        paperIcon = new ImageIcon("src/download.jpg");
        scissorsIcon = new ImageIcon("src/download (1).jpg");

        setLayout(new BorderLayout());

        var resultPanel = new JPanel(new BorderLayout());
        resultLabel = new JLabel("Make your choice!", SwingConstants.CENTER);
        resultLabel.setFont(new Font("Arial", Font.BOLD, 16));
        add(resultLabel, BorderLayout.NORTH);

        var imagePanel = new JPanel(new GridLayout(1, 2));
        playerChoiceLabel = new JLabel("Your Choice", SwingConstants.CENTER);
        computerChoiceLabel = new JLabel("Computer Choice", SwingConstants.CENTER);
        imagePanel.add(playerChoiceLabel);
        imagePanel.add(computerChoiceLabel);
        add(imagePanel, BorderLayout.CENTER);

        var buttonPanel = new JPanel();
        for (var choice : choices) {
            var button = new JButton(choice);
            button.addActionListener(e -> playGame(choice));
            buttonPanel.add(button);
        }
        add(buttonPanel, BorderLayout.SOUTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);
        setVisible(true);
    }


    private void playGame(String userChoice) {
        var computerChoice = choices[random.nextInt(choices.length)];

        // Determine the outcome using switch expressions.
        var outcome = switch (userChoice) {
            case "Rock" -> switch (computerChoice) {
                case "Rock" -> "It's a tie!";
                case "Paper" -> "You lose!";
                case "Scissors" -> "You win!";
                default -> "";
            };
            case "Paper" -> switch (computerChoice) {
                case "Rock" -> "You win!";
                case "Paper" -> "It's a tie!";
                case "Scissors" -> "You lose!";
                default -> "";
            };
            case "Scissors" -> switch (computerChoice) {
                case "Rock" -> "You lose!";
                case "Paper" -> "You win!";
                case "Scissors" -> "It's a tie!";
                default -> "";
            };
            default -> "";
        };

        resultLabel.setText(String.format("You chose %s. Computer chose(Random Choice) %s. %s", userChoice, computerChoice, outcome));

        // Set the corresponding icon using a switch expression.
        var icon = switch (computerChoice) {
            case "Rock" -> rockIcon;
            case "Paper" -> paperIcon;
            case "Scissors" -> scissorsIcon;
            default -> null;
        };
        var iconPlayer = switch (userChoice){
            case "Rock" -> rockIcon;
            case "Paper" -> paperIcon;
            case "Scissors" -> scissorsIcon;
            default -> null;

        };
        playerChoiceLabel.setIcon(iconPlayer);
        computerChoiceLabel.setIcon(icon);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Main::new);
    }
}
