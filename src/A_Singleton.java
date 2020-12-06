/**
* ����ģʽ
 ȷ��һ����ֻ��һ��ʵ������������ʵ������������ϵͳ�ṩ���ʵ��
 ȷ��һ����ֻ��һ��ʵ��
 1 ���췽�����ܹ��������ܱ�������ʵ��������private
 2 ֻ��һ��ʵ������ʵ����������ĳ�Ա��������static
 ����ʵ����
 1 ����ʽ����������ʱ��ʼ����ʵ��
 2 ����ʽ����ʹ��ʵ��ʱ��ʼ����ʵ��
 ������ϵͳ�ṩ���ʵ��
 1 ��Ҫһ����̬������������ṩ��ǰ���ʵ��
 ����ģʽ������
 1���ֲ�ʽϵͳ
 2��ͬһ��JVMʹ���˶���������ͬʱ�����������
 ����ģʽ��ʹ�ó���
 ���������״̬����ô���״̬�ᱻ����
 ����ģʽ�����ʵ������״̬�ģ�ͨ����Ϊ������
 */


public class A_Singleton {
    public static void main(String[] args) {
        Singleton instance = Singleton.INSTANCE;
        instance.print();
    }
}

/**
 * ����ʽ����ģʽ
 */
class SingletonA {

    /**
     * ʵ����Ϊ��ĳ�Ա����
     */
    private static SingletonA singletonA = new SingletonA();

    /**
     * ˽�л����췽��
     */
    private SingletonA() {
    }

    /**
     * �����ṩ���ʵ��
     */
    public static SingletonA getInstance() {
        return singletonA;
    }
}

/**
 * ����ʽ����ģʽ
 */
class SingletonB {
    private static SingletonB singletonB;

    private SingletonB() {

    }

    /**
     * ����ʽ����ģʽ�����̰߳�ȫ����
     * 1��ͨ���Է������������ⵥ�����󱻶��ʵ����
     * ���̲߳���ȫ��������ʼ��ʱ��������Ϊ�գ�A��B�����߳�ͬʱ�ж϶���Ϊ�գ���ôA��B��ֱ�Ե����������ʵ������
     */
    public synchronized static SingletonB getInstance() {
        if (singletonB != null) {
            singletonB = new SingletonB();
        }
        return singletonB;
    }
}

/**
 * ����ʽ����ģʽ��˫�ؼ������
 */
class SingletonC {
    /**
     * ˫�ؼ����ģʽ�¿��ܻᷢ��ָ�����ţ�ʹ�� volatile �ؼ��ֿɱ���
     * <p>
     * ����������Ҫ���� 3 ������
     * 1�������ڴ�
     * 2����ʼ������
     * 3��������ָ�������ڴ��ַ
     * <p>
     * �������ָ������
     * A�߳�ִ����1��3����û��ִ��2����ʱB�߳���������ж�NULL�����ֶ����е�ַ����ʱB�̻߳᷵�ػ�û��ʼ����ɵ�ʵ�����󣬵��´�����
     */
    private volatile static SingletonC singletonC;

    private SingletonC() {
    }

    /**
     * ˫�ؼ����ģʽ
     * 1�������ʵ�����������ڶ����״ε���ʱ���������ö���϶���Ϊ�գ��˴�����ʹ��˫�ؼ������Сͬ���ķ�Χ
     * <p>
     * ˫�ؼ����
     * 1������ж��Ǳ�����״ε��ö�����������ͬ������飬�������Ч��
     * 2���ڲ��ж��Ƿ�ֹ����۱�ʵ�������
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
     * �ھ�̬�ڲ�����ʵ��������
     */
    private static class SingletonHolder {
        private static final SingletonD INSTANCE = new SingletonD();
    }
    private SingletonD(){}

    /**
     * ֻ��ͨ����ʽ���� getInstance() ����ʱ�Ż���ؾ�̬�ڲ��� SingletonHolder���Ӷ���ʼ��ʵ������
     */
    public static final SingletonD getInstance() {
        return SingletonHolder.INSTANCE;
    }
}

enum Singleton{
    // ����һ��ö��Ԫ�أ�ͬʱ��һ������ģʽʵ��
    INSTANCE;

    public void print() {
        System.out.println("ö�ٷ�ʽʵ�ֵ���");
    }
}



