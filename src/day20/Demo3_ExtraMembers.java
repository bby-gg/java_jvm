package day20;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Demo3_ExtraMembers {

    record Person(String name, int age) implements Comparable<Person> {

        // 静态字段
        static final String SPECIES = "Homo sapiens";

        // 静态工厂方法
        static Person of(String name) {
            return new Person(name, 0);
        }

        // 额外实例方法
        public String greeting() {
            return "Hi, I'm " + name;
        }

        // 实现接口
        @Override
        public int compareTo(Person o) {
            return Integer.compare(this.age, o.age);
        }

        // toString 可以覆盖（equals/hashCode 不行）
        @Override
        public String toString() {
            return name + "(" + age + ")";
        }
    }

    public static void main(String[] args) {
        Person a = new Person("Tom", 20);
        Person b = Person.of("Jerry");        // 静态工厂

        System.out.println(a.greeting());      // Hi, I'm Tom
        System.out.println(a);                 // Tom(20)
        System.out.println(Person.SPECIES);    // Homo sapiens

        List<Person> list = new ArrayList<>(List.of(a, b));
        Collections.sort(list);
        System.out.println(list);              // [Jerry(0), Tom(20)]
    }
}