import javax.swing.*;
import java.awt.*;
import java.net.URI;

public class Application {
    private JPanel mainMenu;
    private JButton creditsButton;
    private JButton playButton;
    private JButton viewSourceButton;
    private JFrame frame;

    private JDialog credits;

    private Quiz quizWindow;

    public Application()
    {
        //Try to set look and feel from platform
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch (Exception error) {
            Application.log(error.getMessage());
        }

        //Make GUI
        frame = new JFrame("FOSS Quiz");
        frame.setContentPane(mainMenu);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        //We need that to create quiz object
        final Application application = this;

        //Buttons listeners
        playButton.addActionListener(playButton -> {
            if(quizWindow == null) {
                frame.setVisible(false);
                quizWindow = new Quiz(application);
            }
        });
        creditsButton.addActionListener(creditsButton -> {
            if(credits != null) {
                credits.dispose();
            }
            credits = new Credits();
        });
        viewSourceButton.addActionListener(viewSourceButton -> {
            Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
            if(desktop != null) {
                try {
                    desktop.browse(new URI("https://github.com/PoprostuRonin/FOSSQuiz"));
                }
                catch (Exception error){
                    Application.log(error.getMessage());
                }
            }
        });
    }

    public static void main(String[] args) {
        Application app = new Application();
    }

    public static void log(String message)
    {
        System.out.print(message+"\n");
    }

    public void show()
    {
        frame.setVisible(true);
    }

    public void clearQuiz()
    {
        quizWindow = null;
    }
}
