package sort;

import java.util.Arrays;

/**
 * 快速排序
 */
public class QuickSort {

    public void sort(int[] source) {
        quickSort(source, 0, source.length - 1);
    }

    private void quickSort(int[] source, int p, int r) {
        if (p >= r) return;

        int q = partition(source, p, r);

        quickSort(source, p, q - 1);
        quickSort(source, q + 1, r);
    }

    private int partition(int[] source, int p, int r) {
        int i = p;
        int j = p;
        int pivot = source[r];

        for (; j <= r - 1; j++) {
            if (source[j] < pivot) {
                int temp = source[i];
                source[i] = source[j];
                source[j] = temp;
                i++;
            }
        }

        int temp = source[i];
        source[i] = source[r];
        source[r] = temp;
        return i;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 4, 8, 9, 2, 3, 6};
        int[] b = new int[]{2, 10, 80, 999, 222, 33, 62};

        QuickSort quickSort = new QuickSort();
        quickSort.sort(a);
        quickSort.sort(b);

        Arrays.stream(a).forEach(value -> System.out.print(value + " "));
        System.out.println();
        Arrays.stream(b).forEach(value -> System.out.print(value + " "));
    }
}
