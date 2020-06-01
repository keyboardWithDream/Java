package two_dimensional_array;

import java.util.Arrays;

/**
 * 二维数组
 * @author Harlan
 */
public class TwoDimensionalArray {

    public static void main(String[] args) {
        //动态数组定义
        int[][] array = new int[3][];
        array[0] = new int[] {1, 2};
        array[1] = new int[] {3, 4, 5};
        array[2] = new int[] {6, 7, 8, 9};

        //Object 数组
        Object[][] array2 = {
                {"ID", "姓名", "年龄", "职能", "入职日期"},
                {1001, "Harlan", 23, "学生", "2017-9-1"},
                {1002, "HuHaonan", 24, "学生", "2018-9-2"},
                {1003, "LQ", 25, "学生", "2019-9-1"}
        };

        for (Object[] arr : array2) {
            System.out.println(Arrays.toString(arr));
        }
    }
}
