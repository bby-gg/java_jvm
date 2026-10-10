package day21;

public class Demo03Null {
    public static void main(String[] args) {
        Object[] objects = {"hello", 42, null};

        for (Object obj : objects) {
            if (obj instanceof String s) {
                System.out.println("字符串：" + s.toUpperCase()); // s 一定非 null
            } else if (obj instanceof Integer i) {
                System.out.println("整数：" + (i + 1));
            } else {
                System.out.println("未知或 null");
            }
        }
    }
}