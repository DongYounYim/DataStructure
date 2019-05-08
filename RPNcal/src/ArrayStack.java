public class ArrayStack implements Stack {
    private Object as[];
    private int size;
    public ArrayStack(int capacity) {
        as = new Object[capacity];
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    @Override
    public Object peek() {
        if(size == 0) throw new IllegalStateException("Stack is empty");
        return as[size-1];
    }

    @Override
    public Object pop() {
        if(size == 0) throw new IllegalStateException("Stack is empty");
        Object object = as[--size];
        as[size] = null;
        return object;
    }

    @Override
    public void push(Object object) {
        if(size == as.length) resize();
        as[size++] = object;                                                      //?
    }

    @Override
    public int size() {
        return size;
    }

    private void resize() {
        Object[] c_as = as;
        as = new Object[2 * c_as.length];
        System.arraycopy(c_as, 0, as, 0, size);
    }
}
