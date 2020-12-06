/**
 * @author Linzeyu
 * @create 2020-10-31 22:30
 * @describe ������ģʽ
 * @state todo
 */
public class L_ChainRespPattern {
    public static void main(String[] args) {

        Leader leader = new Leader();
        Boss boss = new Boss();
        BigBoss bigBoss = new BigBoss();

        // ������������ϵ
        leader.setNextHandler(boss);
        boss.setNextHandler(bigBoss);

        /**
         * ����ͬ���������
         * �˴��ɼ�������һ��ʼ�����ǽ���leader���д���ģ�����ÿ���ڵ������Լ���ְ��Χ���д���
         * �����޷����������ᴫ�ݵ���һ���ڵ�
         */
        leader.process(1);
        //Leader ���������
        leader.process(11);
        //Leader �޷�����������󴫵�
        //Boss ���������
        leader.process(21);
        //Leader �޷�����������󴫵�
        //Boss �޷�����������󴫵�
        //BigBoss ���������
        leader.process(31);
        //Leader �޷�����������󴫵�
        //Boss �޷�����������󴫵�
        //Exception in thread "main" java.lang.IllegalArgumentException


    }
}

/**
 * �����߳�����
 */
abstract class Handler{

    // �����������ڵ�֮��Ĺ�ϵ
    protected Handler nextHandler;
    public void setNextHandler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }

    // �������߼�
    public abstract void process(Integer level);
}

/**
 * Leader ������ 1~10 ��������
 */
class Leader extends Handler {
    @Override
    public void process(Integer level) {
        if (level > 0 && level < 11) {
            System.out.println("Leader ���������");
        } else {
            System.out.println("Leader �޷�����������󴫵�");
            nextHandler.process(level);
        }
    }
}

/**
 * Boss ������ 11~20 ��������
 */
class Boss extends Handler {
    @Override
    public void process(Integer level) {
        if (level > 10 && level < 21) {
            System.out.println("Boss ���������");
        } else {
            System.out.println("Boss �޷�����������󴫵�");
            nextHandler.process(level);
        }
    }
}

/**
 * BigBoss ������ 21~30 ��������
 */
class BigBoss extends Handler {
    @Override
    public void process(Integer level) {
        if (level > 20 && level < 31) {
            System.out.println("BigBoss ���������");
        } else {
            throw new IllegalArgumentException();
        }
    }
}


