package day13;

public class Demo04_SynchronizedRelease {

    static final Object LOCK = new Object();

    static void withLock() {
        synchronized (LOCK) {
            System.out.println("拿到锁，然后抛异常");
            throw new RuntimeException("业务异常");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        try {
            withLock();
        } catch (RuntimeException e) {
            System.out.println("捕获: " + e.getMessage());
        }

        // 如果锁没释放，这里会一直阻塞
        Thread t = new Thread(() -> {
            synchronized (LOCK) {
                System.out.println("另一个线程拿到锁了，说明锁已释放");
            }
        });
        t.start();
        t.join();
        System.out.println("结束");
    }
}