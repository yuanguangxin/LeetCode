package etc.ali.q1;

/**
 * 不提前创建，双重检查加锁，线程安全
 */
public class B {
    private volatile static B instance;

    public static B getInstance() {
        if (instance == null) {
            synchronized (B.class) {
                if (instance == null) {
                    instance = new B();
                }
            }
        }
        return instance;
    }
}
