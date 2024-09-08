package by.clevertec.util;

import java.util.List;

public class For {
    public static void forEach(List<?> list){
        list.forEach(System.out::println);
    }
}
