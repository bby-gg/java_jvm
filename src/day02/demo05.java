package day02;

class Student {
    static String school = "清华";  // 静态变量
    String name;                    // 成员变量

    public void test() {
        // 1. 访问局部变量 - 不需要对象
        int a = 10;                 // 直接访问

        // 2. 访问静态变量 - 不需要对象
        school = "北大";             // 直接通过类名访问
        Student.school = "北大";    // 推荐写法

        // 3. 访问成员变量 - 需要对象
        name = "张三";              // 隐式使用 this（当前对象）
//        this.name = name;         // 显式使用 this
        // 如果没有对象，无法访问 name！
    }
}

public class demo05 {
    public static void main(String[] args) {
        // 访问静态变量 - 不需要对象
        Student.school = "北大";   // ✅ 可以直接访问

        // 访问成员变量 - 需要对象
        // Student.name = "张三";   // ❌ 编译报错！
        Student s = new Student(); // 必须先创建对象
        s.test();
        System.out.println(s.name);
//        s.name = "张三";           // ✅ 通过对象访问
//        System.out.println(s.name);
    }
}
