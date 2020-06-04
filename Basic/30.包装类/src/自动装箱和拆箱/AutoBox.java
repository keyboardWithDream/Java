package 自动装箱和拆箱;

/**
 * 自动装箱和拆箱
 * @author Harlan
 */
public class AutoBox {

    public static void main(String[] args) {
        //自动装箱
        //编译器自动转译为 Integer num = Integer.valueOf(446)
        //而不是new Integer()
        Integer num = 446;

        //自动拆箱
        //编译器自动转译为 int b = num.intValue();
        int num2 = num;

        //判断空指针
        Integer num3 = null;
        if (num3 != null){
            int num4 = num3;
        }

        /**
         * 缓存[-128,127]之间的数
         * 当我们调用valueOf()方法的时候,首先检测是否在缓存区间
         * 如果在这个区间,则直接从缓存数组中拿出已经建好的对象(同一个对象)
         * 如果不在这个范围,则创建新的Integer对象(不同对象)
         */
        Integer in1 = -128;
        Integer in2 = -128;
        /* true 因为在-128在缓存范围内 (同一对象)*/
        System.out.println(in1 == in2);
        /* true */
        System.out.println(in1.equals(in2));
    }
}
