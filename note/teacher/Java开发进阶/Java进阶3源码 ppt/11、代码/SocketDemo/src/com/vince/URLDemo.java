package com.vince;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by vince on 2017/6/7.
 */
public class URLDemo {
  public static void main(String[] args) {
    // URL 统一资源定位符
    try {
      URL url = new URL("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1496836692581&di=d5609e04e9f78f50dc2103e825e1e4d9&imgtype=0&src=http%3A%2F%2Fbpic.ooopic.com%2F15%2F57%2F11%2F15571198-c622e0f5ad9464916824bee7d3b8bfe1-3.jpg");
      HttpURLConnection conn = (HttpURLConnection) url.openConnection();
      BufferedInputStream in = new BufferedInputStream(conn.getInputStream());
      BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream("c:\\yali.jpg"));
      byte[] bytes = new byte[1024];
      int len = -1;
      while((len = in.read(bytes)) != -1){
        out.write(bytes,0,len);
        out.flush();
      }
      in.close();
      out.close();
      System.out.println("下载成功");
    } catch (MalformedURLException|IOException e) {
      e.printStackTrace();
    }
  }
}
