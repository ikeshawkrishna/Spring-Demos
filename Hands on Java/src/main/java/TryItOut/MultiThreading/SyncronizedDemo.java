package TryItOut.MultiThreading;

import netscape.javascript.JSObject;

class Table{

    public static void printTable(Integer multiplier) throws InterruptedException {
            for (int i = 1; i <= 10; i++) {
                System.out.println(multiplier * i);
            }
    }

}
public class SyncronizedDemo {

    public static void main(String[] args){
        Runnable obj1 = () -> {
            try {
                Table.printTable(5);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };

        Runnable obj2 = () -> {
            try {
                Table.printTable(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };

        Thread t1 = new Thread(obj1);
        Thread t2 = new Thread(obj2);
//        t1.setPriority(Thread.MAX_PRIORITY);
        t1.start();
        t2.start();
    }

}
