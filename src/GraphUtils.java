import java.awt.*;
import java.awt.geom.AffineTransform;

public class GraphUtils {

//    public static class Edge {
//        Node a,b;
//        public Edge(Node a, Node b) {
//            this.a = a;
//            this.b = b;
//        }
//    }
//    public static class Node {
//        public static int count;
//        final int key;
//        int x,y;
//        public Node() {
//            this.key = count++;
//        }
//    }

    private static final Polygon ARROW_HEAD = new Polygon();
    static {
        ARROW_HEAD.addPoint(0, 0);
        ARROW_HEAD.addPoint(-5, -10);
        ARROW_HEAD.addPoint(5, -10);
    }
    public static class LineArrow {

        private final double x;
        private final double y;
        private final double endX;
        private final double endY;
        private final Color color;
        private final int thickness;

        public LineArrow(double x1, double y1, double x2, double y2, Color color, int thickness) {
            super();
            this.x = x1;
            this.y = y1;
            this.endX = x2;
            this.endY = y2;
            this.color = color;
            this.thickness = thickness;
        }

        public void draw(Graphics g) {
            Graphics2D g2 = (Graphics2D) g;
            double angle = Math.atan2(endY - y, endX - x);
            g2.setColor(color);
            g2.setStroke(new BasicStroke(thickness));
            g2.drawLine((int)x, (int)y, (int)(endX - 10 * Math.cos(angle)), (int) (endY - 10 * Math.sin(angle)));
            AffineTransform tx1 = g2.getTransform();
            AffineTransform tx2 = (AffineTransform) tx1.clone();
            tx2.translate(endX, endY);
            tx2.rotate(angle - Math.PI / 2);
            g2.setTransform(tx2);
            g2.fill(ARROW_HEAD);
            g2.setTransform(tx1);
        }
    }
}
