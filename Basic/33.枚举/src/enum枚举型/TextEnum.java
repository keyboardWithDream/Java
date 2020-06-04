package enum枚举型;

/**
 * 枚举型: 定义一组常量使用枚举
 * enum 枚举名 { 枚举体(常量列表) }
 * @Author: Harlan
 * @Date: 2020/6/2 22:19
 */
public class TextEnum {

    public static void main(String[] args) {
        System.out.println(Season.AUTUMN);
        Season a = Season.AUTUMN;

        switch (a){
            case SPRING -> {
                System.out.println("春天");
                break;
            }
            case SUMMER -> {
                System.out.println("夏天");
                break;
            }
            case AUTUMN -> {
                System.out.println("秋天");
                break;
            }
            case WINDER -> {
                System.out.println("冬天");
                break;
            }
            default -> {
                return;
            }
        }
    }
}

enum Season {
    AUTUMN, SPRING, SUMMER, WINDER
}

enum Week{
    星期一, 星期二, 星期三, 星期四, 星期五, 星期六, 星期天
}
