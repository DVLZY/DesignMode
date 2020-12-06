/**
 * @author Linzeyu
 * @create 2020-10-31 14:13
 * @describe 适配器模式
 * @state todo
 */


/**
 * 场景
 * 有一个英国人，只会说英文
 * 但是听众都是中国人，只会中文
 * 所以此时需要一个翻译者（适配器）将听不懂的英文转换成能听懂的中文
 */
public class F_AdapterPattern {
    public static void main(String[] args) {
        // 直接输出内容是英文，大家都看不懂
        English en = new English();
        System.out.println("en = " + en.speak());

        // 通过适配器转换成中文(将原始对象传入适配器，再调用适配器的翻译方法)
        EN2CH translator = new EN2CH(en);
        System.out.println("ch = " + translator.translator());
    }
}

/**
 * 说英文的人（代表不兼容的接口）
 */
class English {
    public String speak() {
        return "hello";
    }
}

/**
 * 翻译者（适配器接口）
 * 将不兼容的接口转化为兼容的接口
 */
interface Translator{
    public String translator();
}

/**
 * 适配器实现类
 */
class EN2CH implements Translator {

    // 传入需要被转换的对象
    private English english;

    public EN2CH(English english) {
        this.english = english;
    }

    // 将不兼容的接口转化为兼容的接口
    @Override
    public String translator() {
        String speak = english.speak();
        if (speak.equals("hello")) {
            return "你好";
        }
        return null;
    }
}