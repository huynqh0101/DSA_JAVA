package Week7;

import java.util.LinkedList;

class PriorityQueue {
    private LinkedList<Integer> queue;

    public PriorityQueue() {
        queue = new LinkedList<>();
    }

    public void insert(int value) {
        if (queue.isEmpty() || value <= queue.getFirst()) {
            queue.addFirst(value);
        } else {
            int index = 0;
            while (index < queue.size() && value > queue.get(index)) {
                index++;
            }
            queue.add(index, value);
        }
    }

    public int deleteMin() {
        if (queue.isEmpty()) {
            throw new IllegalStateException("Priority Queue is empty");
        }
        return queue.removeFirst();
    }
}

public class Bai8 {
    public static void main(String[] args) {
        PriorityQueue pq = new PriorityQueue();
        pq.insert(5);
        pq.insert(2);
        pq.insert(10);

        System.out.println(pq.deleteMin());
        System.out.println(pq.deleteMin());
        System.out.println(pq.deleteMin());
    }
}
