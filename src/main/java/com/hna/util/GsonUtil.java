package com.hna.util;

import java.util.Map.Entry;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;


public class GsonUtil {
    
    /*
     * 在json中查找节点值。 返回null(没有找到);否则返回JsonElement类型的对象。因为该节点可能对应仍是一个json串。
     */
    public  static Object getElement(String jsonStr, String... tagname) {

        // System.out.println("************************" +
        // Arrays.asList(tagname) + "**********************");
        JsonParser parser = new JsonParser();
        // 全部用小写
        // jsonStr = jsonStr.toLowerCase();

        JsonElement jsonElement = parser.parse(jsonStr);

        return getElement(jsonElement, tagname);

    }

    public static Object getElement(JsonElement jsonElement, String... tagname) {
        if (tagname == null || tagname.length == 0) {
            return null;
        }

        Object object = null;
        for (int size=0;size<tagname.length;size++) {
            // System.out.println(" size-tagname: " + size + " - " +
            // tagname[size]);
            // 全部用小写 .toLowerCase()
            String tag = tagname[size];
            if (isNum(tag)) {
                if (jsonElement.isJsonArray()) {
                    object = jsonElement.getAsJsonArray().get(Integer.parseInt(tag));
                } else {
                    return null;
                }
            } else {
                object = roll(jsonElement, tagname[size]);
            }

            if (object == null) {
                return null;
            } else {
                jsonElement = (JsonElement) object;
            }

        }

        JsonElement result = (JsonElement) object;
        return result;
    }

    /*
     * 在jsonElement中查找名字为str的节点值
     */
    public static Object roll(Object element, String str) {
        if (!(element instanceof JsonElement)) {
            return null;
        }
        JsonElement jsonElement = (JsonElement) element;

        if (jsonElement.getAsJsonObject().has(str)) {
        if (!jsonElement.isJsonPrimitive()) {
                for (Entry<String, JsonElement> entry : jsonElement.getAsJsonObject().entrySet()) {
                if (str.equals(entry.getKey())) {
                    return entry.getValue();
                }
            }
        }
        }
        return null;
    }

    /*
     * 获取JsonElement 对应的值
     */
    public static String getValue(Object obj) {
        if (obj != null && obj instanceof JsonElement) {
            JsonElement ele = (JsonElement) obj;
            return ele.getAsString();
        }
        return "null";
    }

    /*
     * 获取数组对象第num个的 jsonElement
     */
    public static Object arrayroll(JsonElement jsonElement, String str, int num) {
        if (jsonElement.isJsonArray() && jsonElement.getAsJsonArray().size() > num) {

            return roll(jsonElement.getAsJsonArray().get(num), str);
        }
        return null;
    }

    public static boolean isNum(String obj) {
        return obj.matches("[0-9]+");
    }

    public static void main(String[] args) {
        System.out.println(isNum("123"));
        System.out.println(isNum("0123"));
        System.out.println(isNum("012a"));
    }

}


