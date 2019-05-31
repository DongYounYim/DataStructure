public class PriorityQueue_int {
    private int[] Heap;
    private int size;
    private int maxsize;

    public PriorityQueue_int(int maxsize) {
        this.maxsize = maxsize;
        Heap = new int[maxsize];
        size = 0;
    }

    public void add(int num) {
        if(Heap == null) {
            Heap[1] = num;
            size++;
        }
        else {
            int i = size++;
            while(i > 0) {
                int j = i;
                i = i / 2;
                if(Heap[i] >= num) {
                    Heap[j] = num;
                    return ;
                }
                Heap[j] = Heap[i];
            }
            Heap[i] = num;
        }
    }

    public int best() {
        if(Heap == null) throw new java.util.NoSuchElementException();
        return Heap[1];
    }

    public void print() {
        for(int i = 1; i <= size; i++) {
            System.out.println(Heap[i] + " ");
        }
    }

    public int removeBest() {               //자식노드와 비교해서 큰 값을 계속 올린다.
        Heap[1] = Heap[size];
        int i = 1;
        while(i > 0) {
            int j = 2 * i;
            int k = 2 * i + 1;
            if(Heap[j] > Heap[k]) {
                if(Heap[j] > Heap[i]) {
                    swap(Heap[j], Heap[i]);
                    i = j;
                } else
                    return i;               //최하위 노드가 삽입된 곳의 인덱스 반환
            } else  {
                if(Heap[k] > Heap[i]) {
                    swap(Heap[k], Heap[i]);
                    i = k;
                } else
                    return i;               //최하위 노드가 삽입된 곳의 인덱스 반환
            }
        }
        return i;
    }

    public int size() {
        return size;
    }

    public void swap(int a , int b) {
        int temp = b;
        b = a;
        a = temp;
    }
}
