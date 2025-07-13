package com.SpringBootProject.Versioning;

public class Personv1 {

    String Name;
    public Personv1(String name) {
        Name = name;
    }

    public String getName() {
        return Name;
    }

    @Override
    public String toString() {
        return "Personv1{" + "Name='" + Name + '\'' + '}';
    }
}
