/**
* 单例模式
 确保一个类只有一个实例，并且自行实例化并向整个系统提供这个实例
 确保一个类只有一个实例
 1 构造方法不能公开，不能被外界进行实例化——private
 2 只有一个实例，该实例是属于类的成员变量——static
 自行实例化
 1 饿汉式——加载类时初始化该实例
 2 懒汉式——使用实例时初始化该实例
 向整个系统提供这个实例
 1 需要一个静态方法，向外界提供当前类的实例
 单例模式的例外
 1、分布式系统
 2、同一个JVM使用了多个类加载器同时加载了这个类
 单例模式的使用场景
 如果对象有状态，那么这个状态会被共享，
 单例模式的最佳实践是无状态的，通常作为工厂类
 */


public class A_Singleton {
    public static void main(String[] args) {
        Singleton instance = Singleton.INSTANCE;
        instance.print();
    }
}

/**
 * 饿汉式单例模式
 */
class SingletonA {

    /**
     * 实例作为类的成员变量
     */
    private static SingletonA singletonA = new SingletonA();

    /**
     * 私有化构造方法
     */
    private SingletonA() {
    }

    /**
     * 对外提供类的实例
     */
    public static SingletonA getInstance() {
        return singletonA;
    }
}

/**
 * 懒汉式单例模式
 */
class SingletonB {
    private static SingletonB singletonB;

    private SingletonB() {

    }

    /**
     * 懒汉式单例模式存在线程安全问题
     * 1、通过对方法加锁，避免单例对象被多次实例化
     * （线程不安全场景：初始化时单例对象为空，A、B两个线程同时判断对象为空，那么A、B会分别对单例对象进行实例化）
     */
    public synchronized static SingletonB getInstance() {
        if (singletonB != null) {
            singletonB = new SingletonB();
        }
        return singletonB;
    }
}

/**
 * 懒汉式单例模式（双重检查锁）
 */
class SingletonC {
    /**
     * 双重检查锁模式下可能会发生指令重排，使用 volatile 关键字可避免
     * <p>
     * 创建对象需要经过 3 个步骤
     * 1、分配内存
     * 2、初始化对象
     * 3、将对象指向分配的内存地址
     * <p>
     * 如果发生指令重排
     * A线程执行了1、3，还没有执行2，此时B线程来到外层判断NULL，发现对象有地址，此时B线程会返回还没初始化完成的实例对象，导致错误发生
     */
    private volatile static SingletonC singletonC;

    private SingletonC() {
    }

    /**
     * 双重检查锁模式
     * 1、对象的实例化仅发生在对象被首次调用时，后续调用对象肯定不为空，此处可以使用双重检查锁缩小同步的范围
     * <p>
     * 双重检查锁
     * 1、外层判断是避免非首次调用对象，仍需自行同步代码块，提高自行效率
     * 2、内层判断是防止对香港被实例化多次
     */
    public static SingletonC getInstance() {
        if (singletonC != null) {
            synchronized (SingletonC.class) {
                if (singletonC != null) {
                    singletonC = new SingletonC();
                }
            }
        }
        return singletonC;
    }

}

class SingletonD {
    /**
     * 在静态内部类中实例化对象
     */
    private static class SingletonHolder {
        private static final SingletonD INSTANCE = new SingletonD();
    }
    private SingletonD(){}

    /**
     * 只有通过显式调用 getInstance() 方法时才会加载静态内部类 SingletonHolder，从而初始化实例对象
     */
    public static final SingletonD getInstance() {
        return SingletonHolder.INSTANCE;
    }
}

enum Singleton{
    // 定义一个枚举元素，同时是一个单例模式实例
    INSTANCE;

    public void print() {
        System.out.println("枚举方式实现单例");
    }
}



