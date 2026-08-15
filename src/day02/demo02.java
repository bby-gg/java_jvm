package day02;

public class demo02 {
    public static void test(boolean flag) {
        Object obj;
        if (flag) {
            obj = "Hello"; // 路径A：obj 是 String
        } else {
            obj = 123;     // 路径B：obj 是 int
        }
        System.out.println(obj); // 汇合点
    }
    public static void main(String[] args) {
        test(true);
        test(false);
        System.out.println("hello world");
    }
}
