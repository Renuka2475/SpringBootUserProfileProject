package com.SpringBootProject.Versioning;

public class Personv2 {

    String firstName;
    String lastName;

    public Personv2(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return "Personv2{" + "firstName='" + firstName + '\'' + ", lastName='" + lastName + '\'' + '}';
    }
}
