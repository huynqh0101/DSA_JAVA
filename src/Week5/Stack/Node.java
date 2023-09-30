package Week5.Stack;

public class Node<Item> {
    Item data;
    Node next;
    public Node(Item data, Node next) {
        this.data = data;
        this.next = next;
    }
}
