package TryItOut.classDemo;

interface demo{
    private String show(){
        return "";
    }
}
abstract class A{
    static int age = 23;
    private static void show(){
        System.out.println("in a show");
    }
    abstract void display();
}

class B extends A{
    public static void show(){
        System.out.println("in b show");
    }

    @Override
    public void display() {

    }
}
public class StaticClassDemo {
    public static void main(String[] args) {
        A obj = new B();
        int age = obj.age;
        System.out.println(age);
    }
}
