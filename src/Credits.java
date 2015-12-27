import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Credits extends JDialog {
    private JPanel contentPane;
    private JPanel credits;
    private JButton buttonOK;

    public Credits() {
        //Make GUI
        setTitle("Credits");
        setContentPane(contentPane);
        setSize(300,350);
        setModal(true);
        setResizable(false);
        getRootPane().setDefaultButton(buttonOK);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                exit();
            }
        });
    }

    private void exit() {
        dispose();
    }
}
