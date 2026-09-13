package day11;

/**
 * 包装类比较：== 比地址，equals 比值
 * 结论：包装类比大小永远用 equals
 */
public class Demo03_EqualsVsDoubleEq {

    public static void main(String[] args) {
        Integer a = 1000;
        Integer b = 1000;

        System.out.println("a == b        : " + (a == b));          // false
        System.out.println("a.equals(b)   : " + a.equals(b));       // true

        // 和基本类型比较时，会自动拆箱，等价于比值
        int c = 1000;
        System.out.println("a == c        : " + (a == c));          // true，拆箱后比

        // 一个经典判断：下面这个 if 会不会进？
        Integer x = 127;
        Integer y = 127;
        if (x == y) {
            System.out.println("x == y 成立（缓存范围内）");
        }

        Integer m = 128;
        Integer n = 128;
        if (m == n) {
            System.out.println("m == n 成立");
        } else {
            System.out.println("m == n 不成立（缓存范围外）");
        }

        // 推荐写法
        System.out.println("推荐：m.equals(n) = " + m.equals(n));
        System.out.println("推荐：Integer.compare(m, n) = " + Integer.compare(m, n));
    }
}