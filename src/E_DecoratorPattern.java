/**
 * @author Linzeyu
 * @create 2020-10-31 13:26
 * @describe װ����ģʽ
 * @state todo
 */
public class E_DecoratorPattern {
    public static void main(String[] args) {
        // װ������ʹ�á����Ѷ�����װ�����У�Ȼ��Ϳ��Ե�����չ��Ĺ�����

        RobotVersionOne robotVersionOne = new RobotVersionOne();
        RobotDecoratorVersionOne robotVersionTwo = new RobotDecoratorVersionOne(robotVersionOne);
        robotVersionTwo.doMoreThing();
    }
}


/**
 * ��Ʒ����װ���ߣ��ӿ�
 */
interface Robot{
    void doSomething();
}

/**
 * ��Ʒʵ����
 * ��һ��������
 */
class RobotVersionOne implements Robot {
    @Override
    public void doSomething() {
        System.out.println("����1");
        System.out.println("����2");
    }
}

/**
 * ��Ʒװ�����ӿ�
 * 1����Ҫʵ�����Ʒ��ͬ�Ľӿ�
 * 2����Ҫ������Ʒ����
 */
 abstract class RobotDecorator implements Robot {

    /**
     * ����ʹ�û����˶���
     */
    private Robot robot;

    /**
     * ʹ�ù��췽���������
     */
    public RobotDecorator(Robot robot) {
        this.robot = robot;
    }

    /**
     * ʵ��ԭ�л����˵Ĺ���
     */
    @Override
    public void doSomething() {
        robot.doSomething();
    }

}

/**
 * װ����ʵ��
 */
class RobotDecoratorVersionOne extends RobotDecorator {

    /**
     * ����ʹ�û����˶���
     */
    private Robot robot;

    /**
     * ʹ�ù��췽���������
     *
     * @param robot
     */
    public RobotDecoratorVersionOne(Robot robot) {
        super(robot);
    }

    /**
     * ��ԭ�ж��������չ
     */
    public void doMoreThing() {
        robot.doSomething();
        System.out.println("�¹���1");
        System.out.println("�¹���2");
    }
}