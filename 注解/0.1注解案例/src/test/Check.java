package test;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 检查Bug的注解
 * 简单的测试框架
 * 效果: 当主方法执行后, 会自动检测被检测的所有方法(有@Check的方法),记录异常
 * @Author: Harlan
 * @Date: 2020/6/24 20:47
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Check {
}
