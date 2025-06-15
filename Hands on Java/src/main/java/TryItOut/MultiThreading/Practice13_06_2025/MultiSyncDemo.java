package TryItOut.MultiThreading.Practice13_06_2025;


class syncMethod {

}

public class MultiSyncDemo {

    static Integer count = 0;

    public static void main(String[] args) throws InterruptedException {

        Runnable thread1 = () -> {

            for (int i = 0; i < 20; i++) {
//                try {
//                    Thread.sleep(100);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
                increament();
            }
        };

        Runnable thread2 = () -> {

            for (int i = 0; i < 20; i++) {
//                try {
//                    Thread.sleep(200);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
                increament();
            }
        };

        Thread thread = new Thread(thread1);
        Thread thread3 = new Thread(thread2);
        thread.start();
        thread3.start();
        thread.join();
        thread3.join();

        System.out.println(count);
    }

    static void increament() {
        count++;
    }
}
