package jom.com.softserve.s2.task4;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

public class MyUtils {

    public static boolean isNullOrEmpty(final Collection<?> c) {
        return c == null || c.isEmpty();
    }

    public List<Employee> largestEmployees(List<Employee> employees) {

        if (MyUtils.isNullOrEmpty(employees))
            return new ArrayList<Employee>();

        List<Employee> _employees = new ArrayList<>();
        List<Manager> _managers = new ArrayList<>();

        for (Employee employee : employees) {
            if (employee != null) {
                if (employee.getClass().toString().endsWith("Employee"))
                    _employees.add(employee);
                else if (employee.getClass().toString().endsWith("Manager"))
                    _managers.add((Manager) employee);
            }
        }

        if (!_employees.isEmpty()) {
            int maxEmployeeExpirience = Collections.max(_employees, new Comparator<Employee>() {
                @Override
                public int compare(Employee e1, Employee e2) {
                    if (e1.getExperience() > e2.getExperience())
                        return 1;
                    else if (e1.getExperience() < e2.getExperience())
                        return -1;
                    return 0;
                }
            }).getExperience();

            BigDecimal maxEmployeePayment = Collections.max(_employees, new Comparator<Employee>() {
                @Override
                public int compare(Employee e1, Employee e2) {
                    return e1.getPayment().compareTo(e2.getPayment());
                }
            }).getPayment();

            Set<String> uniqueEmployeeNames = new HashSet<>();
            _employees.removeIf(
                    e -> !(e.getExperience() == maxEmployeeExpirience) && !(e.getPayment() == maxEmployeePayment));
            _employees.removeIf(e -> !uniqueEmployeeNames.add(e.getName()));
        }

        if (!_managers.isEmpty()) {
            int maxManagerExpirience = Collections.max(_managers, new Comparator<Manager>() {
                @Override
                public int compare(Manager e1, Manager e2) {
                    if (e1.getExperience() > e2.getExperience())
                        return 1;
                    else if (e1.getExperience() < e2.getExperience())
                        return -1;
                    return 0;
                }
            }).getExperience();

            BigDecimal maxManagerPayment = Collections.max(_managers, new Comparator<Manager>() {
                @Override
                public int compare(Manager e1, Manager e2) {
                    return e1.getPayment().compareTo(e2.getPayment());
                }
            }).getPayment();

            Set<String> uniqueManagerNames = new HashSet<>();
            _managers.removeIf(
                    e -> !(e.getExperience() == maxManagerExpirience) && !(e.getPayment() == maxManagerPayment));
            _managers.removeIf(e -> !uniqueManagerNames.add(e.getName()));
        }

        List<Employee> largeEmployees = new ArrayList<>();
        largeEmployees.addAll(_employees);
        largeEmployees.addAll(_managers);
        return largeEmployees;
    }
}