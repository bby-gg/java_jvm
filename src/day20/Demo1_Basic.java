package day20;

public class Demo1_Basic {

    record Point(int x, int y) {}

    public static void main(String[] args) {
        Point p1 = new Point(1, 2);
        Point p2 = new Point(1, 2);
        Point p3 = new Point(2, 1);

        // toString 自动生成
        System.out.println("p1 = " + p1);

        // equals 自动生成，基于所有组件
        System.out.println("p1.equals(p2) = " + p1.equals(p2)); // true
        System.out.println("p1.equals(p3) = " + p1.equals(p3)); // false

        // hashCode 自动生成
        System.out.println("p1.hashCode() == p2.hashCode() = "
                + (p1.hashCode() == p2.hashCode())); // true

        // 作为 Map 的 key，天然正确
        var map = new java.util.HashMap<Point, String>();
        map.put(p1, "起点");
        System.out.println("map.get(p2) = " + map.get(p2)); // 起点
    }
}