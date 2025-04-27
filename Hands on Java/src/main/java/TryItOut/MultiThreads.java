package TryItOut;

class A implements Runnable {
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("hi");
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class B implements Runnable {
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("hello");
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class Counter {
    int count;
    public synchronized void counter(){
        count++;
    }
}


public class MultiThreads {
    public static void main(String[] args) throws InterruptedException {
//        A obj1 = new A();
//        B obj2 = new B();

//        obj1.start();
//        obj2.start();

//        Thread t1 = new Thread(obj1);
//        Thread t2 = new Thread(obj2);

//        t1.start();
//        t2.start();

        Counter c = new Counter();
        Runnable obj3 = () -> {
            for (int i = 1 ; i <= 2000; i++) {
                c.counter();
            }
        };
        Runnable obj4 = () -> {
            for (int i = 1; i <= 2000; i++) {
                c.counter();
            }
        };

        Thread t3 = new Thread(obj3);
        Thread t4 = new Thread(obj4);
        t3.start();
        t4.start();

        t3.join();
        t4.join();

        System.out.println(c.count);
//        t3.setPriority(Thread.MAX_PRIORITY);

    }


}
