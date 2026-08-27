package day06;

public class Person {
    // 实例变量
    private String name;
    private int age;

    // 1. 构造方法
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
        System.out.println("构造方法被调用");
    }

    // 2. 实例方法
    public void sayHello() {
        System.out.println("Hello, I'm " + this.name);
    }

    // 3. 静态方法
    public static void printClassName() {
        System.out.println("Class: Person");
        // 不能直接访问 name（没有 this）
        // System.out.println(name); // ❌ 编译错误
    }

    // 4. main 方法（静态入口）
    public static void main(String[] args) {
        // 调用静态方法（不需要对象）
        Person.printClassName();

        // 创建对象（调用构造方法）
        Person p = new Person("Tom", 18);

        // 调用实例方法（需要对象）
        p.sayHello();
    }
}