package TryItOut.MultiThreading;

class A extends Thread{
    public void run(){
        for(int i = 0; i < 5; i++){
            System.out.println("in A print");
            try { Thread.sleep(1000);} catch (InterruptedException e) { throw new RuntimeException(e);}
        }
    }
}
class B extends Thread{
    public void run(){
        for(int i = 0; i < 5; i++){
            System.out.println("in B print");
            try { Thread.sleep(2000);} catch (InterruptedException e) { throw new RuntimeException(e);}
        }
    }
}

public class ThreadsDemo{
    public static void main(String[] args) throws InterruptedException {
        A objA = new A();
        B objB = new B();
        objA.setName("Class A");
        objB.setName("Class B");
        objA.start();
        objB.start();

        System.out.println(objA.getName() + " isAlive ? "+objA.isAlive());
        System.out.println(objB.getName() + " isAlive ? "+objB.isAlive());

        objA.join();
        //objB.join();

        System.out.println(objA.getName() + " isAlive ? "+objA.isAlive());
        System.out.println(objB.getName() + " isAlive ? "+objB.isAlive());

        System.out.println("Threads Completed");
    }
}
