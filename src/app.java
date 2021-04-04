public class app implements Runnable {

    static MyFrame _mainFrame;

    public static void main(String[] args) {
        _mainFrame = new MyFrame();
        Thread client = new Thread();
        client.start();
    }

    @Override
    public void run() {
        _mainFrame = new MyFrame();
        _mainFrame.pack();
    }

}
