package treemap;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * 学习TreeMap
 * 在需要排序时用TreeMap
 * @Author: Harlan
 * @Date: 2020/6/6 15:00
 */
public class TestTreeMap {

    public static void main(String[] args) {
        Map<Integer, String> treeMap = new TreeMap<>();
        treeMap.put(1,"a");
        treeMap.put(2,"b");
        treeMap.put(3,"c");

        //ketSet() 返回key排序的集合
        for (Integer key : treeMap.keySet()) {
            System.out.println(key+ "---" +treeMap.get(key));
        }

        Map<Employee,String> eMap = new HashMap<>();
        eMap.put(new Employee(1001,"harlan",1000),"程序员");
        eMap.put(new Employee(1002,"胡号南",3000),"软件工程师");
        eMap.put(new Employee(1003,"吴亦凡",5000),"Rapper");
        eMap.put(new Employee(1004,"马思维",7000),"Rapper");
        eMap.put(new Employee(1005,"蔡徐坤",9000),"Singer");
        for (Employee employee : eMap.keySet()) {
            System.out.println(employee.toString()+ "---" +eMap.get(employee));
        }
    }
}

/**
 * 实现 Comparable 接口 重写compareTo()方法
 * 进行排序
 */
class Employee implements Comparable<Employee>{
    int id;
    String name;
    int salary;

    public Employee(int id, String name, int salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    /**
     * 自定义排序
     * 负数: 小于  ,  零 : 等于   ,正数 : 大于
     * @param o 对比对象
     * @return 比较值
     */
    @Override
    public int compareTo(Employee o) {
        if (this.salary > o.salary){
            return 1;
        }else if (this.salary < o.salary){
            return -1;
        }else {
            if (this.id > o.id){
                return 1;
            }else if (this.id < o.id){
                return -1;
            }else {
                return 0;
            }
        }
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}
