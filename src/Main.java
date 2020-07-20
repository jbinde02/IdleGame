public class Main {
    public static void main(String[] args){
        GameController gc1 = new GameController();
        Thread t1 = new Thread(gc1);
        t1.start();
    }
}
