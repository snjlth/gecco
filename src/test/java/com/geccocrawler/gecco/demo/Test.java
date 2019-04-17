package com.geccocrawler.gecco.demo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {

    public static void main(String[] args) {
        String regStr = "https://www.meishij.net/.*";
        String url = "https://www.meishij.net/chufang/diy/wancan/";

        Pattern pattern2 = Pattern.compile(regStr);
        Matcher matcher2 = pattern2.matcher(url);
        if(matcher2.matches()) {
            System.out.println("yes");
        }
    }
}
