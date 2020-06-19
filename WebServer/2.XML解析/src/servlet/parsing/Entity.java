package servlet.parsing;

/**
 * <servlet>
 *         <servlet-name>login</servlet-name>
 *         <servlet-class>com.sxt.server.basic.servlet.LoginServlet</servlet-class>
 *     </servlet>
 *
 * @Author: Harlan
 * @Date: 2020/6/19 20:37
 */
public class Entity {

    private String name;
    private String clz;

    public Entity() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClz() {
        return clz;
    }

    public void setClz(String clz) {
        this.clz = clz;
    }

    @Override
    public String toString() {
        return "Entity{" +
                "name='" + name + '\'' +
                ", clz='" + clz + '\'' +
                '}';
    }
}
