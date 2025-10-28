package com.samit.designpattern.builder;

public class BuilderPattern {

    public static void main(String[] args) {
        User u1=new User.UserBuilder().setEmail("samit@gmail.com").setName("Sami").setAge(26).build();
        System.out.println(u1);
        User u2=u1.clone();
        System.out.println(u2);
        System.out.println(u1==u2);
        System.out.println(u2.getName());
        System.out.println(u2.getEmail());
        System.out.println(u2.getAge());
    }
}
