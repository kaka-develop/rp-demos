package com.cmc.demo.util;

public class ConverterUtil {

    public static int convertStringToInteger(String input){
        try {
            return Integer.valueOf(input);
        }catch (Exception e){
            return 0;
        }
    }
}
