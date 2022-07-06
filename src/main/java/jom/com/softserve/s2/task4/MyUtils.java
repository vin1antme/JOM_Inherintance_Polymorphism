package jom.com.softserve.s2.task4;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

public class MyUtils {

    public List<Employee> largestEmployees(List<Employee> employees) {

        List<Employee> _employees = new ArrayList<>();
        List<Manager> _managers = new ArrayList<>();

        for (Employee employee : employees) {
            if (employee != null) {
                if (employee.getClass().getName() == Employee.class.getName())
                    _employees.add(employee);
                else if (employee.getClass().getName() == Manager.class.getName())
                    _managers.add((Manager) employee);
            }
        }

        Comparator<Employee> experienceComparator = new Comparator<Employee>() {
            @Override
            public int compare(Employee e1, Employee e2) {
                if (e1.getExperience() > e2.getExperience())
                    return 1;
                else if (e1.getExperience() < e2.getExperience())
                    return -1;
                return 0;
            }
        };

        Comparator<Employee> paymentComparator = new Comparator<Employee>() {
            @Override
            public int compare(Employee e1, Employee e2) {
                return e1.getPayment().compareTo(e2.getPayment());
            }
        };

        if (!_employees.isEmpty()) {
            int maxEmployeeExperience = Collections.max(_employees, experienceComparator).getExperience();
            BigDecimal maxEmployeePayment = Collections.max(_employees, paymentComparator).getPayment();
            Set<String> uniqueEmployeeNames = new HashSet<>();
            _employees.removeIf(
                    e -> !(e.getExperience() == maxEmployeeExperience) && !(e.getPayment() == maxEmployeePayment));
            _employees.removeIf(e -> !uniqueEmployeeNames.add(e.getName()));
        }

        if (!_managers.isEmpty()) {
            int maxManagerExperience = Collections.max(_managers, experienceComparator).getExperience();
            BigDecimal maxManagerPayment = Collections.max(_managers, paymentComparator).getPayment();
            Set<String> uniqueManagerNames = new HashSet<>();
            _managers.removeIf(
                    e -> !(e.getExperience() == maxManagerExperience) && !(e.getPayment() == maxManagerPayment));
            _managers.removeIf(e -> !uniqueManagerNames.add(e.getName()));
        }
        _employees.addAll(_managers);
        return _employees;
    }
}