/**
 * @author Linzeyu
 * @create 2020-10-31 16:28
 * @describe ״̬ģʽ
 * @state todo
 */
public class I_StatePattern {
    public static void main(String[] args) {
        // ������������
        Context zhangSan = new Context();

        // ״̬����ʱ�����������
        zhangSan.setState(new Happy());
        zhangSan.doSimething();

        // ״̬�ѹ�ʱ����޾����
        zhangSan.setState(new Sad());
        zhangSan.doSimething();
    }
}

/**
 * ״̬��
 */
abstract class State {
    /**
     * ��Ϊ
     */
    abstract void doWork();
}

/**
 * ״̬��ʵ��
 * ��ͬ״̬�󶨲�ͬ��Ϊ
 */
class Happy extends State {
    @Override
    void doWork() {
        System.out.println("��������");
    }
}

class Angry extends State {
    @Override
    void doWork() {
        System.out.println("�չ�");
    }
}

class Sad extends State {
    @Override
    void doWork() {
        System.out.println("�޾����");
    }
}

/**
 *  ������
 */
class Context {

    // ����״̬
    private State state;

    // �ı�״̬
    public void setState(State state) {
        this.state = state;
    }

    // ����״ִ̬�з���
    public void doSimething() {
        state.doWork();
    }
}
