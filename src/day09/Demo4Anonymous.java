package day09;

public class Demo4Anonymous {
    private int num = 10;

    Runnable create() {
        final int localVar = 200;

        // 匿名内部类：没有类名，直接 new 接口
        return new Runnable() {
            public void run() {
                System.out.println("匿名内部类 num = " + num + ", localVar = " + localVar);
            }
        };
    }

    public static void main(String[] args) {
        Demo4Anonymous outer = new Demo4Anonymous();
        Runnable r = outer.create();
        r.run();
    }
}