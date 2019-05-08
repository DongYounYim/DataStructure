import java.util.AbstractCollection;
import java.util.Iterator;

public class LinkedCollection extends AbstractCollection {
    private static class Node {
        Object object;
        Node prev, next;
        Node () {
            prev = next = this;
        }
        Node(Object o, Node p, Node n) {
            object = o;
            prev = p;
            next = n;
        }
    }
    private int size;
    private  Node head = new Node();        //dummy head node

    public boolean add(Object object) {
        head.prev = head.prev.next = new Node(object, head.prev, head);
        ++size;
        return true;
    }
    @Override
    public Iterator iterator() {
        return new Iterator() {
            private Node cursor = head.next;
            private boolean okToRemove = false;
            @Override
            public boolean hasNext() {
                return cursor != null;
            }

            @Override
            public Object next() {
                if(cursor == head) throw new RuntimeException();
                okToRemove = true;
                Object object = cursor.object;
                cursor = cursor.next;
                return object;
            }

            public void remove() {
                if(!okToRemove) throw new IllegalStateException();
                cursor.prev = cursor.prev.prev;
                cursor.prev.next = cursor;
                --size;
                okToRemove = false;
            }
        };
    }

    @Override
    public int size() {
        return size;
    }
}
