package TryItOut.MultiThreading.Practice13_06_2025;


import java.security.PublicKey;
import java.util.Scanner;

class MultiClass1 extends Thread {

    boolean running = true;

    public void run() {
        while (running) {
            try {
                sleep(10000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void stopRunning(){
        running = false;
    }
}

public class Multithreademo {

    public static void main(String[] args) throws InterruptedException {
        MultiClass1 thread1 = new MultiClass1();
        thread1.setName("My first thread");
        thread1.setDaemon(true);
        thread1.start();

        Runnable runnable = new Runnable() {
            @Override
            public void run() {

            }

        };

        Scanner scanner = new Scanner(System.in);
//        while (true) {
//            String value = scanner.nextLine();
//            if (value.equalsIgnoreCase("isalive")) {
//                boolean alive = thread1.isAlive();
//                System.out.println("isAlive() >> " + thread1.isAlive());
//                System.out.println("isDaemon() >> " + thread1.isDaemon());
//                System.out.println("getState() >> " + thread1.getState());
//                System.out.println("getName() >> " + thread1.getName());
//
//                if (alive) {
//                    System.out.println("I am alive");
//                }
//
//            }
//            if (value.equalsIgnoreCase("stop")) {
//                thread1.stopRunning();
//                System.exit(1);
//            }
//        }
    }
}
