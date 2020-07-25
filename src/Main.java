/**
 * This is the main class to start my idle / increment game. This is a very basic example of how a game like this would
 * work. It is missing things such as running or continuing while it is closed as well as a proper formulas to make it
 * more of a game. I just wanted something to keep my mind occupied and improve my skills. Just a fun little project.
 * Anyways, this is the main class that starts the game. It runs the controller class on a thread.
 *
 * @author Jacob Binder
 * @version 1.0
 */
public class Main {
    public static void main(String[] args){
        GameController gc1 = new GameController();
        Thread t1 = new Thread(gc1);
        t1.start();
    }
}
