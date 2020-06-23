package generic;

import user.User;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

/**
 * 反射操作泛型
 * @Author: Harlan
 * @Date: 2020/6/23 19:43
 */
public class Generic {

    public void testGeneric(Map<String, User> map, List<User> list){
        System.out.println("testGeneric");
    }

    public Map<Integer, User> testGenericMap(){
        System.out.println("testGenericMap");
        return null;
    }

    public static void main(String[] args) {
        try{

            //获得指定方法参数泛型信息
            Method m = Generic.class.getDeclaredMethod("testGeneric", Map.class, List.class);
            Type[] t = m.getGenericParameterTypes();
            for (Type type : t) {
                System.out.println("参数类型: "+type);

            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
