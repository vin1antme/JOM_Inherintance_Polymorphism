package jom.com.softserve.s2.task1;

public class Person{
    private int age;
    private String healthInfo;
    private String name;
    public String getHealthStatus(){ return name +" " + healthInfo; }
    public Person(int age, String healthInfo, String name) {
        this.age = age;
        this.healthInfo = healthInfo;
        this.name = name;
    }    
}