package com.SpringBootProject.Filtering;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

//@JsonIgnoreProperties({"password","age"}) // Hides multiple fields
@JsonFilter("SomeBeanFilter")
public class SomeBean {

    private String Name;
//    @JsonIgnore      //password will be hidden
    private String password;
    private  int age;

    public SomeBean(String name, String password, int age) {
        Name = name;
        this.password = password;
        this.age = age;
    }

    public String getName() {
        return Name;
    }

    public String getPassword() {
        return password;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "SomeBean{" + "Name='" + Name + '\'' + ", password='" + password + '\'' + ", age=" + age + '}';
    }
}
