package collections;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 学习Collections工具类
 * 提供了对Set List Map 进行排序,填充,查找元素的辅助方法
 * @Author: Harlan
 * @Date: 2020/6/6 16:52
 */
public class TextCollections {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(""+ i);
        }
        System.out.println(list );

        //随机排列list中的元素
        Collections.shuffle(list);
        System.out.println(list);

        //逆序
        Collections.reverse(list);
        System.out.println(list);

        //顺序
        Collections.sort(list);
        System.out.println(list);

        //二分法查找 返回索引
        System.out.println(Collections.binarySearch(list, "4"));
    }
}
