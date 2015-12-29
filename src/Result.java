import javax.swing.*;
import java.awt.event.*;

public class Result {
    private JPanel resultPanel;
    private JLabel scoreValue;
    private JLabel scoreTitle;
    private JButton menuButton;

    public Result(Application application, int score) {
        JFrame frame = new JFrame("Result");
        frame.setContentPane(resultPanel);
        frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        scoreValue.setText(Integer.toString(score));
        menuButton.addActionListener(menuButton -> { frame.setVisible(false); application.show(); });
        frame.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {

            }
            @Override
            public void windowClosing(WindowEvent e) {
                frame.setVisible(false);
                application.show();
            }

            @Override
            public void windowClosed(WindowEvent e) {

            }

            @Override
            public void windowIconified(WindowEvent e) {

            }

            @Override
            public void windowDeiconified(WindowEvent e) {

            }

            @Override
            public void windowActivated(WindowEvent e) {

            }

            @Override
            public void windowDeactivated(WindowEvent e) {

            }});
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
