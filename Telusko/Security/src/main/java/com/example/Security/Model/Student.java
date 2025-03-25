package com.example.Security.Model;

public class Student {
    private int age;
    private String name;
    private String skill;

    public Student(int age, String name, String skill) {
        this.age = age;
        this.name = name;
        this.skill = skill;
    }

    public Student() {
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }
}
