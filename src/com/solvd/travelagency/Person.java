package com.solvd.travelagency;

public class Person {

    public Person() {

    }

    public Person(String name, int age, Address address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    private String name;
    private int age;
    private Address address;

    public String getName() {
        return this.name;

    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Address getAddress() {
        return this.address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void printInfo() {
        System.out.println("Person{ name=" + name + ", age=" + age + ", address=" + address + "}");
    }


}
