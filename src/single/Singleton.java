package single;

/**
 * @author fengsihan
 * @date 2019/9/22 18:39
 * @desc 单例模式
 */

public class Singleton {
    private volatile static Singleton instance;

    private Singleton() {
    }

    public static Singleton getInstance() {
        if (instance == null) {

            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
