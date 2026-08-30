package day10;

public class Demo01 {
    public static void main(String[] args) {
        // 1. 基本类型
        int a = 10;
        int result1 = processInt(a);
        System.out.println("a = " + a);          // 10（不受影响）
        System.out.println("result1 = " + result1); // 20

        // 2. 引用类型 - 改属性
        Person p = new Person("Alice");
        Person result2 = processPerson(p);
        System.out.println("p.name = " + p.name);     // Bob（受影响）
        System.out.println("result2.name = " + result2.name); // Charlie

        // 3. String
        String s = "Hello";
        String result3 = processString(s);
        System.out.println("s = " + s);           // Hello（不受影响）
        System.out.println("result3 = " + result3); // Hello World

        // 4. 包装类
        Integer num = 100;
        Integer result4 = processInteger(num);
        System.out.println("num = " + num);       // 100（不受影响）
        System.out.println("result4 = " + result4); // 200
    }

    // 1. 基本类型：传入副本，返回副本
    public static int processInt(int x) {
        x = 20;
        return x;
    }

    // 2. 引用类型：传入地址副本，返回地址副本
    public static Person processPerson(Person p) {
        p.name = "Bob";              // 改属性，影响外部
        Person newP = new Person("Charlie");
        return newP;                 // 返回新对象
    }

    // 3. String：传入地址副本，返回地址副本（不可变）
    public static String processString(String s) {
        s = s + " World";            // 创建新对象，不影响外部
        return s;                    // 返回新对象
    }

    // 4. 包装类：传入地址副本，返回地址副本（不可变）
    public static Integer processInteger(Integer i) {
        i = 200;                     // 创建新对象，不影响外部
        return i;                    // 返回新对象
    }
}

class Person {
    String name;
    public Person(String name) {
        this.name = name;
    }
}
