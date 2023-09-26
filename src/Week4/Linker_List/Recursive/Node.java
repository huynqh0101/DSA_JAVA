package Week4.Linker_List.Recursive;

import java.awt.event.ItemEvent;

public class Node<Item> {
     Item data;
    Node next;
    public Node(Item data, Node next) {
        this.data = data;
        this.next = next;
    }
}
