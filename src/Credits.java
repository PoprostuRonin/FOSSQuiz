import javax.swing.*;

public class Credits extends JDialog {
    private JPanel contentPane;
    private JPanel credits;
    private JButton buttonOK;

    public Credits() {
        //Make GUI
        setTitle("Credits");
        buttonOK.addActionListener(buttonOK -> exit());
        setContentPane(contentPane);
        setSize(300,350);
        setModal(true);
        setResizable(false);
        getRootPane().setDefaultButton(buttonOK);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    /** Method for leaving this dialog */
    private void exit() {
        setVisible(false);
        dispose();
    }
}
