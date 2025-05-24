package DSA.LinkedList;

public class LLmain {

    public static void main(String[] args) throws Exception {
        LinkedList list = new LinkedList();
        list.addNode(12);
        list.addNode(1);
        list.addNode(2);
        list.addNode(0,3);
        list.addNode(4,5);
        list.addNode(2,10);

//        list.removeNode(0);
//        list.removeNode(4);
        list.removeNode(3);

//        list.addNode(20,12);

        list.printNodes();
        System.out.println(list.getSize());
    }
}
