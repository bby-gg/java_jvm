package day08;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 禁区2：对动态业务数据调用 intern()
 * 后果：StringTable无限膨胀，永不回收，最终OOM
 * 正确做法：使用 ConcurrentHashMap 或 Guava Cache 做带过期时间的缓存
 */
public class Zone2_DynamicIntern {

    // 模拟业务数据：动态生成的订单号
    private static final List<String> ORDER_IDS = new ArrayList<>();

    static {
        for (int i = 0; i < 100000; i++) {
            ORDER_IDS.add("ORDER_" + System.currentTimeMillis() + "_" + i);
        }
    }

    public static void main(String[] args) {
        // ❌ 错误示例：对动态数据调用 intern()
        System.out.println("=== 错误示例：动态数据调用 intern() ===");
        wrongWay();

        // ✅ 正确示例：使用 ConcurrentHashMap 手动缓存
        System.out.println("\n=== 正确示例：使用 ConcurrentHashMap ===");
        rightWay();
    }

    /**
     * 错误方式：对动态生成的订单号调用 intern()
     * 每个订单号都会永久驻留在StringTable中，无法被GC回收
     * 运行一段时间后会导致内存溢出（如果数据量够大）
     */
    private static void wrongWay() {
        // 注意：为了演示效果，这里只取前100个，避免真的撑爆内存
        for (int i = 0; i < 100; i++) {
            String orderId = ORDER_IDS.get(i);
            String cached = orderId.intern();  // 危险！永久驻留
            // 模拟业务处理
            processOrder(cached);
        }
        System.out.println("错误方式执行完成，但注意：这些字符串已永久驻留在StringTable中");
        System.out.println("如果数据量达到百万级，将导致 OOM: Java heap space");
    }

    /**
     * 正确方式：使用 ConcurrentHashMap 做本地缓存
     * 可以手动控制缓存的清除和过期
     */
    private static void rightWay() {
        ConcurrentHashMap<String, String> cache = new ConcurrentHashMap<>();

        for (int i = 0; i < 100; i++) {
            String orderId = ORDER_IDS.get(i);
            // 使用 putIfAbsent 保证线程安全且不会覆盖已有值
            String cached = cache.putIfAbsent(orderId, orderId);
            if (cached == null) {
                cached = orderId;
            }
            processOrder(cached);
        }

        System.out.println("正确方式执行完成，缓存大小: " + cache.size());
        System.out.println("提示：可定时调用 cache.clear() 或使用 Guava Cache 的过期策略");
    }

    private static void processOrder(String orderId) {
        // 模拟业务处理
        // System.out.println("处理订单: " + orderId);
    }
}