package Day5.MultiThreading;

public class MultiThreading extends Thread {

    public static void main(String[] args) {
        Thread t1 = new Thread();
        t1.setName("t1");
        t1.start();
        System.out.println("Thread "+ t1.getName()+ " started");
    }

}
