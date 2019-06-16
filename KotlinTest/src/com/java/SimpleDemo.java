package com.java;

public class SimpleDemo {

    public String name;

    private int age;

    private String cardNo;

    public SimpleDemo(String name, int age, String cardNo) {
        this.name = name;
        this.age = age;
        this.cardNo = cardNo;
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

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }
}
