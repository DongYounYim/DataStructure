import java.lang.*;

public class Merge_Sort {
    int[] mergesort(int a[]) {
        if (a.length == 1)
            return a;

        int b[] = new int[a.length/ 2];
        int k;
        if(a.length % 2 == 0) {
            k = a.length / 2;
        } else {
            k = a.length / 2 + 1;
        }
        int c[] = new int[k];
        System.arraycopy(a, 0, b, 0, a.length / 2);
        System.arraycopy(a, a.length / 2, c, 0, k);

        b = mergesort(b);
        c = mergesort(c);

        return merge(b, c);
    }

    int[] merge(int a[], int b[]) {
        int c[] = new int[a.length + b.length];
        int i = 0;                  //a의 인덱스
        int j = 0;                  //b의 인덱스
        int k = 0;                  //c의 인덱스
        while(i < a.length && j < b.length) {
            if(a[i] > b[j]) {
                c[k] = b[j];
                k++;
                j++;
            } else if(a[i] <= b[j]) {
                c[k] = a[i];
                k++;
                i++;
            }
        }

        while (i < a.length) {
            c[k] = a[i];
            k++;
            i++;
        }

        while (j < b.length) {
            c[k] = b[j];
            k++;
            j++;
        }

        return c;

    }
}
