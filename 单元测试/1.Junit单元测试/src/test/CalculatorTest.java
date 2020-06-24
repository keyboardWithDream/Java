package test;

import junit.Calculator;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * 测试方法:
 * 1.创建测试包 - 创建测试类
 * 2.编写测试方法
 * 3.加入@Test 注解, 导入junit.Test
 *
 * @Author: Harlan
 * @Date: 2020/6/24 9:02
 */
public class CalculatorTest {
    /**
     * / @Before
     * 初始方法
     * 用于资源申请,所有测试方法在执行之前都会先执行该方法
     */
    @Before
    public void init(){
        System.out.println("init正在执行...");
    }

    /**
     * /@After
     * 释放资源方法
     * 在所有测试方法执行完后,都会自动执行
     */
    @After
    public void close(){
        System.out.println("close正在执行...");
    }

    /**
     * 测试加法
     */
    @Test
    public void testAdd(){
        //创建计算器对象
        Calculator c = new Calculator();
        //调用add方法
        double result = c.add(2.0,5.0);
        //断言
        Assert.assertEquals(7.0,result,0.0);
        System.out.println("testAdd正在执行...");
    }

    /**
     * 测试减法
     */
    @Test
    public void testSub(){
        Calculator c = new Calculator();
        double result = c.sub(4.0,6.0);
        Assert.assertEquals(-2.0,result,0.0);
        System.out.println("testSub正在执行...");
    }
}
