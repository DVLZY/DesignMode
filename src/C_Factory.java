/**
 * ����ģʽ
 */
public class C_Factory {
    public static void main(String[] args) {
        // ����һ��IPhone
        Factory factory = new IPhoneFactory();
        Phone phone = factory.createPhone();
        phone.print();
        //��� IPhone
    }
}

/**
 * ��Ʒ�ӿ�
 */
interface Phone {
    /**
     * ��Ʒ����
     */
    void print();
}

/**
 * ��Ʒʵ����
 */
class IPhone implements Phone {
    @Override
    public void print() {
        System.out.println("IPhone");
    }
}

class HuaWeiPhone implements Phone {
    @Override
    public void print() {
        System.out.println("HuaWeiPhone");
    }
}

/**
 * ������ӿ�
 */
interface Factory {
    /**
     * ������Ʒ����
     */
    Phone createPhone();
}

/**
 * ������ʵ����
 */
class IPhoneFactory implements Factory {
    /**
     * ʵ�ֲ�Ʒ����
     */
    @Override
    public Phone createPhone() {
        return new IPhone();
    }
}

class HuaWeiPhoneFactory implements Factory {
    /**
     * ʵ�ֲ�Ʒ����
     */
    @Override
    public Phone createPhone() {
        return new HuaWeiPhone();
    }
}