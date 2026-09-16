package day13;

public class Demo01_FinallyReturn {

    static int case1() {
        try {
            return 1;
        } finally {
            System.out.println("finally 执行");
        }
    }

    static int case2() {
        try {
            return 1;
        } finally {
            return 2;   // 覆盖上面的 return 1
        }
    }

    public static void main(String[] args) {
        System.out.println("case1 = " + case1());  // 1
        System.out.println("case2 = " + case2());  // 2
    }
}