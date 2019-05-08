import java.util.*;

public class Sequence extends AbstractSequentialList {
    private Node head = new Node(null, null, null);
    private int size;
    public Sequence() {
        head.prev = head.next = head;
    }
    public Sequence(Collection collection) {
        this();
        addAll(collection); //addAll은 데이터를 통째로 붙이는 메서드
    }

    @Override
    public ListIterator listIterator(int index) {
        return new SequenceIterator(index);
    }

    @Override
    public int size() {
        return size;
    }

    private static class Node {//Node선언 Double LinkedList를위해 prev, next
        Node prev, next;
        Object object;
        Node(Node p, Node n, Object o) {
            this.prev = p;
            this.next = n;
            this.object = o;
        }
    }

    private class SequenceIterator implements ListIterator {
        private Node last, next;
        private int nextIndex;
        public SequenceIterator(int i) {
            if(i < 0 || i > size) throw new IndexOutOfBoundsException();
            nextIndex = i;
            next = head.next;
            for(int j = 0; j < i; j++)
                next = next.next;
        }
        public void add(Object object) {
            Node newNode = new Node(next.prev, next, object);
            newNode.prev.next = next.prev = newNode;
            ++size;
            ++nextIndex;
            last = null;
        }
        public boolean hasNext() {
            return nextIndex < size;
        }
        public boolean hasPrevious() {
            return nextIndex > 0;
        }

        public Object next() {//현재의 원소를 반환하고 다음 원소로 이동
            if(!hasNext()) throw new NoSuchElementException();
            last = next;//현재원소 저장
            next = next.next;//이동
            ++nextIndex;
            return last.object;//반환
        }
        public int nextIndex() {
            return nextIndex;
        }//next()할때 반환되는 원소의 index1

        @Override
        public Object previous() {//이전원소의 반환 및 이동
            if(!hasPrevious()) throw new NoSuchElementException();
            next = last = next.prev;
            --nextIndex;
            return last.object;
        }
        public int previousIndex() {
            return nextIndex - 1;
        }//previous()할 때 반환되는 원소의 indx
        public void remove() {
            if(last == null) throw new IllegalStateException();
            last.prev.next = last.next;//원소의 이전의 다음을 원소의 다음으로 바꾼다.
            last.next.prev = last.prev;//원소의 다음의 이전을 원소의 이전으로 바꾼다.
            last = null;//원소를 비운다.
            --size;//사이즈줄이기
            --nextIndex;//값줄이기
        }
        public void set(Object object) {//현재원소를 다른원소로 대체한다.
            if(last == null) throw new IllegalStateException();
            last.object = object;
        }
    }
}
