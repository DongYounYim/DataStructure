public class Set implements Bag {
    private Object[] objects = new Object[1000];
    private int size=0, i=0;

    @Override
    public void add(Object object) {
        objects[size] = object;
        for(int i = 0; i < size - 1; i++) {
            if (objects[i].equals(object)) {
                objects[size] = null;
                size--;
                }
            }
        size++;
        }

    @Override
    public boolean contains(Object object) {
        for(int i = 0; i < size; i++) {
            if(objects[i].equals(object))
                return true;
        }
        return false;
    }

    @Override
    public Object getFirst() {
        i = 0;
        return objects[i];
    }

    @Override
    public Object getNext() {
        return objects[++i];
    }

    @Override
    public boolean remove(Object object) {
        for(int i = 0; i < size; i++) {
            if(objects[i].equals(object)) {
                objects[i] = null;
                for(int j = i; j < size; j++) {
                    objects[j] = objects[j+1];
                }
                return true;
            }
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }
}
