package day08;

/**
 * 禁区1：循环内使用 += 拼接字符串
 * 后果：创建大量中间String对象，触发频繁GC，CPU飙升
 * 正确做法：使用 StringBuilder 复用
 */
public class Zone1_LoopConcat {

    public static void main(String[] args) {
        // ❌ 错误示例：循环内用 += 拼接
        System.out.println("=== 错误示例：循环内使用 += ===");
        wrongWay();

        System.out.println("\n=== 正确示例：使用 StringBuilder ===");
        rightWay();
    }

    /**
     * 错误方式：循环内使用 s += "a"
     * 每次循环都会创建新的String对象，10万次产生10万个垃圾对象
     */
    private static void wrongWay() {
        String result = "";
        long start = System.currentTimeMillis();

        for (int i = 0; i < 100000; i++) {
            result += "a";  // 等价于 result = new String(result + "a")
        }

        long end = System.currentTimeMillis();
        System.out.println("耗时: " + (end - start) + "ms");
        System.out.println("结果长度: " + result.length());
        // 在你的机器上可能比较慢，建议把循环次数调小到10000测试
    }

    /**
     * 正确方式：循环外创建 StringBuilder，循环内 append
     * 只创建1个StringBuilder对象，最后toString()产生1个String对象
     */
    private static void rightWay() {
        StringBuilder sb = new StringBuilder();
        long start = System.currentTimeMillis();

        for (int i = 0; i < 100000; i++) {
            sb.append("a");
        }

        String result = sb.toString();
        long end = System.currentTimeMillis();
        System.out.println("耗时: " + (end - start) + "ms");
        System.out.println("结果长度: " + result.length());
    }
}