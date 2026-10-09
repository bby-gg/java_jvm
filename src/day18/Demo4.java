package day18;

import java.io.*;

public class Demo4 {
    public static void main(String[] args) {
        // 传统写法
        try (BufferedReader r1 = new BufferedReader(new StringReader("hello"))) {
            System.out.println(r1.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }

        // var 写法
        try (var r2 = new BufferedReader(new StringReader("world"))) {
            System.out.println(r2.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
