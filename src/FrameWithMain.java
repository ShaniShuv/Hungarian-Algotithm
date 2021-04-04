import javax.swing.*;
import java.awt.*;

public class FrameWithMain {
    public static void main(String[] ards){

        JPanel greyPanel = new JPanel();
        greyPanel.setBounds(0, 0, 250, 250);



                JFrame frame = new JFrame();

        frame.setTitle("Hung Algo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(750, 750);
        frame.setVisible(true);

        ImageIcon img = new ImageIcon("AU.png");
        frame.setIconImage(img.getImage());
        frame.getContentPane().setBackground(Color.LIGHT_GRAY);

        // to have a color by rgb
        //frame.getContentPane().setBackground(new Color(123, 50, 250));


//        JLabel lable = new JLabel();
//        lable.setText("Implement of the Hungarian Method for perfect match in a ***bidiretional graphs");
//        lable.setHorizontalTextPosition(JLabel.CENTER);
//        lable.setVerticalTextPosition(JLabel.TOP);
//        lable.setBounds(0, 0, 500, 500);
//        frame.add(lable);
//        frame.pack();

        frame.setLayout(null);
        frame.add(greyPanel);






    }
}
