package sort;

/**
 * 插入排序
 */
public class InsertionSort {

    /**
     * 插入排序
     *
     * @param source
     */
    public static void sort(int[] source) {
        int length = source.length;
        for (int i = 1; i < length; i++) {
            int temp = source[i];
            int j = i - 1;
            //查找插入的位置
            for (; j >= 0; j--) {
                if (temp < source[j]) {
                    //数据移动
                    source[j + 1] = source[j];
                } else {
                    break;
                }
            }
            source[j + 1] = temp;
        }
    }

    public static void main(String[] args) {
        int[] ints = new int[]{4, 5, 6, 1, 3, 2};
        int[] ints1 = new int[]{4, 5, 3, 2, 1, 2};
        int[] ints2 = new int[]{1, 2, 3, 4, 5, 6};
        int[] ints3 = new int[]{6, 5, 4, 3, 2, 1};
        InsertionSort.sort(ints);
        InsertionSort.sort(ints1);
        InsertionSort.sort(ints2);
        InsertionSort.sort(ints3);
    }
}
