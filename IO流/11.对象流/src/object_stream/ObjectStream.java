package object_stream;

import javax.xml.crypto.Data;
import java.io.*;
import java.util.Date;

/**
 * 对象流 (序列化和反序列化)
 * 1.先写出,后读取
 * 2.读取的顺序与写出顺序必须一致
 * 3.不是所有的对象都可以序列化Serializable
 * ObjectInputStream
 * ObjectOutputStream
 *
 * @Author: Harlan
 * @Date: 2020/6/9 14:41
 */
public class ObjectStream {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ByteArrayOutputStream bAos = new ByteArrayOutputStream();
        ObjectOutputStream oOs = new ObjectOutputStream(new BufferedOutputStream(bAos));
        /* 对象 */
        oOs.writeObject("谁解其中味");
        oOs.writeObject(new Date());
        Employee emp = new Employee("马云",50);
        oOs.writeObject(emp);
        byte[] data = bAos.toByteArray();

        ObjectInputStream oIs = new ObjectInputStream(new BufferedInputStream(new ByteArrayInputStream(data)));
        Object str = oIs.readObject();
        Object date = oIs.readObject();
        Object maYun = oIs.readObject();

        //类型转换
        if (str instanceof String){
            String strObj = (String) str;
            System.out.println(strObj);
        }
        if (date instanceof Data){
            Date dateObj = (Date) date;
            System.out.println(dateObj);
        }
        if (maYun instanceof Employee){
            Employee maYunObj = (Employee) maYun;
            System.out.println(maYunObj.getName() + maYunObj.getAge());
        }
    }
}


/**
 * 继承序列化接口
 */
class Employee implements Serializable {
    private String name;
    private int age;

    public Employee() {

    }

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}