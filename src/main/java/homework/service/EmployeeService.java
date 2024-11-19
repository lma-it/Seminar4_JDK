package homework.service;

import homework.entity.Employee;
import homework.interfaces.Decorator;
import homework.utlis.EmployeeBD;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

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
        List<Employee> stageEqual = new ArrayList<>();

        for(Employee employee : getEmployees()){
            if(employee.getStage() == stage){
                stageEqual.add(employee);
            }
        }
        return !stageEqual.isEmpty() ? stageEqual : null;
    }

    public List<Employee> findPhoneNumberByName(String name){
        List<Employee> phoneHolders = new ArrayList<>();

        for(Employee employee : getEmployees()){
            if(employee.getName().equals(name)){
                phoneHolders.add(employee);
            }
        }
        return !phoneHolders.isEmpty() ? phoneHolders : null;
    }

    public Employee findEmployeeByID(int id){

        for(Employee employee : getEmployees()){
            if(employee.getID() == id){
                return employee;
            }
        }
        return null;
    }

    @Override
    public void decorateOutput(List<Employee> employeeList) {

        if(!employeeList.isEmpty()){
            for (Employee employee : employeeList){
                System.out.println(employee.toString());
            }
        } else {
            System.out.println("Сотрудники не найдены.");
        }
    }

    @Override
    public void decorateOutput(Employee employee) {
        System.out.println(employee.toString());
    }

}
