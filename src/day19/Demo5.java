package day19;

public class Demo5 {
    enum Day { MON, TUE, WED, THU, FRI, SAT, SUN }

    static int getValue(Day day) {
        return switch (day) {
            case MON, FRI -> 6;
            case TUE -> 7;
            case WED, THU -> 8;
            case SAT, SUN -> 0;
        };
    }

    public static void main(String[] args) {
        System.out.println(getValue(Day.TUE)); // 7
        System.out.println(getValue(Day.SUN)); // 0
    }
}
