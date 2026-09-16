package day13;

public class Demo02_StackUnwinding {

    static void a() {
        System.out.println("a 进入");
        b();
        System.out.println("a 退出（不会执行）");
    }

    static void b() {
        System.out.println("b 进入");
        throw new RuntimeException("出错了");
    }

    public static void main(String[] args) {
        try {
            a();
        } catch (RuntimeException e) {
            System.out.println("main 捕获: " + e.getMessage());
        }
    }
}