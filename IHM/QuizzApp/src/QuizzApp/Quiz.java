package QuizzApp;

import java.awt.event.*;
import java.util.ArrayList;
import java.awt.*;
import javax.swing.*;

public class Quiz implements ActionListener{
    
	String[] questions =  {
            "Who was the first president of the United States?",
            "What is the capital of France?",
            "Which element has the chemical symbol 'O'?",
            "In which year did the Titanic sink?",
            "What is the smallest planet in our solar system?",
            "Who painted the Mona Lisa?",
            "What is the hardest natural substance on Earth?",
            "Which country is known as the Land of the Rising Sun?",
            "Who wrote the play 'Romeo and Juliet'?",
            "What is the largest ocean on Earth?"
        };

	String[][] options =  {
	            {"George Washington", "Thomas Jefferson", "Abraham Lincoln", "John Adams"},
	            {"Berlin", "Madrid", "Rome", "Paris"},
	            {"Oxygen", "Gold", "Osmium", "Ozone"},
	            {"1900", "1912", "1920", "1935"},
	            {"Mars", "Mercury", "Venus", "Earth"},
	            {"Pablo Picasso", "Leonardo da Vinci", "Michelangelo", "Vincent van Gogh"},
	            {"Iron", "Gold", "Diamond", "Platinum"},
	            {"China", "South Korea", "Japan", "Thailand"},
	            {"Charles Dickens", "William Shakespeare", "Jane Austen", "Oscar Wilde"},
	            {"Atlantic Ocean", "Indian Ocean", "Southern Ocean", "Pacific Ocean"}
	    };

	char[] answers =      {
	            'A',
	            'D',
	            'A',
	            'B',
	            'B',
	            'B',
	            'C',
	            'C',
	            'B',
	            'D'
	     };

    char guess;
    char answer;
    int index;
    int correct_guesses = 0;
    int total_questions = questions.length;
    int result;
    int seconds = 10;

    
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
    JLabel time_label = new JLabel();
    JLabel seconds_left = new JLabel();
    JTextField number_right = new JTextField();
    JTextField percentage = new JTextField();
    JButton restartButton = new JButton("Restart");
    JButton leaderboardButton = new JButton("Leaderboard");
    JPanel leaderboardPanel = new JPanel();
    JTextArea leaderboardTextArea = new JTextArea();
    
    ArrayList<String> leaderboard = new ArrayList<>();
    
    Timer timer = new Timer(1000, new ActionListener() {
        
        @Override
        public void actionPerformed(ActionEvent e) {
            seconds--;
            seconds_left.setText(String.valueOf(seconds));
            if(seconds <= 0) {
                displayAnswer();
            }
        }
    });
    
    public Quiz() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(650,650);
        frame.getContentPane().setBackground(new Color(50,50,50));
        frame.setLayout(null);
        frame.setResizable(false);
        
        textfield.setBounds(0,0,650,50);
        textfield.setBackground(new Color(25,25,25));
        textfield.setForeground(new Color(25,255,0));
        textfield.setFont(new Font("Serif", Font.BOLD, 30));
        textfield.setBorder(BorderFactory.createBevelBorder(1));
        textfield.setHorizontalAlignment(JTextField.CENTER);
        textfield.setEditable(false);
        
        textarea.setBounds(0,50,650,50);
        textarea.setLineWrap(true);
        textarea.setWrapStyleWord(true);
        textarea.setBackground(new Color(25,25,25));
        textarea.setForeground(new Color(25,255,0));
        textarea.setFont(new Font("Serif", Font.BOLD, 25));
        textarea.setBorder(BorderFactory.createBevelBorder(1));
        textarea.setEditable(false);
        
        buttonA.setBounds(0,100,100,100);
        buttonA.setFont(new Font("Serif", Font.BOLD, 35));
        buttonA.setFocusable(false);
        buttonA.addActionListener(this);
        buttonA.setText("A");
        
        buttonB.setBounds(0,200,100,100);
        buttonB.setFont(new Font("Serif", Font.BOLD, 35));
        buttonB.setFocusable(false);
        buttonB.addActionListener(this);
        buttonB.setText("B");
        
