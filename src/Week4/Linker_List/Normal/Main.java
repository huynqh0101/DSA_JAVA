package Week4.Linker_List.Normal;


public class Main {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.append(1);
        list.append(1);//2
        list.append(3);//3
        list.prepend(1);
        list.insertAt(5,3);//5
        list.append(1);
        list.printList();

        list.removeAll(1);
        System.out.println();
        list.printList();

        list.Sort();
        System.out.println();
        list.printList();




       /* list.remove1(1);
        System.out.println();
        list.printList();


        list.remove2(1);
        System.out.println();
        list.printList();*/
    }
}
