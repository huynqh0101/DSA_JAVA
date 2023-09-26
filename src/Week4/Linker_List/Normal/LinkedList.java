package Week4.Linker_List.Normal;

public class LinkedList {
    Node head;

    public LinkedList() {
        head = null;
    }

    //Chen vao cuoi danh sach
    public void append(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    //Chen vao dau danh sach lien ket
    public void prepend(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    //Chen vao vi tri bat ki trong danh sach
    public void insertAt(int data, int postion) {
        Node newNode = new Node(data);

        if(postion == 0) {
            prepend(data);
            return;
        }
        Node current = head;
        int currentPostion = 0;
        while (current!= null && currentPostion< postion-1) {
            current = current.next;
            currentPostion++;
        }
        if(current == null) {
            System.out.println("Vi tri chen khong hop le");
            return;
        }
        newNode.next = current.next;
        current.next = newNode;
    }

    //Xoa 1 phan tu cu the co gia tri bang data
    public void remove1(int data) {
        if(head == null) {
            System.out.println("Danh sach trong.");
        }
        if (head.data == data) {
            head = head.next;
            return;
        }
        Node current = head;
        Node previous = null;
        while(current!=null && current.data!= data) {
            previous =current;
            current = current.next;
        }
        if(current == null) {
            System.out.println("Khong tim thay gia tri can xoa");
        }
        previous.next = current.next;
    }

    //Xoa phan tu co vi tri postion
    public void remove2(int postion) {
        if (postion == 0) {
            head = head.next;
            return;
        }
        Node current = head;
        int currentPostion = 0;
        while(current.next!= null && currentPostion < postion-1) {
            current = current.next;
            currentPostion++;
        }
        if (current == null || current.next== null) {
            System.out.println("Vi tri xoa khong hop le.");
            return;
        }
        current.next = current.next.next;
    }

    //Xoa tat ca cac phan tử có giá trị bằng data
    public void removeAll(int data) {
        if(head == null) {
            System.out.println("danh sach trong.");
            return;
        }
       while (head != null&&head.data == data) {
           head = head.next;
       }
        Node current = head;
        Node previous = null;
        while(current !=null) {
            if(current.data == data) {
                previous.next = current.next;
                current = current.next;
            } else {
                previous = current;
                current=current.next;
            }
        }
    }

    //Xap xep Linkedlist
    public void Sort() {
        for (Node q = head; q!=null; q=q.next) {
            for( Node p = q.next; p!=null; p= p.next) {
                if(q.data < p.data) {
                    int tmp = q.data;;
                    q.data = p.data;
                    p.data = tmp;
                }
            }
        }
    }
    //In danh sach
    public void printList() {
        Node current = head;
        if(head == null) {
            System.out.println("Danh sach trong.");
        }
        while (current != null) {
            System.out.print(current.data + "->");
            current = current.next;
        }
        System.out.print("null");
    }
}
