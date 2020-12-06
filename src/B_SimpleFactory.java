import java.util.Collection;

/**
 * �򵥹���ģʽ����̬��������ģʽ��
 * ������ģʽ
 * ���� JDK DataFormat
 *
 * ���ݲ����Ĳ�ͬ���ز�ͬ�����ʵ��������һ���������𴴽��������ʵ����
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
 * �򵥹��������ݲ����Ĳ�ͬ���ز�ͬ�����ʵ����
 * �ŵ㣺
 * 1��������Ĵ�����ʹ�÷���
 * ȱ�ݣ�
 * 1�������������Ҫ�����µ����͵Ķ�����Ҫ�޸Ĺ�������ж��߼���Υ������ԭ��
 * 2������ж����Ͷ�ʱ���߼����ø���
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
