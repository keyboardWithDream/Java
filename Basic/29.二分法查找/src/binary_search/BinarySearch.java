package binary_search;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 二分法查找
 * @author Harlan
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] array = {1, 8, 3, 6, 5, 4, 7, 3, 9, 0};
        System.out.println(binarySearch(array,7));
    }


    public static int binarySearch(int[] array, int value){
        //先排序
        Arrays.sort(array);
        int low = 0;
        int high = array.length - 1;
        while (low <= high){
            int mid = (low + high) / 2;
            if (value == array[mid]){
                return mid;
            }else if (value > array[mid]){
                low = mid + 1;
            }else if (value < array[mid]){
                high = mid - 1;
            }
        }
        System.out.println("not find");
        return  -1;
    }
}
