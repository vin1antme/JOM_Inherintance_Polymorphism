package jom.com.softserve.s2.task1;

public class Adult extends Person{   
    private String passportNumber;

    public Adult(int age, String healthInfo, String name, String passportNumber) {
        super(age, healthInfo, name);
        this.passportNumber = passportNumber;
    }     
}