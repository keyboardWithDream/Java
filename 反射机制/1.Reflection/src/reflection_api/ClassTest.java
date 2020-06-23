package reflection_api;

/**
 * java.lang.Class 对象的获取方式
 *
 * @Author: Harlan
 * @Date: 2020/6/23 17:35
 */
public class ClassTest {

    public static void main(String[] args) {
        //类的路径
        String path = "test.Test";

        try {
            //一个类加载后,JVM会创建一个对应该类的Class对象,类的整个结构信息会放到对应的Class对象中
            //这个Class对象就像一面镜子一样, 通过这面镜子可以看到对应类的全部信息
            //类信息只会被加载一次 一个类只有一个Class对象
            //获取Class 对象
            Class<?> clazz = Class.forName(path);
            System.out.println(clazz);
            System.out.println(clazz.hashCode());

            System.out.println("============");

            Class<?> strClazz = String.class;
            Class<?> strClass2 = path.getClass();
            System.out.println(strClazz == strClass2);

            System.out.println("============");

            //类和长度无关 和 维度相关
            int[] arr1 = new int[10];
            int[] arr2 = new int[30];
            int[][] arr3 = new int[10][10];
            Class<?> arr1Clazz = arr1.getClass();
            Class<?> arr2Clazz = arr2.getClass();
            Class<?> arr3Clazz = arr3.getClass();
            System.out.println(arr1Clazz.hashCode());
            System.out.println(arr2Clazz.hashCode());
            System.out.println(arr3Clazz.hashCode());

            System.out.println("============");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
