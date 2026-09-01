package day08;

/**
 * 禁区3：截取大文件后直接用 substring 保留小片段
 * 后果：虽然JDK7+已修复（substring内部复制数组），
 *       但思想要保留：不切断引用，大数组无法回收
 * 正确做法：使用 new String(substring) 重新构造，切断引用
 *
 * 注意：本Demo模拟的是"截取大字符串中的一小段，但原大字符串被废弃"
 * 演示如何切断引用让GC回收大字符串的char[]
 */
public class Zone3_SubstringLeak {

    public static void main(String[] args) {
        System.out.println("=== 模拟从大文本中截取关键字段 ===");
        System.out.println();

        // 模拟一个大文本（实际场景可能是几MB的JSON或日志）
        String bigText = buildBigText();

        // ❌ 错误示例：直接使用 substring
        System.out.println("❌ 错误方式：直接截取");
        wrongWay(bigText);

        // ✅ 正确示例：new String() 重新构造
        System.out.println("✅ 正确方式：new String() 重构造");
        rightWay(bigText);
    }

    /**
     * 构建一个大文本（模拟大JSON或日志）
     */
    private static String buildBigText() {
        StringBuilder sb = new StringBuilder();
        // 构建一个包含大量无用信息的文本
        sb.append("【无用信息】");
        for (int i = 0; i < 10000; i++) {
            sb.append("padding_data_").append(i).append(",");
        }
        sb.append("【关键字段】USER_ID=12345");
        sb.append("【无用信息】");
        for (int i = 0; i < 10000; i++) {
            sb.append("padding_data_").append(i).append(",");
        }
        return sb.toString();
    }

    /**
     * 错误方式：直接截取子串
     * 在JDK6中，substring会直接引用原String的char[]，导致大数组无法回收
     * 在JDK7+中，虽然内部复制了数组，但为了代码可移植性，建议仍用new String()包裹
     */
    private static void wrongWay(String bigText) {
        long start = System.currentTimeMillis();

        // 直接截取关键字段
        int startIdx = bigText.indexOf("USER_ID=");
        String userId = bigText.substring(startIdx, startIdx + 11); // "USER_ID=12345"

        // 此时如果 bigText 被置为 null，在JDK6中userId仍持有整个大数组的引用
        // 在JDK7+中，userId只持有自己复制的小数组

        long end = System.currentTimeMillis();
        System.out.println("截取结果: " + userId);
        System.out.println("耗时: " + (end - start) + "ms");
        System.out.println("注意：在JDK6中，此方式会导致大数组无法回收！");
        System.out.println("在JDK7+中虽然已修复，但建议使用 new String() 包裹以确保万无一失");
        System.out.println();
    }

    /**
     * 正确方式：使用 new String() 重新构造
     * 强制切断与原字符串的引用关系，确保原大数组可以被GC回收
     */
    private static void rightWay(String bigText) {
        long start = System.currentTimeMillis();

        // 截取后立即用 new String() 重新构造
        int startIdx = bigText.indexOf("USER_ID=");
        String userId = new String(bigText.substring(startIdx, startIdx + 11));

        // 此时 userId 完全独立，bigText 可以被GC正常回收

        long end = System.currentTimeMillis();
        System.out.println("截取结果: " + userId);
        System.out.println("耗时: " + (end - start) + "ms");
        System.out.println("✅ 强制切断引用，原大字符串可被GC回收");
    }
}