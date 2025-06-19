package tpihm;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;

public class TestJWindow implements ActionListener {

    // Quiz data
    String[] questions = {
            "Which company created Java?",
            "Which year was Java created?",
            "What was Java originally called?",
            "Who is credited with creating Java?"
    };
    String[][] options = {
            {"Sun Microsystems", "Starbucks", "Microsoft", "Alphabet"},
            {"1989", "1996", "1972", "1492"},
            {"Apple", "Latte", "Oak", "Koffing"},
            {"Steve Jobs", "Bill Gates", "James Gosling", "Mark Zuckerberg"}
    };
    char[] answers = {'A', 'B', 'C', 'C'};

    // State variables
    char guess;
    char answer;
    int index;
    int correct_guesses = 0;
    int total_questions = questions.length;
    int seconds = 10;

    // Leaderboard
    ArrayList<Integer> leaderboard = new ArrayList<>();

    // Swing components
    JFrame frame = new JFrame();
    JTextField textfield = new JTextField();
    JTextArea textarea = new JTextArea();
    JButton buttonA = new JButton();
    JButton buttonB = new JButton();
    JButton buttonC = new JButton();
    JButton buttonD = new JButton();
    JLabel answer_labelA = new JLabel();
    JLabel answer_labelB = new JLabel();
    JLabel answer_labelC = new JLabel();
    JLabel answer_labelD = new JLabel();
    JLabel time_label = new JLabel("Timer");
    JLabel seconds_left = new JLabel(String.valueOf(seconds));
    JTextField number_right = new JTextField();
    JTextField percentage = new JTextField();
    JTextArea leaderboardArea = new JTextArea();
    JButton restartButton = new JButton("Restart");

