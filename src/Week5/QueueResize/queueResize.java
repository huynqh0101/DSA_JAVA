package Week5.QueueResize;

public class queueResize<T> {
    private Object[] queueArray;
    private int front; // Chỉ mục của phần tử đầu hàng đợi
    private int rear;  // Chỉ mục của phần tử cuối hàng đợi
    private int size;  // Số lượng phần tử trong hàng đợi

    public queueResize() {
        this.queueArray = new Object[4]; // Dung lượng ban đầu là 4
        this.front = 0;
        this.rear = -1;
        this.size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void enqueue(T item) {
        if (size == queueArray.length) {
            resize(queueArray.length * 2); // Tăng gấp đôi dung lượng khi cần
        }
        rear = (rear + 1) % queueArray.length;
        queueArray[rear] = item;
        size++;
    }

    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        T item = (T) queueArray[front];
        queueArray[front] = null;
        front = (front + 1) % queueArray.length;
        size--;

        // Kiểm tra xem có cần giảm dung lượng
        if (size > 0 && size == queueArray.length / 4) {
            resize(queueArray.length / 2); // Giảm dung lượng đi một nửa khi cần
        }
        return item;
    }

    private void resize(int newCapacity) {
        Object[] newArray = new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newArray[i] = queueArray[(front + i) % queueArray.length];
        }
        queueArray = newArray;
        front = 0;
        rear = size - 1;
    }

    public static void main(String[] args) {
       queueResize<Integer> queue = new queueResize<Integer>();

        // Thêm các phần tử vào hàng đợi
        for (int i = 1; i <= 10; i++) {
            queue.enqueue(i);
        }

        // Lấy và in các phần tử ra khỏi hàng đợi
        while (!queue.isEmpty()) {
            System.out.print(queue.dequeue() + " ");
        }
    }
}
