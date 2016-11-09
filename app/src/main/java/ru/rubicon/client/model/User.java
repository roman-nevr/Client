package ru.rubicon.client.model;

import java.util.Random;

/**
 * Created by Витя on 25.10.2016.
 */

public class User {
    private String name;
    private int age;
    private static Random random = new Random();

    public User(){
        this.age = random.nextInt(100);
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
