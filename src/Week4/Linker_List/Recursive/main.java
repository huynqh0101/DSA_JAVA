package Week4.Linker_List.Recursive;

public class main {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.append(1);
        list.append(2);
        list.append(2);
        list.append(3);
        list.removeAll(2);
        list.printList();
        if(list.search(2)) {
            System.out.println("Tim thay");
        } else {
            System.out.println("Khong tim thay");
        }
    }
}
