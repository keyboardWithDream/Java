package text_object_toString;

/**
 * 重写toString() 方法
 * @author Harlan
 */
public class TextObjectToString {

    @Override
    public String toString() {
        return "测试重写Object类的toString()方法.";
    }

    public static void main(String[] args) {
        TextObjectToString textObject = new TextObjectToString();
        System.out.println(textObject.toString());
    }
}
