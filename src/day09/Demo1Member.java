package day09;

public class Demo1Member {
    private int num = 10;

    class Inner {                 // 定义在类里
        void show() {
            System.out.println("成员内部类 num = " + num);
        }
    }

    Inner create() {              // 能作为返回类型
        return new Inner();
    }

    public static void main(String[] args) {
        Demo1Member outer = new Demo1Member();
        Demo1Member.Inner x = outer.create();   // 外部能声明 Inner 类型
        x.show();
    }
}