package homework.interfaces;

import homework.entity.Employee;

import java.util.List;

public interface Decorator {
    void decorateOutput(List<Employee> employeeList);
    void decorateOutput(Employee employee);
}
