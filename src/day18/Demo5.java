package day18;

public class Demo5 {
    public static void main(String[] args) {
        // 显式类型：编译错误！Object 没有 hello()
        // Object obj1 = new Object() {
        //     void hello() { System.out.println("hi"); }
        // };
        // obj1.hello();

        // var：编译通过，能调用匿名类特有方法
        var obj = new Object() {
            void hello() {
                System.out.println("hello from anonymous");
            }
        };
        obj.hello();  // ✅ 只有 var 能做到

        // 再举个例子：带字段的匿名类
        var counter = new Object() {
            int count = 0;
            void inc() { count++; }
            int get() { return count; }
        };
        counter.inc();
        counter.inc();
        System.out.println("count = " + counter.get());
    }
}