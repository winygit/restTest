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
        // Matcher matcher = Pattern.compile("\"@\\d{3}").matcher(obj);
        Matcher matcher = Pattern.compile("\"@").matcher(obj);
        while (matcher.find()) {
            // obj = obj.replace(matcher.group(),
            // matcher.group().toLowerCase().replace("@", ""));
            System.out.println(matcher.group(0));
            System.out.println(matcher.regionStart());
            obj = obj.replace(matcher.group(), matcher.group().replace("@", ""));
        }
        return obj;
    }

    public static void main(String[] args) {
        switchForTDP("avb\"@236ddyyy\"@238hh");
    }


}
