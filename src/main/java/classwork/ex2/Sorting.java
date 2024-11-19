package classwork.ex2;

import org.jetbrains.annotations.NotNull;

import java.util.*;

public class Sorting {

    public static void main(String[] args) {

        List<String> names = new ArrayList<>(
                Arrays.asList("Иван", "Сергей", "Александр", "Ирина", "Светлана", "Ирина", "Светлана"));

        Set<String> setNames = convertListToSet(names);
        System.out.println(setNames);
        System.out.println("Наименьшее в алфавитном порядке имя: " + minLengthName(setNames));
        List<String> minAndMaxNames = minAndMaxLengthNames(setNames);
        System.out.printf("Наименьшее по длине имя: %s, наибольшее по длине имя %s\n",
                minAndMaxNames.get(0), minAndMaxNames.get(1));

        removeByChar(setNames, "И", "и");

        System.out.println("Коллекция, которая без имен содержащих Аа: " + setNames);
    }


    public static @NotNull Set<String> convertListToSet(List<String> list){
        return new HashSet<>(list);
    }

    public static String minLengthName(@NotNull Set<String> list){
        return list.stream().min(Comparator.comparing(String::length)).orElse(null);
    }

    public static @NotNull List<String> minAndMaxLengthNames(@NotNull Set<String> names){
        List<String> resultNames = new ArrayList<>();
        resultNames.add(names.stream().min(Comparator.comparing(String::length)).orElse(null));
        resultNames.add(names.stream().max(Comparator.comparing(String::length)).orElse(null));
        return resultNames;

    }

    public static void removeByChar(@NotNull Set<String> names, String... symbol){
        List<String> listNames = names.stream().filter(n -> n.contains(symbol[0]) || n.contains(symbol[1])).toList();
        listNames.forEach(names::remove);
    }

}
