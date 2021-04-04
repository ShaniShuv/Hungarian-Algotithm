import java.util.Collection;
import java.util.HashMap;

public class Node {
//    geo
    public static int keyCounter = 0;
    public int key, x, y, tag=-1;

    public Node(){
        this.x = keyCounter*10;
        this.y = keyCounter*10;
        this.key=keyCounter;
        keyCounter++;
    }

    public Node(int x, int y){
        this.x = x;
        this.y = y;
        this.key=keyCounter;
        keyCounter++;
    }

}
