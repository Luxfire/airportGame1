import javax.swing.*;
import java.awt.*;

public class MainFrame {
    JFrame frame;
    KeyListen keyListen;

    public MainFrame(KeyListen keyListen) {
        this.keyListen = keyListen;

        frame = new JFrame("Аэропорт");
        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.addKeyListener(keyListen);
        //frame.setBackground(Color.BLACK);
        frame.setSize(900, 900);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}