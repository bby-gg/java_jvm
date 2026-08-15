package day01;

public class demo04 {
    public static void main(String[] args) {
        // 整数型
        byte b = 10;
        short s = 20;
        int i = 30;
        long l = 40L;

        // 浮点型
        float f = 3.14f;
        double d = 3.14;

        // 验证：用这些变量做点事，防止被优化掉
        System.out.println(b + s + i + l + f + d);
    }
}
