package Week5.Queue;

public class linkedQueue<Item> {
    private Node<Item> front; // Phần tử đầu hàng đợi
    private Node<Item> rear;  // Phần tử cuối hàng đợi

    public linkedQueue() {
        this.front = null;
        this.rear = null;
    }

    // Kiểm tra xem hàng đợi có trống không.
    public boolean isEmpty() {
        return front == null;
    }

    // Thêm phần tử vào cuối hàng đợi.
    public void enqueue(Item data) {
        Node<Item> newNode = new Node<>(data);

        if (rear == null) {
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
    }

    // Loại bỏ và trả về phần tử ở đầu hàng đợi.
    public Item dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }

        Item data = front.data;
        front = front.next;

        if (front == null) {
            rear = null;
        }

        return data;
    }

    // Lấy phần tử ở đầu hàng đợi mà không loại bỏ.
    public Item peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }

        return front.data;
    }

    // Lấy kích thước của hàng đợi.
    public int size() {
        int size = 0;
        Node<Item> current = front;
        while (current != null) {
            size++;
            current = current.next;
        }
        return size;
    }

    // In toàn bộ hàng đợi.
    public void printQueue() {
        Node<Item> current = front;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        linkedQueue<Integer> queue = new linkedQueue<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        System.out.println("Queue:");
        queue.printQueue();

        System.out.println("Dequeue: " + queue.dequeue());
        System.out.println("Peek: " + queue.peek());

        System.out.println("Queue size: " + queue.size());
    }
}