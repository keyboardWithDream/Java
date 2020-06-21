package annotation;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * 了解注解 Annotation
 * @Author: Harlan
 * @Date: 2020/6/21 11:03
 */
public class TestAnnotation {

    /**
     * 重写Object方法
     * 注解 @Override 重写
     * @return String
     */
    @Override
    public String toString() {
        return super.toString();
    }

    /**
     * 过时
     */
    @Deprecated
    public static void deprecated(){
        System.out.println("测试一个Deprecated方法...");
    }

    /**
     * 压制警告信息
     * 参数: deprecation(过时), unchecked(未检查的转换), fallthrough(switch 使用发生case穿透)
     * path(路径有不存在), serial(可序列化时缺少 serialVersionUID), all(以上所有)
     */
    @SuppressWarnings(value = {"unchecked", "all"})
    public static void suppressWarnings(){
        List list = new ArrayList();
    }
}

class Run {

    public static void main(String[] args) {
        TestAnnotation.deprecated();
    }
}
