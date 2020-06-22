package orm;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 * 使用反射 读取 注解的信息,模拟处理注解信息的流程
 * @Author: Harlan
 * @Date: 2020/6/22 12:03
 */
public class Test {

    public static void main(String[] args){
        try {
            Class clz = Class.forName("orm.Student");

            //获取类的所有有效注解信息
            Annotation[] annotations = clz.getAnnotations();
            for (Annotation a : annotations) {
                System.out.println(a.toString());
            }

            System.out.println("============================");

            //获取对应的注解信息
            Annotation annotation = clz.getAnnotation(StuTable.class);
            System.out.println(annotation.toString());

            System.out.println("============================");

            //向下转型获取值对应注解的值
            StuTable stu = (StuTable)annotation;
            System.out.println(stu.value());

            System.out.println("============================");

            //获取类所有属性的注解
            Field[] fields = clz.getDeclaredFields();
            for (Field field : fields) {
                System.out.println(field.getAnnotation(StuField.class));
            }

            System.out.println("============================");

            //获得指定属性的注解
            Field field = clz.getDeclaredField("studentName");
            StuField stuField = field.getAnnotation(StuField.class);
            System.out.println(stuField.columnName()+"--"+stuField.type()+"--"+stuField.length());

            System.out.println("============================");

            StuTable stuTable = (StuTable)clz.getAnnotation(StuTable.class);

            //根据获得的信息,拼出DDL语句,使用JDBC执行SQL,在数据库中生成相关的表
            String create_stu_table = "create table " + stuTable.value() +"  ....";
            System.out.println(create_stu_table);


        } catch (ClassNotFoundException | NoSuchFieldException e) {
            e.printStackTrace();
        }
    }
}
