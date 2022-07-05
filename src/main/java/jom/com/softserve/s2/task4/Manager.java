package jom.com.softserve.s2.task4;

import java.math.BigDecimal;

public class Manager extends Employee{
    private double coefficient;

    public Manager(String name, int experience, BigDecimal basePayment, double coefficient) {
        super(name, experience, basePayment);
        this.coefficient = coefficient;
    }

    public double getCoefficient() {
        return coefficient;
    }

    @Override
    public BigDecimal getPayment() {     
        return BigDecimal.valueOf(coefficient).multiply(super.getPayment());
    }
}
