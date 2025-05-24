package TryItOut.AllAboutInterface;

interface A {
    int age = 23;

    void show();

    default void view() {
        System.out.println("in A view");
    }

    static void print() {
        System.out.println("in static A print");
    }
}

interface B {
    public final static int age = 23;

    void show();

    default void view() {
        System.out.println("in B view");
    }

    static void print() {
        System.out.println("in static B print");
    }
}


abstract class abstractDemo implements A, B {
    //Mandatory
    public void view() {
        System.out.println("in abstract view");
    }

    static void print() {
        System.out.println("in abstract print");
    }
}

class InterfaceDemo extends abstractDemo{

    @Override
    public void show() {
        System.out.println("in Demo Show");
    }

    static void print() {
        System.out.println("in static demo print");
    }

    public static void main(String[] args) {
        A obj = new InterfaceDemo();
        obj.view();
        obj.show();
        InterfaceDemo.print();
        A.print();
    }
}
