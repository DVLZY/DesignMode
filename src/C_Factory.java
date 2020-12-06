/**
 * 工厂模式
 */
public class C_Factory {
    public static void main(String[] args) {
        // 生产一部IPhone
        Factory factory = new IPhoneFactory();
        Phone phone = factory.createPhone();
        phone.print();
        //输出 IPhone
    }
}

/**
 * 产品接口
 */
interface Phone {
    /**
     * 产品方法
     */
    void print();
}

/**
 * 产品实现类
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
 * 工厂类接口
 */
interface Factory {
    /**
     * 生产产品方法
     */
    Phone createPhone();
}

/**
 * 工厂类实现类
 */
class IPhoneFactory implements Factory {
    /**
     * 实现产品生产
     */
    @Override
    public Phone createPhone() {
        return new IPhone();
    }
}

class HuaWeiPhoneFactory implements Factory {
    /**
     * 实现产品生产
     */
    @Override
    public Phone createPhone() {
        return new HuaWeiPhone();
    }
}