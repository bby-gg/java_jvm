package day05;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BytecodeDemo {

    public void arrayAccess() {
        // 1. 数组（JVM 原生支持）
        int[] arr = new int[3];
        arr[0] = 100;
        arr[1] = 200;
        arr[2] = 300;
        int sum = arr[0] + arr[1] + arr[2];
        System.out.println(sum);
    }

    public void arrayListAccess() {
        // 2. ArrayList（JDK 层）
        ArrayList<Integer> list = new ArrayList<>(3);
        list.add(100);
        list.add(200);
        list.add(300);
        int sum = list.get(0) + list.get(1) + list.get(2);
        System.out.println(sum);
    }

    public void linkedListAccess() {
        // 3. LinkedList（JDK 层，纯对象链）
        LinkedList<Integer> list = new LinkedList<>();
        list.add(100);
        list.add(200);
        list.add(300);
        int sum = list.get(0) + list.get(1) + list.get(2);
        System.out.println(sum);
    }

    public static void main(String[] args) {
        BytecodeDemo demo = new BytecodeDemo();
        demo.arrayAccess();
        demo.arrayListAccess();
        demo.linkedListAccess();
    }
}
