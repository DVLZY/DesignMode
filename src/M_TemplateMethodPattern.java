/**
 * @author Linzeyu
 * @create 2021-03-13 15:03
 * @describe 模板方法模式：父类控制行为，子类负责行为的实现
 * @state todo
 */
public class M_TemplateMethodPattern {
    public static void main(String[] args) {
        CookingFood cooking = new CookingFood();
        cooking.cook();
    }
}

/**
 * 抽象类：定义完成事件需要的抽象步骤(作为模板)
 * 1、对于某些公共（固定）方法，无需子类实现，可以抽象到父类中，例如做饭开始和结束
 * 2、对于不固定的方法由子类去实现
 */
abstract class Cooking {
    // 定义抽象步骤
    protected abstract void step1();

    protected abstract void step2();

    // 组合抽象步骤
    public void cook() {
        System.out.println("做饭开始");
        step1();
        step2();
        System.out.println("做饭结束");
    }
}

/**
 * 实现之类：负责每个步骤的具体实现
 */
class CookingFood extends Cooking {
    @Override
    protected void step1() {
        System.out.println("放西红柿和番茄");
    }

    @Override
    protected void step2() {
        System.out.println("放盐和味精");
    }
}