package customize_annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义注解
 * 元注解: 负责注解其它注解 - @Target @Retention @Documented @Inheritd
 * -@Target: 描述注解使用范围
 * -@Retention: 保留策略(生命周期)
 *
 * @Author: Harlan
 * @Date: 2020/6/21 11:54
 */

@Target(value = {ElementType.METHOD, ElementType.TYPE})
@Retention(value = RetentionPolicy.RUNTIME)
public @interface CustomizeAnnotation {
    //参数类型 和 参数名 及 默认值(负数可表示不存在)
    String studentName() default "";
    int age() default -1;
    String[] school() default {"重庆人文科技学院", "重庆大学"};
}

