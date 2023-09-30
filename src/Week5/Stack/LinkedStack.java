package Week5.Stack;

public class LinkedStack<Item> {
    private Node<Item> first = null;
    private int count = 0;
    public boolean isEmpty() {
        return first == null;
    }
    public void push(Item data) {
        Node oldFirst = first;
        first = new Node(data, null);
        first.next = oldFirst;
    }
    public Item pop() {
        if(isEmpty()) {
            return null;
        }
        Item result = first.data;
        first.data = null;
        first = first.next;
        return result;
    }
    public void printStack() {
        if(isEmpty()) {
            System.out.println("Stack is empty.");
            return;
        }

        Node current = first;
        while (current!= null) {
            System.out.print(current.data+ " ");
            current = current.next;
        }
        System.out.println();
    }
    public int size() {
        Node<Item> current = first;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }
    public static void main(String[] args) {
        LinkedStack<Integer> st = new LinkedStack<>();
        st.push(1);
        st.push(2);
        st.push(5);
        st.printStack();
        st.printStack();
        System.out.println(st.size());
    }
}
