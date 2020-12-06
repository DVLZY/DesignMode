/**
 * @author Linzeyu
 * @create 2020-10-31 22:30
 * @describe 责任链模式
 * @state todo
 */
public class L_ChainRespPattern {
    public static void main(String[] args) {

        Leader leader = new Leader();
        Boss boss = new Boss();
        BigBoss bigBoss = new BigBoss();

        // 配置责任链关系
        leader.setNextHandler(boss);
        boss.setNextHandler(bigBoss);

        /**
         * 处理不同级别的请求
         * 此处可见，所有一开始请求都是交给leader进行处理的，但是每个节点会根据自己的职责范围进行处理
         * 对于无法处理的请求会传递到下一个节点
         */
        leader.process(1);
        //Leader 处理该请求
        leader.process(11);
        //Leader 无法处理，请求向后传递
        //Boss 处理该请求
        leader.process(21);
        //Leader 无法处理，请求向后传递
        //Boss 无法处理，请求向后传递
        //BigBoss 处理该请求
        leader.process(31);
        //Leader 无法处理，请求向后传递
        //Boss 无法处理，请求向后传递
        //Exception in thread "main" java.lang.IllegalArgumentException


    }
}

/**
 * 处理者抽象类
 */
abstract class Handler{

    // 定义责任链节点之间的关系
    protected Handler nextHandler;
    public void setNextHandler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }

    // 请求处理逻辑
    public abstract void process(Integer level);
}

/**
 * Leader 负责处理 1~10 级的请求
 */
class Leader extends Handler {
    @Override
    public void process(Integer level) {
        if (level > 0 && level < 11) {
            System.out.println("Leader 处理该请求");
        } else {
            System.out.println("Leader 无法处理，请求向后传递");
            nextHandler.process(level);
        }
    }
}

/**
 * Boss 负责处理 11~20 级的请求
 */
class Boss extends Handler {
    @Override
    public void process(Integer level) {
        if (level > 10 && level < 21) {
            System.out.println("Boss 处理该请求");
        } else {
            System.out.println("Boss 无法处理，请求向后传递");
            nextHandler.process(level);
        }
    }
}

/**
 * BigBoss 负责处理 21~30 级的请求
 */
class BigBoss extends Handler {
    @Override
    public void process(Integer level) {
        if (level > 20 && level < 31) {
            System.out.println("BigBoss 处理该请求");
        } else {
            throw new IllegalArgumentException();
        }
    }
}


