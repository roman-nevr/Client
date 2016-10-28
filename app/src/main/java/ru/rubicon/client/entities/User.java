package ru.rubicon.client.entities;

/**
 * Created by Витя on 25.10.2016.
 */

public class User {
    private String name;
    private int age;

    public User(){
        this.age = 8;
        this.name = "Timur";
    }

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
