package Week5.StackResize;

import java.util.Arrays;

public class stackResize<T> {
    private Object[] stackArray;
    private int size;
    private int capacity;//Dung lượng tối đa của stack

    // Khởi tạo một mảng stack với dung lượng ban đầu
    public stackResize(int n) {
        this.capacity = n;
        this.stackArray = new Object[n];
        this.size = 0;
    }

    // Đẩy một phần tử vào stack
    public void push(T item) {
        if (size == capacity) {
            // Nếu mảng đã đầy, thực hiện tăng gấp đôi dung lượng
            resize(capacity * 2);
        }
        stackArray[size++] = item;
    }

    // Lấy và xóa phần tử đầu tiên khỏi stack
    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        T item = (T) stackArray[--size];
        stackArray[size] = null;
        if(size > 0 && size == stackArray.length/4) {
            resize(stackArray.length/2);
        }
        return item;
    }

    //Kiểm tra xem stack có rỗng hay không
    public boolean isEmpty() {
        return size == 0;
    }

    //Lấy kích thước hiến tại của stack
    public int getSize() {
        return size;
    }

    //Thực hiện resize mảng stack
    private void resize(int newCapacity) {
        stackArray = Arrays.copyOf(stackArray, newCapacity);
        capacity = newCapacity;
    }

    public static void main(String[] args) {
        stackResize<Integer> stack = new stackResize<>(5);

        // Push các phần tử vào stack
        for (int i = 1; i <= 10; i++) {
            stack.push(i);
        }
        // Pop và in các phần tử ra khỏi stack
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
        System.out.println(stack.getSize()+ "   huy");
    }
}