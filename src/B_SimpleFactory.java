import java.util.Collection;

/**
 * 简单工厂模式（静态工厂方法模式）
 * 创建型模式
 * 案例 JDK DataFormat
 *
 * 根据参数的不同返回不同子类的实例（定义一个类来负责创建其他类的实例）
 *
 */
public class B_SimpleFactory {
    public static void main(String[] args) {
        Product productA = SimpleFactory.createProduct(1);
        productA.print();
        Product productB = SimpleFactory.createProduct(2);
        productB.print();
    }
}

abstract class Product {
    public abstract void print();
}

class ProductA extends Product {

    @Override
    public void print() {
        System.out.println("ProductA");
    }
}

class ProductB extends Product {

    @Override
    public void print() {
        System.out.println("ProductB");
    }
}

/**
 * 简单工厂（根据参数的不同返回不同子类的实例）
 * 优点：
 * 1、将对象的创建与使用分离
 * 缺陷：
 * 1、不够灵活，如果需要创建新的类型的对象，需要修改工厂类的判断逻辑（违反开闭原则）
 * 2、如果判断类型多时，逻辑会变得复杂
 */
class SimpleFactory {
    public static Product createProduct(Integer type) {
        if (1 == type) {
            return new ProductA();
        }
        if (2 == type) {
            return new ProductB();
        } else {
            throw new IllegalArgumentException();
        }
    }
}
