package ru.rubicon.client.model;

import java.util.Random;

import javax.inject.Inject;

import ru.rubicon.client.Basement;
import ru.rubicon.client.di.AgeModule;
import ru.rubicon.client.di.DaggerComponents_IUserComponent;
import ru.rubicon.client.di.scope.UserScope;

/**
 * Created by Витя on 25.10.2016.
 */

@UserScope
public class User {
    private String name;

    private static Random random = new Random();
    @Inject
    Age age;

    public User(){
        this.name = "Timur";
        init();
    }

    public User(String name, int age) {
        this.name = name;
        init();
    }

    private void init(){
        Basement.setUserComponent(DaggerComponents_IUserComponent.builder().ageModule(new AgeModule()).build());
        Basement.getUserComponent().inject(this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age.getAge();
    }

    public void setAge(int age) {
        this.age.setAge(age);
    }
}
