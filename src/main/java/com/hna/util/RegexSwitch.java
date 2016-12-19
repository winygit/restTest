/**
 * 
 */
package com.hna.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *<p>
 *
 *</p>
 * @author winy  
 * @date 2016年12月9日
 */
public class RegexSwitch {

    public static String switchForTDP(String obj) {
        // Matcher matcher = Pattern.compile("\"@[A-Z]").matcher(obj);
        Matcher matcher = Pattern.compile("\"@").matcher(obj);
        while (matcher.find()) {
            // obj = obj.replace(matcher.group(),
            // matcher.group().toLowerCase().replace("@", ""));
            obj = obj.replace(matcher.group(), matcher.group().replace("@", ""));
        }
        return obj;
    }



}
