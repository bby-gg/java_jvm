package day09;

public class Demo3Local {
    private int num = 10;

    Runnable create() {           // 只能返回接口类型
        final int localVar = 100;

        class Local implements Runnable {   // 定义在方法里
            public void run() {
                System.out.println("局部内部类 num = " + num + ", localVar = " + localVar);
            }
        }

        return new Local();       // 返回时类型是 Runnable
    }

    public static void main(String[] args) {
        Demo3Local outer = new Demo3Local();
        Runnable r = outer.create();   // 外部只能拿到 Runnable
        r.run();
    }
}