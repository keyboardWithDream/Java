package static_proxy;

/**
 * 静态代理
 * 公共接口(两个角色都必须实现)
 * 1.真实角色
 * 2.代理角色
 * @Author: Harlan
 * @Date: 2020/6/11 13:52
 */
public class StaticProxy {

    public static void main(String[] args) {
        //new 代理角色(new 真实角色).方法()
        new ProxyUser(new Master()).text();

    }
}


/**
 * 公共接口(两个角色都将实现)
 */
interface Proxy{
    /**
     * 公共接口的方法
     */
    void text();
}

/**
 * 真实角色
 */
class Master implements Proxy{

    @Override
    public void text() {
        System.out.println("真实角色的方法执行...");
    }
}

/**
 * 代理角色
 */
class ProxyUser implements Proxy{

    /**
     * 真实角色(目标对象)
     */
    private Master target;

    public ProxyUser(Master target) {
        this.target = target;
    }

    private void ready(){
        System.out.println("正在准备...");
    }

    private void after(){
        System.out.println("已经结束...");
    }

    @Override
    public void text() {
        this.target.text();
    }
}