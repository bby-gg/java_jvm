package day18;

public class Demo1 {
    public static void main(String[] args) {
        var age = 25;          // int
        var price = 9.9;       // double
        var letter = 'A';      // char
        var flag = true;       // boolean
        var name = "Tom";      // String

        System.out.println(age);
        System.out.println(price);
        System.out.println(letter);
        System.out.println(flag);
        System.out.println(name);

        // 验证推断出的真实类型
        System.out.println(((Object) age).getClass().getSimpleName());   // Integer
        System.out.println(((Object) price).getClass().getSimpleName()); // Double
        System.out.println(((Object) name).getClass().getSimpleName());  // String
    }
}