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
            // System.out.println(matcher.group(0));
            // System.out.println(matcher.regionStart());
            obj = obj.replace(matcher.group(), matcher.group().replace("@", ""));
        }
        return obj;
    }

    public static String switchForIBEPnrHis(String obj) {

        String regStr = "\\s{7,}";
        obj = obj.replaceAll(regStr, "\n       ");

        regStr = "[^0-9/]0\\d{2}[X/\\s]";
        Matcher matcher = Pattern.compile(regStr).matcher(obj);
        while (matcher.find()) {
            String find = matcher.group();
            find = find.substring(1, find.length());

            obj = obj.replaceAll(find, "\n" + find);
        }

        return obj.replaceAll("\n+", "\n");
    }


    public static void main(String[] args) {
        // System.out.println(switchForTDP("avb\"@236ddyyy\"@238hh"));
        // test();
        System.out.println(switchForIBEPnrHis(
                "*THIS PNR WAS ENTIRELY CANCELLED*006     TSN309 43429 1622 16MAR17 I     X1.TEST/CNNLIXINONE CHD(001) X2.TEST/LIXINONE(001) NZPX8G/GS001 X3.  GS1113 E   TH30MAR  TSNNAY XX2   0800 1000      E       NN(001)  HK(001)  RR(003)  XX(006)001 X4.  GS1114 Y   FR31MAR  NAYTSN XX2   1400 1600      E       NN(001)  HK(001)  RR(004)  XX(006)001 X5.NO005 X6.T001 X7.SSR FOID GS XX1 NIPAS456154648/P1       HK(001)   XX(006)001 X8.SSR FOID GS XX1 NI341281198905262473/P2       HK(001)   XX(006)005 X9.SSR TKNE GS XX1 TSNNAY 1113 E30MAR INF8262381532582/1/P2       HK(005)   XX(006)005X10.SSR TKNE GS XX1 TSNNAY 1113 E30MAR 8262381532581/1/P2       HK(005)   XX(006)005X11.SSR TKNE GS XX1 TSNNAY 1113 E30MAR 8262381532580/1/P1       HK(005)   XX(006)005X12.SSR TKNE GS XX1 NAYTSN 1114 Y31MAR 8262381532580/2/P1       HK(005)   XX(006)005X13.SSR TKNE GS XX1 NAYTSN 1114 Y31MAR 8262381532581/2/P2       HK(005)   XX(006)005X14.SSR TKNE GS XX1 NAYTSN 1114 Y31MAR INF8262381532582/2/P2       HK(005)   XX(006)001X15.SSR CKIN GS XX1 TSNNAY 1113 E30MAR GTH/P1       HK(001)   XX(006)001X16.SSR CKIN GS XX1 TSNNAY 1113 E30MAR GTH/P2       HK(001)   XX(006)001X17.SSR CKIN GS XX1 NAYTSN 1114 Y31MAR GTH/P2       HK(001)   XX(006)001X18.SSR CKIN GS XX1 NAYTSN 1114 Y31MAR GTH/P1       HK(001)   XX(006)001X19.SSR INFT GS XX1 TSNNAY 1113 E30MAR TEST/INFLIXINONE 03AUG15/P2       KK(001)   HK(003)   XX(006)001X20.SSR INFT GS XX1 NAYTSN 1114 Y31MAR TEST/INFLIXINONE 03AUG15/P2       KK(001)   HK(003)   XX(006)001X21.SSR CHLD GS XX1 03MAR09/P1       HK(001)   XX(006)001X22.OSI YY 1INF TEST/INFLIXINONE INF/P2001X23.OSI GS CTCM15926385696/P2001X24.OSI GS MFXL20KG/P2001X25.OSI GS MFXL20KG/P2001X26.OSI GS MFXL20KG/P1001X27.OSI GS MFXL20KG/P1001X28.OSI GS CTCT15926385696001X29.FN/M/FCNY1340.00/SCNY1340.00/C0.00/TEXEMPTYQ/TEXEMPTCN/ACNY1340.00/P1001X30.FN/M/IN/FCNY300.00/SCNY300.00/C0.00/TEXEMPTCN/TEXEMPTYQ/ACNY300.00/P2001X31.FN/M/FCNY2090.00/SCNY2090.00/C0.00/XCNY100.00/TCNY100.00CN/TEXEMPTYQ/        ACNY2190.00/P2005X32.TN/826-2381532580/P1005X33.TN/826-2381532581/P2005X34.TN/IN/826-2381532582/P2002X35.FP/CASH,CNY/P2002X36.FP/CASH,CNY/P1002X37.FP/IN/CASH,CNY/P2001X38.XN/IN/TEST/INFLIXINONE INF(AUG15)/P2001 39.TSN309001     TSN309 43429 1617 16MAR17002     TSN309 43429 1617 16MAR17 I003     TSN309 43429 1618 16MAR17 IK004     TSN309 43429 1618 16MAR17 IK001/005 TL/0058/17MAR/TSN309001/005 FC/M/TSN GS NAY 590.00E/GTH GS TSN 750.00YCH50 CNY1340.00END/TEST/        /CNNLIXINONE CHD001/005 FC/M/IN/TSN GS NAY 150.00YIN10S GS TSN 150.00YIN10S CNY300.00END/TEST/        /LIXINONE001/005 FC/M/TSN GS NAY 590.00E/GTH GS TSN 1500.00Y/GTH CNY2090.00END/TEST/        /LIXINONE002/005 EI/仅限网退,不得签转,GTH/TEST/LIXINONE002/005 EI/仅限网退,不得签转,GTH/TEST/CNNLIXINONE CHD                  -005TSN309 43429 1618 16MAR17 I006     TSN309 43429 1622 16MAR17 I"));

    }

}
