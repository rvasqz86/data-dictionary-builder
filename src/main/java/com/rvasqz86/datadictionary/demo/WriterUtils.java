package com.rvasqz86.datadictionary.demo;

import org.apache.commons.lang3.StringUtils;

public class WriterUtils {
    public static String pad(String string, int pad,  String padValue) {
        if(string == null || string.equals("null") ) {
            string = "";
        }
        return StringUtils.leftPad(string, pad *5, padValue);
    }

    public static String pad(String string, int pad) {
        if(string == null || string.equals("null") ) {
            string = "";
        }
        return StringUtils.leftPad(string, pad *5, " ");
    }
}
