public class Main {
    public static void main(String[] args) {

        List list = new LinkedList();

        list.insert(3);
        list.insert(1);
        list.insert(5);
        list.insert(7);
        list.insert(2);
        list.insert(5);
        list.printList();

        list.delete(7);
        list.printList();


        list.delete(3);
        list.printList();


        list.addLast(7);
        list.printList();


        list.deleteLast();
        list.printList();


        list.addFirst(0);
        list.delete(9);
        list.printList();
        System.out.println("해당 리스트의 크기는 "+list.getLength()+" 입니다.");


        list.clear();
        list.printList();
        System.out.println("해당 리스트의 크기는 "+list.getLength()+" 입니다.");

    }

}
