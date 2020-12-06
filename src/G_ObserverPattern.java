/**
 * @author Linzeyu
 * @create 2020-10-31 14:38
 * @describe �۲���ģʽ
 * @state todo
 */

import java.util.ArrayList;
import java.util.List;



/**
 * ����
 * ��������������ѵ�Ǯ������ûǮ��
 * ������������һ��Ǯ��֪ͨ�������׼����Ǯ(״̬�仯ʱ֪ͨ�۲���)
 */
public class G_ObserverPattern {
    public static void main(String[] args) {

        // �����
        CustomDebit zhangSan = new CustomDebit();

        // ծ�����۲��ߣ�
        CustomCredit liShi = new CustomCredit("����");
        CustomCredit wangWu = new CustomCredit("����");

        // ��ӹ۲��ߣ���������ѽ�Ǯ��
        zhangSan.Borrow(liShi);
        zhangSan.Borrow(wangWu);

        // ���۲���״̬�����仯��֪ͨ�۲��ߣ�������Ǯ�ˣ�֪ͨծ��׼����Ǯ��
        zhangSan.notifyCredit();
        // �����յ���֪ͨ
        // �����յ���֪ͨ

    }
}

/**
 * �������۲��ߣ�
 */
interface Debit {
    // ������Ǯ
    void Borrow(Credit credit);

    // ֪ͨ���
    void notifyCredit();
}

/**
 * ��ʵ����
 */
class CustomDebit implements Debit {

    // ����һ�����ݽṹ������洢���н�Ǯ���������ˣ�Ҫ֪ͨ�Ķ���
    private List<Credit> allCredit = new ArrayList<Credit>();

    @Override
    public void Borrow(Credit credit) {
        // ���һ���۲��߶���
        allCredit.add(credit);
    }

    @Override
    public void notifyCredit() {
        // ֪ͨ���й۲���
        allCredit.forEach(credit -> credit.takeMoney());
    }
}


/**
 * ������۲��ߣ�
 */
interface Credit {
    void takeMoney();
}

/**
 * ���ʵ����
 */
class CustomCredit implements Credit {

    private String name;

    public CustomCredit(String name) {
        this.name = name;
    }

    @Override
    public void takeMoney() {
        System.out.println(name+"�յ���֪ͨ");
    }
}
