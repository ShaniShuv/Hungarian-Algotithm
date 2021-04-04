import java.util.HashMap;

public class Edge {
    private static int idk = 0;
    private Node src;
    private Node dest;
    private int id, color;

    public int getId() {
        return id;
    }



    public Node getSrc() {
        return src;
    }



    public Node getDest() {
        return dest;
    }



    public Edge(Node n1, Node n2){
        this.id = idk;
        idk ++;
        this.color = 0;
        this.src = n1;
        this.dest = n2;
    }

    public int getColor() {
        return color;
    }

    public boolean setColor(int color) {
        if(color > 2 || color < 0) return false;
        this.color = color;
        return true;
    }
}
