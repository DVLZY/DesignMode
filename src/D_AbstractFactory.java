/**
 * 抽象工厂模式
 */
public class D_AbstractFactory {
    public static void main(String[] args) {
        AbstractFactory factory = new SuperFactory();
        Computer Lenovo = factory.createComputer(1);
        Mask N95 = factory.createMask(2);
        Lenovo.print();
        N95.print();
    }
}

/**
 * 抽象工厂
 */
interface AbstractFactory {
    Mask createMask(Integer type);
    Computer createComputer(Integer type);
}

/**
 * 工厂实现类
 */
class SuperFactory implements AbstractFactory {
    @Override
    public Mask createMask(Integer type) {
        if (1 == type) {
            return new N90();
        } else {
            return new N95();
        }
    }

    @Override
    public Computer createComputer(Integer type) {
        if (1 == type) {
            return new Lenovo();
        } else {
            return new Dell();
        }
    }
}

/**
 * 产品——电脑
 */
interface Computer {
    void print();
}

class Lenovo implements Computer {
    @Override
    public void print() {
        System.out.println("Lenovo");
    }
}
class Dell implements Computer {
    @Override
    public void print() {
        System.out.println("Dell");
    }
}

/**
 * 产品——口罩
 */
interface Mask {
    void print();
}

class N90 implements Mask {
    @Override
    public void print() {
        System.out.println("N90");
    }
}
class N95 implements Mask {
    @Override
    public void print() {
        System.out.println("N95");
    }
}