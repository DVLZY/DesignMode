/**
 * @author Linzeyu
 * @create 2020-10-31 14:38
 * @describe 观察者模式
 * @state todo
 */

import java.util.ArrayList;
import java.util.List;



/**
 * 场景
 * 张三借了亲朋好友的钱，但是没钱还
 * 不过张三打算一有钱就通知亲朋好友准备还钱(状态变化时通知观察者)
 */
public class G_ObserverPattern {
    public static void main(String[] args) {

        // 借款人
        CustomDebit zhangSan = new CustomDebit();

        // 债主（观察者）
        CustomCredit liShi = new CustomCredit("李四");
        CustomCredit wangWu = new CustomCredit("王五");

        // 添加观察者（向亲朋好友借钱）
        zhangSan.Borrow(liShi);
        zhangSan.Borrow(wangWu);

        // 被观察者状态发生变化后通知观察者（张三有钱了，通知债主准备还钱）
        zhangSan.notifyCredit();
        // 李四收到了通知
        // 王五收到了通知

    }
}

/**
 * 借款方（被观察者）
 */
interface Debit {
    // 向贷款方借钱
    void Borrow(Credit credit);

    // 通知贷款方
    void notifyCredit();
}

/**
 * 借款方实现类
 */
class CustomDebit implements Debit {

    // 定义一个数据结构，方便存储所有借钱给张三的人（要通知的对象）
    private List<Credit> allCredit = new ArrayList<Credit>();

    @Override
    public void Borrow(Credit credit) {
        // 添加一个观察者对象
        allCredit.add(credit);
    }

    @Override
    public void notifyCredit() {
        // 通知所有观察者
        allCredit.forEach(credit -> credit.takeMoney());
    }
}


/**
 * 贷款方（观察者）
 */
interface Credit {
    void takeMoney();
}

/**
 * 贷款方实现类
 */
class CustomCredit implements Credit {

    private String name;

    public CustomCredit(String name) {
        this.name = name;
    }

    @Override
    public void takeMoney() {
        System.out.println(name+"收到了通知");
    }
}
