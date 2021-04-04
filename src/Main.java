public class Main {

    public static void main(String[] args) {

        Graph g = new Graph();
        for (int i = 0; i < 10; i++) {
            Node n = new Node(i, i);
        }

	    MyFrame frame = new MyFrame();
        frame.panel.setGraph(g);

    }
}
