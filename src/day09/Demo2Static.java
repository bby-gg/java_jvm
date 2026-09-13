package day09;

public class Demo2Static {

    private static int staticNum = 20;
    private int num = 10;

    // 静态内部类
    static class Inner {
        void show() {
            System.out.println("静态内部类访问外部 staticNum = " + staticNum);
            // System.out.println(num);  // ❌ 编译错误！访问不了实例成员
        }
    }

    public static void main(String[] args) {
        Demo2Static.Inner inner = new Demo2Static.Inner();   // 不需要外部实例
        inner.show();
    }
}