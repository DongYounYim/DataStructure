

public class Main {
    public static void main(String args[]) {
        int a[] = {99, 44, 22, 11, 55, 66, 33, 88, 77};
        int b[] = {99, 44, 22, 11, 55, 66, 33, 88, 77};
        print(a);
        Merge_Sort m = new Merge_Sort();
        a = m.mergesort(a);
        print(a);
        System.out.println();

        print(b);
        Quick_Sort q = new Quick_Sort();
        q.Quicksort(b, 0, b.length - 1);
        print(b);
    }

    static void print(int a[]) {
        System.out.print("{ ");
        for(int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println("}");
    }
}
