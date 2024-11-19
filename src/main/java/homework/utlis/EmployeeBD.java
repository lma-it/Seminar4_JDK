package homework.utlis;

import java.util.Random;

public class EmployeeBD {

    private static final Random RANDOM = new Random();

    private static final String[] names = {
            "Adam", "Michael", "Lola", "Anna", "Violetta", "Lion", "Freddy", "Lev", "Dmitriy",
            "Sergey", "Svetlana", "Naomi", "Alex", "Oleg", "Pavel", "Smith", "Omar", "Vlad",
            "Vadim", "Vyacheslav", "Inna", "Maria", "Sara", "Ann", "Chu", "Pu", "Mila",
            "Yakov", "Sam", "Masha", "Olga", "Ola", "Viola", "Vera", "Sonya", "Bella"
    };

    public static String getRandomName(){
        return names[RANDOM.nextInt(0, names.length)];
    }

    public static String getRandomPhoneNumber(){

        StringBuilder phoneNumber = new StringBuilder(16);

        for (int i = 0; i < phoneNumber.capacity(); i++){
            if (i != 0 && i != 1 && i != 2 && i != 6 && i != 10 && i != 13){
                phoneNumber.append(RANDOM.nextInt(0,10));
            } else if (i == 1) {
                phoneNumber.append(RANDOM.nextInt(7,9));
            } else if(i == 0){
                phoneNumber.append("+");
            }else if(i == 2){
                phoneNumber.append("(");
            }else if(i == 6){
                phoneNumber.append(")");
            }else{
                phoneNumber.append("-");
            }
        }
        return phoneNumber.toString();
    }

    public static int getRandomStage(){
        return RANDOM.nextInt(1, 30);
    }
}
