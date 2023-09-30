package Week5.Queue;

public class linkedQueue {
    public Node first, last;
    public boolean isEmpty() {
        return first == null;
    }

    public void enqueue(String item) {
        Node oldlast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if(isEmpty()) {
            first = last;
        } else {
            oldlast.next = last;
        }
    }
    public String dequeue() {
        String item = first.item;
        first = first.next;
        if(isEmpty()) {
            last = null;
        }
        return item;
    }
    public int resize() {
        Node current = first;
        int count = 0;
        while (current != null) {
            current = current.next;
            count++;
        }
        return count;
    }
    public static void main(String[] args) {
        linkedQueue queue = new linkedQueue();
        
        System.out.println("Hàng đợi rỗng? " + queue.isEmpty());

        queue.enqueue("Phần tử 1");
        queue.enqueue("Phần tử 2");
        queue.enqueue("Phần tử 3");
        System.out.println("Size: " + queue.resize());

        while (!queue.isEmpty()) {
            System.out.println("Phần tử được dequeue: " + queue.dequeue());
        }

        // Kiểm tra xem hàng đợi có rỗng sau khi dequeue không
        System.out.println("Hàng đợi rỗng sau khi dequeue? " + queue.isEmpty());
    }
}
