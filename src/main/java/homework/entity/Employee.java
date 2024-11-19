package homework.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Getter
public class Employee {

    private final int ID;
    @Setter
    private String phoneNumber;

    private final String name;
    private final int stage;
    private final List<Integer> IDs = new ArrayList<>();


    public Employee(String name, String phoneNumber, int stage){
        while(true){
            int id = new Random().nextInt(1000000, Integer.MAX_VALUE);
            if(!IDs.contains(id)){
                this.ID = id;
                IDs.add(id);
                break;
            }
        }
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.stage = stage;
    }

    @Override
    public String toString() {
        return String.format("Табельный номер: %s, Имя: %s, Номер телефона: %s, Стаж: %s %s",
                this.getID(),
                this.getName(),
                this.getPhoneNumber(),
                this.getStage(),
                getRightNounsCasesBy(this.getStage()));
    }


    private static String getRightNounsCasesBy(int stage){

        if (stage > 20){
            if (stage % 10 == 2 || stage % 10 == 3 || stage % 10 == 4) return "года";
            if (stage % 10 == 1) return "год";
        }
        if (stage >= 5) return "лет";
        if (stage >= 2) return "года";
        if (stage == 1) return "год";
        return "лет";
    }
}