        buttonC.setBounds(0,300,100,100);
        buttonC.setFont(new Font("Serif", Font.BOLD, 35));
        buttonC.setFocusable(false);
        buttonC.addActionListener(this);
        buttonC.setText("C");
        
        buttonD.setBounds(0,400,100,100);
        buttonD.setFont(new Font("Serif", Font.BOLD, 35));
        buttonD.setFocusable(false);
        buttonD.addActionListener(this);
        buttonD.setText("D");
        
        answer_labelA.setBounds(125,100,500,100);
        answer_labelA.setBackground(new Color(50,50,50));
        answer_labelA.setForeground(new Color(25,255,0));
        answer_labelA.setFont(new Font("Serif", Font.PLAIN, 35));
        
        answer_labelB.setBounds(125,200,500,100);
        answer_labelB.setBackground(new Color(50,50,50));
        answer_labelB.setForeground(new Color(25,255,0));
        answer_labelB.setFont(new Font("Serif", Font.PLAIN, 35));
        
        answer_labelC.setBounds(125,300,500,100);
        answer_labelC.setBackground(new Color(50,50,50));
        answer_labelC.setForeground(new Color(25,255,0));
        answer_labelC.setFont(new Font("Serif", Font.PLAIN, 35));
        
        answer_labelD.setBounds(125,400,500,100);
        answer_labelD.setBackground(new Color(50,50,50));
        answer_labelD.setForeground(new Color(25,255,0));
        answer_labelD.setFont(new Font("Serif", Font.PLAIN, 35));
        
        seconds_left.setBounds(535,510,100,100);
        seconds_left.setBackground(new Color(25,25,25));
        seconds_left.setForeground(new Color(255,0,0));
        seconds_left.setFont(new Font("Serif", Font.BOLD, 60));
        seconds_left.setBorder(BorderFactory.createBevelBorder(1));
        seconds_left.setOpaque(true);
        seconds_left.setHorizontalAlignment(JTextField.CENTER);
        seconds_left.setText(String.valueOf(seconds));
        
        time_label.setBounds(535,475,100,25);
        time_label.setBackground(new Color(50,50,50));
        time_label.setForeground(new Color(255,0,0));
        time_label.setFont(new Font("Serif", Font.PLAIN, 16));
        time_label.setHorizontalAlignment(JTextField.CENTER);
        time_label.setText("timer >:D");
        
        number_right.setBounds(225,225,200,100);
        number_right.setBackground(new Color(25,25,25));
        number_right.setForeground(new Color(25,255,0));
        number_right.setFont(new Font("Serif", Font.BOLD, 30));
        number_right.setBorder(BorderFactory.createBevelBorder(1));
        number_right.setHorizontalAlignment(JTextField.CENTER);
        number_right.setEditable(false);
        
        percentage.setBounds(225,325,200,100);
        percentage.setBackground(new Color(25,25,25));
        percentage.setForeground(new Color(25,255,0));
        percentage.setFont(new Font("Serif", Font.BOLD, 20));
        percentage.setBorder(BorderFactory.createBevelBorder(1));
        percentage.setHorizontalAlignment(JTextField.CENTER);
        percentage.setEditable(false);
        
