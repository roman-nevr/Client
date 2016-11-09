package ru.rubicon.client.model;

import java.util.Random;

/**
 * Created by Витя on 09.11.2016.
 */

public class Age {
    private static Random random = new Random();
    private int age;

    public Age() {
        this.age = random.nextInt(100);
    }

    public static Random getRandom() {
        return random;
    }

    public static void setRandom(Random random) {
        Age.random = random;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
