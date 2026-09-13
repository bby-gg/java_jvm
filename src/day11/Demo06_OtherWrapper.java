package day11;

/**
 * 其他包装类的缓存对比
 * Byte 全缓存、Boolean 用常量、Float/Double 不缓存
 */
public class Demo06_OtherWrapper {

    public static void main(String[] args) {
        // Byte：全部 256 个值都缓存
        Byte b1 = 100;
        Byte b2 = 100;
        System.out.println("Byte 100 == 100 : " + (b1 == b2)); // true

        // Short：-128 ~ 127
        Short s1 = 127;
        Short s2 = 127;
        System.out.println("Short 127 == 127 : " + (s1 == s2)); // true
        Short s3 = 128;
        Short s4 = 128;
        System.out.println("Short 128 == 128 : " + (s3 == s4)); // false

        // Long：-128 ~ 127
        Long l1 = 127L;
        Long l2 = 127L;
        System.out.println("Long 127 == 127 : " + (l1 == l2)); // true
        Long l3 = 128L;
        Long l4 = 128L;
        System.out.println("Long 128 == 128 : " + (l3 == l4)); // false

        // Character：0 ~ 127
        Character c1 = 'a'; // 97
        Character c2 = 'a';
        System.out.println("Character 'a' == 'a' : " + (c1 == c2)); // true
        Character c3 = '中'; // 20013，超出
        Character c4 = '中';
        System.out.println("Character '中' == '中' : " + (c3 == c4)); // false

        // Boolean：只有 TRUE / FALSE 两个常量
        Boolean t1 = true;
        Boolean t2 = true;
        System.out.println("Boolean true == true : " + (t1 == t2)); // true

        // Float：不缓存
        Float f1 = 1.0f;
        Float f2 = 1.0f;
        System.out.println("Float 1.0 == 1.0 : " + (f1 == f2)); // false

        // Double：不缓存
        Double d1 = 1.0;
        Double d2 = 1.0;
        System.out.println("Double 1.0 == 1.0 : " + (d1 == d2)); // false
    }
}