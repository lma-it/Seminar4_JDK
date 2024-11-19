package classwork.ex3;

import org.jetbrains.annotations.NotNull;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

public class PhoneBook {
    public static void main(String[] args) {
        Map<String, String> phoneBook = new HashMap<>();
        phoneBook.put("786574939", "Ivan");
        phoneBook.put("89303054", "Dmitriy");
        phoneBook.put("87505982", "Sonya");
        phoneBook.put("9874764", "Ira");
        phoneBook.put("933030548", "Dmitriy");
        phoneBook.put("933030", "Aleksandr");

        System.out.printf(findByMinPhoneNumber(phoneBook));
        System.out.println();
        System.out.printf(findByMaxPhoneNumber(phoneBook));
        System.out.println();
        System.out.println(findByMaxLengthName(phoneBook));


    }


    public static @NotNull String findByMinPhoneNumber(Map<String, String> phoneBook){
        String  number = String.valueOf(phoneBook.keySet().stream().min(Comparator.comparingLong(Long::valueOf)).orElseThrow(
                () -> new NoSuchElementException("Нет минимального элемента в коллекции, все элементы одинаковые.")));
        return String.format("Наименьший номер %s у владельца: %s.", number, phoneBook.get(number));
    }

    public static @NotNull String findByMaxPhoneNumber(Map<String, String> phoneBook){
        String  number = String.valueOf(phoneBook.keySet().stream().max(Comparator.comparingLong(Long::valueOf)).orElseThrow(
                () -> new NoSuchElementException("Нет минимального элемента в коллекции, все элементы одинаковые.")));
        return String.format("Наибольший номер %s у владельца: %s.", number, phoneBook.get(number));
    }

    public static String findByMaxLengthName(Map<String, String> phoneBook){
        String name = phoneBook.values().stream().max(Comparator.comparing(String::length)).orElse(null);

        String key = phoneBook.entrySet()
                .stream()
                .filter(entry -> entry.getValue().equals(name))
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(null);

        return String.format("Номер телефона %s, у владельца с самым длинным именем %s", key, name);
    }


}
