import javax.swing.*;
import java.awt.*;

public class MyFrameS extends JFrame {
    MyPanel panel;

    MyFrameS(){
        this.panel = new MyPanel();
        this.setTitle("Hung Algo");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        this.setSize(500, 500);
        this.setVisible(true);

        ImageIcon img = new ImageIcon("AU.png");
        this.setIconImage(img.getImage());
        this.getContentPane().setBackground(Color.LIGHT_GRAY);

        // this will open the window in the center of the screen
        this.setLocationRelativeTo(null);

        this.add(panel);
        this.pack();
    }


}

