package day19;

public class Demo1 {
    enum Day { MON, TUE, WED, THU, FRI, SAT, SUN }

    public static void main(String[] args) {
        Day day = Day.TUE;

        int num = switch (day) {
            case MON, FRI -> 6;
            case TUE -> 7;
            case WED, THU -> 8;
            case SAT, SUN -> 0;
        };

        System.out.println(num); // 7
    }
}