package map;

import java.util.HashMap;
import java.util.Map;

/**
 * 学习使用Map
 * 键不能重复
 * @Author: Harlan
 * @Date: 2020/6/5 17:28
 */
public class TestMap {

    public static void main(String[] args) {

        Map<Integer, String> map = new HashMap<>();
        map.put(1,"harlan");
        map.put(2,"hello");
        map.put(3,"world");
        System.out.println(map.get(1));
        System.out.println(map.size());
        System.out.println(map.isEmpty());
        System.out.println(map.containsKey(1));
        System.out.println(map.containsValue("hello"));
        Map<Integer, String> map1 = new HashMap<>();
        map1.put(4,"四");
        map1.put(5,"五");
        map.putAll(map1);
        System.out.println(map);


        Employee e1 = new Employee(1001,"harlan",150000);
        Employee e2 = new Employee(1002,"胡号南",300000);
        Employee e3 = new Employee(1003,"吴亦凡",20000);
        Map<Integer, Employee> mapOfElement = new HashMap<>();
        mapOfElement.put(e1.getId(),e1);
        mapOfElement.put(e2.getId(),e2);
        mapOfElement.put(e3.getId(),e3);
        System.out.println(mapOfElement);
        System.out.println(mapOfElement.get(1001).getName());
    }
}

/**
 * 雇员信息
 * id
 * name
 * salary
 */
class Employee{
    private int id;
    private String name;
    private double salary;

    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
