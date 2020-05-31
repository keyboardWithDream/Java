package testscanner;
import java.util.Scanner; //导入Scanner类

public class TestScanner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); //创建Scanner对象 System.in是IO流对象
        System.out.println("请输入姓名:");
        String name = scanner.nextLine();
        System.out.printf("Hello %s !\n", name);
    }
}
