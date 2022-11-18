package util;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class TreeUtil {
    private List<JSONObject> dataList;
    private int parentId;
    private final String key;

    public TreeUtil(List<JSONObject> dataList, int parentId, String key) {
        this.dataList = dataList;
        this.parentId = parentId;
        this.key = key;
    }

    /**
     * create tree
     *
     * @param dataList dataList
     * @param parentId parentId
     * @return JSONArray
     * @author add by huyingzhao
     * 2022-11-16 09:48
     */
    private JSONArray createTree(List<JSONObject> dataList, int parentId) {
        JSONArray childMenu = new JSONArray();
        for (JSONObject data : dataList) {
            int id = data.getIntValue("id");
            int pid = -1;
            if (data.containsKey("p_id")) {
                pid = data.getIntValue("p_id");
            } else if (data.containsKey("pId")) {
                pid = data.getIntValue("pId");
            }
            if (parentId == pid) {
                JSONArray c_node = createTree(dataList, id);
                if (c_node.size() > 0) {
                    data.put(this.key, c_node);
                }
                childMenu.add(data);
            }
        }

        return childMenu;
    }

    /**
     * @param list list
     * @param id   id
     * @param key  key
     * @return String
     * @author add by huyingzhao
     * 2022-11-16 09:55
     */
    public String getParentName(List<JSONObject> list, String id, String key) {
        return findParentName(list, id, key).replaceFirst("-", "");
    }

    /**
     * @param list list
     * @param id   id
     * @param key  key
     * @return String
     * @author add by huyingzhao
     * 2022-11-16 09:55
     */
    private String findParentName(List<JSONObject> list, String id, String key) {
        String name = "";
        for (int i = 0; i < list.size(); i++) {
            JSONObject data = list.get(i);
            String cid = data.getString("id");
            String pid = data.getString("p_id");
            if (id.equals(cid) && !cid.equals(pid)) {
                name = findParentName(list, pid, key) + "-" + data.getString(key);
                return name;
            }
        }
        return "";
    }

    /**
     * @param dataList dataList
     * @param id       id
     * @param key      key
     * @return JSONArray
     * @author add by huyingzhao
     * 2022-11-16 10:00
     */
    public JSONArray getParentTree(List<JSONObject> dataList, String id, String key) {
        String idsStr = getParentName(dataList, id, "id");
        String[] ids = idsStr.split("-");
        List<JSONObject> result = new ArrayList<JSONObject>();
        for (String s : ids) {
            JSONObject node = findNode(dataList, s);
            result.add(node);
        }
        return new TreeUtil(result, 0, key).createTree(this.dataList, parentId);
    }

    /**
     * @param dataList dataList
     * @param id       id
     * @return JSONObject
     * @author add by huyingzhao
     * 2022-11-16 10:01
     */
    public JSONObject findNode(List<JSONObject> dataList, String id) {
        for (JSONObject node : dataList) {
            if (id.equals(node.getString("id"))) {
                return node;
            }
        }

        return null;
    }
}
