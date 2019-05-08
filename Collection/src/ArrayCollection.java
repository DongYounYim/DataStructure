import java.util.AbstractCollection;
import java.util.Iterator;

public class ArrayCollection extends AbstractCollection {
    private final int INITIAL_LENGTH = 16;
    private int size;
    private Object a[] = new Object[INITIAL_LENGTH];

    public boolean add(Object obj) {
        a[size++] = obj;
        return true;
    }
    @Override
    public Iterator iterator() {
        return new Iterator() {
            private int i = 0;
            private boolean okToRemove =  false;
            @Override
            public boolean hasNext() {
                return (i < size);
            }

            @Override
            public Object next() {
                if (i == size) throw new RuntimeException();
                okToRemove = true;
                return a[i++];
            }

            @Override
            public void remove() {
                if(!okToRemove) throw new IllegalStateException();
                a[--i] = a[--size];
                a[size] = null;
                okToRemove = false;
             }
        };
    }

    @Override
    public int size() {
        return size;
    }
}
