package day08;

import java.nio.charset.StandardCharsets;

/**
 * 禁区5：不加字符集，直接用 getBytes() / new String(byte[])
 * 后果：不同操作系统默认编码不同，导致乱码
 * 正确做法：强制指定 StandardCharsets.UTF_8
 */
public class Zone5_CharsetError {

    public static void main(String[] args) {
        System.out.println("=== 字符集乱码问题演示 ===");
        System.out.println("当前系统默认字符集: " + System.getProperty("file.encoding"));
        System.out.println();

        String original = "你好世界! Hello World! 123";
        System.out.println("原始字符串: " + original);
        System.out.println();

        // ❌ 错误示例：使用平台默认编码
        System.out.println("❌ 错误方式：使用平台默认编码（不指定字符集）");
        wrongWay(original);

        // ✅ 正确示例：强制指定 UTF-8
        System.out.println("\n✅ 正确方式：强制指定 UTF-8");
        rightWay(original);

        // 额外演示：GBK 与 UTF-8 互转乱码
        System.out.println("\n=== 扩展演示：GBK 和 UTF-8 互转乱码 ===");
        demoCharsetMismatch(original);
    }

    /**
     * 错误方式：不指定字符集，使用平台默认编码
     * 在Windows（GBK）和Linux（UTF-8）上运行结果不同
     */
    private static void wrongWay(String original) {
        // 不指定字符集 -> 使用平台默认编码（危险！）
        byte[] bytes = original.getBytes();  // 默认使用 file.encoding

        // 解码时也不指定字符集
        String decoded = new String(bytes);  // 默认使用 file.encoding

        System.out.println("编码后的字节数: " + bytes.length);
        System.out.println("解码后字符串: " + decoded);

        // 在UTF-8环境下，中文占3个字节；在GBK环境下，中文占2个字节
        // 如果编码解码使用相同默认编码，通常没问题
        // 但一旦部署到不同操作系统，就会乱码！

        System.out.println("⚠️ 风险：在Windows（GBK）和Linux（UTF-8）上结果可能不同！");
    }

    /**
     * 正确方式：强制指定 UTF-8
     */
    private static void rightWay(String original) {
        // 编码时指定 UTF-8
        byte[] bytes = original.getBytes(StandardCharsets.UTF_8);

        // 解码时也指定 UTF-8
        String decoded = new String(bytes, StandardCharsets.UTF_8);

        System.out.println("编码后的字节数: " + bytes.length);
        System.out.println("解码后字符串: " + decoded);
        System.out.println("✅ 无论在Windows还是Linux，结果一致！");
    }

    /**
     * 演示字符集不匹配导致的乱码
     */
    private static void demoCharsetMismatch(String original) {
        // 1. 用 UTF-8 编码
        byte[] utf8Bytes = original.getBytes(StandardCharsets.UTF_8);

        // 2. 用 GBK 解码（错误！）
        String wrongDecoded = new String(utf8Bytes, java.nio.charset.Charset.forName("GBK"));
        System.out.println("UTF-8编码后用GBK解码: " + wrongDecoded);
        // 输出类似：浣犲ソ涓栫晫! Hello World! 123 （乱码）

        // 3. 正确做法：用 UTF-8 解码
        String correctDecoded = new String(utf8Bytes, StandardCharsets.UTF_8);
        System.out.println("UTF-8编码后用UTF-8解码: " + correctDecoded);

        System.out.println("⚠️ 教训：编码和解码必须使用相同的字符集！");
        System.out.println("建议：全程使用 StandardCharsets.UTF_8");
    }
}