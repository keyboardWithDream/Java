package structure;

import java.util.Scanner;

public class SwitchStructure {
    //判断 元音字母
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入字母:");
        char letter = scanner.next().charAt(0);

        switch (letter){
            case 'a' & 'A' :
            case 'o' & 'O':
            case 'e' & 'E':
            case 'i' & 'I':
            case 'u' & 'U':
                System.out.println("元音");
                break;
            default:
                System.out.println("辅音");

        }
    }
}
