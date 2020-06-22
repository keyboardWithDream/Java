package customize_annotation;

/**
 * 测试自定义注解
 * @Author: Harlan
 * @Date: 2020/6/22 11:22
 */

@CustomizeAnnotation
public class Test {

    @CustomizeAnnotation(studentName = "Harlan", age = 23,school = {"重庆大学", "清华大学"})
    public void testAnnotation(){

    }
}