        restartButton.setBounds(225, 450, 200, 50);
        restartButton.setFont(new Font("Serif", Font.BOLD, 25));
        restartButton.setFocusable(false);
        restartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                restartQuiz();
            }
        });
        
        leaderboardPanel.setBounds(50, 100, 550, 400);
        leaderboardPanel.setBackground(new Color(50,50,50));
        leaderboardPanel.setLayout(new BorderLayout());
        leaderboardTextArea.setBackground(new Color(25,25,25));
        leaderboardTextArea.setForeground(new Color(25,255,0));
        leaderboardTextArea.setFont(new Font("Serif", Font.BOLD, 20));
        leaderboardTextArea.setEditable(false);
        leaderboardPanel.add(new JScrollPane(leaderboardTextArea), BorderLayout.CENTER);
        leaderboardPanel.setVisible(false); 

        leaderboardButton.setBounds(225, 550, 200, 50);
        leaderboardButton.setFont(new Font("Serif", Font.BOLD, 20));
        leaderboardButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                leaderboardPanel.setVisible(!leaderboardPanel.isVisible());
                if (leaderboardPanel.isVisible()) {
                    showLeaderboard();
                }
            }
        });

        
        restartButton.setVisible(false);

        frame.add(leaderboardButton);
        frame.add(leaderboardPanel);
        frame.add(leaderboardButton);
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
        frame.setVisible(true);
        
        nextQuestion();
    }
    
    private void showLeaderboard() {
        leaderboardTextArea.setText("Leaderboard\n\n");
        if (leaderboard.isEmpty()) {
            leaderboardTextArea.append("No scores yet.\n");
        } else {
            for (String score : leaderboard) {
                leaderboardTextArea.append(score + "\n");
            }
        }
    }
    
    public void nextQuestion() {
        if(index >= total_questions) {
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
        buttonA.setEnabled(false);
        buttonB.setEnabled(false);
        buttonC.setEnabled(false);
        buttonD.setEnabled(false);
        
        if(e.getSource() == buttonA) {
            answer = 'A';
            if(answer == answers[index]) {
                correct_guesses++;
            }
        }
        if(e.getSource() == buttonB) {
            answer = 'B';
            if(answer == answers[index]) {
                correct_guesses++;
            }
        }
        if(e.getSource() == buttonC) {
            answer = 'C';
            if(answer == answers[index]) {
                correct_guesses++;
            }
        }
        if(e.getSource() == buttonD) {
            answer = 'D';
            if(answer == answers[index]) {
                correct_guesses++;
            }
        }
        displayAnswer();
    }
    
    public void displayAnswer() {
        timer.stop();
        
        buttonA.setEnabled(false);
        buttonB.setEnabled(false);
        buttonC.setEnabled(false);
        buttonD.setEnabled(false);
        
        if(answers[index] != 'A')
            answer_labelA.setForeground(new Color(255,0,0));
        if(answers[index] != 'B')
            answer_labelB.setForeground(new Color(255,0,0));
        if(answers[index] != 'C')
            answer_labelC.setForeground(new Color(255,0,0));
        if(answers[index] != 'D')
            answer_labelD.setForeground(new Color(255,0,0));
        
        Timer pause = new Timer(2000, new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                
                answer_labelA.setForeground(new Color(25,255,0));
                answer_labelB.setForeground(new Color(25,255,0));
                answer_labelC.setForeground(new Color(25,255,0));
                answer_labelD.setForeground(new Color(25,255,0));
                
                answer = ' ';
                seconds = 10;
                seconds_left.setText(String.valueOf(seconds));
                buttonA.setEnabled(true);
                buttonB.setEnabled(true);
                buttonC.setEnabled(true);
                buttonD.setEnabled(true);
                index++;
                nextQuestion();
            }
        });
        pause.setRepeats(false);
        pause.start();
    }
    
    public void results() {
        buttonA.setEnabled(false);
        buttonB.setEnabled(false);
        buttonC.setEnabled(false);
        buttonD.setEnabled(false);
        
        result = (int)((correct_guesses / (double)total_questions) * 100);
        
        textfield.setText("RESULTS!");
        textarea.setText("");
        answer_labelA.setText("");
        answer_labelB.setText("");
        answer_labelC.setText("");
        answer_labelD.setText("");
        
        number_right.setText("(" + correct_guesses + "/" + total_questions + ")");
        if(result == 100) {
            percentage.setText("Excellent");
        } else if(result >= 90) {
            percentage.setText("Very Good");
        } else if(result >= 80) {
            percentage.setText("Good");
        } else if(result >= 60) {
            percentage.setText("Not That Bad");
        } else if(result >= 50) {
            percentage.setText("Do More Efforts");
        } else {
            percentage.setText("Better Luck Next Time");
        }
        
        leaderboard.add("Player: " + correct_guesses + "/" + total_questions + " (" + result + "%)");
        
        frame.add(number_right);
        frame.add(percentage);
        
        restartButton.setVisible(true);
    }
    
    public void restartQuiz() {
        index = 0;
        correct_guesses = 0;
        seconds = 10;
        buttonA.setEnabled(true);
        buttonB.setEnabled(true);
        buttonC.setEnabled(true);
        buttonD.setEnabled(true);
        seconds_left.setText(String.valueOf(seconds));
        frame.remove(number_right);
        frame.remove(percentage);
        restartButton.setVisible(false);
        nextQuestion();
    }
}
