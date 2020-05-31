package structure;

public class WhileStucture {
    //从0 累加到 100
    public static void main(String[] args) {
        int i = 1;
        int sum = 0;
        while (i <= 100){
            sum += i;
            i++;
            System.out.println(sum);
        }
    }
}
