package com.vince;
import org.junit.Test;
/**
 * 正则表达式示例
 */
public class RegexDemo2 {
  @Test
  public void test(){
    // 匹配电话号码
    String phoneNumber = "010-38389438";
    boolean b = phoneNumber.matches("\\d{3,4}-\\d{7,8}");
    System.out.println(b);
    // 匹配手机号码
    String phone = "13895271234";
    System.out.println(phone.matches("[1][3-9]\\d{9}"));
    // 匹配用户名：字母开头，数字字母下划线组合
    String username = "abc1314";
    System.out.println(username.matches("[a-zA-Z]+[\\w|_]*"));
    // 匹配IP地址
    String ip = "20.10.20.123";
    System.out.println(ip.matches("\\d{1,3}.\\d{1,3}.\\d{1,3}.\\d{1,3}"));
    // 匹配网址
    String addr = "http://www.baidu.com";
    System.out.println(addr.matches("http://\\w+.\\w+.\\S*"));
    // 匹配年龄
    String age = "18";
    System.out.println(age.matches("\\d{1,3}"));
    // 匹配金额
    String price = "19.8";
    System.out.println(price.matches("\\d+.\\d+"));
  }
}
