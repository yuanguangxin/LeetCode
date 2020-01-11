package etc.ali.q1;

/**
 * 饿汉式，提前创建，用空间换时间,线程安全
 */
public class A {
    private static A instance = new A();

    private A() {

    }

    public static A getInstance() {
        return instance;
    }
}
