public class Quick_Sort {
    void Quicksort(int a[], int low, int high) {
        if (low < high) {
            int pivot_location = Partition(a, low, high);
            Quicksort(a, low, pivot_location);
            Quicksort(a, pivot_location + 1, high);
        }
    }

    int Partition(int a[], int low, int high) {
        int pivot = a[low];
        int leftwall = low;

        for(int i = low + 1; i <= high; i++) {
            if(a[i] < pivot) {
                swap(a, i, leftwall+1);
                leftwall = leftwall + 1;
            }
        }
        swap(a, low, leftwall); //오류

        return leftwall;
    }

    void swap(int a[], int b, int c) {
        int temp = a[b];
        a[b] = a[c];
        a[c] = temp;
    }
}
