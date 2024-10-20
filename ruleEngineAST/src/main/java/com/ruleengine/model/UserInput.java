package com.ruleengine.model;

public class UserInput {
    private int age;
    private String department;
    private double salary;
    private int experience;

    // Constructor
    public UserInput(int age, String department, double salary, int experience) {
        this.age = age;
        this.department = department;
        this.salary = salary;
        this.experience = experience;
    }

    // Getters
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }


    public String getDepartment() {
        return department;
    }
    public void setDepartment(String department) {
        this.department = department;
    }
    public double getSalary() {
        return salary;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }
    public int getExperience() {
        return experience;
    }
    public void setExperience(int experience) {
        this.experience = experience;
    }
}
