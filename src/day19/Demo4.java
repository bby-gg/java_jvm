package day19;

public class Demo4 {
    public static void main(String[] args) {
        String day = "TUE";

        int num = switch (day) {
            case "MON", "FRI" -> 6;
            case "TUE" -> 7;
            default -> 0;
        };

        System.out.println(num); // 7
    }
}