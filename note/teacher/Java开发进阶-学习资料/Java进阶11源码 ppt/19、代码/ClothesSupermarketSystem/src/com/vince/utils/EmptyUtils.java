package com.vince.utils;

/**
 * Created by vince on 2017/7/19.
 */
public class EmptyUtils {

    public static boolean isEmpty(String s){
        if(null==s || "".equals(s)){
            return true;
        }else{
            return false;
        }
    }
}
