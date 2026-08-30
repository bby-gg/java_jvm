package day10;

import java.util.Arrays;

/**
 * 数组传递的特殊性
 * 数组是对象，传递的是地址，但修改数组元素会影响外部
 */
public class SpecialDemo1 {
    public static void main(String[] args) {
        // 1. 数组是对象，传递地址
        int[] arr = {1, 2, 3};
        System.out.println("修改前: " + Arrays.toString(arr));
        changeArray(arr);
        System.out.println("修改后: " + Arrays.toString(arr));

        // 2. 数组重新赋值（改指向）不影响外部
        int[] arr2 = {10, 20, 30};
        System.out.println("\n重新赋值前: " + Arrays.toString(arr2));
        reassignArray(arr2);
        System.out.println("重新赋值后: " + Arrays.toString(arr2));
    }

    // 修改数组元素 → 影响外部（通过地址找到同一个数组）
    public static void changeArray(int[] a) {
        a[0] = 100;
        a[1] = 200;
        System.out.println("方法内修改后: " + Arrays.toString(a));
    }

    // 重新赋值（改指向）→ 不影响外部
    public static void reassignArray(int[] a) {
        a = new int[]{99, 88, 77};
        System.out.println("方法内重新赋值: " + Arrays.toString(a));
    }
}