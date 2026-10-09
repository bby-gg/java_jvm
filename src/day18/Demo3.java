package day18;

import java.util.List;

public class Demo3 {
    public static void main(String[] args) {
        // 普通 for
        for (var i = 0; i < 3; i++) {
            System.out.println("i = " + i);
        }

        // for-each
        var names = List.of("Alice", "Bob", "Carol");
        for (var n : names) {
            System.out.println("name = " + n);
        }

        // while 里也能用
        var count = 0;
        while (count < 2) {
            System.out.println("count = " + count);
            count++;
        }
    }
}