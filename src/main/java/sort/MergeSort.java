package sort;

import java.util.Arrays;

/**
 * 归并排序
 */
public class MergeSort {

    public void sort(int[] source) {
        mergeSort(source, 0, source.length - 1);
    }

    private void mergeSort(int[] source, int p, int r) {
        if (p >= r) {
            return;
        }

        int q = (p + r) / 2;
        mergeSort(source, p, q);
        mergeSort(source, q + 1, r);

        merge(source, p, q, r);
    }

    private void merge(int[] source, int p, int q, int r) {
        int i = p;
        int j = q + 1;
        int k = 0;

        int[] temp = new int[r - p + 1];

        while (i <= q && j <= r) {
            if (source[i] <= source[j]) {
                temp[k++] = source[i++];
            } else {
                temp[k++] = source[j++];
            }
        }

        int start = i;
        int end = q;
        if (j <= r) {
            start = j;
            end = r;
        }
        for (; start <= end; ) {
            temp[k++] = source[start++];
        }

        for (int m = 0; m < temp.length; m++) {
            source[p + m] = temp[m];
        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 4, 8, 9, 2, 3, 6};
        int[] b = new int[]{2, 10, 80, 999, 222, 33, 62};

        MergeSort mergeSort = new MergeSort();
        mergeSort.sort(a);
        mergeSort.sort(b);

        Arrays.stream(a).forEach(System.out::println);
        Arrays.stream(b).forEach(System.out::println);
    }
}
