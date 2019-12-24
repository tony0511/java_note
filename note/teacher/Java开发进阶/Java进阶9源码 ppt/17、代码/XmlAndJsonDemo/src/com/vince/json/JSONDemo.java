package com.vince.json;

import com.google.gson.stream.JsonReader;
import org.junit.Test;

import javax.print.attribute.standard.MediaSize;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
/**
 * Created by vince on 2017/7/1.
 */
public class JSONDemo {
  // 解析一个JSON数组
  @Test
  public void parseJSONNames(){
    InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("com/vince/json/names.json");
    InputStreamReader in = new InputStreamReader(is);
    // JSON的解析工具（解析器）
    JsonReader reader = new JsonReader(in);
    ArrayList<Name> list = new ArrayList<>();
    try {
      // 开始解析数组
      reader.beginArray();
      while (reader.hasNext()) {
        list.add(parseName(reader));
      }
      // 结束解析数组
      reader.endArray();
    } catch (IOException e) {
      e.printStackTrace();
    }
    System.out.println(Arrays.toString(list.toArray()));
  }
  // 解析对象 Name
  private Name parseName(JsonReader jsonReader){
    Name name = null;
    try {
      // 开始解析对象
      jsonReader.beginObject();
      name = new Name();
      while (jsonReader.hasNext()) {
        String attrName = jsonReader.nextName();
        if ("firstName".equals(attrName)) {
          name.setFirstName(jsonReader.nextString());
        } else if ("lastName".equals(attrName)){
          name.setLastName(jsonReader.nextString());
        } else if ("email".equals(attrName)){
          name.setEmail(jsonReader.nextString());
        }
      }
      // 结束解析对象
      jsonReader.endObject();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return name;
  }
}
