package TryItOut.MultiThreading;

class runnableA implements Runnable{
    public void run(){
        for(int i = 0; i < 5; i++){
            System.out.println("in A print");
            try { Thread.sleep(1000);} catch (InterruptedException e) { throw new RuntimeException(e);}
        }
    }
}

public class RunnableInterface {
    public static void main(String[] args) {
        runnableA obj1 = new runnableA();
        Thread t1 = new Thread(obj1);


        Runnable obj2 = () -> {
            for(int i = 0; i < 5; i++){
                System.out.println("in B print");
                try { Thread.sleep(2000);} catch (InterruptedException e) { throw new RuntimeException(e);}
            }
        };
        Thread t2 = new Thread(obj2);

        t1.start();
        t2.start();
    }
}
