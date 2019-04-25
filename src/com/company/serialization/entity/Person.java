package com.company.serialization.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Person implements Serializable {
    private static final long serialVersionUID = 1533804677525933720L;

    public static String staticString = "static value";

    private String name;
    private int age;
    private double heigh;
    private boolean married;
    transient private String secretCode;

    private List<String> anyList;

    public Person(String name, int age, double heigh, boolean married, String secretCode) {
        this.name = name;
        this.age = age;
        this.heigh = heigh;
        this.married = married;
        this.secretCode = secretCode;

        anyList = new ArrayList<>();
    }

    public List getAnyList() {
        return anyList;
    }

    public void setAnyList(List anyList) {
        this.anyList = anyList;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getHeigh() {
        return heigh;
    }

    public boolean isMarried() {
        return married;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", heigh=" + heigh +
                ", married=" + married +
                ", secret=" + secretCode +
                '}';
    }
}
