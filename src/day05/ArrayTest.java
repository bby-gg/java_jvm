package day05;

public class ArrayTest {
    public static void main(String[] args) {
        // 1. 先造一个对象
        Person p = new Person("张三");

        // 2. 把 p 的地址同时赋给 arr[0] 和 arr[1]
        Person[] arr = new Person[2];
        arr[0] = p;  // arr[0] 指向 0x100（张三）
        arr[1] = p;  // arr[1] 也指向 0x100（张三）

        // 3. 关键操作：通过 arr[1] 改名字
        arr[1].name = "李四";

        // 4. 打印 arr[0]
        System.out.println(arr[0].name);
        // 输出：李四 （张三 被覆盖了！）
    }
    static class Person{
        private String name;
        Person(String name){
            this.name = name;
        }
    }
}
