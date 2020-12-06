/**
 * @author Linzeyu
 * @create 2020-10-31 13:26
 * @describe 装饰器模式
 * @state todo
 */
public class E_DecoratorPattern {
    public static void main(String[] args) {
        // 装饰器的使用——把对象传入装饰器中，然后就可以调用扩展后的功能了

        RobotVersionOne robotVersionOne = new RobotVersionOne();
        RobotDecoratorVersionOne robotVersionTwo = new RobotDecoratorVersionOne(robotVersionOne);
        robotVersionTwo.doMoreThing();
    }
}


/**
 * 产品（被装饰者）接口
 */
interface Robot{
    void doSomething();
}

/**
 * 产品实现类
 * 第一代机器人
 */
class RobotVersionOne implements Robot {
    @Override
    public void doSomething() {
        System.out.println("功能1");
        System.out.println("功能2");
    }
}

/**
 * 产品装饰器接口
 * 1、需要实现与产品相同的接口
 * 2、需要关联产品对象
 */
 abstract class RobotDecorator implements Robot {

    /**
     * 关联使用机器人对象
     */
    private Robot robot;

    /**
     * 使用构造方法传入对象
     */
    public RobotDecorator(Robot robot) {
        this.robot = robot;
    }

    /**
     * 实现原有机器人的功能
     */
    @Override
    public void doSomething() {
        robot.doSomething();
    }

}

/**
 * 装饰器实现
 */
class RobotDecoratorVersionOne extends RobotDecorator {

    /**
     * 关联使用机器人对象
     */
    private Robot robot;

    /**
     * 使用构造方法传入对象
     *
     * @param robot
     */
    public RobotDecoratorVersionOne(Robot robot) {
        super(robot);
    }

    /**
     * 对原有对象进行扩展
     */
    public void doMoreThing() {
        robot.doSomething();
        System.out.println("新功能1");
        System.out.println("新功能2");
    }
}