package homework.service;

import homework.entity.Employee;
import homework.interfaces.Decorator;
import homework.utlis.EmployeeBD;
import lombok.Getter;

import java.util.*;
import java.util.stream.Collectors;

@Getter
public class EmployeeService implements Decorator {
    private final List<Employee> employees;


    public EmployeeService(){
        employees = new ArrayList<>();
    }

    public void createEmployeeFromDB(){
        employees.add(new Employee(
                EmployeeBD.getRandomName(),
                EmployeeBD.getRandomPhoneNumber(),
                EmployeeBD.getRandomStage()));
    }

    public void createEmployee(){
        employees.add(new Employee(
                InputService.input("Введите имя."),
                InputService.input("Введите номер телефона в формате +Х(ХХХ)ХХХ-ХХ-ХХ."),
                Integer.parseInt(InputService.input("Введите стаж."))
        ));
    }

    public List<Employee> findEmployeeByStage(int stage){
        return getEmployees().stream().filter(employee -> employee.getStage() == stage).toList();
    }

    public List<Employee> findPhoneNumberByName(String name){
        return getEmployees().stream().filter(employee -> employee.getName().equals(name)).toList();
    }

    public Employee findEmployeeByID(int id){
        return getEmployees().stream().filter(employee -> employee.getID() == id).findFirst().orElse(null);
    }

    @Override
    public void decorateOutput(List<Employee> employeeList) {

        String print = !employeeList.isEmpty() ? employeeList.stream().map(Employee::toString).collect(Collectors.joining("\n")) : "Сотрудники не найдены.";
        System.out.println(print);

    }

    @Override
    public void decorateOutput(Employee employee) {
        String print = employee != null ? employee.toString() : "Сотрудника с таким ID не существует.";
        System.out.println(print);
    }

}
