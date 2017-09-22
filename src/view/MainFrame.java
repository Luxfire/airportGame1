package view;

import controller.Controller;

import javax.swing.*;
import java.awt.*;

public class MainFrame {
    JFrame frame;

    public MainFrame(Controller controller) {

        frame = new JFrame("Аэропорт");
        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.addKeyListener(new KeyListen(controller));
        frame.add(new DrawLocation(controller,this));
        frame.setSize(900, 900);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
