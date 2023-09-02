package com.example.listviewexample;

public class Person {

    private String name;
    private String fname;
    private int age;

    public Person(String name, String fname, int age) {
        this.name = name;
        this.fname = fname;
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getFname() {
        return fname;
    }

    public int getAge() {
        return age;
    }
}
