/**
 * 
 */
package com.hna.util;

import java.lang.reflect.Field;

import org.springframework.util.StringUtils;

/**
 *<p>
 *
 *</p>
 * @author winy  
 * @date 2017年2月23日
 */
public class ClassToString {

    public String getString(Object obj) {

        System.out.println(obj.getClass().getName());
        Field[] declaredFields = obj.getClass().getDeclaredFields();
        StringBuilder sb = new StringBuilder();

        for (Field field : declaredFields) {
            try {
                field.isAccessible();
                if (!StringUtils.isEmpty(field.get(obj))) {
                    sb.append(field.getName() + ":" + field.get(obj) + ";");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if (!StringUtils.isEmpty(sb.toString())) {
            return sb.toString().substring(0, sb.length() - 1);
        }
        return null;
    }

}
