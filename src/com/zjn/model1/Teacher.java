package com.zjn.model1;

/**
 * 数据模型
 */
public class Teacher {

    private String name;
    private String description;
    private int age;
    private int id;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Teacher() {
    }

    public Teacher( String name, String description, int age,int id) {

        this.name = name;
        this.description = description;
        this.age = age;
        this.id=id;
    }

    public Teacher(String name, String description, int age) {
        this.name = name;
        this.description = description;
        this.age = age;

    }
}
