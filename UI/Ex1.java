package nguyentrongkhoi_5867.UI;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;

public class Ex1 {

    public static void main(String[] args) {
        JFrame jframe = new JFrame("Frame 1");
        JPanel jPanel = new JPanel();
        jPanel.setBackground(Color.BLACK);
        
        
        JButton jButton1 = new JButton("I'm a button.");
        jButton1.setBackground(Color.PINK);
        JButton jButton2 = new JButton("Click me!");
        jButton2.setBackground(Color.YELLOW);

        jPanel.add(jButton1);
        jPanel.add(jButton2);

        jframe.add(jPanel);

        jframe.setSize(300, 120);
        jframe.setVisible(true);
    }
}
