package day13;

public class Demo03_FillInStackTrace {

    static void deep(int n) {
        if (n == 0) throw new RuntimeException("bottom");
        deep(n - 1);
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            try {
                deep(30);
            } catch (RuntimeException ignored) {
            }
        }
        System.out.println("1万次异常耗时: " + (System.currentTimeMillis() - start) + " ms");

        // 关闭堆栈填充
        start = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            try {
                deepLight(30);
            } catch (RuntimeException ignored) {
            }
        }
        System.out.println("1万次轻量异常耗时: " + (System.currentTimeMillis() - start) + " ms");
    }

    // 轻量异常：不填充堆栈
    static class LightweightException extends RuntimeException {
        @Override
        public synchronized Throwable fillInStackTrace() {
            return this;
        }
    }

    static void deepLight(int n) {
        if (n == 0) throw new LightweightException();
        deepLight(n - 1);
    }
}