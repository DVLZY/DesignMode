/**
 * @author Linzeyu
 * @create 2020-10-31 19:22
 * @describe ����ģʽ
 * @state todo
 */
public class K_ProxyPattern {

    public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        // ��ȡ�������
        RealSubjectProxy realSubjectProxy = new RealSubjectProxy();
        // ͨ������������Ŀ�����
        realSubjectProxy.doWork();
    }
}

/**
 * Ŀ����ӿ�
 */
interface Subject {
    void doWork();
}

/**
 * ʵ��Ŀ����
 */
class RealSubject implements Subject {


    @Override
    public void doWork() {
        System.out.println("hello");
    }
}

/**
 * Ŀ�������
 */
class RealSubjectProxy implements Subject {

    // ����Ŀ������󣬽������������ϵ
    private RealSubject realSubject;

    public RealSubjectProxy() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        // ͨ�������������Ŀ��������������������贫��ʵ������Ҳ������Ķ����ʱ��ʵ����
        try {
            this.realSubject = (RealSubject) this.getClass().getClassLoader().loadClass("RealSubject").newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * ��չ����
     */
    private void connect() {
        System.out.println("������������");
    }
    private void log() {
        System.out.println("��¼��־");
    }

    /**
     * ����ԭ�еķ�����������ǿ�����ʿ��ƣ�
     */
    @Override
    public void doWork() {
        this.connect();
        realSubject.doWork();
        this.log();
    }
}