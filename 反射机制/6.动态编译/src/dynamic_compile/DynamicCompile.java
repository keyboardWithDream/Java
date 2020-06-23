package dynamic_compile;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * 动态编译
 * @Author: Harlan
 * @Date: 2020/6/23 20:33
 */
public class DynamicCompile {

    public static void main(String[] args) {

        //通过IO流操作,将自负床存储为一个临时文件,然后执行动态编译
        String str = "public class Hi {\n" +
                "\n" +
                "    public static void main(String[] args) {\n" +
                "        System.out.println(\"Hello Java!\");\n" +
                "    }\n" +
                "}";

        dynamicCompile(str,"./6.动态编译/src/Hi.java");

//        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
//        int result = compiler.run(null, null, null, "./6.动态编译/src/HelloWorld.java");
//        System.out.println(result == 0 ? "编译成功" : "编译失败");
    }


    /**
     * 临时文件编译
     * @param str java语句
     * @param path 文件路径
     */
    public static void dynamicCompile(String str,String path){

        File file = new File(path);

        try (OutputStreamWriter os = new OutputStreamWriter(new FileOutputStream(file))) {
            os.write(str);
            os.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }


        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        int result = compiler.run(null, null, null, file.getPath());
        System.out.println(result == 0 ? "编译成功" : "编译失败");
        boolean res = file.delete();
        System.out.println(res);

        try{
            URL[] urls = new URL[] {new URL("./6.动态编译/src/")};
            URLClassLoader loader = new URLClassLoader(urls);
            Class<?> clazz = loader.loadClass("Hi");
            clazz.getMethod("main",String[].class).invoke(null,(Object)new String[]{});
        } catch (MalformedURLException | ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
