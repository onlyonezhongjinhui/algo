package sort;

/**
 * 冒泡排序
 */
public class BubbleSort {

    /**
     * 冒泡排序
     *
     * @param source
     */
    public void sort(int[] source) {
        int length = source.length;
        for (int i = 0; i < length; i++) {
            //提前退出冒泡循环标志位
            boolean swap = false;
            for (int j = 0; j < length - 1 - i; j++) {
                if (source[j] > source[j + 1]) {
                    int temp = source[j];
                    source[j] = source[j + 1];
                    source[j + 1] = temp;
                    //有数据交换
                    swap = true;
                }
            }
            if (!swap) {
                //没有数据交换，提前退出
                break;
            }
        }
    }
}
