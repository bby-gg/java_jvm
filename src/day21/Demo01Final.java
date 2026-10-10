package day21;

public class Demo01Final {
    public static void main(String[] args) {
        Object obj = "hello";

        if (obj instanceof String s) {
            System.out.println(s);
            // s = "world"; // 编译错误：模式变量不能重新赋值
        }
    }
}