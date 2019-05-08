public class CircularQueue {
    int front = 0, rear = 0;
    int size;
    int MAX_QUEUE_SIZE;
    private Object[] array;

    public CircularQueue(int MAX_QUEUE_SIZE) {
        array = new Object[MAX_QUEUE_SIZE];
        this.MAX_QUEUE_SIZE = MAX_QUEUE_SIZE;
    }

    public Object peek() {
        Object first = array[front+1];
        return first;
    }

    public Object dequeuer() {                              //원소삭제
        if(isEmpty()) {
            System.out.println("삭제할 원소가 없습니다.");
            return null;
        }
        Object first = array[++front%MAX_QUEUE_SIZE];
        array[front%MAX_QUEUE_SIZE] = null;
        size--;
        return first;
    }

    public Boolean enqueue(Object object) {                 //원소삽입
        if(isFull()) {
            System.out.println("큐가 가득 찼습니다.");
            return false;
        }
        array[++rear%MAX_QUEUE_SIZE] = object;
        size++;
        return true;
    }

    public int size() {
        return size;
    }

    public Boolean isFull() {
        if(size == MAX_QUEUE_SIZE)
            return true;
        return false;
    }

    public Boolean isEmpty() {
        if(size == 0)
            return true;
        return false;
    }
}
