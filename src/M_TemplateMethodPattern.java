/**
 * @author Linzeyu
 * @create 2021-03-13 15:03
 * @describe ģ�巽��ģʽ�����������Ϊ�����ฺ����Ϊ��ʵ��
 * @state todo
 */
public class M_TemplateMethodPattern {
    public static void main(String[] args) {
        CookingFood cooking = new CookingFood();
        cooking.cook();
    }
}

/**
 * �����ࣺ��������¼���Ҫ�ĳ�����(��Ϊģ��)
 * 1������ĳЩ�������̶�����������������ʵ�֣����Գ��󵽸����У�����������ʼ�ͽ���
 * 2�����ڲ��̶��ķ���������ȥʵ��
 */
abstract class Cooking {
    // ���������
    protected abstract void step1();

    protected abstract void step2();

    // ��ϳ�����
    public void cook() {
        System.out.println("������ʼ");
        step1();
        step2();
        System.out.println("��������");
    }
}

/**
 * ʵ��֮�ࣺ����ÿ������ľ���ʵ��
 */
class CookingFood extends Cooking {
    @Override
    protected void step1() {
        System.out.println("���������ͷ���");
    }

    @Override
    protected void step2() {
        System.out.println("���κ�ζ��");
    }
}