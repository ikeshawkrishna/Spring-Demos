package DSA.LinkedList;

public class LinkedList {
    private static Node head;
    private static Node tail;
    private static int size = 0;

    public int getSize() {
        return size;
    }

    // 5 ---> 4 ---> 1 ---> 8
    public void addNode(int data) {
        Node current = new Node(data);

        if (size == 0) {
            head = current;
            tail = current;
            size++;
            return;
        }

        tail.next = current;
        tail = current;
        size++;
    }


    public void addNode(int index, int data) throws IndexOutOfBoundsException {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Mention correct index");
        }

        Node current = new Node(data);
        if (index == 0) {
            current.next = head;
            head = current;
            size++;
            return;
        } else if (index == size) {
            tail.next = current;
            tail = current;
            size++;
            return;
        }

        Node indexNode = getNode(index);
        current.next = indexNode.next;
        indexNode.next = current;

        size++;
    }

    /* 9 ---> 5 ---> 3 -->  4 ---> 1 ---> 8
     *
     * */
    public void removeNode(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index == size) {
            throw new IndexOutOfBoundsException("Mention correct index");
        }

        if (index == 0) {
            head = head.next;
            size--;
            return;
        }
        Node indexNode = getNode(index);
        indexNode.next = indexNode.next.next;
        tail = indexNode;

        size--;

    }

    public void printNodes() {
        Node indexNode = head;

        while (indexNode != null) {
            System.out.print(indexNode.data + " --> ");
            indexNode = indexNode.next;
        }
        System.out.println("null");
    }

    private Node getNode(int index) {
        Node indexNode = head;
        for (int i = 0; i < index - 1; i++) {
            indexNode = indexNode.next;
        }
        return indexNode;
    }


    class Node {
        public int data;
        public Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
}
