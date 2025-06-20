package TryItOut.classDemo;

import java.util.Arrays;

public class EnumDemo {

    public static void main(String[] args) {
        method();
    }

    public static void method(){
        days[] values = days.values();
        Arrays.stream(values).forEach(System.out::println);

        days monday = days.valueOf("MONDAY");
        System.out.println(monday);
        System.out.println(monday.ordinal());

    }

}

enum days{
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY,
    SUNDAY
}
