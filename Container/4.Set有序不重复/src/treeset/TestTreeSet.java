package treeset;

import java.util.Set;
import java.util.TreeSet;

/**
 * 学习TreeSet的使用
 * 底层是ThreeMap
 * @Author: Harlan
 * @Date: 2020/6/6 16:06
 */
public class TestTreeSet {

    public static void main(String[] args) {
        Set<Integer> set = new TreeSet<>();

        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);
        set.add(5);
        for (Integer i : set) {
            System.out.println(i);
        }



        Set<Employee> eSet = new TreeSet<>();
        eSet.add(new Employee(1001,"harlan",1000));
        eSet.add(new Employee(1002,"胡号南",3000));
        eSet.add(new Employee(1003,"吴亦凡",8000));
        eSet.add(new Employee(1004,"马思维",7000));
        eSet.add(new Employee(1005,"蔡徐坤",9000));
        for (Employee employee : eSet) {
            System.out.println(employee.toString());
        }
    }
}

/**
 * 实现 Comparable 接口 重写compareTo()方法
 * 进行排序
 */
class Employee implements Comparable<Employee> {
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
     *
     * @param o 对比对象
     * @return 比较值
     */
    @Override
    public int compareTo(Employee o) {
        if (this.salary > o.salary) {
            return 1;
        } else if (this.salary < o.salary) {
            return -1;
        } else {
            if (this.id > o.id) {
                return 1;
            } else if (this.id < o.id) {
                return -1;
            } else {
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
