package com.qianfeng.utils;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializeFilter;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.qianfeng.vo.JsonBean;

public class JsonUtils {

	public static void bean2Json(int code, Object info, HttpServletResponse response){
		
		JsonBean bean = new JsonBean();
		bean.setCode(code);
		bean.setInfo(info);
		
		PrintWriter writer = null;
		try {
			writer = response.getWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		writer.write(JSON.toJSONString(bean));
		/*
			QuoteFieldNames———-输出key时是否使用双引号,默认为true 
			WriteMapNullValue——–是否输出值为null的字段,默认为false 
			WriteNullNumberAsZero—-数值字段如果为null,输出为0,而非null 
			WriteNullListAsEmpty—–List字段如果为null,输出为[],而非null 
			WriteNullStringAsEmpty—字符类型字段如果为null,输出为”“,而非null 
			WriteNullBooleanAsFalse–Boolean字段如果为null,输出为false,而非null
		 * */
		SerializerFeature[] feature = new SerializerFeature[]{
			SerializerFeature.WriteMapNullValue,
			SerializerFeature.WriteNullStringAsEmpty,
			SerializerFeature.WriteNullNumberAsZero,
			SerializerFeature.WriteDateUseDateFormat
		};
		writer.write(JSON.toJSONString(bean, feature));
		writer.flush();
		writer.close();
	}
}
