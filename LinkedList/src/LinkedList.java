public class LinkedList implements List {
    private Node start = null;

    @Override
    public void insert(int x) {
        Node p = start;
        if(start == null) {
            start = new Node(x);
            p = start;
        } else if(p.next == null) {
            if(p.value > x) {
                Node temp = p;
                start = new Node(x);
                p = start;
                p.next = temp;
            } else if(p.value < x) {
                p.next = new Node(x);
            }
        }
        else {
            for(; p.next != null; p = p.next) {
                if(p.value < x && x <= p.next.value) {
                    Node temp = p.next;
                    p.next = new Node(x);
                    p.next.next = temp;
                    break;
                } else if (p.value > x) {               //0으로 실험
                    Node temp = p;
                    start = new Node(x);
                    p = start;
                    p.next = temp;
                    break;
                }
            }
            if(p.next == null)
                p.next = new Node(x);
        }
    }

    @Override
    public void delete(int x) {
        Node p = start;
        if(start.value == x) {
            start = start.next;
            p = start;
        }
        else {
            Node q = p;                     //Node q 는 p의 이전위치를 표시(처음에만 동일) 만약 처음이라면 위에서 처리
            while (p.next != null) {
                if (p.value == x) {
                    q.next = p.next;
                    p = null;
                    break;
                }
                if ((p.next.next == null) && (p.next.value == x)) {
                    p.next= null;
                    break;
                }
                q = p;
                p = p.next;
            }
        }
    }

    @Override
    public Boolean addFirst(int x) {
        Node p = start;
        if(x < start.value) {
            Node q = new Node(x);
            q.next = p;
            start = q;
            p = start;
            return true;
        }
        return false;
    }

    @Override
    public Boolean addLast(int x) {
        Node p = start;
        for(; p.next != null; p = p.next) { }
        if(p.next == null && p.value < x) {
            p.next = new Node(x);
            return true;
        }
        else
            return false;
    }

    @Override
    public void deleteLast() {
        Node p = start;
        for(; p.next.next != null; p=p.next) { }
        p.next = null;
    }

    @Override
    public int getLength() {
        int count = 1;
        if(start == null) {
            return 0;
        }
        Node p = start;
        while (p.next != null) {
            count++;
            p = p.next;
        }
        return count;
    }

    @Override
    public void printList() {
        Node p = start;
        System.out.print("{");
        while(p != null) {
            System.out.print(p.value + " ");
            p = p.next;
        }
        System.out.println("}");
    }

    @Override
    public void clear() {
        start = null;
    }

}
