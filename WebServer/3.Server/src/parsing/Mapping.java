package parsing;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * <servlet-mapping>
 *         <servlet-name>login</servlet-name>
 *         <url-pattern>/login</url-pattern>
 *         <url-pattern>/g</url-pattern>
 *     </servlet-mapping>
 *
 * @Author: Harlan
 * @Date: 2020/6/19 20:38
 */
public class Mapping {

    private String name;
    private Set<String> pattern;

    public Mapping() {
        pattern = new HashSet<>();
    }

    public void addPattern(String pattern){
        this.pattern.add(pattern);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<String> getPattern() {
        return pattern;
    }

    public void setPattern(Set<String> pattern) {
        this.pattern = pattern;
    }

    @Override
    public String toString() {
        return "Mapping{" +
                "name='" + name + '\'' +
                ", pattern=" + Arrays.toString(new Set[]{pattern}) +
                '}';
    }
}
