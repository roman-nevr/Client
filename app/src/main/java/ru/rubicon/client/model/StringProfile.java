package ru.rubicon.client.model;

import java.io.Serializable;

/**
 * Created by Admin on 30.11.2016.
 */

public class StringProfile implements Serializable{
    private int id;
    private String name;

    public StringProfile(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Builder toBuilder(){
        return new Builder(this);
    }

    public Builder toBuilder(StringProfile stringProfile){
        return new Builder(stringProfile);
    }

    public static class Builder{
        private int id;
        private String name;

        public Builder(){
        }

        public Builder(StringProfile stringProfile){
            this.id = stringProfile.getId();
            this.name = stringProfile.getName();
        }

        public Builder(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public Builder setId(int id) {
            this.id = id;
            return this;
        }

        public String getName() {
            return name;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public StringProfile build(){
            return new StringProfile(id, name);
        }
    }

    @Override
    public boolean equals(Object obj) {
        if ((obj != null) && (obj instanceof StringProfile)){
            return (((StringProfile)obj).getId() == this.getId());
            }else{
            return false;
        }
    }

    @Override
    public String toString() {
        return "id: " + getId() + ", name: " + getName();
    }
}
