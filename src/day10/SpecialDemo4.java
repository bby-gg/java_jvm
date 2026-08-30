package day10;

/**
 * final 修饰参数的特殊行为
 * final 只能阻止重新赋值，不能阻止修改属性
 */
public class SpecialDemo4 {
    public static void main(String[] args) {
        int num = 10;
        changeFinalPrimitive(num);
        System.out.println("基本类型: " + num);

        Person p = new Person("Alice");
        changeFinalReference(p);
        System.out.println("引用类型 name: " + p.name);
    }

    public static void changeFinalPrimitive(final int x) {
        // x = 20;  // ❌ 编译错误
        System.out.println("方法内: " + x);
    }

    public static void changeFinalReference(final Person p) {
        // p = new Person("Charlie");  // ❌ 编译错误
        p.name = "Bob";
        System.out.println("方法内: " + p.name);
    }
}

