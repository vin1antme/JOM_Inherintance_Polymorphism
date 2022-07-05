package jom.com.softserve.s2.task4;

import java.math.BigDecimal;

public class Employee {

    private String name;
    private int experience;
    private BigDecimal basePayment;
    public Employee(String name, int experience, BigDecimal basePayment) {
        this.name = name;
        this.experience = experience;
        this.basePayment = basePayment;
    }

    public String getName() {
        return name;
    }

    public int getExperience() {
        return experience;
    }

    public BigDecimal getPayment() {
        return basePayment;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((basePayment == null) ? 0 : basePayment.hashCode());
        result = prime * result + experience;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Employee other = (Employee) obj;
        if (basePayment == null) {
            if (other.basePayment != null)
                return false;
        } else if (!basePayment.equals(other.basePayment))
            return false;
        if (experience != other.experience)
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }    
}