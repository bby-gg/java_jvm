package day20;

public class Demo3_CompactCtor {

    record Range(int lo, int hi) {
        // 紧凑构造函数：无参数列表，编译器自动补 this.lo = lo;
        public Range {
            if (lo > hi) {
                throw new IllegalArgumentException("lo > hi: " + lo + " > " + hi);
            }
        }
    }

    // 也可以做归一化
    record Normalized(String name) {
        public Normalized {
            if (name == null) {
                throw new NullPointerException("name is null");
            }
            name = name.trim().toUpperCase(); // 归一化
        }
    }

    public static void main(String[] args) {
        Range r = new Range(1, 10);
        System.out.println(r);

        try {
            new Range(10, 1);
        } catch (IllegalArgumentException e) {
            System.out.println("捕获异常: " + e.getMessage());
        }

        System.out.println(new Normalized("  tom  ")); // Normalized[name=TOM]
    }
}