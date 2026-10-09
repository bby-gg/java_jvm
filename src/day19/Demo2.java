package day19;

public class Demo2 {
    enum Day { MON, TUE, WED }

    public static void main(String[] args) {
        Day day = Day.WED;

        int num = switch (day) {
            case MON -> 1;
            case TUE -> 2;
            default -> 0;
        };

        System.out.println(num); // 0
    }
}