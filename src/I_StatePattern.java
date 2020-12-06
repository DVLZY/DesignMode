/**
 * @author Linzeyu
 * @create 2020-10-31 16:28
 * @describe 状态模式
 * @state todo
 */
public class I_StatePattern {
    public static void main(String[] args) {
        // 创建环境对象
        Context zhangSan = new Context();

        // 状态高兴时输出积极主动
        zhangSan.setState(new Happy());
        zhangSan.doSimething();

        // 状态难过时输出无精打采
        zhangSan.setState(new Sad());
        zhangSan.doSimething();
    }
}

/**
 * 状态类
 */
abstract class State {
    /**
     * 行为
     */
    abstract void doWork();
}

/**
 * 状态类实现
 * 不同状态绑定不同行为
 */
class Happy extends State {
    @Override
    void doWork() {
        System.out.println("积极主动");
    }
}

class Angry extends State {
    @Override
    void doWork() {
        System.out.println("罢工");
    }
}

class Sad extends State {
    @Override
    void doWork() {
        System.out.println("无精打采");
    }
}

/**
 *  环境类
 */
class Context {

    // 引入状态
    private State state;

    // 改变状态
    public void setState(State state) {
        this.state = state;
    }

    // 根据状态执行方法
    public void doSimething() {
        state.doWork();
    }
}
