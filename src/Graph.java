import java.util.Collection;
import java.util.HashMap;

public class Graph {
    private int maxX = 0, maxY = 0, minX = 0, minY = 0;
    private HashMap<Integer,HashMap<Integer, Edge>> edgeC = new HashMap<Integer, HashMap<Integer, Edge>>();
    private HashMap<Integer, Node> nodeC = new HashMap<>();
    private int changesNum=0;

    public Graph (){
        this.nodeC = new HashMap<Integer, Node>();
    }


    public Node getNode(int key){
        if(!nodeC.containsKey(key)) return null;
        Node node = nodeC.get(key);
        return node;
    }

    public Edge getEdge(int key1, int key2){
        if(!nodeC.containsKey(key1)||!nodeC.containsKey(key2)) return null;
        Node node1 = nodeC.get(key1);
        Node node2 = nodeC.get(key2);

        if (key1 % 2 == 0){
            return this.edgeC.get(key1).get(key2);
        }
        return this.edgeC.get(key2).get(key1);
    }

    public void connect(int key1, int key2){
        if(!nodeC.containsKey(key1) || !nodeC.containsKey(key2) || key1==key2)
            return;
        Node node1 = nodeC.get(key1);
        Node node2 = nodeC.get(key2);
        Edge e = new Edge(node1, node2);
        if(key1 % 2 == 0) {
            if(!this.edgeC.containsKey(key1)) {
                this.edgeC.put(key1, new HashMap<Integer, Edge>());
            }
            this.edgeC.get(key1).put(key2, e);
        }
        else {
            if(!this.edgeC.containsKey(key2)) {
                this.edgeC.put(key2, new HashMap<Integer, Edge>());
            }
            this.edgeC.get(key2).put(key1, e);
        }
    }

    public Collection<Node> getAV(){
        return nodeC.values();
    }

    public Collection<Edge> getAE(){
//        return edgeC.values();
        return null;
    }

    public Collection<Edge> getV(int key){
        if (!this.nodeC.containsKey(key)) return null;
        if(this.edgeC.containsKey(key)) {
//            return this.edgeC.get(key);
        }
        return null;
    }


}
