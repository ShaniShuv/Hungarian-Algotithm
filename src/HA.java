import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class HA {
    // להעביר למחלקה של הגרף
    HashMap<Integer, Node> a1 = new HashMap<>();
    HashMap<Integer, Node> b1 = new HashMap<>();
    HashMap<Integer, Node> a2 = new HashMap<>();
    HashMap<Integer, Node> b2 = new HashMap<>();


    // כרגע אני מניחה שהגרף דו צדדי
    public Match HA(Graph graph){
        setAB(graph);
        Match match = new Match();
        for (Edge e: graph.getAE()){
            match.add(e);
            // adding to a1, b1
            addingAB(e);
            break;
        }
        LinkedList<Edge> augmentingPath = getAugmentingPath(graph, match);
        while (augmentingPath != null){
            currectMatch(graph, match, augmentingPath);
        }
        return match;
    }

    public LinkedList getAugmentingPath(Graph graph, Match match){
        for (Edge e: graph.getAE()){
            e.setColor(0);
            if(match.getAE().contains(e)){
                e.setColor(1);
            }
        }
        for (Node na1: this.a1.values()){
            LinkedList<Edge> maybe = new LinkedList<>();
            for (Node nb2: this.b2.values()){
                Edge e1 = graph.getEdge(na1.key, nb2.key);
                if (e1 != null) {
                    maybe.add(e1);
                    for (Node na2 : this.a2.values()) {
                        Edge e2 = graph.getEdge(nb2.key, na2.key);
                        if (e2 != null) {
                            maybe.addLast(e2);
                            for (Node nb1 : this.b1.values()) {
                                Edge e3 = graph.getEdge(na2.key, nb1.key);
                                if (e3 != null) {
                                    maybe.add(e3);
                                    return maybe;
                                }
                            }

                        }

                    }
                }
            }

        }
        return null;

    }

    public void addingAB(Edge e){
        Node n1 = e.getSrc();
        Node n2 = e.getDest();
        if(n1.key % 2 ==0){
            a2.remove(n1.key);
            a1.put(n1.key, n1);
            b2.remove(n2.key);
            b1.put(n2.key, n2);
        }
        else{
            b2.remove(n1.key);
            b1.put(n1.key, n1);
            a2.remove(n2.key);
            a1.put(n2.key, n2);
        }
    }
        private void setAB(Graph graph) {

        for (Node n: graph.getAV()){
            if (n.key % 2 ==0){
                a2.put(n.key, n);
            }
            else{
                b2.put(n.key, n);
            }
        }
    }
    public void currectMatch(Graph graph, Match match, LinkedList<Edge> ap){
        for (Edge e2: ap){

            for ( Edge e1: match.getAE()) {
                boolean b = false;
                if (e1.getSrc() == e2.()){
                    a1.remove(e1.getSrc().key);
                    b1.remove(e1.getDest().key);
                    b = true;
                }
                if (e2.getSrc() == e2.getDest()){
                    a1.remove(e1.getSrc().key);
                    b1.remove(e1.getDest().key);
                }
                if(b){
                    match.matchRemove(e1);
                }
            }
        }
        for (Edge e2: ap) {
            match.add(e2);
            a1.put(e2.getSrc().key, e2.getSrc());
        }
    }

}
