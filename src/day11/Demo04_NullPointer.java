package day11;

/**
 * 自动拆箱 NPE：包装类为 null 时拆箱会抛异常
 */
public class Demo04_NullPointer {

    public static void main(String[] args) {
        Integer i = null;

        // 下面这行会抛 NullPointerException
        // int n = i;

        // 正确做法：先判空
        if (i != null) {
            int n = i;
            System.out.println("n = " + n);
        } else {
            System.out.println("i 为 null，跳过拆箱");
        }

        // 常见业务坑：Map 取值
        java.util.Map<String, Integer> map = new java.util.HashMap<>();
        map.put("count", null);

        Integer count = map.get("count");
        // int c = count; // 这里会 NPE

        // 安全写法
        int safeCount = count == null ? 0 : count;
        System.out.println("safeCount = " + safeCount);
    }
}