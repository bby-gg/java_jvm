//package day02;
//
//public class demo03 {
//    public static void test01(boolean flag) {
//        int a;
//        if (flag) {
//            a = 1; // 只有 flag 为 true 时，a 才会被赋值
//        }
//        // 如果 flag 为 false，程序也会走到这里，但 a 还没被赋值！
//        System.out.println(a); // ❌ 编译报错：Variable 'a' might not have been initialized
//    }
//    public void test02() {
//        return; // 方法在这里直接结束了
//        System.out.println("Hello"); // ❌ 编译报错：Unreachable statement
//    }
//    public int getNumber(boolean flag) {
//        if (flag) {
//            return 1;
//        }
//        // 如果 flag 为 false，程序走到这里就结束了，没有返回值！
//    } // ❌ 编译报错：Missing return statement
//    public static void main(String[] args) {
//        test01(true);
//        test01(false);
//        System.out.println("hello world");
//        int number = 10;
//        boolean a = number;
//        char b = 'a';
//        int num = b;
//        for(int i = 0; i < 300; i++) {
//            Integer c = new Integer(10);
//        }
//    }
//}
