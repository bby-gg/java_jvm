package day11;

/**
 * 常用 API 练习
 */
public class Demo08_ApiDemo {

    public static void main(String[] args) {
        // 字符串 → 基本类型
        int n = Integer.parseInt("123");
        double d = Double.parseDouble("3.14");
        boolean flag = Boolean.parseBoolean("true");
        System.out.println("parseInt: " + n + ", parseDouble: " + d + ", parseBoolean: " + flag);

        // 基本类型 → 字符串
        String s1 = Integer.toString(123);
        String s2 = String.valueOf(123);
        String s3 = 123 + "";
        System.out.println("toString: " + s1 + ", valueOf: " + s2 + ", 拼接: " + s3);

        // 进制转换
        System.out.println("toBinaryString(10) : " + Integer.toBinaryString(10));   // 1010
        System.out.println("toHexString(255)  : " + Integer.toHexString(255));      // ff
        System.out.println("toOctalString(8)  : " + Integer.toOctalString(8));      // 10

        // 比较与最大最小
        System.out.println("max(3,5)     : " + Integer.max(3, 5));
        System.out.println("min(3,5)     : " + Integer.min(3, 5));
        System.out.println("compare(3,5) : " + Integer.compare(3, 5));

        // Character 常用
        System.out.println("isDigit('5')     : " + Character.isDigit('5'));
        System.out.println("isLetter('a')    : " + Character.isLetter('a'));
        System.out.println("isWhitespace(' ') : " + Character.isWhitespace(' '));
        System.out.println("toUpperCase('a') : " + Character.toUpperCase('a'));
        System.out.println("toLowerCase('A') : " + Character.toLowerCase('A'));

        // 注意：parseInt 传入非法字符串会抛 NumberFormatException
        try {
            Integer.parseInt("abc");
        } catch (NumberFormatException e) {
            System.out.println("非法字符串 parseInt 抛 NumberFormatException");
        }
    }
}