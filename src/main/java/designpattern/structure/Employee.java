package designpattern.structure;

/**
 * Created by samo on 2018/4/29.
 *
 * @author samo
 * @date 2018/04/29
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 组合模式用于表示具有层次结构的数据，使得我们对单个对象和组合对象的访问具有一致性。

 直接看一个例子吧，每个员工都有姓名、部门、薪水这些属性，同时还有下属员工集合（虽然可能集合为空），而下属员工和自己的结构是一样的，也有姓名、部门这些属性，同时也有他们的下属员工集合。

 通常，这种类需要定义 add(node)、remove(node)、getChildren() 这些方法。

 */
public class Employee {
    private String name;
    private String dept;
    private int salary;
    private List<Employee> subordinates; // 下属

    public Employee(String name,String dept, int sal) {
        this.name = name;
        this.dept = dept;
        this.salary = sal;
        subordinates = new ArrayList<Employee>();
    }

    public void add(Employee e) {
        subordinates.add(e);
    }

    public void remove(Employee e) {
        subordinates.remove(e);
    }

    public List<Employee> getSubordinates(){
        return subordinates;
    }

    public String toString(){
        return ("Employee :[ Name : " + name + ", dept : " + dept + ", salary :" + salary+" ]");
    }
}
