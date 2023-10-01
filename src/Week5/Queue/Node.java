package Week5.Queue;

public class Node<Item> {
    Item data;
    Node<Item> next;
    public Node(Item data) {
        this.data = data;
        this.next = null;
    }
}
