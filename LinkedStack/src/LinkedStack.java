import java.util.LinkedList;

public class LinkedStack {
    private LinkedList list;

    public LinkedStack() {
        list = new LinkedList();
    }

    public Object peak() {
        Object last = list.getLast();
        return last;
    }

    public Object pop() {
        int i = 0;
        for(; i < list.size()-1; i++) { }
        Object last = list.get(i);
        list.removeLast();
        return last;
    }

    public void push(Object object) {
        list.addLast(object);
    }

    public int size() {
        int count = 0;
        for(int i = 0; i < list.size(); i++)
            count++;
        return count++;
    }

    @Override
    public String toString() {
        int i = 0;
        String s = "";
        for(; i < list.size(); i++) {
            s = list.get(i) + s;
        }
        return s;
    }

    public Object peekSecond() {
        Node p = (Node) list.getFirst();
        if(p.next == null)
            return null;
        Object second = p.next.digit;
        return second;
    }

    public Object bottom() {
        Object bottom = list.getFirst();
        return bottom;
    }
}