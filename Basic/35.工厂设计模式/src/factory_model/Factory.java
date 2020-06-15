package factory_model;

/**
 * @Author: Harlan
 * @Date: 2020/6/15 20:41
 */
public class Factory {

    public static Food createFood(String name){
        if ("Bread".equals(name)){
            return new Bread();
        }else if ("Apple".equals(name)){
            return new Apple();
        }else{
            return null;
        }
    }
}
