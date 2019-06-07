public class Heap_Sort {
    void bulidHeap(int[] a, int i, int n) {
        if (i >= n/2) return;
        bulidHeap(a,2*i+1, n);
        bulidHeap(a,2*i+2, n);
        heapify(a, i, n);
    }

    void heapify(int[] a, int i, int n) {
        int ai = a[i];
        while(i < n/2) {
            int j = 2 * i + 1;
            if(j+1 <= ai) break;
            a[i] = a[j];
            i = j;
            a[i] = ai;
        }
    }
}
