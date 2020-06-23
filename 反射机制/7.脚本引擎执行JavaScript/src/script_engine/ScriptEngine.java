package script_engine;


import org.python.util.PythonInterpreter;

import javax.script.Invocable;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.List;

/**
 * JavaScript 脚本引擎
 * @Author: Harlan
 * @Date: 2020/6/23 21:44
 */
public class ScriptEngine {

    public static void main(String[] args) throws ScriptException, NoSuchMethodException {
        //获得脚本引擎的对象
        ScriptEngineManager sem = new ScriptEngineManager();
        javax.script.ScriptEngine engine = sem.getEngineByName("javascript");

        //定义变量, 存储到引擎的上下文中
        engine.put("msg","Hello ScriptEngine!");
        String scriptStr = "var user = {name:'harlan',age:24,schools:['重庆大学','清华大学']};";
        scriptStr += "print(user.name);";

        //执行脚本
        engine.eval(scriptStr);
        engine.eval("print(msg)");
        engine.eval("msg = 'Hello Java!';");
        System.out.println("------------------");
        engine.eval("print(msg)");
        System.out.println(engine.get("msg"));

        System.out.println("==================");

        //定义函数
        engine.eval("function add(a,b){var sum = a + b; return sum;}");
        //取得调用接口
        Invocable invocable = (Invocable) engine;
        //执行定义的方法
        Object res = invocable.invokeFunction("add", 10, 20);
        System.out.println(res);

        System.out.println("====================");

        //导入其它的java包,使用其它包中的java类
//        String jsCode = "importPackage(java.util); var list = Arrays.asList([\"HARLAN\",\"HARLAN\",\"HARLAN\"]);";
//        engine.eval(jsCode);
//
//        List<String> list = (List<String>) engine.get("list");
//        for (String s : list) {
//            System.out.println(s);
//        }

        pythonScript("msg","Hello Python!");

    }


    public static void pythonScript(String msg, String pyStr) throws ScriptException {
        //导入jython jar包
        PythonInterpreter interpreter = new PythonInterpreter();
        interpreter.set(msg,pyStr);
        interpreter.exec("print "+msg);
    }
}
