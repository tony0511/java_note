package com.qfedu.springmvc.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

public class DateConverter implements Converter<String, Date>{
    /**
     * 将字符串转换成日期格式
     */
    @Override
    public Date convert(String source) {
    	
    	System.out.println("日期格式转换器");
    	
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
                sdf.setLenient(false);//是否宽松解析：默认true
            return sdf.parse(source);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
