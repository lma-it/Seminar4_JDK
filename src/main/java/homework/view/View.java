package homework.view;

import homework.entity.Employee;
import homework.service.EmployeeService;
import homework.service.InputService;

public class View {
    private static EmployeeService company;

    public View(){
        company = new EmployeeService();
    }


    public void start(){

        System.out.println("Добро пожаловать в компанию!");

        while (true){
            mainMenu();
            switch (Integer.parseInt(InputService.input("Введите команду"))){
                case 1 -> {
                    System.out.println("1. Добавить вручную");
                    System.out.println("2. Добавить из БД");
                    System.out.println("0. Выход из меню");
                    switch (Integer.parseInt(InputService.input("Введите команду"))){
                        case 1 -> {
                            int count = Integer.parseInt(InputService.input("Сколько сотрудников хотите добавить?"));
                            while (count > 0){
                                company.createEmployee();
                                count--;
                            }
                        }
                        case 2 -> {
                            int count = Integer.parseInt(InputService.input("Сколько сотрудников хотите добавить?"));
                            while (count > 0){
                                company.createEmployeeFromDB();
                                count--;
                            }
                        }
                        case 0 -> {
                            break;
                        }
                    }
                    break;
                }
                case 2 -> {
                    findMenu();
                    switch (Integer.parseInt(InputService.input("Введите команду"))){
                        case 1 -> {
                            System.out.println("Все стажи сотрудников компании:");
                            for (Employee employee : company.getEmployees()){
                                System.out.println(employee.getStage());
                            }
                            int stage = Integer.parseInt(InputService.input("Введите стаж, по которому хотите найти сотрудников."));
                            company.decorateOutput(company.findEmployeeByStage(stage));
                        }
                        case 2 -> {
                            System.out.println("Все имена сотрудников компании:");
                            for (Employee employee : company.getEmployees()){
                                System.out.println(employee.getName());
                            }
                            String name = InputService.input("Введите имя, чтоб увидеть все номера телефонов сотрудников с таким именем.");
                            company.decorateOutput(company.findPhoneNumberByName(name));
                        }
                        case 3 -> {
                            System.out.println("Все табельные номера сотрудников компании:");
                            for (Employee employee : company.getEmployees()){
                                System.out.println(employee.getID());
                            }
                            int id = Integer.parseInt(InputService.input("Введите табельный номер, чтоб просмотреть информацию о сотруднике"));
                            company.decorateOutput(company.findEmployeeByID(id));
                        }
                        case 0 -> {
                            break;
                        }
                    }
                    break;
                }
                case 3 -> {
                    company.decorateOutput(company.getEmployees());
                    break;
                }
                case 0 ->{
                    return;
                }
                default -> {
                    break;
                }
            }
        }
    }


    private static void mainMenu(){

        if (company.getEmployees().isEmpty()){
            System.out.println("1. Добавить сотрудника.");
            System.out.println("0. Выход из компании");
        } else {
            System.out.println("1. Добавить сотрудника.");
            System.out.println("2. Найти сотрудника/сотрудников.");
            System.out.println("3. Просмотреть всех сотрудников.");
            System.out.println("0. Выход из компании");
        }

    }

    private static void findMenu(){
        System.out.println("1. Найти сотрудника(ов) по стажу.");
        System.out.println("2. Найти номер(а) телефона по имени.");
        System.out.println("3. Найти сотрудника по табельному номеру.");
        System.out.println("0. Выход выход из меню");

    }
}
