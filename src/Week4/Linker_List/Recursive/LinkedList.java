package Week4.Linker_List.Recursive;

public class LinkedList<Item> {
    Node<Item> head = null;

    //Thêm một phần tử vào cuối danh sách theo hàm đệ quy
    public void append(Item data) {
        head = appendRecursive(head, data);
    }
    private Node appendRecursive(Node current, Item data) {
        if(current == null) {
            return new Node(data, null);
        }
        current.next = appendRecursive(current.next, data);
        return current;
    }

    //In danh sách theo đệ quy
    public void printList() {
        printRecursive(head);
    }
    private void printRecursive(Node current) {
        if (current == null) {
            return;
        }
        System.out.print(current.data+ " ");
        printRecursive(current.next);
    }

    //Xóa node đầu tiên trong danh sách có giá trị bằng data sử dụng đệ quy.
    public void removeFirst(Item data) {
        head = removeFirst(data, head);
    }
    private Node removeFirst(Item data, Node cureent) {
        if(cureent == null) return null;
        if(cureent.data.equals(data)) return cureent.next;
        cureent.next = removeFirst(data, cureent.next);
        return cureent;
    }

    //Xóa tất cả các node trong danh sách có giá trị bằng data sử dụng đệ quy.
    public void removeAll(Item data) {
        head = removeAll(data, head);
    }
    private Node removeAll(Item data, Node current) {
        if(current == null) return null;
        if(current.data.equals(data)) {
            return removeAll(data, current.next);
        }
        current.next = removeAll(data, current.next);
        return current;
    }

    //Tìm một phần tử có giá trị cụ thể bằng đệ quy
    public boolean search(Item data) {
        return search(data, head);
    }
    private boolean search(Item data, Node current) {
        if(current == null) {
            return false;
        }
        if (current.data.equals(data)) {
            return true;
        }
        return search(data, current.next);
    }

}
