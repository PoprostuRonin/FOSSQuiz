import javax.swing.*;
import java.util.Locale;
import java.util.Random;
import java.util.ResourceBundle;

public class Quiz {
    private Random random;
    private int points = 0;
    private int number = 0;
    private int goodAnswer = 0;

    private JRadioButton answer1;
    private JRadioButton answer2;
    private JRadioButton answer3;
    private JRadioButton answer4;
    private JPanel question;
    private JLabel questionText;
    private JButton nextButton;

    private JRadioButton[] answers;

    private ResourceBundle resourceBundle;
    private ButtonGroup answersGroup;

    private Application root;

    public Quiz(Application application) {
        root = application;

        //Initialize
        random = new Random();
        resourceBundle = ResourceBundle.getBundle("questions", Locale.ROOT);

        //Make GUI
        JFrame frame = new JFrame("Quiz");
        frame.setContentPane(question);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(600,400);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.getRootPane().setDefaultButton(nextButton);

        //Get radio buttons to array
        answers = new JRadioButton[]{ answer1, answer2, answer3, answer4 };

        //Get ButtonGroup of radio buttons
        answersGroup = new ButtonGroup();
        for(int i = 0; i < answers.length; i++)
        {
            answersGroup.add(answers[i]);
        }

        //Pick first question
        pickQuestion();

        nextButton.addActionListener(nextButton -> {
            //Check if some of radio buttons is even selected
            if(answer1.isSelected() || answer2.isSelected() || answer3.isSelected() || answer4.isSelected())
            {
                //Is good answer selected
                if(answers[goodAnswer].isSelected())
                    points++;

                number++;

                //If we finish the quiz
                if(number > 9) {
                    frame.dispose();
                    application.clearQuiz();
                    new Result(application,points);
                }
                else {
                    pickQuestion();
                    //Reset selection
                    answersGroup.clearSelection();
                    //Why not .setSelected(false) ?
                    //It doesn't work...
                }
            }
        });
    }

    /** Picks new question */
    public void pickQuestion()
    {
        //Set title and "real" question ID
        int questionID = number+1;
        questionText.setText(resourceBundle.getString("question" + Integer.toString(questionID)));

        //Set good answer
        goodAnswer = random.nextInt(4);
        answers[goodAnswer].setText(resourceBundle.getString("answer-" + Integer.toString(questionID) + "-1"));

        //Set other answers
        int currentAnswerProp = 2;
        for(int i = 0; i < answers.length; i++)
        {
            if(i != goodAnswer)
            {
                answers[i].setText(resourceBundle.getString("answer-" + Integer.toString(questionID) + "-" + Integer.toString(currentAnswerProp)));
                currentAnswerProp++;
            }
        }
    }
}
