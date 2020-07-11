public class Main {
    public static void main(String[] args){

        Points p1 = new Points(100000);
        Points p2 = new Points(10000);
        System.out.println(Points.compare(p1, p2));
        System.out.println(p1.compareTo(p2));

        System.out.println("Hello World");
        GameController gc1 = new GameController();
        Thread t1 = new Thread(gc1);
        t1.start();


    }
}
