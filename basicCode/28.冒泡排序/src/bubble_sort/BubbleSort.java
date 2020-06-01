package bubble_sort;

import java.util.Arrays;

/**
 * 冒泡排序
 * @author Harlan
 */
public class BubbleSort {
    static public void bubbleSort(int[] array){
        int len = array.length;
        boolean flag;
        int temp = 0;
        for (int j = 0; j < len -1; j++) {
            //判断是否交换位置
            flag = true;
            for (int i = 0; i < len - 1 - j; i++) {
                //比较大小,换顺序
                if (array[i] > array[i + 1]){
                    temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    flag = false;
                }
            }
            if (flag){
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {1, 8, 3, 6, 5, 4, 7, 3, 9, 0};
        bubbleSort(array);
        System.out.println(Arrays.toString(array));
    }
}
