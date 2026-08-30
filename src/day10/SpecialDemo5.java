package day10;

import java.util.Arrays;

/**
 * 可变参数的特殊行为
 * 本质是数组，传递的是地址
 */
public class SpecialDemo5 {
    public static void main(String[] args) {
        System.out.println("=== 可变参数 ===");
        printAll("Hello", "World", "Java");
        printAll("Single");
        printAll();

        System.out.println("\n=== 混合参数 ===");
        printWithPrefix("前缀:", "A", "B", "C");

        System.out.println("\n=== 数组特性（传递地址） ===");
        String[] arr = {"X", "Y", "Z"};
        modifyArray(arr);
        System.out.println("修改后: " + Arrays.toString(arr));
    }

    public static void printAll(String... args) {
        System.out.println("参数个数: " + args.length);
        System.out.println("内容: " + Arrays.toString(args));
    }

    public static void printWithPrefix(String prefix, String... args) {
        for (String s : args) {
            System.out.print(prefix + s + " ");
        }
        System.out.println();
    }

    public static void modifyArray(String... args) {
        if (args.length > 0) {
            args[0] = "Modified";
        }
        System.out.println("方法内: " + Arrays.toString(args));
    }
}
