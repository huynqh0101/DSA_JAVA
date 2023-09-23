package Week4.Linker_List;

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    Node head;

    public LinkedList() {
        this.head = null;
    }

    // Thêm một nút vào đầu danh sách liên kết
    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    // Thêm một nút vào cuối danh sách liên kết
    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    // In danh sách liên kết
    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}

public class link1 {
    public static void main(String[] args) {
        LinkedList myList = new LinkedList();

        myList.insertAtEnd(1);
        myList.insertAtEnd(2);
        myList.insertAtBeginning(0);

        System.out.println("Danh sách liên kết sau khi thêm:");
        myList.printList();
    }
}