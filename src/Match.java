import java.util.Collection;
import java.util.HashMap;

public class Match {

    // A will be the nodes with the even keys
    // the diraction of the edge is from even
    private HashMap<Integer, Edge> edgeC;
    private HashMap<Integer, Integer> nID;


    Match(){
        this.edgeC = new HashMap<>();
    }
    public int size(){
        return this.edgeC.size();
    }

    public void add(Edge e){
        this.edgeC.put(e.getId(), e);
        this.nID.put(e.getDest().key, e.getSrc().key);
        this.nID.put(e.getSrc().key, e.getDest().key);
    }

    public Collection<Edge> getAE(){
        return edgeC.values();
    }

    public void matchRemove(Edge e) {
        this.edgeC.remove(e);
        this.nID.remove(e.getDest().key);
        this.nID.remove(e.getSrc().key);
    }


}
