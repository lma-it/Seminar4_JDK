package classwork.ex1;

import java.util.*;

public class MyArray {


    public static void main(String[] args) {
        List<String> names = new ArrayList<>(Arrays.asList("Иван", "Сергей", "Александр", "Ирина", "Светлана"));
        System.out.println(names);
        sortByAlphabet(names);
        System.out.println(names);
        sortByLength(names);
        System.out.println(names);
        reverseList(names);
        System.out.println(names);
    }
    public static void sortByAlphabet(List<String> list){
        Collections.sort(list);
    }

    public static void sortByLength(List<String> list){
        list.sort(Comparator.comparing(String::length));
    }

    public static void reverseList(List<String> list){
        Collections.reverse(list);
    }
}
