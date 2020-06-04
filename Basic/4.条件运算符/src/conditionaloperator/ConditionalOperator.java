package conditionaloperator;

public class ConditionalOperator {
    public static void main(String[] args) {
        int score = 80;
        String grand = score < 60 ? "不及格" : "及格";
        System.out.println(grand);

        int num = -10;
        int flag = num > 0 ? 1 : (num == 0 ? 0 : -1);
        System.out.println(flag);
    }
}