    Timer timer = new Timer(1000, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            seconds--;
            seconds_left.setText(String.valueOf(seconds));
            if (seconds <= 0) {
                displayAnswer();
            }
        }
    });

    public TestJWindow() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(650, 750);
        frame.getContentPane().setBackground(new Color(50, 50, 50));
        frame.setLayout(null);
        frame.setResizable(false);

        // Set up components
        textfield.setBounds(0, 0, 650, 50);
        textfield.setBackground(new Color(25, 25, 25));
        textfield.setForeground(new Color(25, 255, 0));
        textfield.setFont(new Font("Serif", Font.BOLD, 30));
        textfield.setHorizontalAlignment(JTextField.CENTER);
        textfield.setEditable(false);

        textarea.setBounds(0, 50, 650, 50);
        textarea.setLineWrap(true);
        textarea.setWrapStyleWord(true);
        textarea.setBackground(new Color(25, 25, 25));
        textarea.setForeground(new Color(25, 255, 0));
        textarea.setFont(new Font("Serif", Font.BOLD, 25));
        textarea.setEditable(false);

        setupButton(buttonA, 0, 100, "A");
        setupButton(buttonB, 0, 200, "B");
        setupButton(buttonC, 0, 300, "C");
        setupButton(buttonD, 0, 400, "D");

        setupAnswerLabel(answer_labelA, 125, 100);
        setupAnswerLabel(answer_labelB, 125, 200);
        setupAnswerLabel(answer_labelC, 125, 300);
        setupAnswerLabel(answer_labelD, 125, 400);

        time_label.setBounds(535, 475, 100, 25);
        time_label.setForeground(new Color(255, 0, 0));
        time_label.setFont(new Font("Serif", Font.PLAIN, 16));
        time_label.setHorizontalAlignment(JTextField.CENTER);

        seconds_left.setBounds(535, 510, 100, 100);
        seconds_left.setForeground(new Color(255, 0, 0));
        seconds_left.setFont(new Font("Serif", Font.BOLD, 60));
        seconds_left.setHorizontalAlignment(JTextField.CENTER);

        number_right.setBounds(225, 225, 200, 100);
        setupResultField(number_right);

        percentage.setBounds(225, 325, 200, 100);
        setupResultField(percentage);

        leaderboardArea.setBounds(125, 500, 400, 100);
        leaderboardArea.setBackground(new Color(25, 25, 25));
        leaderboardArea.setForeground(new Color(25, 255, 0));
        leaderboardArea.setFont(new Font("Serif", Font.BOLD, 18));
        leaderboardArea.setEditable(false);
        leaderboardArea.setText("Leaderboard:\n");

        restartButton.setBounds(225, 650, 200, 50);
        restartButton.setFont(new Font("Serif", Font.BOLD, 25));
        restartButton.addActionListener(e -> restartQuiz());
        restartButton.setVisible(false);

        frame.add(time_label);
        frame.add(seconds_left);
        frame.add(answer_labelA);
        frame.add(answer_labelB);
        frame.add(answer_labelC);
        frame.add(answer_labelD);
        frame.add(buttonA);
        frame.add(buttonB);
        frame.add(buttonC);
        frame.add(buttonD);
        frame.add(textarea);
        frame.add(textfield);
        frame.add(restartButton);
        frame.add(leaderboardArea);
        frame.setVisible(true);

        nextQuestion();
    }

    private void setupButton(JButton button, int x, int y, String text) {
        button.setBounds(x, y, 100, 100);
        button.setFont(new Font("Serif", Font.BOLD, 35));
        button.setText(text);
        button.addActionListener(this);
        frame.add(button);
    }

    private void setupAnswerLabel(JLabel label, int x, int y) {
        label.setBounds(x, y, 500, 100);
        label.setForeground(new Color(25, 255, 0));
        label.setFont(new Font("Serif", Font.PLAIN, 35));
        frame.add(label);
    }

    private void setupResultField(JTextField field) {
        field.setBackground(new Color(25, 25, 25));
        field.setForeground(new Color(25, 255, 0));
        field.setFont(new Font("Serif", Font.BOLD, 50));
        field.setHorizontalAlignment(JTextField.CENTER);
        field.setEditable(false);
    }

    public void nextQuestion() {
        if (index >= total_questions) {
            results();
        } else {
            textfield.setText("Question " + (index + 1));
            textarea.setText(questions[index]);
            answer_labelA.setText(options[index][0]);
            answer_labelB.setText(options[index][1]);
            answer_labelC.setText(options[index][2]);
            answer_labelD.setText(options[index][3]);
            timer.start();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton source = (JButton) e.getSource();
        answer = source.getText().charAt(0);

        if (answer == answers[index]) {
            correct_guesses++;
        }
        displayAnswer();
    }

    public void displayAnswer() {
        timer.stop();

        if (answers[index] != 'A') answer_labelA.setForeground(new Color(255, 0, 0));
        if (answers[index] != 'B') answer_labelB.setForeground(new Color(255, 0, 0));
        if (answers[index] != 'C') answer_labelC.setForeground(new Color(255, 0, 0));
        if (answers[index] != 'D') answer_labelD.setForeground(new Color(255, 0, 0));

        Timer pause = new Timer(2000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetAnswerLabels();
                index++;
                nextQuestion();
            }
        });
        pause.setRepeats(false);
        pause.start();
    }

    private void resetAnswerLabels() {
        answer_labelA.setForeground(new Color(25, 255, 0));
        answer_labelB.setForeground(new Color(25, 255, 0));
        answer_labelC.setForeground(new Color(25, 255, 0));
        answer_labelD.setForeground(new Color(25, 255, 0));
    }

    public void results() {
        timer.stop();

        int result = (int) ((correct_guesses / (double) total_questions) * 100);
        leaderboard.add(result);
        Collections.sort(leaderboard, Collections.reverseOrder());

        textfield.setText("RESULTS!");
        textarea.setText("");

        number_right.setText("(" + correct_guesses + "/" + total_questions + ")");
        percentage.setText(result + "%");

        leaderboardArea.setText("Leaderboard:\n");
        for (int i = 0; i < Math.min(5, leaderboard.size()); i++) {
            leaderboardArea.append((i + 1) + ". " + leaderboard.get(i) + "%\n");
        }

        restartButton.setVisible(true);
    }

    public void restartQuiz() {
        index = 0;
        correct_guesses = 0;
        seconds = 10;
        restartButton.setVisible(false);
        nextQuestion();
    }

    public static void main(String[] args) {
        new TestJWindow();
    }
}
