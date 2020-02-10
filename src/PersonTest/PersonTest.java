package PersonTest;

import java.sql.SQLOutput;
import java.util.GregorianCalendar;
import java.util.*;

public class PersonTest {
    public static void main(String[] args) {
        Person[] people=new Person[2];
        people[0]=new Employee("Herry Hacker",5000,1989,10,1);
        people[1]=new Student("Maria Morris","Computer science");//多态性
        for(Person p:people) {
            System.out.println(p.getName() + "," + p.getDescription());
        }
    }
}
abstract class Person//抽象类
{
    public Person(String n)//构造器
    {
        name=n;
    }
    public abstract String getDescription();//抽象类中定义方法
    public String getName()
    {
        return name;
    }
    private String name;
}
class Employee extends Person{
    public Employee(String n,double s,int year,int month,int day)
    {
        super(n);
        salary=s;
        GregorianCalendar calender=new GregorianCalendar(year,month-1,day);
        hireDay=calender.getTime();
    }
    public double getSalary()
    {
        return salary;
    }
    public Date getHirDay(){
        return hireDay;
    }
    public String getDescription()
    {
        return String.format("an employee with a salary of $%.2f",salary);//这里的$是一个美元符号的意思
    }
    public void raiseSalary(double byPercent)
    {
        double raise=salary * byPercent/100;
        salary+=raise;
    }
    private double salary;
    private Date hireDay;
}
class Student extends Person{
    public Student(String n,String m)
    {
        super(n);//调用父类（Frame）构造函数，s为传入的参数，也就是调用了父类 public Frame(String s){ ...}构造函数
        major=m;
    }
    public String getDescription()
    {
        return "a student majoring in "+major;
    }
    private String major;

}
/**
 * super出现在继承了父类的子类中。有三种存在方式：
 * 第一种
 * super.xxx;(xxx为变量名或对象名)
 * 这种方法意义为，获取父类中的名字为xxx的变量或方法引用。
 * 使用这种方法可以直接访问父类中的变量或对象，进行修改赋值等操作
 * 第二种
 * super.xxx();(xxx为方法名)
 * 这种方法意义为，直接访问并调用父类中的方法。
 * 第三种
 * super();
 * 这种方法意义为，调用父类的初始化方法，其实就是调用父类中的public xxx()方法
 */