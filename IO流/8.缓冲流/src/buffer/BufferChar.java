package buffer;

import java.io.*;

/**
 * 文件字节输入流 加缓冲流
 * @Author: Harlan
 * @Date: 2020/6/8 19:39
 */
public class BufferChar {

    public static void main(String[] args) {
        input();
        output();
    }

    public static void input(){
        File file = new File("./8.缓冲流/src/buffer/text.txt");
        try(BufferedReader reader = new BufferedReader(new FileReader(file))){
            String line = null;
            while ((line = reader.readLine()) != null){
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void output(){
        File file = new File("./8.缓冲流/src/buffer/text.txt");
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(file,true))){
            writer.newLine();
            writer.append("BufferWriter 就是好!!!!!!");
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
