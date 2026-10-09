package day20;

public class Demo2_Accessor {

    record Person(String name, int age) {}

    public static void main(String[] args) {
        Person p = new Person("Tom", 18);

        // 访问器名 = 组件名，不是 getName()
        System.out.println(p.name()); // Tom
        System.out.println(p.age());  // 18

        // p.getName();  // 编译错误
        // p.name;       // 编译错误，字段是 private
    }
}