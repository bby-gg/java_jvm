package day11;

/**
 * Integer 缓存池：-128 ~ 127
 * 这个范围内的自动装箱直接返回缓存对象，超出则 new
 */
public class Demo02_IntegerCache {

    public static void main(String[] args) {
        Integer a = 100;
        Integer b = 100;
        System.out.println("100 == 100 : " + (a == b));   // true，同一缓存对象

        Integer c = 200;
        Integer d = 200;
        System.out.println("200 == 200 : " + (c == d));   // false，各自 new

        // 边界验证
        Integer e1 = -128;
        Integer e2 = -128;
        System.out.println("-128 == -128 : " + (e1 == e2)); // true，下界含

        Integer f1 = 127;
        Integer f2 = 127;
        System.out.println("127 == 127 : " + (f1 == f2));   // true，上界含

        Integer g1 = 128;
        Integer g2 = 128;
        System.out.println("128 == 128 : " + (g1 == g2));   // false，越界

        // 想看缓存上界？可以读系统属性
        String prop = System.getProperty("java.lang.Integer.IntegerCache.high");
        System.out.println("IntegerCache.high 属性 = " + prop);

        // 用 new 一定不走缓存
        Integer h1 = new Integer(100);
        Integer h2 = new Integer(100);
        System.out.println("new Integer(100) == new Integer(100) : " + (h1 == h2)); // false
    }
}