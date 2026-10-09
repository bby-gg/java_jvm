package day19;

public class Demo3 {
    enum Day { MON, TUE, WED }

    public static void main(String[] args) {
        Day day = Day.TUE;

        int num = switch (day) {
            case MON -> 1;
            case TUE -> {
                int base = 5;
                int extra = 2;
                yield base + extra; // 返回 7
            }
            default -> 0;
        };

        System.out.println(num); // 7
    }
}
