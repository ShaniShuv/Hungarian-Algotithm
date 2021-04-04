import javax.swing.*;
import java.awt.*;

public class MyPanel extends JPanel {

    private Graph graph;
    private Match match;

    MyPanel(){
        this.setPreferredSize(new Dimension(250, 250));
        this.match = new Match();
        this.graph = new Graph();
    }

    public void setGraph(Graph g){
        this.graph = g;
    }
    public void setMatch(Match m){
        this.match = m;
    }

    public void paint(Graphics g){
        Graphics2D g2D = (Graphics2D) g;

        for (Edge e: match.getAE()) {
            e.setColor(1);
        }
        g2D.setStroke(new BasicStroke(1));
        for (Edge e: graph.getAE()) {
            g2D.setPaint(Color.BLACK);
            if(e.getColor() == 1){
                g2D.setPaint(Color.RED);
            }
            else if (e.getColor() == 2){
                g2D.setPaint(Color.BLUE);
            }

            g2D.drawLine(e.getSrc().x, e.getSrc().y, e.getDest().x, e.getDest().y);
        }

        g2D.setStroke(new BasicStroke(6));
        g2D.setPaint(Color.black);
        for (Node n: graph.getAV()) {
            g2D.drawString("v", n.x, n.y);
        }
//        g2D.
    }
}
