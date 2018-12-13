package com.uduck.multthread.util;

public class ConvertUtil {

    public static void convert(String param){
        System.out.println("转换开始 ===> " + param);
        try {
            Thread.sleep(20 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("转换结束 ===> " + param);
    }
}
