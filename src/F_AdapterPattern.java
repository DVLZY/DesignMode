/**
 * @author Linzeyu
 * @create 2020-10-31 14:13
 * @describe ������ģʽ
 * @state todo
 */


/**
 * ����
 * ��һ��Ӣ���ˣ�ֻ��˵Ӣ��
 * �������ڶ����й��ˣ�ֻ������
 * ���Դ�ʱ��Ҫһ�������ߣ�������������������Ӣ��ת����������������
 */
public class F_AdapterPattern {
    public static void main(String[] args) {
        // ֱ�����������Ӣ�ģ���Ҷ�������
        English en = new English();
        System.out.println("en = " + en.speak());

        // ͨ��������ת��������(��ԭʼ���������������ٵ����������ķ��뷽��)
        EN2CH translator = new EN2CH(en);
        System.out.println("ch = " + translator.translator());
    }
}

/**
 * ˵Ӣ�ĵ��ˣ��������ݵĽӿڣ�
 */
class English {
    public String speak() {
        return "hello";
    }
}

/**
 * �����ߣ��������ӿڣ�
 * �������ݵĽӿ�ת��Ϊ���ݵĽӿ�
 */
interface Translator{
    public String translator();
}

/**
 * ������ʵ����
 */
class EN2CH implements Translator {

    // ������Ҫ��ת���Ķ���
    private English english;

    public EN2CH(English english) {
        this.english = english;
    }

    // �������ݵĽӿ�ת��Ϊ���ݵĽӿ�
    @Override
    public String translator() {
        String speak = english.speak();
        if (speak.equals("hello")) {
            return "���";
        }
        return null;
    }
}