public class PriorityQueue_Node {
    private Node[] Heap;
    private int size;
    private int maxsize;

    public PriorityQueue_Node(int maxsize) {
        this.maxsize = maxsize;
        Heap = new Node[maxsize];
        size = 0;
    }

    public void add(Node n) {
        if(Heap == null) {
            Heap[1] = n;
            size++;
        }
        else {
            int i = size++;
            while(i > 0) {
                int j = i;
                i = i / 2;
                if(Heap[i].priority <= n.priority) {
                    Heap[j] = n;
                    return ;
                }
                Heap[j] = Heap[i];
            }
            Heap[i] = n;
        }
    }

    public Node best() {
        if(Heap[1] == null) throw new java.util.NoSuchElementException();
        return Heap[1];
    }

    public void print() {
        for(int i = 1; i <= size; i++) {
            System.out.println(Heap[i].elements + " ");
        }
    }

    public Node removeBest() {
        Heap[1] = Heap[size];
        int i = 1;
        while(i > 0) {
            int j = 2 * i;
            int k = 2 * i + 1;
            if(Heap[j].priority < Heap[k].priority) {
                if(Heap[j].priority < Heap[i].priority) {
                    swap(Heap[j], Heap[i]);
                    i = j;
                } else
                    return Heap[1];               //최상위 노드 반환
            } else  {
                if(Heap[k].priority < Heap[i].priority) {
                    swap(Heap[k], Heap[i]);
                    i = k;
                } else
                    return Heap[1];               //최상위 노드 반환
            }
        }
        return Heap[1];
    }

    public int size() {
        return size;
    }

    private void swap(Node a, Node b) {
        Node temp = b;
        b = a;
        a = temp;
    }
}
