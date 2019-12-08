/**
  === 文档注释 ===
  public：关键字（公共的）
  class：关键字（类）
  HelloWorld：自定义的类名
  {}：表示范围，作用域
*/

import java.util.Scanner; // 引入键盘工具类
import java.util.Random; // 生成一个随机数
import java.util.Arrays; // 数组工具类

// 结构定义语句
public class HelloWorld {
  /*
    === 多行注释 ===
    static：关键字（静态的）
    void：关键字（返回值类型，为空，没有返回值）
    main：主函数名称（只能用main）
    main后面的()：表示函数的参数列表
    String[]：表示字符串数组
    args：表示字符串数组的名称
  */
  int a = 10; // 成员变量
  public static void main(String[] args){
    // === 单行注释 ===
    // 想控制台输出一句话 Hello World，这是一条功能执行语句
    // 注意只能用双引号 ""
    // 一个分号;表示一条语句
    int num = 20; // 局部变量
    System.out.println("Hello World!");

    // === 八种基本数据类型 ===

    // 声明变量
    int e;

    // 定义变量
    // 数值类型
    byte b = 10; // 占用1个字节，取值范围：-128~127，默认值：0
    short s = 20; // 占用2个字节，取值范围：-32768~32767，默认值：0
    int i = 30; // 占用4个字节，取值范围：-2147483648~2147483647，默认值：0
    long lon = 40L; // 占用8个字节，取值范围：-9223372036854775808~9223372036854775807，默认值：0
    float f = 10.2F; // 占用4个字节，取值范围：1.4E-45~3.4028235E38，默认值：0.0F
    double d = 10.1231D; // 占用一个字节，取值范围：4.9E-324~1.7976931348623157E308，默认值：0.0D
    // 字符类型
    char c = 'A'; // 占用2个字节，取值范围：0~65535，默认值：'\u0000'（注：要使用单引号）
    char c2 = 97; // 可以使用 ASCII 码给字符变量赋值
    // 布尔类型
    boolean bol = false; // 占用字节不确定，取值：true/false，默认值：false

    // 赋值变量
    b = 20;
    e = 10;

    Scanner input = new Scanner(System.in); // 新建一个键盘输入实例
    // System.out.print("请输入一个整数：");
    // int x1 = input.nextInt(); // 从键盘输入一个整数
    // System.out.println(x1);
    // System.out.print("请输入一个字符串：");
    // String s1 = input.next(); // 从键盘输入一个字符串
    // System.out.println(s1);

    Random r = new Random(); // 创建一个可以生成随机数的工具
    int rNum = r.nextInt(20); // 生成一个20以内的整数

    int a = 1;
    b = 2;
    System.out.println(++a + (b--) + (a - b) + b);
    System.out.println(true|false);

    i = 1;
    a = 1;
    while (i <= 100) {
      a += i++;
    }
    System.out.println(a);

    i = 1;
    a = 1;
    do {
      a += i++;
    } while (i <= 100);
    System.out.println(a);

    i = 1;
    a = 1;
    for (; i <= 100; i += 1) {
      a += i;
    }
    for (; i <= 200;) {
      a += i++;
    }
    System.out.println(a);

    getMenu(5); // 调用（实参是5）

    // System.out.println(getMenu(2)); // 报错
    System.out.println(isRunNian(2017));
    System.out.println(isRunNian(2000));
    isRunNian(2017);

    // ==== 数组赋值方式 ====
    // 第一种
    int[] nums = new int[2];
    nums[0] = 1;
    nums[1] = 2;

    // 第二种
    int[] nums2;
    nums2 = new int[2];

    // 第三种
    int[] nums3 = new int[]{ 4, 5 };

    // 第四种
    int[] nums4 = { 0, 0, 0, 0, 0, 2 };

    // 多维数组（本例是二维数组）
    // int[][] scores = { { 78, 98, 88 }, { 87, 96, 85 }, { 67, 78, 89 } };
    // int classLen = scores.length;
    // for (int i = 0; i < classLen; i++) {
    //   int sum = 0;
    //   int count = scores[i].length;
    //   for (int j = 0; j < count; j++) {
    //     sum += scores[i][j];
    //   }
    //   int avg = sum / count;
    //   System.out.println("第" + (i + 1) + "班的平均成绩是" + avg);
    // }

    // 数组长度
    System.out.println("数组长度：" + nums4.length + nums4[0]);
    System.out.println(nums3);
    System.out.println(Arrays.binarySearch(nums4, 2)); // 查找元素
    System.out.println(Arrays.toString(nums4)); // 转换成字符串
    Arrays.sort(nums4); // 快速排序
    System.out.println(Arrays.toString(nums4)); // 转换成字符串
    int[] nums5 = Arrays.copyOf(nums4, 5); // 复制数组，并指定的长度，不足的用0填充
    System.out.println(Arrays.toString(nums5)); // 转换成字符串
    int[] nums6 = Arrays.copyOfRange(nums4, 1, 3); // 截取数组指定的区间段
    System.out.println(Arrays.toString(nums6)); // 转换成字符串
    int[] nums7 = new int[nums4.length];
    System.arraycopy(nums4, 0, nums7, 0, nums4.length); // 复制数组，效率高于Arrays.copyOf()
    System.out.println(Arrays.toString(nums7)); // 转换成字符串
    System.out.println(Arrays.equals(nums7, nums4)); // 判断两个数组的值是否相等
    Arrays.fill(nums7, 0); // 填充数组
    System.out.println(Arrays.toString(nums7));
    print(nums3);
    print2(8, 9, 10);

    // ==== 数组的遍历 ====
    // 方式一
    int len = nums4.length;
    for (int nums4_i = 0; nums4_i < len; nums4_i++) {
      System.out.println(nums4[nums4_i]);
    }

    // 方式二 (JDK 1.5之后才可用)
    for (int x:nums4) {
      System.out.println(x);
    }
  }

  // ==== 定义一个方法 ====
  // public：访问权限修饰符
  // static：静态修饰符，描述的方法可以直接调用
  // void：返回值（无返回值）
  // getMenu：方法名
  // line：形参
  public static void getMenu(int line) {
    System.out.println("-----菜单-----");
    for (int i = 0; i <= line; i += 1) {
      System.out.println(i);
    }
    return;
    // return "测试"; // 报错
  }

  public static boolean isRunNian(int year) {
    if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
      return true;
    } else {
      return false;
    }
  }

  // 接收数组参数
  public static void print(int[] x) {
    int len = x.length;
    for (int i = 0; i < len; i++) {
      System.out.println(x[i]);
    }
  }

  // 接收可变数组参数（JDK 1.5之后才可用）
  // 可变参数只能是参数列表中最后一个
  public static void print2(int k, int... x) {
    int len = x.length;
    for (int i = 0; i < len; i++) {
      System.out.println(x[i]);
    }
  }

  // ==== 常见数组异常 ====
  // 数组空指针异常(NullPointerException)
  public static void print3(int[] x) {
    // 当一个变量为null时去调用它的一些属性和方法
    System.out.println("数组长度" + x.length);
  }

  // 数组下标越界(ArrayIndexOutOfBoundsException)
  public static void print4(int[] x) {
    for (int i = 0; i <= x.length; i++) {
      System.out.println(x[i]);
    }
  }
}








