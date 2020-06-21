package parsing;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 通过对应的路径找到对应的class
 * @Author: Harlan
 * @Date: 2020/6/19 21:57
 */
public class WebContext {

    private final Map<String, String> entityMap = new HashMap<>();
    private final Map<String, String> mappingMap = new HashMap<>();

    /**
     * 将集合转换为映射关系
     * @param entityList 传入集合
     * @param mappingList 传入集合
     */
    public WebContext(List<Entity> entityList, List<Mapping> mappingList) {

        for (Entity entity : entityList) {
            entityMap.put(entity.getName(),entity.getClz());
        }

        for (Mapping mapping : mappingList) {
            for (String pattern : mapping.getPattern()) {
                mappingMap.put(pattern,mapping.getName());
            }
        }
    }

    /**
     * 通过patten找到class
     * @param pattern
     * @return
     */
    public String getClz(String pattern){
        return entityMap.get(mappingMap.get(pattern));
    }
}
