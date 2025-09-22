package com.samit.java8.cheatseatImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;

class Person{
    private String name;
    private int age;
    private int salary;

    public Person(int age, String name, int salary) {
        this.age = age;
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public int getSalary() {
        return salary;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }
}


public class ComparatorInterFace {

    public static void main(String[] args) {
        List<Person> list=new ArrayList<Person>();
        list.add(new Person(23,"Samit",1000));
        list.add(new Person(26,"Deepak",2400));
        list.add(new Person(28,"Abhishek",3000));

        Comparator<Person> comparatorP=( o1,  o2) ->o2.getSalary()-o1.getSalary();
        System.out.println(list);
        list.sort(comparatorP);
        System.out.println(list);

    }
}
