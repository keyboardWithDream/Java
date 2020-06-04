package arrays_tools;

import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;

/**
 * Arrays 工具类的使用
 * @author Harlan
 */
public class ArraysTools {

    public static void main(String[] args) {
        int[] arr = {1, 10, 3, 8, 5, 6, 7, 4, 9, 2};

        //打印数组内容
        System.out.println(Arrays.toString(arr));

        //数组排序
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));

        //数组查找(返回下标)
        System.out.println(Arrays.binarySearch(arr,5));
    }
}
