/**
 * @author Linzeyu
 * @create 2020-10-31 19:22
 * @describe 代理模式
 * @state todo
 */
public class K_ProxyPattern {

    public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        // 获取代理对象
        RealSubjectProxy realSubjectProxy = new RealSubjectProxy();
        // 通过代理对象访问目标对象
        realSubjectProxy.doWork();
    }
}

/**
 * 目标类接口
 */
interface Subject {
    void doWork();
}

/**
 * 实现目标类
 */
class RealSubject implements Subject {


    @Override
    public void doWork() {
        System.out.println("hello");
    }
}

/**
 * 目标代理类
 */
class RealSubjectProxy implements Subject {

    // 传入目标类对象，建立代理关联关系
    private RealSubject realSubject;

    public RealSubjectProxy() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        // 通过类加载器加载目标对象，这样构造器就无需传入实例对象，也无需关心对象何时被实例化
        try {
            this.realSubject = (RealSubject) this.getClass().getClassLoader().loadClass("RealSubject").newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 扩展方法
     */
    private void connect() {
        System.out.println("建立网络链接");
    }
    private void log() {
        System.out.println("记录日志");
    }

    /**
     * 代理原有的方法（功能增强、访问控制）
     */
    @Override
    public void doWork() {
        this.connect();
        realSubject.doWork();
        this.log();
    }
}