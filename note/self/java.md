[TOC]

### Java开发入门

- JDK（Java Development Kit）Java开发工具包，包含了JRE（因为开发后要运行程序）

- JRE（Java Runtime Environment）Java运行环境(在一个沙箱内运行，所以不会影响系统，也不会用来开发病毒)

- 下载链接：<http://www.oracle.com/technetwork/java/archive-139210.html>

  ![](https://img-blog.csdn.net/20160614105103329?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQv/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/Center)

- Java分类：
  - Java SE：Java Platform，Standard Edition 
  标准版：各应用平台的基础，桌面开发和低端商务应用的解决方案。
  - Java EE：Java Platform，Enterprise Edition 
  企业版：以企业为环境而开发应用程序的解决方案
  - Java ME ：Java Platform, Micro Edition 
  微型版：致力于消费产品 和嵌入式设备的最佳解决方案
  
- 环境变量：
  - PATH：用于指定操作系统的可执行指令的路径  (如path：C:\Program Files\Java\jdk1.8.0_77\bin;…..)
  - CLASSPATH：Java 虚拟机在运行某个类时会按 classpath 指定的目录顺序去查找这个类 
  **注：** 从JDK 5.0 开始默认就会到当前工作目录以及JDK 的lib 目录中查找 
	windows: 在桌面右击“我的电脑”－“属性”－“高级系统设置”－“环境变量” 
	mac: 在 ~/.bash_profile 中配置
	
- Java步骤：
  1. 新建 .java 文件
  2. javac (编译命令)：把 .java 文件编译成 .class 的字节码文件
  3. java(执行命令)：运行 .class 文件
  
  ![](http://dl.iteye.com/upload/attachment/364841/7dbc84af-e878-3718-beb5-6471ad99b995.gif)
  
- 注释

  1. 单行注释 //
  2. 多行注释 /* … */
  3. 文档注释 /** … */

- 反编译工具

  - JD-GUI (Mac / Windows)

    - [下载JD-GUI]([http://java-decompiler.github.io/#jd-gui-download](http://java-decompiler.github.io/#jd-gui-download))
    - 解压 -> 点击打开 JD-GUI程序文件(app或exe)
    - 选择需要反编译的 class文 件

  - Cavaj Java Decompiler (Windows)

    [下载](http://cavaj-java-decompiler.en.softonic.com/)

- 用 javadoc 命令可以构建结构文档

- java 跨平台原理是因为 .class 文件可以通过不同系统的 jre（JVM，Java虚拟机） 运行环境编译成不同的机器代码。

- 编写代码时除了 lang 包下面的类不用引入，其他的包都需要引入才能使用。

### Java基础

#### 工作空间

**切换工作空间时，一般需要修改一下一些基本配置**(eclipse)

1. 打开配置 preferences
2. 搜索 font ，修改 General 下的  basic 下的 text font
3. 搜索 encoding，修改 General -> Workspace下的编码
4. 搜索 assist，修改 Java -> Editor -> Content Assist 下的提示
   - 50毫秒
   - .abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ(@,
5. 搜索 Formatter，在右侧点击 New... 按钮来新建一个属性，随便写一个 Profile name，如 ldf，Initialize settings with the following profile 选择 Eclipse [built-in] 就好，然后点击OK；再点击“Edit…”按钮；在 Indentation 选项卡中的 General settings 中的 Tab policy 选择 Spaces only，ndentation size 的值输入 2；再点击 OK 即可。

#### 变量与标识符

##### 变量分类
1. 按数据类型分：
  - 基本数据类型（8种）
  - 引用数据类型
2. 按被声明的位置分：
  - 局部变量：方法或语句块内部定义的变量
  - 成员变量：方法外部、类的内部定义的变量 

##### 标识符(变量)命名规则
- 由字母、数字、下划线（_）和美元符号（$）组成。
- 不能以数字开头。
- 区分大小写。
- 长度无限制。
- 不能是Java中的关键字和保留关键字。 
- 标识符命名习惯：驼峰命名法、见名知意。以单词或单词组合来命名

#### 八种基本数据类型
**注：**  

- 字节(Byte)是文件大小的基本单位，位(bit)二进制最小的基本单位
- 布尔值默认是 false，其他其他数据默认类型是 0 或 0.0
- 长整型、单精度、双精度一般会在数字后面添加 L/l、F/f、D/d 最为后缀来区分，但是不写后缀也是可以
- 八进制使用0开头，如0123；十六进制使用0x/0X开头，如0x123
- [补码](https://www.zhihu.com/question/20159860)：负数使用其绝对值的反码加1表示
- 二进制数转换成十进制数：1011.01 = 1×2^3＋0×2^2＋1×2^1＋1×2^0＋0×2^-1＋1×2^-2 = 11.25
- 十进制转换成二进制：89.625 = 1011001.101
整数部分：除2取余，逆序排列 
小数部分：乘2取整，顺序排列

数据类型 | 关键字 | 占用字节 | 取值范围 | 默认值  
:-- | :-- | :-- | :-- | :--   
布尔型 | boolean | 不定值 | true,false | false  
字节型 | byte | 1 | -128~127 | 0   
短整型 | short | 2 | -32768~32767 | 0   
整型 | int | 4 | -2147483648~2147483647 | 0   
长整型 | long | 8 | -9223372036854775808~9223372036854775807 | 0  
字符型 | char | 2 | 0~65535 | ‘\u0000’   
单精度浮点型 | float | 4 | 1.4E-45~3.4028235E38 | 0.0F   
双精度浮点型 | double | 8 | 4.9E-324~1.7976931348623157E308 | 0.0D

##### 类型转换

自动类型转换：

- 容量小的类型自动转换成容量大的数据类型
- byte,short,int，它们三者在计算时会转换成int类型（**注：**+=、-=等复合运算符运算时不会转）
- 如果把int值转换为float值，或者long转换为double值，不需要强制转换，但可能丢失精度.

强制类型转换：

- 容量大的类型转换成容量小的数据类型时，要加上强制转换符。如：`byte n = 10; i = (byte)(n + 10);`
- 有可能造成精度降低或数据溢出，使用时要小心。
- boolean 类型不能转换成任何其它数据类型。

#### 包装类

**Number**：Integer、Short、Long、Double、Float、Byte 都是 Number 的子类，表示是一个数字。

**Object**：Character、Boolean 都是 Object 的直接子类。

| 基本数据类型 | 包装类    |
| ------------ | --------- |
| int          | Integer   |
| char         | Character |
| float        | Float     |
| double       | Double    |
| boolean      | Boolean   |
| byte         | Byte      |
| short        | Short     |
| long         | Long      |

##### 装箱/拆箱操作

将一个基本数据类型转换为包装类的操作称为装箱操作。将一个包装类转换为一个基本数据类型的操作称为拆箱操作。

| 方法          | 描述                |
| ------------- | ------------------- |
| byteValue()   | Byte  —>   byte     |
| doubleValue() | Double  —>   double |
| floatValue()  | Float  —>  float    |
| intValue()    | Integer —>   int    |
| longValue()   | Long  —>   long     |
| shortValue()  | Short  —>   short   |

##### 转型操作

1. 将一个字符串变为指定的基本数据类型
2. **转型操作时，字符串必须由数字组成，否则会出现错误**

##### 享元模式（Flyweight Pattern）

它使用共享对象，用来尽可能减少内存使用量以及分享资讯给尽可能多的相似对象；它适合用于当大量对象只是重复因而导致无法令人接受的使用大量内存。通常对象中的部分状态是可以分享。常见做法是把它们放在外部数据结构，当需要使用时再将它们传递给享元

**注：Integer 会缓存 -128~127 的数据，在静态内部类 private static class IntegerCache 中**，示例如下：

```java
public class Test16{
	public static void main(String[] args){
		// 装箱操作，把基本数据类型转换为包装类
		Integer i1 = new Integer(10);
		// 拆箱操作，把包装类转换为基本数据类型
		int i2 = i1.intValue();
		Integer i3 = 10; // 建议方式
		Integer i4 = new Integer("123");
		// 把数值字符串转换为int类型
		String num1 = "12";
		int i5 = Integer.parseInt(num1);
		int i6 = Integer.valueOf(num1);
    
		// 面试题
		Integer x1 = new Integer(127);
		Integer x2 = new Integer(127);
		System.out.println(x1 == x2);  // flase
		System.out.println(x1.equals(x2)); // true

		Integer x3 = new Integer(128);
		Integer x4 = new Integer(128);
		System.out.println(x3 == x4); // flase
		System.out.println(x3.equals(x4)); //true

		Integer x5 = 127;
		Integer x6 = 127;
		System.out.println(x5 == x6); // true
		System.out.println(x5.equals(x6)); // true

		Integer x7 = 128;
		Integer x8 = 128;
		System.out.println(x7 == x8); // false(因为 Integer 的享元模式)
		System.out.println(x7.equals(x8)); // true
	}
}
```

#### 数字处理类

##### BigInteger类

可以让超过 Integer 范围内的数据进行运算

**注：**除法运算时，返回 BigInteger 类型的整数，商的小数部分会舍弃

##### BigDecimal类

由于在运算的时候，float 类型和 double 很容易丢失精度，为了能精确的表示、计算浮点数，Java提供了 BigDecimal，不可变的、任意精度的有符号十进制数

**注：**除法运算时，其值为`(this / divisor)` ，优先级为`(this.scale() - divisor.scale())` ; 如果不能表示确切的商（因为它具有非终止的十进制扩展，也就是说**除不尽**），则抛出一个`ArithmeticException` (算法异常)

##### DecimalFormat类

可以用最快的速度将数字格式化为你需要的样子

![](https://upload-images.jianshu.io/upload_images/5097954-e10ec3820f84208c.png)

```java
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.util.Arrays;
public class Test {
	public static void main(String[] args) {
		// BigInteger 大整数运算
		BigInteger b1 = new BigInteger("84567890986544567");
		BigInteger b2 = new BigInteger("45097659985495567");
		System.out.println(b1.add(b2)); // 加法
		System.out.println(b1.subtract(b2)); // 减法
		System.out.println(b1.multiply(b2)); // 乘法
		System.out.println(b1.divide(b2)); // 除法
		System.out.println(b1.remainder(b2)); // 求余
    // 求商和求余，返回一个数组 [1, 39470231001049000]
		System.out.println(Arrays.toString(b1.divideAndRemainder(b2)));
    
		// BigDecimal 大浮点数运算
		BigDecimal b3 = new BigDecimal("5696.698494847898754789");
		BigDecimal b4 = new BigDecimal("6");
		System.out.println(b3.add(b4)); // 加法
		System.out.println(b3.subtract(b4)); // 减法
		System.out.println(b3.multiply(b4)); // 乘法
		System.out.println(b3.divide(b4)); // 除法
		// System.out.println(b3.scale()); // 返回数值的小数位数
    
		// DecimalFormat 数字格式化
		double pi=3.1415927; // 圆周率
		// 取一位整数，结果：3
		System.out.println(new DecimalFormat("0").format(pi));
		// 取一位整数和两位小数，结果3.14
		System.out.println(new DecimalFormat("0.00").format(pi));
		// 取两位整数和三位小数，整数不足部分以0填补，结果：03.142
		System.out.println(new DecimalFormat("00.000").format(pi));
		// 取所有整数部分，结果：3
		System.out.println(new DecimalFormat("###").format(pi));
		// 以百分比方式计数，并取两位小数，结果：314.16%
		System.out.println(new DecimalFormat("#.##%").format(pi));
		// 以千分比分比方式计数，并取两位小数，结果：3141.59‰
		System.out.println(new DecimalFormat("#.##\u2030").format(pi));
		// 插入货币符号，并取两位小数，结果：￥3.14
		System.out.println(new DecimalFormat("\u00A4#.##").format(pi));
		long c = 299792458L; // 光速
		// 显示为科学计数法，并取五位小数
		System.out.println(new DecimalFormat("#.#####E0").format(c)); // 2.99792E8
		// 显示为两位整数的科学计数法，并取四位小数
		System.out.println(new DecimalFormat("00.####E0").format(c)); // 29.9792E7
	  // 每三位以逗号进行分隔。
		System.out.println(new DecimalFormat(",###").format(c)); // 299,792,458
		// 将格式嵌入文本
		System.out.println(new DecimalFormat("光速每秒,###米").format(c)); // 光速每秒299,792,458米
	}
}
```



#### 转义字符

\n：换行，\r：回车，\t：tab制表符，\\\\：反斜杠，\"：双引号，\'：单引号

#### 运算符

##### 算数运算符
-  从左往右运算   
- +、-、×、/、%、++、--

##### 赋值运算符
- 从右往左运算  
- =、+=、-=、×=、/=、%=、&=、|=、^=、~=、<<=、>>=、>>>=

##### 关系运算符
- ==、!=、>、<、>=、<=

##### 逻辑运算符

运算符 | 描述 | 示例 | 结果  
:-- | :-- | :-- | :--  
& | 与 | false & true | false  
\| | 或 | false \| true | true  
^ | 异或 | true ^ false | true  
! | 非 | ! true | false  
&& | 短路与 | false && true | false  
\|\| | 短路或 | false \|\| true | true 

&与&&区别： 

- &：在逻辑运算时分别计算&两边表达式的结果后再做&运算，在做位运算时&表示按位与(所有表达式都会执行一遍)
- &&: 先计算左边的表达式，如果为false，则不会计算后面的表达式，直接返回false；如果左边表达式结果为true，则还要计算右边的表达式（短路与）。
- |与||的区别和上面的类似。

##### 位运算符

- ~：按位取反  
- &：按位与
- |：按位或
- ^：按位异或 

##### 位移运算符（运算速度最快）

- 左移："a<<b; "将二进制形式的a逐位左移b位，最低位空出的b位补0
- 带符号右移："a>>b; "将二进制形式的a逐位右移b位，最高位空出的b位补原来的符号位
- 无符号右移："a>>>b;"将二进制形式的a逐位右移b位，最高位空出的b位补0

##### 三目运算符

- bool ? a : b

##### 运算符优先级

| 优先级 | 运算符                                       | 结合性   |
| ------ | -------------------------------------------- | -------- |
| 1      | () [] .                                      | 从左到右 |
| 2      | ! +(正)  -(负) ~ ++ —                        | 从右向左 |
| 3      | * / %                                        | 从左向右 |
| 4      | +(加) -(减)                                  | 从左向右 |
| 5      | << >> >>>                                    | 从左向右 |
| 6      | < <= > >= instanceof                         | 从左向右 |
| 7      | ==   !=                                      | 从左向右 |
| 8      | &(按位与)                                    | 从左向右 |
| 9      | ^                                            | 从左向右 |
| 10     | \|                                           | 从左向右 |
| 11     | &&                                           | 从左向右 |
| 12     | \|\|                                         | 从左向右 |
| 13     | ?:                                           | 从右向左 |
| 14     | = += -= *= /= %= &= \|= ^=  ~=  <<= >>= >>>= | 从右向左 |

#### 输入类

```java
import java.util.Scanner; //接收键盘输入的工具类

Scanner input = new Scanner(System.in); // 新建一个输入类实例
// 从键盘接收一个整数(将输入的下一个标记扫描为int )
int x1 = input.nextInt();
/* next()
	 1、一定要读取到有效字符后才可以结束输入，
	 2、对输入有效字符之前遇到的空白，next()方法会自动将其去掉，
	 3、只有输入有效字符后才将其后面输入的空白作为分隔符或者结束符。
	 所以，next()不能得到带有空格的字符串
*/
String s1 = input.next();
/* nextLine()
	 1、以Enter为结束符,也就是说nextLine()方法返回的是输入回车之前的所有字符。
	 2、可以获得空白。
*/
String s1 = input.nextLine();
```

#### 随机数类

```java
import java.util.Random;

Random r = new Random(); // 生成随机数的实例
int i = r.nextInt(16); // 获取16范围内的随机整数
```

#### 语句

##### if条件语句
```java
if (bol1) {
  // ...
} else if (bol2) {
  // ...
} else {
  // ...
}
```
**注：**在实现分支判断时，尽量把匹配成功率高的判断放在前面，可以提高效率

##### switch语句

- 表达式的返回值必须是下述6种类型之一：**char,byte, short,int（包括包装类Character、Byte、Short、Integer ）,枚举**，jdk1.7后支持**String**；

- case子句中的取值必须是常量，且所有case子句中的取值应是不同的；

- default子句是可选的；

- break语句用来在执行完一个case分支后使程序跳出switch语句块；如果case后面没有写break则直接往下面执行！

- case后面的执行体可写{ }也可以不写{ }

- Java 7 switch支持String的实现原理

  > 这个新特性是在编译器这个层次上实现的。而在Java虚拟机和字节码这个层次上还是只支持在switch语句中使用与整数类型兼容的类型。这么做的目的就是为了减少这个特性所影响的范围，以降低实现的代价。在编译器层次实现的含义是，虽然开发人员在Java源代码的switch语句中使用了字符串类型，但是在编译的过程中，编译器会根据源代码的含义进行转换，将字符串类型转换成与整数类型兼容的格式。不同的Java编译器可能采用不同的方式来转换，并采用不同的优化策略。比如：如果switch语句中只包含一个case语句，那么就可以简单的将其转换成一个if语句。如果包含一个case和一个default语句，就可以转换成if-else语句。而对于复杂的情况（多个case语句），也可以转换成Java 7 之前的switch语句，只不过使用字符串的哈希值作为switch语句表达式的值。经过转换，Java 虚拟机看到的仍然是与整数类型兼容的类型。这里要注意的是，在case字句中对应的语句块中仍然需要使用String的equals方法来进行字符串比较，这是因为哈希函数在映射的时候可能存在冲突，这样更加保险了。

```java
switch (表达式) {
  case a1:
  int i = 10;
  // ...
  break;
  case a2: {
    // ...
    break;
  }
  case a3:
  i = 20; // i的作用域在switch的大括号里
  // ...
  default:
  // ...
}
```
#### 循环语句
##### while循环
```java
while (bool) {
  // ...
}
```
##### do-while循环
```java
do {
  // ...
} while (bool);
```
##### for循环
```java
for (初始化参数; 判断条件; 更新循环变量) {
  // 循环体;
}
```

#### 打印
- print：打印输出，但不换行
- println：打印输出，且要换行

### 方法

#### 方法的格式

- 实参和形参的类型要相互兼容，且实参的取值范围要小于或者等于形参类型的取值范围。
- 若当前方法没有返回值类型，即返回值类型是 void，那么当前方法中可以不写 return，也可以写 return; 。
- return 即表示结束一个方法，也可以将返回值返回给调用当前方法的调用者
- return 返回值时一次只能返回一个值，不可以返回多个值
- 一个方法中可以有多个return，但被执行的只能有一个，所以需要判断

```java
/**
访问权限修饰符 [其他的修饰符 如static] 返回值类型 方法名(参数类型1 形参1,参数类型2 形参2,...){ //形参列表
  //方法体
  return 返回值;
}
*/

  // ==== 调用方法 ====
  getMenu(5); // 实参是5

  // ==== 定义一个方法 ====
  // public：访问权限修饰符
  // static：静态修饰符，描述的方法可以直接调用
  // void：返回值类型（boolean等八种数据类型，无返回值为void）
  // getMenu：方法名
  // line：形参
  public static void getMenu(int line){
    System.out.println("-----菜单-----");
    for (int i = 0; i <= line; i += 1) {
      System.out.println(i);
    }
  }

  public static boolean isRunNian(int year) {
    if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
      return true;
    } else {
      return false;
    }
  }
```
#### 方法的重载(overloading)

**定义：** 在同一个类中可以创建多个方法，它们具有相同的名字，但具有不同的参数和不同的定义**（返回值不能作为重载的条件）**

```java
public void method(int a) {
  // ...
}
public void method(char c) {
  // ...
}
```

#### 方法的重写(overriding)

1. 发生在子父类中，方法重写的两个方法 **返回值、方法名、参数列表** 必须完全一致（子类重写父类的方法）
2. 子类抛出的异常不能超过父类相应方法抛出的异常**（子类异常不能大于父类异常）**
3. 子类方法的访问级别不能低于父类相应方法的访问级别**(子类访问级别不能低于父类访问级别)**
4. 父类中的方法若使用 **private、static、final** 任意修饰符修饰，那么不能被子类重写。

#### main方法

main方法参数在执行java命令时传递：`java Test1 "字符串1" "字符串2"`

### 数组

- 数组是引用数据类型，是在栈内存里存放堆数据的地址；而八种基本数据类型的数据是直接存放在栈内存里的。

#### 数组（包括多维数组）的赋值方式（4种）

1. 使用默认的初始值来初始化数组中的每一个元素  
  **语法：** 数组元素类型 [] 数组名 = new 数组元素类型[数组中元素的个数（数组的长度）];  

  ```java
  int[] scores = new int[3];
  ```

2. 先声明，然后再赋予默认的初始值。  
  **语法：** 数组元素类型 [] 数组名;  
      数组名= new 数组元素类型[数组中元素的个数（数组的长度）];  

  ```java
  int[] scores;
  scores = new int[3];
  ```

3. 先声明，然后再使用指定的值进行初始化。  
  **语法：** 数组元素类型 [] 数组名 = new 数组元素类型[]{元素1，元素2,....};  

  ```java
  int[] scores = new int[]{ 56, 78, 98 };
  ```

4. 将第三种写法可以简化为（使用数组常量值给数组进行赋值）  
  **语法：** 数组元素类型 [] 数组名 = {元素1，元素2,....};  

   ```java
  int[] scores =  { 56, 78, 98 };
   ```

```java

    // ==== 数组赋值方式 ====
    // 第一种
    int[] nums = new int[2];
    nums[0] = 1;
    nums[1] = 2;

    // 第二种
    int[] nums2;
    nums2 = new int[2];

    // 第三种
    int[] nums3 = new int[]{ 1, 2 };

    // 第四种
    int[] nums4 = { 1, 2 };

    // 数组长度
    System.out.println("数组长度：" + nums4.length + nums4[0]);
    
     // 多维数组（本例是二维数组）
    int[][] scores = { { 78, 98, 88 }, { 87, 96, 85 }, { 67, 78, 89 } };
    int classLen = scores.length;
    for (int i = 0; i < classLen; i++) {
      int sum = 0;
      int count = scores[i].length;
      for (int j = 0; j < count; j++) {
        sum += scores[i][j];
      }
      int avg = sum / count;
      System.out.println("第" + (i + 1) + "班的平均成绩是" + avg);
    }

```

#### 数组的遍历

```java
    // 方式一
    int len = nums4.length;
    for (int nums4_i = 0; nums4_i < len; nums4_i++) {
      System.out.println(nums4[nums4_i]);
    }

    // 方式二 (forearch循环，JDK 1.5之后才可用)
    for (int x:nums4) {
      System.out.println(x);
    }
    
    print(nums4); // 1, 2
    print2(3, 4, 5); // 4, 5
    
  // 接收数组参数
  public static void print(int[] x) {
    int len = x.length;
    for (int i = 0; i < len; i++) {
      System.out.println(x[i]);
    }
  }

  // 接收可变数组参数（JDK 1.5之后才可用）
  // 可变参数只能是参数列表中最后一个(会出去前面的参数，如下面的k)
  public static void print2(int k, int... x) {
    int len = x.length;
    for (int i = 0; i < len; i++) {
      System.out.println(x[i]);
    }
  }
```

#### 常见数组异常

```java
  // 数组空指针异常(NullPointerException)
  public static void print3(int[] x) {
    System.out.println("数组长度" + x.length); // 当一个变量为null时去调用它的一些属性和方法
  }

  // 数组下标越界(ArrayIndexOutOfBoundsException)
  public static void print4(int[] x) {
    for (int i = 0; i <= x.length; i++) {
      System.out.println(x[i]);
    }
  }
```

#### 常用算法

- 冒泡排序法：  
  

比较相邻的元素。如果第一个比第二个大，就交换他们两个。对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对。在这一点，最后的元素应该会是最大的数。针对所有的元素重复以上的步骤，除了最后一个。这是一个稳定排序法。

- 选择排序算法：  
  

每一趟从待排序的数据元素中选出最小（或最大）的一个元素（记住该元素的索引），然后交换该元素和所找元素中最前面的元素的值。重复以上步骤，除了最前面一个。这个是不稳定的排序法。

- 插入排序法：
  选择排序算法
每一趟从待排序的数据元素中选出最小（或最大）的一个元素，顺序放在已排好序的数列的最后，直到全部待排序的数据元素排完。 选择排序是不稳定的排序方法。

- 二分查找法：  
  
  前提是在已经排好序的数组中，通过将待查找的元素与中间索引值对应的元素进行比较，若大于中间索引值对应的元素，去右半部分查找，否则，去左半部分查找。依此类推。直到找到为止；找不到返回一个负数。

#### Arrays工具类的使用

```java
import java.util.Arrays;

int[] num2 = {45,65,76,87,98,901};
// 转化成字符串
String s = Arrays.toString(num2);
// 二分查找
int index = Arrays.binarySearch(num2,98);
// 快速排序
Arrays.sort(num2);
// 数组的复制
Arrays.copyOf(num2,10);
// 使用 arraycopy 复制
int[] newNum = new int[num2.length];
System.arraycopy(num2,0,newNum,0,num2.length);
// 判断两个数组的值是否相等
boolean b = Arrays.equals(num2,newNum);
// 填充数组
Arrays.fill(newNum,0); 
```

**注：**数组复制的效率由高到低排序为：System.arraycopy  >  Arrays.copyOf  >  for

### 类与对象

定义一个 **类：**  

1. 除了 byte、int、short、long、boolean、char、float 和 double 等八种基本数据类型外，其他的都是引用数据类型。
2. new关键字：表示向内存申请空间，也表示实例化一个对象，创建一个对象。
3. 一个对象在内存中的大小，由该对象的所有属性所占的内存大小的总和。引用类型变量在32位系统上占4个字节，在64位系统上占8个字节。加上而外的对象隐性数据所占的大小。
4. 相同的类型才可以赋值
5. 不同的引用，指向同一个对象，任何一个引用改变对象的值，其它引用都会反映出来。
6. **编程时要注意的问题，在确定不使用对象时，要尽早释放对象：引用=null**
7. 当一个堆中的对象没有被任何引用变量所指向时，该对象会被JVM 的 GC 程序认为是垃圾对象，从而被回收。
8. 通常在一个类中，属性都私有化（使用private关键字），并对外暴露 getter 和 setter 方法。


```java
class 类名称{
	属性名称;
	返回值类型 方法名称(){}
}
```

定义一个 **对象：**
一个类要想真正的进行操作，则必须依靠对象，对象的定义格式如下：

```java
// new 关键字表示实例化一个对象，并申请内存空间
类名称 对象名称 = new 类名称();

// 访问
对象.属性;
对象.方法();

```

#### 成员变量与局部变量

1. 在类中的位置不同 
	成员变量：在类中定义 
	局部变量：在方法中定义或者方法的参数  
2. 在内存中的位置不同 
	成员变量：在堆内存(成员变量属于对象，对象进堆内存， **static 变量进入静态方法区**) 
	局部变量：在栈内存(局部变量属于方法，方法进栈内存)  
3. 生命周期不同 
	成员变量：随着对象的创建而存在，随着对象的销毁而消失**(非 static 变量)**
	局部变量：随着方法的调用而存在，随着方法的调用完毕而消失  
4. 初始化值不同 
	成员变量：有默认初始化值，引用类型默认为null 
	局部变量：没有默认初始化值，必须定义，赋值，然后才能使用  

**注意：**  局部变量名称可以和成员变量名称一样，在方法中使用的时候，采用的是就近原则。

#### static 关键字的作用：

1. 静态变量或方法不依赖对象实例，而是依赖该类**(可以直接用类名去获取或者调用)**
2. 使用 static关键字修饰一个属性
   - 声明为static的变量实质上就是全局变量**(生命周期从类被加载后一直到程序结束)**
   - 静态变量只有存一份，在 **静态方法区** 中存储，是本类所有对象共享一份
   - **建议不要使用对象名去调用静态数据，直接使用类名调用**
3. 使用 static 关键字修饰一个方法
   - 静态方法不能访问非静态属性和方法（如 this 和 super 不可用使用），只能访问静态属性和方法。
4. 使用static关键字修饰一个类（内部类）
5. 静态方法区：存储 **静态变量** 和 **类信息(方法)**

![](https://upload-images.jianshu.io/upload_images/5097954-2c10b966f7f93280.png)

#### 权限关键字

访问级别：public  >  protected  >  default  >  private

| 作用域        | 当前类 | 同一包内(子类/非子类) | 子孙类 | 其他包 |
| ------------- | ------ | --------------------- | ------ | ------ |
| public        | √      | √                     | √      | √      |
| protected     | √      | √                     | √      | ×      |
| default(默认) | √      | √                     | ×      | ×      |
| private       | √      | ×                     | ×      | ×      |

#### 构造方法

1. 构造方法名称与类名相同，没有返回值声明（包括 void）

2. 构造方法用于初始化数据（属性）

3. 每一个类中都会有一个默认的无参的构造方法

4. **如果类中有显示的构造方法，那么默认构造方法将无效, 如果有显示的构造方法，还想保留默认构造 方法，需要显示的写出来。**

5. 构造方法可以有多个，但参数不一样，称为构造方法的重载

6. **在构造方法中调用另一个构造方法，使用this(…)，该句代码必须在第一句。且构造方法之间的调用，必须要有出口**。

7. 给对象初始化数据可以使用构造方法或setter方法，通常情况下，两者都会保留。

8. 一个好的编程习惯是要保留默认的构造方法。（为了方便一些框架代码使用反射来创建对象）

9. **private Dog(){}，构造方法私有化，当我们的需求是为了 保正该类只有一个对象时**。什么时候一个类只需要一个对象？比如，工具类（没有属性的类，只有行为）并且该工具对象被频繁使用。权衡只用一个对象与产生多个对象的内存使用，来确定该类是否要定义为只需要一个对象。

#### this

1. 调用类中的属性

2. 调用类中的方法或构造方法

3. 表示当前对象

```java
class Cat{
	private String name;
	private int age;
	public String Cat(){}
	public String Cat(String name){
    // 局部变量名称可以和成员变量名称一样，在方法中使用的时候，采用的是就近原则
		this.name = name;
	}
	public void Cat(String name, int age){
    // 在构造方法中调用另一个构造方法，使用this(…)，该句代码必须在第一句
    this(name);
		this.setAge(age);
	}
	public void setName(String name){
    // this代表的是当前类的实例
		this.name = name;
	}
	public String getName(){
		return name;
	}
	public void setAge(int age){
		this.age = age;
	}
	public int getAge(){
		return age;
	}
	public void eat(){
		//在方法中使用this调用类中的其它方法或属性，this可以省略,this前面可以使用当前的类名.this
		System.out.println("我是" + Cat.this.getName() + ",我爱吃鱼");
		// System.out.println("我是" + getName() + ",我爱吃鱼");
	}
}
```



#### 代码块

1. 普通代码块

   在方法中写的代码块

2. 构造块

   是在类中定义的代码块，在创建对象时被调用，优于构造方法执行

3. 静态代码块

   在类中使用static声明的代码块称为静态代码块，在第一次使用的时候被调用（创建对象），**只会执行一次**，优于构造块执行，我们在项目开发中，通常会使用静态代码块来初始化只调用一次的数据

4. 同步代码块 (使用 **synchronized** 关键字)

**执行顺序：**静态代码块  >  构造块  >  构造方法

**注：重点会使用的顺序是静态代码块，普通代码块，同步代码块，构造代码块**

```java
public class Test7{
	public static void main(String[] args){
		Student s = new Student();
		Student s1 = new Student();
	}
}
class Student{
  private int ticket = 10;
	static{
		System.out.println("我是静态代码块");
	}
	public Student(){
		System.out.println("构造方法");
	}
	{
		System.out.println("我是构造代码块");
	}
	public void study(){
		//限制作用域
		{
			int i = 10;
			System.out.println("我是普通代码块");
		}
	}
  public void run() {
  	for (int i = 0; i < 300; i++) {
      synchronized (this) {
        System.out.println("我是同步代码块");
        if (ticket > 0) {
          try {
            Thread.sleep(1000);
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
      }
      method();
    }
	}
}
```



#### 单例设计模式

**满足要求：**

1. 构造方法私有化
2. 声明一个本类对象
3. 给外部提供一个静态方法获取对象实例

**用途：**

1. 在设计一些工具类的时候(通常工具类，只有功能方法，没有属性)
2. 工具类可能会被频繁调用

**方式：**

- 懒汉式

  在第一次调用getInstance方法时，对象被创建，到程序结束后释放

- 饿汉式

  在类被加载后，对象被创建，到程序结束后释放

**注：使用单例比使用构造方法私有化+ 静态方法 更节省内存。**

**示例：**

```java
public class Test8{
	public static void main(String[] args){
		Singleton1 s1 = new Singleton1();
		Singleton2 s2 = Singleton2.getInstance();
		s2.print();
		Singleton2 s3 = Singleton2.getInstance();
		s3.print();
		System.out.println(s2 == s3);
	}
}

// 方式一 使用构造方法私有化+ 静态方法 来实现工具类，比如Math
class Tools{
	private Tools(){};
	public static void print1(){
	}
	public static void print2(){
	}
}

// 方式二 饿汉式: 占用内存的时间长，提高效率(类加载时就创建实例对象)
class Singleton1{
	private Singleton1(){}
	private static Singleton1 s = new Singleton1();
	public static Singleton1 getInstance(){
		return s;
	}
	public void print(){
		System.out.println("测试方法");
	}
}

// 方式三 懒汉式(懒加载,延迟加载): 占用内存的时间短，效率低(第一次创建实例时才创建该单例对象)
// 在多线程访问时会有安全问题
class Singleton2{
	private Singleton2(){};
	private static Singleton2 s;
	public static Singleton2 getInstance(){
		if(s==null){
			s = new Singleton2();
		}
		return s;
	}
	public void print(){
		System.out.println("测试方法2");
	}
}
// 方式四 使用同步
import java.io.Serializable;
/**
 * 1、多线程访问的安全问题
 * 2、加上 volatile 关键字保证变量的一致性
 * 3、防止反射调用私有构造方法
 * 4、让单例类可以被序列化
 */
public class Singleton implements Serializable {
  private volatile static Singleton singleton = null;
  private Singleton() {
    if (singleton != null) {
      throw new RuntimeException("此类对象为单例模式，已经被实例化了");
    }
  }
  public static Singleton getInstance() {
    if (singleton == null) {
      synchronized (Singleton.class) {
        if (singleton == null) {
          singleton = new Singleton();
        }
      }
    }
    return singleton;
  }
}
```

####volatile 关键字

volatile 提醒编译器它后面所定义的变量随时都有可能改变，因此编译后的程序每次需要存储或读取这个变量的时候，都会直接从变量地址中读取数据。如果没有 volatile 关键字，则编译器可能优化读取和存储，可能暂时使用寄存器中的值，如果这个变量由别的程序更新了的话，将出现不一致的现象。

### 继承

#### 要点

1. 被继承的类称为父类（超类），继承父类的类称为子类（派生类）
2. 继承使用关键字extends
3. Java只能实现单继承，也就是一个类只能有一个父类
4. 允许多层继承，即一个子类可以有一个父类，一个父类还可以有其他的父类。
5. 继承只能继承非私有的属性和方法。
6. 构造方法不能被继承
7. 创建对象会调用构造方法，调用构造方法不一定就是创建对象
8. 在子类进行实例化操作的时候，首先会先让其父类进行初始化操作。之后子类再自己进行实例化操作。
9. 实例化子类对象，会先调用父类的构造方法，如果父类中没有默认的构造方法，那么子类必须显示的通过super(...)来调用父类的带参构造方法，super也只能在子类构造方法中的第一句。

#### super

1. 使用super调用父类中的属性，可以从 **父类实例** 处获得信息。
2. 使用super调用父类中的方法，可以委托 **父类实例** 帮助完成某件事情。
3. 使用super调用父类中的构造方法（super(实参)），必须在子类构造方法的第一条语句，调用父类中相应的构造方法，若不显示的写出来，默认调用父类的无参构造方法，比如：super();

#### final

1. 使用final关键字声明一个常量

   修饰属性或者修饰局部变量为 **常量**，也称为最终变量，一次定义，不能再更改。

   常量会在类加载的时候进入常量池，方法弹栈后常量池中常量还在，可以继续使用。

2. 使用final关键字声明一个方法

   该方法为最终方法，且只能被子类继承，但是不能被子类重写。

3. 使用final关键字声明一个类

   该类就转变为最终类，不能被继承，所以该类没有子类(一般用于常量工具类)

4. 在方法参数中使用final，在该方法内部不能修改参数的值

#### 抽象类

1. 抽象类使用 **abstract** 关键字声明
2. 抽象类可以没有抽象方法，有抽象方法的类必须是抽象类
3. 非抽象类继承抽象类必须实现所有抽象方法
4. 抽象类可以继承抽象类，可以不实现父类抽象方法
5. 抽象类可以有方法实现和属性
6. 抽象类不能被实例化
7. 抽象类不能声明为final
8. 抽象类可以有构造方法

```java
abstract class Animal{
	public abstract void move(); // 方法的声明，抽象方法只有声明，没有实现(需要子类去实现)
}
```

#### 接口

1. 定义一个接口，使用 **interface** 关键字
2. 在一个接口中，只能定义常量、抽象方法，**JDK1.8后可以定义默认的实现方法**
3. **接口可以继承多个接口：extends xxx,xxx**
4. 一个具体类实现接口使用 **implements** 关键字
5. 一个类可以实现多个接口
6. 抽象类实现接口可以不实现接口的方法
7. **在接口中定义的方法没有声明访问修饰符，默认为 public abstract** 
8. **在接口中定义的属性没有声明访问修饰符，默认为 public static final** 
9. 接口不能有构造方法
10. 接口不能被实例化

```java

interface IEat{
  // 接口中只能定义抽象方法
  // 接口中定义的方法没有声明修饰符，默认为 public abstract
  void eat(); // 等价于 public abstract void eat();
  // 接口中定义的属性(常量)没有声明修饰符，默认为 public static final
  int NUM = 10; // 等价于 public static final int NUM = 10;
  // 在JDK1.8后新特性，可以被所有实现类继承
  public default void print(){
    System.out.println("eat");
  }
}

interface IRun{
  void run();
}
// 接口之间可以多继承（但是：类是只能单继承）
interface ISleep extends IEat,IRun{
  void sleep();
}

// 具体类实现接口必须实现接口的所有方法
class Girl implements ISleep,IEat{
  private String name;
  public Girl(String name){
    this.name = name;
  }
  public Girl(){}
  public void sleep(){
    System.out.println("我爱睡觉");
  }
  public void eat(){
    System.out.println("我是"+name+",我爱吃猪脚");
  }
  public void run(){
    System.out.println("吃完就跑");
  }
}
```

#### 多态性

多态性我们大概可以分为两类：

1. 方法的重载与重写就是方法的多态性表现
2. 多个子类就是父类中的多种形态
3. **父类引用可以指向子类对象，自动转换**
4. **子类对象指向父类引用需要强制转换（注意：类型不对会报异常）**
5. 在实际开发中尽量使用父类引用，即向上转型（更利于扩展）

##### 向上转型 (自动转换)

用父类的引用指向子类对象（用大的类型去接受小的类型）

格式：父类 父类对象 = 子类实例

##### 向下转型 (强制转换)

用子类的引用指向父类对象（用小的类型去接受大的类型）

格式：子类 子类对象 = （子类）父类实例

##### instanceof

返回值为 boolean 型

格式：对象 instanceof 类型

```java
// 向上转型：父类 父类对象 = 子类实例
Father f = new Son();
int i = 'a';
  
// 向下转型：子类 子类对象 = （子类）父类实例
Son s = (Son) new Father();
char c = (char)97; 

// instanceof 关键字使用
if(s instanceof Son){
	//...
}
```

##### 父类的设计建议

通过instanceof关键字，我们可以很方便 的检查对象的类型，但如果一个父类的子类过多，这样的判断还是显得很繁琐，下面是设计父类的一些建议

1. 父类通常情况下都设计为抽象类或接口，其中优先考虑接口，如接口不能满足才考虑抽象类。
2. 一个具体的类尽可能不去继承另一个具体类，这样的好处是无需检查对象是否为父类的对象。

#### Object 类

所有类都是Object类的子类

##### Object 方法

1. public String **toString**()

   通常，toString 方法会返回一个“以文本方式表示”此对象的字符串。结果应是一个简明且易于读懂的信息表达式，建议所有子类都重写此方法。

2. public boolean **equals**(Object obj) 

   指示其他某个对象是否与此对象“相等”。 equals 方法在非空对象引用上实现相等关系：自反性，对称性，传递性，一致性。

3. protected void **finalize**()throws Throwable

   当垃圾回收器确定不存在对该对象的更多引用时，由对象的垃圾回收器调用此方法。子类重写 finalize 方法，以配置系统资源或执行其他清除。 

4. public final Class<?> **getClass**()

   返回此 Object 的运行时类。

#### 内部类

##### 要点

1. 内部类就是在一个类的内部定义的类。主要有 成员内部类、方法内部类、静态内部类、匿名内部类

2. 依赖外部类对象的：成员内部类，方法内部类，匿名内部类
3. 静态内部类不依赖外部类的对象。所以，我们在项目中优先考虑选择静态内部类（不会产生内存泄露）
4. 每个内部类都能独立地继承自一个（接口的）实现，所以无论外部类是否已经继承了某个（接口的）实现，对于内部类都没有影响。如果没有内部类提供的可以继承多个具体的或抽象的类的能力，一些设计与编程问题就很难解决。从这个角度看，内部类使得多重继承的解决方案变得完整。接口解决了部分问题，而内部类有效地实现了“多重继承”。

##### 成员内部类(成员)

1. 成员内部类除了可以在外部类中产生实例化对象，也可以在外部类的外部来实例化。
2. 根据内部类生成的class文件：Outer\$Inner.class，“\$”符号在程序运行时将替换成“.”，通过Outer.Inner表示

##### 静态内部类(成员)

1. 该内部类可以像其他静态成员一样，没有外部类对象时，也能够访问它。静态嵌套类仅能访问外部类的静态成员和方法。

##### 方法内部类(局部)

1. 方法内部类只能在定义该内部类的方法内实例化，不可以在此方法外对其实例化。
2. 方法内部类对象不能使用该内部类所在方法的非 final 局部变量。

##### 匿名内部类(局部)

1. 匿名内部类就是没有名字的内部类。
2. 匿名内部类的三种情况
   - 继承式的匿名内部类
   - 接口式的匿名内部类
   - 参数式的匿名内部类
3. **在使用匿名内部类时，要记住以下几个原则**
   - 不能有构造方法，只能有一个实例。
   - 不能定义任何静态成员、静态方法。
   - 不能是 public, protected, private, static。
   - 一定是在 new 的后面，用其隐含实现一个接口或继承一个类。
   - 匿名内部类为局部的，所以局部内部类的所有限制都对其生效。

```java
// 成员内部类/静态内部类，编译上述代码会产生两个文件：Outer.class 和 Outer$Inner1.class / Outer$Inner2.class
class Outer {
  // ==== 成员内部类 ====
	class Inner1{}
  // ==== 静态内部类 ====
	static class Inner2{}
  // 成员内部类实例化(在外部类中实例化)
	public void innerPrint(){
		Inner1 in1 = new Inner1();
	}
	// ==== 匿名内部类 ====
	// 继承式
	public void print1(){
		Cat cat = new Cat(){
			public void eat(){
				System.out.println("eat:继承式匿名内部类");
			}
		};
		cat.eat();
	}
	// 接口式
	public void print2(){
		Eat eat = new Eat(){
			public void eat(){
				System.out.println("eat:接口式匿名内部类");
			}
		};
		eat.eat();
	}
	// 参数式
	public void print3(Eat eat){
		eat.eat();
	}
}
// 成员内部类实例化(在外部类的外部来实例化)
Outer out = new Outer(); // 产生外部类实例
Outer.Inner1 in1 = out.new Inner1();

// 静态内部类实例化
Outer.Inner2 in2 = new Outer.Inner2();

// 参数式匿名内部类
outer.print3(new Eat(){
  public void eat(){
    System.out.println("参数式匿名内部类");
  }
});

interface Eat{
	public void eat();
}
abstract class Cat{
	public abstract void eat();
}

// ==== 方法内部类 ====
class Outer {
   public void doSomething(){
       class Inner{}
       Inner in = new Inner();
   }
}
```

**注：** 为什么局部内部类访问局部变量必须用final修饰？

​		当调用这个方法时，局部变量如果没有用final修饰，他的生命周期和方法的生命周期是一样的，当方法被调用时会入栈，方法结束后即弹栈，这个局部变量也会消失，那么如果局部内部类对象还没有马上消失想用这个局部变量，显然已无法使用了，如果用final修饰会在类加载的时候进入常量池，即使方法弹栈，常量池的常量还在，也就可以继续使用了。

**注：在jdk1.8中取消了在局部内部类中使用的变量必须显示的使用 final 修饰，编译器默认会为这个变量加上final**

#### 包

包定义语句只能出现在代码中的第一句

如：`package com.vince;`

#### OO 原则

1. 开闭原则

   一个软件实体如类、模块和函数应该对扩展开放，对修改关闭。

2. 合成/聚合复用原则

   新对象的某些功能在已创建好的对象里已实现，那么尽量用已有对象提供的功能，使之成为新对象的一部分，而不要再重新创建。

3. 依赖倒置原则

   高层模块不应该依赖低层模块，二者都应该依赖其抽象；抽象不应该依赖细节；细节应该依赖抽象。

4. 接口隔离原则

   客户端不应该依赖它不需要的接口；一个类对另一个类的依赖应该建立在最小的接口上。

5. 迪米特法则

   一个对象应该对其他对象保持最少的了解

6. 里氏替换原则

   所有引用基类的地方必须能透明地使用其子类的对象

7. 单一职责原则

   不要存在多于一个导致类变更的原因，即一个类只负责一项职责。

### 异常

#### 要点

1. Throwable 是异常的基类，分为 Error 和 Exception，在编程中我们关注 Exception
2. Exception 分为编译期异常(受检)和运行期异常（非受检）
3. 异常会导致程序中断，无法继续执行
4. 在开发中，我们需要把可能出现异常的代码使用 try 语句块包裹起来
5. 处理异常可以让程序保持运行状态
6. catch 可以有多个，顺序为从子类到父类，小的放前面，大的放后面

#### 异常分类

- ArithmeticException

 *              ArrayIndexOutOfBoundsException
 *              NullPointerException
 *              InputMismatchException
 *              Exception
 *              RuntimeException
 *              ClassNotFoundException 
 *              DataFormatException
 *              ClassCastException

#### try、catch 和 finally 关键字

**异常处理的语法规则**

1. try 语句不能单独存在，可以和 catch、finally 组成 try...catch...finally、try...catch、try…finally 三种结构，catch 语句可以有一个或多个，finally语句最多一个，try、catch、finally 这三个关键字均不能单独使用。
2. try、catch、finally 三个代码块中变量的作用域分别独立而不能相互访问。
3. 多个 catch 块时候，Java 虚拟机会匹配其中一个异常类或其子类，就执行这个 catch 块，而不会再执行别的catch块，所以一般会把更细的异常类放在前面，更大的类放在后面。

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
// JDK1.7以后直接释放括号内的资源(如下表示自动关闭流)
try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
	// ... 有可能发生异常的代码段
  System.out.println("请输入数字:");
  String info = br.readLine();
  int num = Integer.parseInt(info);
  System.out.println(info);
  // br.close();
} catch (IOException e) {
  // ... 异常的处理操作
  e.printStackTrace();
} catch (NumberFormatException|Exception e) {
	// ... 异常的处理操作
  e.printStackTrace();
} finally {
  // ... 不管是否有异常都会执行
}
```

#### throw 与 throws 关键字

1. throws 关键字主要在方法的声明上使用，表示方法中不处理异常，而交给调用处处理。实际上对于 Java 程序来讲，如果没有加入任何的异常处理，默认由 JVM 进行异常的处理操作。
2. throw 关键字表示在程序中手动抛出一个异常，因为从异常处理机制来看，所有的异常一旦产生之后，实际上抛出的就是一个异常类的实例化对象，那么此对象也可以由 throw 直接抛出。

#### 异常处理过程分析

1. 一旦产生异常，则系统会自动产生一个异常类的实例化对象。
2. 此时如果存在了 try 语句，则会自动找到匹配的 catch 语句执行，如果没有异常处理，则程序将退出，并由系统报告错误。
3. 所有的 catch 根据方法的参数匹配异常类的实例化对象，如果匹配成功，则表示由此 catch 进行处理。

#### 受检异常/非受检异常

##### 受检异常(Exception)

​	定义方法时必须声明所有可能会抛出的 Exception，在调用这个方法时，**必须捕获它的 checked exception**，不然就得把它的 Exception 传递下去，**Exception** 是从 **java.lang.Exception** 类衍生出来的。例如： **IOException**， **SQLException** 就属于 **Exception**

##### 非受检异常(RuntimeException)

​	在定义方法时不需要声明会抛出 RuntimeException,在调用这个方法时**不需要捕获这个 RuntimeException**， **RuntimeException** 是从 **java.lang.RuntimeException** 或 **java.lang.Error** 类衍生出来的。 例如：**NullPointException**，**IndexOutOfBoundsException** 就属于 **RuntimeException**

![](https://upload-images.jianshu.io/upload_images/5097954-602dae88697a8c65.png)

#### 自定义异常

```java
package com.vince.ex;

/**
 * 自定义异常通常都是通过继承一个异常类来实现
 * 1、Throwable
 * 2、Exception
 * 3、RuntimeException
 * 自定义异常常的实现是，提供构造方法
 * 异常对象本身是没有实际功能，只是一个有意义的标识
 */
public class MyException extends RuntimeException{
  public MyException(){
    super();
  }
  public MyException(String message){
    super(message);
  }
}
```



#### assert(断言)

##### 格式

1. assert  Boolean；

   如果 Boolean 为 true，表示断言成功，程序继续执行。如果为false，会抛出 AssertionError，AssertionError 继承 Error 类，Error 类与我们经常用到的 Exception 类都是集成于 Throwable 类。

2. assert  Boolean  :  String；

   当 AssertionError 发生时，会 AssertionError 信息后一起打印出。

```java
// assert可以通过参数 -da（默认）使程序不进行断言判断。要使用时要添加参数虚拟机启动参数 -ea
// 如 java Test -ea
public static void main(String[] args) {
  // assert expression
  assert cstVar == "final_anima";
	assert cstVar == "final_anima" : "asd";
}
```

##### debug

debug as  —>  Java Application

快捷键

​	F5：单步跳入。进入本行代码中执行

​	F6：单步跳过。执行本行代码，跳到下一行

​	F7：单步返回。跳出方法

​	F8：继续。执行到下一个断点，如果没有断点了，就执行到结束

​	Ctrl+R：执行到光标所在的这一行

### 常用类库

#### String类

##### 赋值方式

```java
// 方式一 直接赋值(推荐)，只创建1个对象(常量池中的小白)
String name = "小白";
// 方式二 通过 String 的构造方法赋值
// 面试题，问下面的代码创建了几个对象? 答案：2个，一个是String常量池中的小白，另一个是new出来的空间
String name =  new String("小白");
```

##### String编译期与运行期分析

如果在编译期值可以被确定，那么就使用已有的对象，否则会创建新的对象。

```java
// 代码示例：4种情况分析: 直接赋值字符串连接时，考虑编译期和运行期
String a = "a";
String a1 = a + 1;
String a2 = "a1";
System.out.println(a1 == a2); // false(因为a1在编译期值不可以被确定，所以a2会创建新的对象)

final String b = "b";
String b1 = b + 1;
String b2 = "b1";
System.out.println(b1 == b2); // true (因为b1在编译期值可以被确定，所以b2就使用已有的对象)

String c = getC();
String c1 = c + 1;
String c2 = "c1";
System.out.println(c1 == c2); // false (因为方法在运行期才会返回结果)

final String d = getD();
String d1 = d + 1;
String d2 = "d1";
System.out.println(d1 == d2); // false (因为方法在运行期才会返回结果)
```

#### String方法

##### 字符与字符串操作方法

| No   | 方法名称                                           | 类型 | 描述                                 |
| ---- | -------------------------------------------------- | ---- | ------------------------------------ |
| 1    | public char charAt(int index)                      | 普通 | 根据下标找到指定的字符               |
| 2    | public char[] toCharArray()                        | 普通 | 以字符数组的形式返回全部的字符串内容 |
| 3    | public String(char[] value)                        | 构造 | 将全部的字符数组变为字符串           |
| 4    | public String(char[] value,int offset,int   count) | 构造 | 将指定范围的字符数组变为字符串       |

##### 字节与字符串操作方法

| No.  | 方法名称                                            | 类型 | 描述                                                         |
| ---- | --------------------------------------------------- | ---- | ------------------------------------------------------------ |
| 1    | public byte[] getBytes()                            | 普通 | 将字符串变为字节数组                                         |
| 2    | public String(byte[] bytes)                         | 构造 | 字节数组变为字符串                                           |
| 3    | public String(byte[] bytes,int offset,int   length) | 构造 | 将指定范围的字节数组变为字符串                               |
| 4    | public String(byte[] bytes,   String charsetName)   | 构造 | 通过使用指定的 charset 解码指定的 byte 数组，构造一个新的 String |

##### 判断是否以指定内容开头或结尾

| No.  | 方法名称                                               | 类型 | 描述                                     |
| :--- | ------------------------------------------------------ | ---- | ---------------------------------------- |
| 1    | public boolean startsWith(String   prefix)             | 普通 | 从第一个位置开始判断是否以指定的内容开头 |
| 2    | public boolean startsWith(String   prefix,int toffset) | 普通 | 从指定的位置开始判断是否以指定的内容开头 |
| 3    | public boolean endsWith(String suffix)                 | 普通 | 判断是否以指定的内容结尾                 |

##### 替换操作

| No.  | 方法名称                                                     | 类型 | 描述                       |
| ---- | ------------------------------------------------------------ | :--- | -------------------------- |
| 1    | public String replace(char oldChar,char   newChar)           | 普通 | 替换指定字符               |
| 2    | public String replace(CharSequence   target, CharSequence   replacement) | 普通 | 替换指定字符串             |
| 3    | public String replaceAll(String   regex,String replacement)  | 普通 | 替换指定的字符串           |
| 4    | public String replaceFirst(String   regex,String replacement) | 普通 | 替换第一个满足条件的字符串 |

##### 截取操作

| No.  | 方法名称                                             | 类型 | 描述                         |
| ---- | ---------------------------------------------------- | ---- | ---------------------------- |
| 1    | public String substring(int beginIndex)              | 普通 | 从指定位置开始一直截取到末尾 |
| 2    | public String substring(int beginIndex,int endIndex) | 普通 | 截取指定范围的字符串         |

##### 字符串拆分操作

| No.  | 方法名称                                        | 类型 | 描述                         |
| ---- | ----------------------------------------------- | ---- | ---------------------------- |
| 1    | public String[] split(String regex)             | 普通 | 按照指定的字符串拆分         |
| 2    | public String[] split(String regex,int   limit) | 普通 | 拆分字符串，并指定拆分的个数 |

##### 字符串查找操作

| No.  | 方法名称                                       | 类型 | 描述                                                         |
| ---- | ---------------------------------------------- | ---- | ------------------------------------------------------------ |
| 1    | public boolean contains(String s)              | 普通 | 返回一个字符串是否存在                                       |
| 2    | public int indexOf(int   ch)                   | 普通 | 从头查找指定的字符是否存在，char   à int，如果存在则返回位置，如果不存在则返回“-1”。 |
| 3    | public int indexOf(int   ch,int fromIndex)     | 普通 | 从指定位置查找指定的字符是否存在，char   à int，如果存在则返回位置，如果不存在则返回“-1”。 |
| 4    | public int indexOf(String   str)               | 普通 | 从头查找指定的字符串是否存在，如果存在则返回位置，如果不存在则返回“-1”。 |
| 5    | public int indexOf(String   str,int fromIndex) | 普通 | 从指定位置查找字符串是否存在，如果存在则返回位置，如果不存在则返回“-1”。 |
| 6    | public int lastIndexOf(int   ch)                | 普通 | 从字符串的最后向前查找，指定的字符是否存在，如果存在则返回位置，如果不存在则返回“-1”。 |
| 7    | public int lastIndexOf(int   ch,int fromIndex)  | 普通 | 从字符串的指定的末尾向前查找，指定的字符是否存在，如果存在则返回位置，如果不存在则返回“-1”。 |
| 8    | public int lastIndexOf(String   str)            | 普通 | 从字符串的最后向前查找，指定的字符串是否存在，如果存在则返回位置，如果不存在则返回“-1”。 |
| 9    | public int lastIndexOf(String   str,int fromIndex) | 普通 | 从字符串的指定的末尾向前查找，指定的字符串是否存在，如果存在则返回位置，如果不存在则返回“-1”。 |

##### 其它操作方法

| No.  | 方法名称                         | 类型 | 描述                                 |
| ---- | -------------------------------- | ---- | ------------------------------------ |
| 1    | public boolean isEmpty()         | 普通 | 判断是否为空，指的是内容为空“""”     |
| 2    | public int length()              | 普通 | 取得字符串的长度                     |
| 3    | public String toLowerCase()      | 普通 | 转小写                               |
| 4    | public String toUpperCase()      | 普通 | 转大写                               |
| 5    | public String trim()             | 普通 | 去掉开头和结尾的空格，中间的空格不去 |
| 6    | public String concat(String str) | 普通 | 字符串连接操作                       |

#### StringBuffer类

StringBuffer 的内部实现采用字符数组，默认数组的长度为16，超过数组大小时，动态扩充的算法是原来长度*2+2，所以当我们预知要添加的数据长度时，建议使用带初始化容量的构造方法，来避免动态扩充的次数，从而提高效率，线程安全的，会影响性能，

##### StringBuffer常用操作方法

| **方法名称**                                              | **描述**                                     |
| --------------------------------------------------------- | -------------------------------------------- |
| public StringBuffer()                                     | 构造一个空的StringBuffer对象                 |
| public StringBuffer(String str)                           | 将指定的String变为StringBuffer的内容         |
| public StringBuffer(CharSequence seq)                     | 接收CharSequence接口的实例                   |
| public StringBuffer append(数据类型 b)                    | 提供了很多的append()方法，用于进行字符串连接 |
| public StringBuffer delete(int start,int   end)           | 删除指定位置的内容                           |
| public int indexOf(String   str)                          | 字符串的查询功能                             |
| public StringBuffer insert(int   offset,数据类型 b)       | 在指定位置上增加一个内容                     |
| public StringBuffer replace(int start,int end,String str) | 将指定范围的内容替换成其他内容               |
| public String substring(int start,int   end)              | 截取指定范围的字符串                         |
| public String substring(int   start)                      | 字符串截取                                   |
| public StringBuffer reverse()                             | 字符串反转                                   |

##### String，StringBuffer 与 StringBuilder 的区别

1. StringBuffer 是线程安全的，性能低，适合在多线程的使用，jdk1.0
2. StringBuilder 是线程不安全的，性能高，适合在单线程中使用，这种情况占多大数,在jdk1.5后添加
3. String 类型和 StringBuffer 类型的主要性能区别其实在于 String 是不可变的对象, 因此在每次对 String 类型进行改变的时候其实都等同于生成了一个新的 String 对象，然后将指针指向新的 String 对象，所以经常改变内容的字符串最好不要用 String ，因为每次生成对象都会对系统性能产生影响，特别当内存中无引用对象多了以后， JVM 的 GC 就会开始工作，那速度是一定会相当慢的。
    而如果是使用 StringBuffer 类则结果就不一样了，每次结果都会对 StringBuffer 对象本身进行操作，而不是生成新的对象，再改变对象引用。所以在一般情况下我们推荐使用 StringBuffer ，特别是字符串对象经常改变的情况下。而在某些特别情况下， String 对象的字符串拼接其实是被 JVM 解释成了 StringBuffer 对象的拼接，所以这些时候 String 对象的速度并不会比 StringBuffer 对象慢，而特别是以下的字符串对象生成中， String 效率是远要比 StringBuffer 快的：

```java
String S1 = "This is only a" + " simple" + " test";
StringBuffer Sb = new StringBuilder(“This is only a”).append(“ simple”).append(“ test”);
// 你会很惊讶的发现，生成 String S1 对象的速度简直太快了，而这个时候 StringBuffer 居然速度上根本一点都不占优势。其实这是 JVM 的一个把戏，在 JVM 眼里，这个
String S1 = "This is only a" + " simple" +  "test"; 
// 其实就是
String S1 = "This is only a simple test";
// 所以当然不需要太多的时间了。但大家这里要注意的是，如果你的字符串是来自另外的 String 对象的话，速度就没那么快了，譬如：
String S2 = "This is only a";
String S3 = " simple";
String S4 = " test";
String S1 = S2 + S3 + S4;
// 这时候 JVM 会规规矩矩的按照原来的方式去做
```

**在大部分情况下 StringBuffer > String**
	java.lang.StringBuffer **线程安全** 的可变字符序列。一个类似于 String 的字符串缓冲区，但不能修改。虽然在任意时间点上它都包含某种特定的字符序列，但通过某些方法调用可以改变该序列的长度和内容。
	**可将字符串缓冲区安全地用于多个线程**。可以在必要时对这些方法进行同步，因此任意特定实例上的所有操作就好像是以串行顺序发生的，该顺序与所涉及的每个线程进行的方法调用顺序一致。
StringBuffer 上的主要操作是 append 和 insert 方法，可重载这些方法，以接受任意类型的数据。每个方法都能有效地将给定的数据转换成字符串，然后将该字符串的字符追加或插入到字符串缓冲区中。append 方法始终将这些字符添加到缓冲区的末端；而 insert 方法则在指定的点添加字符。
例如，如果 z 引用一个当前内容是“start”的字符串缓冲区对象，则此方法调用 z.append("le") 会使字符串缓冲区包含“startle”，而 z.insert(4, "le") 将更改字符串缓冲区，使之包含“starlet”。

**在大部分情况下 StringBuilder > StringBuffer**
	java.lang.StringBuilder一个可变的字符序列是5.0新增的。此类提供一个与 StringBuffer 兼容的 API，**但不保证同步**。该类被设计用作 StringBuffer 的一个简易替换，**用在字符串缓冲区被单个线程使用的时候**（这种情况很普遍）。如果可能，建议优先采用该类，因为在大多数实现中，它比 StringBuffer 要快。两者的方法基本相同。

#### 程序国际化

##### Locale类

- Locale(String language)  // 构造方法

- Locale(String language, String country)  // 构造方法

- getDefault() // 获取当前系统的默认语言环境

##### ResourceBundle类

表示的是一个资源文件的读取操作，所有的资源文件需要使用ResourceBundle进行读取，读取的时候不需要加上文件的后缀。

- getBundle(String baseName)  // 构造方法

- getBundle(String baseName,Locale locale)  // 构造方法

- getString(String key) // 从属性文件中使用key来获取value

##### MessageFormat类

- format(String pattern, Object... arguments)  // 使用给定的模式创建一个MessageFormat，并使用它来格式化给定的参数。

```properties
# info_en_US.properties
system.name=EMP Manager System
input.username=Input UserName:
input.password=Input Password:
login.success=Login Success!
login.error=Login Error
# {0}为待替换内容的占位符
welcome=welcome,{0}
```

```properties
# info_zh_CN.properties
system.name=\u5458\u5DE5\u7BA1\u7406\u7CFB\u7EDF
input.username=\u8F93\u5165\u7528\u6237\u540D\uFF1A
input.password=\u8F93\u5165\u5BC6\u7801\uFF1A
login.success=\u767B\u5F55\u6210\u529F
login.error=\u767B\u5F55\u9519\u8BEF
welcome=\u6B22\u8FCE\u4F60\uFF0C{0}
```

```java
import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle; // 只有读取功能配置文件，不能写入(Properties 类则可读可写)
import java.util.Scanner;
/**
 * 1、Locale
 * 2、Properties文件：属性文件（配置文件），内容以键值对的形式存放（key-value）
 * 3、ResourceBundle工具类，用来绑定属性文件，并指定Locale对象，来自动选择使用哪个属性文件，默认将使用与操作系统相同的语言环境。
 * getString()方法来从属性文件中使用key来获取value
 * 注意，ResourceBundle工具类是只读的
 */
public class I18NDemo {
	public static void main(String[] args) {
		// 创建一个本地语言环境对象，该对象会根据参数设置来自动选择与之相关的语言环境
		// 参数：语言，地区
		Locale locale_CN = new Locale("zh", "CN");
		Locale locale_US = new Locale("en", "US");
		// 获取当前系统的默认语言环境
		Locale locale_default = Locale.getDefault();
		Scanner input = new Scanner(System.in);
		// 用于绑定属性文件的工具类（参数：属性文件的基本名（就是前缀：比如 info））
		ResourceBundle r = ResourceBundle.getBundle("com.vince.info", locale_US);
		// ResourceBundle r = ResourceBundle.getBundle("com.vince.info");
		System.out.println(r.getString("system.name"));
		System.out.println(r.getString("input.username"));
		String username = input.nextLine();
		System.out.println(r.getString("input.password"));
		String password = input.nextLine();
		if("admin".equals(username) && "123".equals(password)){
			System.out.println(r.getString("login.success"));
			String welcome = r.getString("welcome");
			// 动态文本格式化
			welcome = MessageFormat.format(welcome, username);
			System.out.println(welcome);
		} else {
			System.out.println(r.getString("login.error"));
		}
	}
}
```

#### Math类

##### 方法

| 方法  | 释义                       |
| ------------------- | ------------------------------------------------------------ |
| static double   **PI** | 比任何其他值都更接近 **pi** 的 double 值                    |
| **abs**(double a)   | 返回   double   值的绝对值                                   |
| **random**()        | 返回带正号的   double   值，该值大于等于   0.0   且小于   1.0 |
| **round**(double a) | 返回最接近参数并等于某一整数的   double   值                 |
| **sqrt**(double a)  | 返回正确舍入的   double   值的正平方根                       |

#### Random类

用于生成**伪随机数**

| 方法     | 释义                                |
| -------------- | ------------------------------------------------------------ |
| nextLong()     | 返回下一个伪随机数的long   值                                |
| nextBoolean()  | 返回下一个伪随机数boolean 值                                 |
| nextDouble()   | 返回下一个伪随机数，在   0.0   和 1.0   之间的   double   值 |
| nextFloat()    | 返回下一个伪随机数，在   0.0   和 1.0   之间的   float   值  |
| nextInt()      | 返回下一个伪随机数，int 值                                   |
| nextInt(int n) | 返回一个伪随机数，在   0（包括）和指定值分布的 int 值        |

#### Date类

Date 类表示特定的瞬间，精确到毫秒，也就是程序运行时的当前时间。

#### Calendar类

日历类，使用此类可以将时间精确到毫秒显示。

#### DateFormat类 及 子类SimpleDateFormat

日期格式化类

```java
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateDemo {
	public static void main(String[] args) {
    // Date类
		// Date date = new Date();
		Date date = new Date(1572711009992L);
		// java.sql.Date sqlDate = new java.sql.Date();
		System.out.println(date);
		// Calendar类
		Calendar c1 = Calendar.getInstance();
		Calendar c2 = new GregorianCalendar();
		int year = c1.get(Calendar.YEAR);
		int month = c1.get(Calendar.MONTH);
		int day = c1.get(Calendar.DAY_OF_MONTH);
		int hour = c1.get(Calendar.HOUR_OF_DAY);
		int minute = c1.get(Calendar.MINUTE);
		int second = c1.get(Calendar.SECOND);
		int millisecond = c1.get(Calendar.MILLISECOND);
		StringBuilder sb = new StringBuilder(50);						      sb.append(year).append("年").append(month).append("月").append(day).append("日").append(hour).append(":").append(minute).append(":").append(second).append(" ").append(millisecond);
		System.out.println(sb.toString());
		// DateFormat类 及其子类 SimpleDateFormat类
		DateFormat df = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss SSS");
		String nowDate = df.format(new Date());
		System.out.println(nowDate);
	}
}
```

#### 对象比较器

继承并实现相关比较器接口就可以使用 **Arrays.sort()** 进行排序

#####Comparable接口

1. 此接口强行对实现它的每个类的对象进行整体排序，这种排序被称为类的自然排序，类的
   **compareTo** 方法被称为它的自然比较方法。

##### Comparator接口

1. Comparable接口是要求自定义类去实现。
2. 强行对某个对象 collection 进行整体排序的比较。
3. 一般用于某个类已经定义好了，不想再去修改它，但又想实现比较排序功能。

```java
// ====== Cat.java ======
// Comparable 接口，需要实现 compareTo 方法
public class Cat implements Comparable<Cat>{
	private int age;
	public Cat() {
		super();
	}
	public Cat(int age) {
		super();
		this.age = age;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public int compareTo(Cat o) {
		return this.age-o.age;
	}
}

// ====== Dog.java ======
public class Dog {
	private int age;
	public Dog() {
		super();
	}
	public Dog(int age) {
		super();
		this.age = age;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Dog [name=" + name + ", age=" + age + "]";
	}
}

// ====== DogComparator.java ======
// Comparator 接口，需要实现 compare 方法
import java.util.Comparator;
public class DogComparator implements Comparator<Dog>{
  @Override
  public int compare(Dog o1, Dog o2) {
    return o1.getAge()-o2.getAge();
  }
}

// ====== Test.java ======
import java.util.Arrays;
public class Test {
	public static void main(String[] args) {
		int[] nums = { 34, 54, 22, 3, 5, 6, 7, 87, 9 };
		Arrays.sort(nums);
		System.out.println(Arrays.toString(nums));

		Cat[] cats = {new Cat(1),new Cat(4),new Cat(2)};
		Arrays.sort(cats);
		System.out.println(Arrays.toString(cats));

		Dog[] dogs = {new Dog(1), new Dog(4), new Dog(2)};
		Arrays.sort(dogs, new DogComparator());
		System.out.println(Arrays.toString(dogs));
	}
}
```

#### 对象的克隆

##### Cloneable接口

如果某个类的对象要想被克隆，则对象所在的类必须实现 Cloneable 接口。此接口没有定义任何方法，是一个标记接口。

```java
// ====== Cat.java ======
/**
 * 对象需要具备克隆功能：
 * 1、实现Cloneable接口(标记接口)
 * 2、重写Object类中的clone方法
 */
public class Cat implements Cloneable{
	private String name;
	public Cat() {
		super();
	}
	public Cat(String name) {
		super();
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	// 重写Object中的clone方法
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	@Override
	public String toString() {
		return "Cat [name=" + name + ", age=" + age + "]";
	}
}

// ====== Test.java ======
import java.io.IOException;
public class Test {
	public static void main(String[] args) {
		Cat cat = new Cat("喵喵小白");
		try {
			Cat newCat = (Cat) cat.clone();
			System.out.println("cat=" + cat);
			System.out.println("new cat=" + newCat);
			System.out.println(cat == newCat); // false
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
	}
}
```

#### System类

System类代表系统，系统级的很多属性和控制方法都放置在该类的内部。该类位于java.lang包。

##### 成员变量

System类内部包含**in**、**out** 和 **err** 三个成员变量，分别代表标准输入流(键盘输入)，标准输出流(显示器)和标准错误输出流。

##### 成员方法

1. **public static void arraycopy(Object src, int srcPos, Object dest, int destPos, int length)**

   该方法的作用是数组拷贝，也就是将一个数组中的内容复制到另外一个数组中的指定位置，由于该方法是native方法，所以性能上比使用循环高效。

2. **public static long currentTimeMillis()**

   该方法的作用是返回当前的计算机时间，时间的表达格式为当前计算机时间和GMT时间(格林威治时间)1970年1月1号0时0分0秒所差的毫秒数。

3. **public static void exit(int status)**

   该方法的作用是退出程序。其中status的值为0代表正常退出，非零代表异常退出。使用该方法可以在图形界面编程中实现程序的退出功能等。

4. **public static void gc()**

   该方法的作用是请求系统进行垃圾回收。至于系统是否立刻回收，则取决于系统中垃圾回收算法的实现以及系统执行时的情况。

5. **public static String getProperty(String key)**

   该方法的作用是获得系统中属性名为key的属性对应的值。

```java
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Date;

public class SystemDemo {
	public static void main(String[] args) {
    Scanner input = new Scanner(System.in); // 新建一个输入类实例
		System.out.println("向控制台输出");
		System.err.println("出错啦");
		int[] num1 = {1,2,3,4,5,6,7,8};
		int[] num2 = new int[num1.length];
		// 参数（源数组，源数组的起始位置 ，目标数组，目标数组的起始位置 ，长度）
		System.arraycopy(num1, 0, num2, 0, num1.length); // 复制数组
		System.out.println(System.currentTimeMillis()); // 获取系统时间毫秒值
		// System.exit(0); // 退出JVM
		System.out.println(System.getProperty("java.version")); // Java 运行时环境版本
		System.out.println(System.getProperty("java.home")); // Java 安装目录
		System.out.println(System.getProperty("os.name")); // 操作系统的名称
		System.out.println(System.getProperty("os.version")); // 操作系统的版本
		System.out.println(System.getProperty("user.name")); // 用户的账户名称
		System.out.println(System.getProperty("user.home")); // 用户的主目录
		System.out.println(System.getProperty("user.dir")); // 用户的当前工作目录
		// 加载C、C++编写的类库
		// System.loadLibrary(libname);
  }
}
```

#### Runtime类

每个 Java 应用程序都有一个 Runtime 类实例，使应用程序能够与其运行的环境相连接。

```java
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Date;

public class SystemDemo {
	public static void main(String[] args) {
    // 获取Java运行时相关的运行时对象
		Runtime rt = Runtime.getRuntime();
		System.out.println("处理器数量：" + rt.availableProcessors() + " 个");
		System.out.println("Jvm总内存数 ：" + rt.totalMemory() + " byte");
		System.out.println("Jvm空闲内存数： " + rt.freeMemory() + " byte");
		System.out.println("Jvm可用最大内存数： " + rt.maxMemory() + " byte");
		//在单独的进程中执行指定的字符串命令。
		try {
			rt.exec("notepad"); // 打开记笔本
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
```

#### MD5/Base64

**注：**jdk1.8之前使用sun.misc.BASE64Encoder(此类在 rt.jar > sun/misc/\*下，但是没有访问权限，需要在rt.jar中添加访问权限：sun/misc/*)

![](https://upload-images.jianshu.io/upload_images/5097954-b2cc221d964efd4b.png)

```java
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;
public class MD5Demo {
	public static void main(String[] args) {
		test();
	}
	private static void test() {
		String password = "admin123456"; // dsfkjdskfj76776f98732 明文（原文）
		String savePassword = "pmq7VoTEWWLYh1ZPCDRujQ=="; // 存储的密文
		try {
      // ==== md5 ====
			MessageDigest md = MessageDigest.getInstance("md5"); // 获取 md5 实例
			byte[] bytes = md.digest(password.getBytes("UTF-8")); // 通过 md5 计算摘要
			String mdStr = new String(bytes); // 转为 String
      
			// ==== base64 ==== 编码算法(a-z A-Z 0-9 / +)
			// jdk1.8版本
			// String str = Base64.getEncoder().encodeToString(bytes); // base64 编码
			// byte[] bs = Base64.getDecoder().decode(savePassword); // base64 解码

			// jdk1.8之前使用
      // base64 编码
			BASE64Encoder base64 = new BASE64Encoder();
			String str = base64.encode(bytes);
			// base64 解码
			BASE64Decoder decoder = new BASE64Decoder();
			byte[] bs = decoder.decodeBuffer(str);
			System.out.println(str);
		} catch (NoSuchAlgorithmException|UnsupportedEncodingException|IOException e) {
			e.printStackTrace();
		}
	}
}
```

#### 二叉树

树是一种重要的非线性数据结构，直观地看，它是数据元素（在树中称为结点）按分支关系组织起来的结构。二叉树（Binary Tree）是每个节点最多有两个子树的有序树。通常子树被称作 **左子树** 和 **右子树**。

1. 选择第一个元素作为根节点

2. 之后如果元素大于根节点放在右子树，如果元素小于根节点，则放在左子树

3. 最后按照中序遍历的方式进行输出，则可以得到排序的结果（左 > 根 > 右）

#### Lambda表达式

##### 要点

1. **jdk1.8** 的 Lambda 表达式（也称为闭包）是整个Java 8发行版中最受期待的在Java语言层面上的改变，Lambda允许把函数作为一个方法的参数（函数作为参数传递进方法中），或者把代码看成数据。Lambda表达式用于简化JAVA中接口式的匿名内部类，被称为函数式接口的概念，**函数式接口就是一个具有一个方法的普通接口**，像这样的接口，可以被隐式转换为lambda表达式。

2. 在之前，如果需要在匿名类的内部引用外部变量，需要将外部变量定义为 final ，现在有了 lambda 表达式，你不必再这么做了。但同样需要保证外部的自由变量不能在 lambda 表达式中被改变。
3. 默认方法与静态方法并不影响函数式接口的契约，可以任意使用

**语法：**(参数1,参数2...) -> { ... }

```java
import java.util.Arrays;
import java.util.Comparator;
public class LambdaDemo {
	public static void main(String[] args) {
		// 没有使用lambda表达式时
		IEat ieat1 = new IEat(){
			public void eat(){
				System.out.println("eat bnana");
			}
		};
		ieat1.eat();

		// ==== 使用lambda表达式 ====
		// 好处：1. 代码更简洁，2. 不会单独生成class文件
    
		// 没有参数时使用
		IEat ieat2 = () -> { System.out.println("eat apple bnana"); };
		ieat2.eat();

		// 带参数时使用,参数的类型可以省略
		// 当代码块中只有一行代码
		IEat ieat3 = (thing, name) -> System.out.println("eat..." + thing + "..." + name);
		// 当代码块中有多行代码
		// IEat ieat3 = (thing,name) -> {
		// 	System.out.println("eat..." + thing);
		// 	System.out.println(name);
		// };
		ieat3.eat("apple", "大冰");

		// 带返回值(有多行代码)
		// IEat ieat4 = (thing,name)->{
		// 	System.out.println(name+ " eat "+thing);
		// 	return 10;
		// };
		// 带返回值(只有一行代码)
		IEat ieat4 = (final String thing, final String name) -> name == null ? 1 : 0;
		ieat4.eat("apple", "大冰");

		IEat.method();
	}
}
// 只有一个抽象方法的接口
interface IEat{
	public int eat(final String thing, final String name);
  // 默认方法与静态方法并不影响函数式接口的契约，可以任意使用
	public default void print() {
		System.out.println("print test");
	}
	public static void method() {
		System.out.println("static method..");
	}
}
```

### 文件与IO

#### File类

可以实现文件的创建、删除、重命名、得到路径、创建时间等等，是唯一与文件本身有关的操作类。

##### File类方法

| 方法                                   | 释义                       |
| -------------------------------------- | -------------------------- |
| public static final String   separator | 表示路径分隔符“\”          |
| public File(String pathname)           | 构造File类实例，要传入路径 |
| public String[] list()                 | 列出文件夹中的文件名      |
| public File[] listFiles()              | 列出文件夹中的所有文件   |
| public boolean createNewFile()         | 创建新文件                 |
| public boolean mkdir()             		 | 创建新的文件夹           |
| public boolean delete()                | 删除文件                   |
| public boolean isDirectory()           | 判断给定的路径是否是文件夹 |
| public boolean isFile()            		 | 判断给定的路径是否是文件 |
| public boolean renameTo(File dest)     | 为文件重命名/移动文件    |
| public long length()                   | 返回文件大小             |
| String getPath()                       | 路径名字符串。           |

```java
// ====== File类的使用 ======
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
public class FileDemo {
	public static void main(String[] args) {
		// File类表示一个文件或目录
		// C:\\test\\vince.txt
		File f1 = new File("c:" + File.separator + "test" + File.separator + "vince.txt");
		if(!f1.exists()){ // 判断文件是否存在
			try {
				f1.createNewFile(); // 创建文件
				System.out.println("文件创建成功");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println("是否为文件：" + f1.isFile());
		System.out.println("是否为文件夹：" + f1.isDirectory());

		File f2 = new File("c:\\test\\my");
		boolean b = f2.delete(); // 删除文件
		String[] names = f2.list(); // 列出当前目录下的所有文件名
		System.out.println(Arrays.toString(names));

		File[] fs = f2.listFiles(); // 列出当前目录下的所有文件，以file对象返回
		for(File f: fs){
			System.out.println("length=" + f.length()); // 文件长度
			System.out.println("name=" + f.getName()); // 文件名
			System.out.println("相对路径=" + f.getPath()); // 相对于项目
			System.out.println("绝对路径=" + f.getAbsolutePath());
			System.out.println("是否为隐藏文件=" + f.isHidden());
			System.out.println("是否可读文件=" + f.canRead());
			Date date = new Date(f.lastModified()); // 文件最后修改时间
			DateFormat df = new SimpleDateFormat("HH:mm:ss");
			System.out.println("文件最后修改的时间=" + df.format(date));
		}

		File f3 = new File("temp.txt");
		System.out.println(f3.getPath()); // 获取相对路径
		System.out.println(f3.getAbsolutePath()); // 获取绝对路径

		File f4 = new File("c:\\test\\dabin1");
		f4.mkdirs(); // 新建文件夹
		// f4.renameTo(new File("c:\\test\\dabin2")); // 重命名文件
		f4.renameTo(new File("c:\\dabin1")); // 移动文件

		// 添加文件过滤条件
		File f5 = new File("c:\\test\\my");
		// File[] files = f5.listFiles(new FileFilter() {
		// 	@Override
		// 	public boolean accept(File pathname) {
		// 		return pathname.getName().endsWith(".txt");
		// 	}
		// });
		File[] files = f5.listFiles((pathname) -> pathname.getName().endsWith(".txt"));
		for(File f:files){
			System.out.println(f.getName());
		}
	}
}
```

#### IO流

- 根据处理数据类型的不同分为：**字符流** 和 **字节流**

- 根据数据流向不同分为：**输入流** 和 **输出流**

![](https://upload-images.jianshu.io/upload_images/5097954-58affea05274b720.png)

#### 字节流

- **每次只会操作一个字节**

##### OutputStream类 (字节输出流)

- public **abstract class** OutputStream extends Object implements Closeable, Flushable

- **此抽象类是表示输出字节流的所有类的超类**，输出流接受输出字节并将这些字节发送到 InputStream 类某个接收器要向文件中输出，使用 **FileOutputStream** 文件操作类

##### InputStream类 (字节输入流)

- public **abstract class** InputStream extends Object implements Closeable 

- **此抽象类是表示字节输入流的所有类的超类**，使用 **FileInputStream** 文件操作类从文件系统中的某个文件中获得输入字节

```java
// ====== 字节输入输出流 ======
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
public class ByteStreamDemo {
  // === 字节输入流 ===
	private static void in(){
		File file = new File("c:\\test\\vince.txt"); // 确定目标文件
		try {
			InputStream in = new FileInputStream(file); // 构建一个文件输入流对象
			byte[] bytes = new byte[10];
			StringBuilder buf = new StringBuilder();
			int len = -1; // 表示每次读取到的字节长度
			// 把数据读入到数组中，并返回读取的字节数,当不等-1时，表示读取到数据，等于-1表示文件已经读完
			while((len = in.read(bytes)) != -1){
				// 根据读取到的字节数组，再转换为字符串内容，添加到 StringBilder 中
				buf.append(new String(bytes, 0, len));
			}
			System.out.println(buf); // 打印内容
			in.close(); // 关闭输入流
		} catch (FileNotFoundException|IOException e) {
			e.printStackTrace();
		}
	}
  // === 字节输出流 ===
	private static void out(){
		File file = new File("c:\\test\\vince.txt"); // 确定目标文件
		try {
      // 构建一个文件输出流对象(true表示追加内容)
			OutputStream out = new FileOutputStream(file, true);
			String info = "小河流水哗啦啦\r\n";// 输出的内容，\r\n表示换行
			// String lf = System.getProperty("line.separator"); // 获取换行符
			out.write(info.getBytes()); // 把内容写入到文件
			// out.write((info + lf).getBytes());
			out.close(); // 关闭输出流
		} catch (FileNotFoundException|IOException e) {
			e.printStackTrace();
		}
	}
}
```

#### 字符流

- **每次操作的单位是一个字符**

- 文件字符操作流会自带缓存，默认大小为1024字节，在缓存满后，或手动刷新缓存，或关闭流时会把数据写入文件

##### Writer类 (字符输出流)

- 写入字符流的抽象类，子类必须实现的方法仅有 write(char[], int, int)、flush() 和 close()。但是，多数子类将重写此处定义的一些方法，以提供更高的效率和/或其他功能。使用 **FileWriter** 文件操作类。

##### Reader类 (字符输入流)

- 用于读取字符流的抽象类，子类必须实现的方法只有 read(char[], int, int) 和 close()。但是，多数子类将重写此处定义的一些方法，以提供更高的效率和/或其他功能。使用 **FileReader** 文件操作类。

```java
// ====== 字符输入输出流 ======
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
public class CharStreamDemo {
  // === 字符输入流 ===
	private static void in() {
		File file = new File("c:\\test\\vince.txt");
		try {
			Reader in = new FileReader(file);
			char[] cs = new char[3];
			int len = -1;
			StringBuilder buf = new StringBuilder();
			while((len = in.read(cs)) != -1){
				buf.append(new String(cs, 0, len));
			}
			in.close();
		} catch (FileNotFoundException|IOException e) {
			e.printStackTrace();
		}
	}
  // === 字符输出流 ===
	private static void out() {
		File file = new File("c:\\test\\vince.txt");
		try {
			Writer out = new FileWriter(file, true);
			out.write(",村花到我家");
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
```

#### 如何选择使用字节流还是字符流

1. 一般操作**非**文本文件时，使用字节流。操作文本文件时，建议使用字符流。
2. 如果你确认你要处理的流是可打印的字符，那么使用字符流会看上去简单一点。如果不确认，那么用字节流总是不会错的。

#### 转换流

- **OutputStreamWriter：**可以将输出的字符流转换为字节流的输出形式
- **InputStreamReader：**将输入的字节流转换为字符流输入形式

```java
// ====== 转换流 ======
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.nio.charset.Charset;
public class ChangeStreamDemo {
  // === 字节输入流 转 字符输入流 ===
	private static void read(InputStream in){
		Reader reader = new InputStreamReader(in, Charset.defaultCharset());
		char[] cs = new char[1024];
		int len = -1;
		try {
			while((len = reader.read(cs)) != -1){
				System.out.println(new String(cs, 0, len));
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
  // === 字节输出流 转 字符输出流 ===
	private static void write(OutputStream out){
		Writer writer = new OutputStreamWriter(out, Charset.defaultCharset());
		try {
			writer.write("开开心心来玩耍\r\n");
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) throws FileNotFoundException {
		InputStream in = new FileInputStream("c:\\test\\vince.txt");
		read(in);
		OutputStream out = new FileOutputStream("c:\\test\\vince.txt");
		write(out);
	}
}
```

#### 缓存流

- 使用缓冲流的好处是，能够更高效的读写信息，原理是将数据先缓冲起来，然后一起写入或者读取出来。
- **BufferedInputStream**
  - 为另一个输入流添加一些功能，在创建 BufferedInputStream 时，会创建一个内部缓冲区数组，用于缓冲数据。
- **BufferedOutputStream**
  - 通过设置这种输出流，应用程序就可以将各个字节写入底层输出流中，而不必针对每次字节写入调用底层系统。
  - 内部默认的缓存大小是8KB，每次写入时存储到缓存中的byte数组中，当数组存满时，会把数组中的数据写入文件，并且缓存下标归零。
- **BufferedReader**
  - 从字符输入流中读取文本，缓冲各个字符，从而实现字符、数组和行的高效读取。
  - 内部使用 InputStreamReader( sun.nio.cs.StreamDecoder)，解码过程，byte > char。
  - 默认缓存大小是8K，但可以手动指定缓存大小，把数据进接读取到缓存中，减少每次转换过程,效率更高。
- **BufferedWriter**
  - 将文本写入字符输出流，缓冲各个字符，从而提供单个字符、数组和字符串的高效写入。 
  - 默认缓存大小是8K，但可以手动指定缓存大小，把数据进接读取到缓存中，减少每次转换过程,效率更高。

```java
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
public class BufferStreamDemo {
  // === 字节缓冲输入流 ===
	private static void byteReader(){
		File file = new File("c://test//vince.txt");
		try(BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file))) {
		// try {
		// 	InputStream in = new FileInputStream(file);
		// 	// 构造一个字节缓冲输入流
		// 	BufferedInputStream bis = new BufferedInputStream(in);
			byte[] bytes = new byte[1024];
			int len = -1;
			while((len = bis.read(bytes)) != -1){
				System.out.println(new String(bytes, 0, len));
			}
			// bis.close();
		} catch (FileNotFoundException|IOException e) {
			e.printStackTrace();
		}
	}
  // === 字节缓冲输出流 ===
	private static void byteWriter(){
		File file = new File("c://test//vince.txt");
		try {
			OutputStream out = new FileOutputStream(file);
			// 构造一个字节缓冲输出流
			BufferedOutputStream bos = new BufferedOutputStream(out);
			String info = "小河还是流水哗啦啦";
			bos.write(info.getBytes());
      bos.flush();
			bos.close();
		} catch (FileNotFoundException|IOException e) {
			e.printStackTrace();
		}
	}
  // === 字符缓冲输入流 ===
	private static void charReader(){
		File file = new File("c://test//vince.txt");
		try {
			Reader reader = new FileReader(file);
			// 构造一个字符缓冲输入流
			BufferedReader br = new BufferedReader(reader);
			char[] cs = new char[1024];
			int len = -1;
			while((len = br.read(cs)) != -1){
				System.out.println(new String(cs, 0, len));
			}
			br.close();
		} catch (FileNotFoundException|IOException e) {
			e.printStackTrace();
		}
	}
  // === 字符缓冲输出流 ===
	private static void charWriter(){
		File file = new File("c://test//vince.txt");
		try {
			Writer writer = new FileWriter(file);
			// 构造一个字符缓冲输出流
			BufferedWriter bw = new BufferedWriter(writer);
			bw.write("村花到我家");
			bw.flush();
			bw.close();
		} catch (FileNotFoundException|IOException e) {
			e.printStackTrace();
		}
	}
}
```

#### 打印流

- 很方便的进行输出**并打印到指定的文件**
- **PrintStream**：字节打印流
- **PrintWriter**：字符打印流

```java
// ====== 打印流 ======
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.Writer;
public class PrintStreamDemo {
  // === 字节打印流 ===
	private static void bytePrint(){
		File file = new File("c:\\test\\vince.txt");
		try {
			OutputStream out = new FileOutputStream(file);
			BufferedOutputStream bos = new BufferedOutputStream(out); // 加缓存
			PrintStream ps = new PrintStream(bos); // 增强打印功能
			ps.println("小河流水天天哗啦啦");
			ps.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
  // === 字符打印流 ===
	private static void charPrint(){
		File file = new File("c:\\test\\vince.txt");
		try {
			Writer out = new FileWriter(file);
			BufferedWriter bos = new BufferedWriter(out); // 加缓存
			PrintWriter pw = new PrintWriter(bos); // 增强打印功能
			pw.println("小河流水天天哗啦啦");
			pw.close();
		} catch (FileNotFoundException|IOException e) {
			e.printStackTrace();
		}
	}
}
```

#### 对象流

- 如果一个类创建的对象，需要被序列化，那么该类必须实现 **Serializable** 接口，Serializable 是一个标记接口，没有任何定义，为了告诉 JVM 该类对象可以被序列化。如果对象没有实现 Serializable 接口，会报抛**java.io.NotSerializableException** 的异常。
- **ObjectOutputStream**： 将 Java 对象的基本数据类型和图形写入 OutputStream，即 **序列化**。
- **ObjectInputStream**： 对以前使用 ObjectOutputStream 写入的基本数据和对象进行 **反序列化**。

##### transient关键字

如果用transient声明一个实例变量，当对象存储时，它的值不需要维持

**什么时候对象需要被序列化**

1. 把对象保存到文件中（存储到物理介质）
2. 对象需要在网络上传输

```java
// ====== 对象流 ======
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
public class ObjectStreamDemo {
	// === 对象序列化 (把对象写入文件：实际写入的是类名、属性名、属性类型、属性的值等) ===
	private static void writeObject(){
		Dog dog = new Dog("wangwang");
		File file = new File("c:\\test\\dog.obj");
		try {
			OutputStream out = new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(out);
			oos.writeObject(dog);
			oos.close();
		} catch (FileNotFoundException|IOException e) {
			e.printStackTrace();
		}
	}
	// === 反序列化的过程 (从文件中把对象的内容读取出来，还原成对象) ===
	private static void readObject(){
		File file = new File("c:\\test\\dog.obj");
		try {
			InputStream in = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(in);
			Dog dog = (Dog)ois.readObject();
			ois.close();
			System.out.println(dog);
		} catch (FileNotFoundException|IOException|ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}

// ====== Dog.java ======
import java.io.Serializable;
// 如果一个类创建的对象，需要被序列化，那么该类必须实现 Serializable 接口，
public class Dog implements Serializable{
	private static final long serialVersionUID = 1L;
	private String name;
	private transient int id; // 在序列化中被忽略
	public Dog() {
		super();
	}
	public Dog(String name) {
		super();
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
```

#### 字节数组流

- **场景**：可以让你**从一个字节数组来读取流**，或者当你有一个组件需要把数据写出到 OutputStream，但是你需要用到字节数组。
- 基于内存操作，内部维护着一个字节数组，我们可以利用流的读取机制来处理字符串。
- 无需关闭，因为字节数组流是基于内存的操作流，所以关闭也无效。
- **ByteArrayInputStream**：包含一个内部缓冲区，该缓冲区包含从流中读取的字节。内部计数器跟踪 read 方法要提供的下一个字节。 关闭 ByteArrayInputStream 无效。此类中的方法在关闭此流后仍可被调用，而不会产生任何 IOException。
- **ByteArrayOutputStream**：此类实现了一个输出流，其中的数据被写入一个 byte 数组。缓冲区会随着数据的不断写入而自动增长。可使用 toByteArray() 和 toString() 获取数据。 关闭 ByteArrayOutputStream 无效。此类中的方法在关闭此流后仍可被调用，而不会产生任何 IOException。

```java
// ====== 字节数组流 ======
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
public class ByteArrayStreamDemo {
	private static void byteArray(){
		String s = "12345676dfghjhg(*$$%^&SDFGHJ";
		ByteArrayInputStream bais = new ByteArrayInputStream(s.getBytes());
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		int curr = -1; // 每次读取的字节
		while((curr = bais.read()) != -1){
			if((curr >= 65 && curr <= 90) || (curr >= 97 && curr <= 122)){
				baos.write(curr);
			}
		}
		// 无需关闭，因为字节数组流是基于内存的操作流
    byte[] bs = baos.toByteArray(); // 获取 byte类型 数据
		System.out.println(baos.toString()); // 获取 String类型 数据
	}
}
```

#### 数据流

- **场景**：实现文件分割合并。
- 与机器无关的操作JAVA的**基本数据类型**。
- **DataInputStream**：数据输入流允许应用程序以与机器无关方式从底层输入流中读取基本 Java 数据类型。应用程序可以使用数据输出流写入稍后由数据输入流读取的数据。 DataInputStream 对于多线程访问**不一定安全**，线程安全是可选的，它由此类方法的使用者负责。
- **DataOutputStream**：数据输出流允许应用程序以适当方式将基本 Java 数据类型写入输出流中，然后，应用程序可以使用数据输入流将数据读入。 
- **注：读取的顺序要和写入的顺序保持一致。**

```java
// ====== 数据流 ======
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
public class DataStreamDemo {
  // === 数据流读取 ===
	private static void read(){
		File file = new File("c:\\test\\vince.dat");
		try {
			InputStream in = new FileInputStream(file);
			BufferedInputStream bis = new BufferedInputStream(in);
			DataInputStream dis = new DataInputStream(bis);
      // 注意：读取的顺序要和写入的顺序保持一致(见下方写入的顺序)
			int num = dis.readInt();
			byte b = dis.readByte();
			String s = dis.readUTF();
			System.out.println(num + "," + b + "," + s);
			dis.close();
		} catch (FileNotFoundException|IOException e) {
			e.printStackTrace();
		}
	}
  // === 数据流输出 ===
	private static void write(){
		File file = new File("c:\\test\\vince.dat");
		try {
			OutputStream out = new FileOutputStream(file);
			BufferedOutputStream bos = new BufferedOutputStream(out);
			DataOutputStream dos = new DataOutputStream(bos);
			dos.writeInt(10); // 写入4个字节
			dos.writeByte(1); // 写入1个字节
			dos.writeUTF("中");
			dos.close();
		} catch (FileNotFoundException|IOException e) {
			e.printStackTrace();
		}
	}
}
```

####  合并流

- **SequenceInputStream** ：表示其他输入流的逻辑串联，它从输入流的有序集合开始，并从第一个输入流开始读取，直到到达文件末尾，接着从第二个输入流读取，依次类推，直到到达包含的最后一个输入流的文件末尾为止。

##### 文件合并案例

```java
// ====== 文件分割合并示例 ======
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.SequenceInputStream;
import java.util.Enumeration;
import java.util.Vector;
public class FileDivisionMergeDemo {
	// === 文件的分割 targetFile: 要分割的目标文件, cutSize: 每个文件大小 ===
	private static void division(File targetFile, long cutSize) {
		if (targetFile == null) return;
		// 计算总分割的文件数
		int num = targetFile.length() % cutSize == 0 ? (int) (targetFile.length() / cutSize)
      : (int) (targetFile.length() / cutSize + 1);
		try {
			// 构造一个文件输入流
			BufferedInputStream in = new BufferedInputStream(new FileInputStream(targetFile));
			BufferedOutputStream out = null;
			byte[] bytes = null; // 每次要读取的字节数
			int len = -1; // 每次实际读取的长度
			int count = 0; // 每一个文件要读取的次数
			// 循环次为生成文件的个数
			for (int i = 0; i < num; i++) {
				out = new BufferedOutputStream(new FileOutputStream(
          new File("c:\\test\\" + (i + 1) + "-temp-" + targetFile.getName())));
				if (cutSize <= 1024) {
					bytes = new byte[(int) cutSize];
					count = 1;
				} else {
					bytes = new byte[1024];
					count = (int) cutSize / 1024;
				}
				while (count > 0 && (len = in.read(bytes)) != -1) {
					out.write(bytes, 0, len);
					out.flush();
					count--;
				}
				// 计算每个文件大小除于1024的余数，决定是否要再读取一次
				if (cutSize % 1024 != 0) {
					bytes = new byte[(int) cutSize % 1024];
					len = in.read(bytes);
					out.write(bytes, 0, len);
					out.flush();
				}
				out.close();
			}
			in.close();
		} catch (FileNotFoundException|IOException e) {
			e.printStackTrace();
		}
	}
	// === 文件合并 ===
	private static void merge(Enumeration<InputStream> es) {
		// 构造一个合并流
		SequenceInputStream sis = new SequenceInputStream(es);
		try {
			BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("c:\\test\\第01章_Java开发入门_01_计算机基本概念与DOS命令.avi"));
			byte[] bytes = new byte[1024];
			int len = -1;
			while((len = sis.read(bytes)) != -1){
				bos.write(bytes, 0, len);
				bos.flush();
			}
			bos.close();
			sis.close();
			System.out.println("合并完成.");
		} catch (FileNotFoundException|IOException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		File file = new File("c:\\第01章_Java开发入门_01_计算机基本概念与DOS命令.avi");
		division(file, 1024 * 1024 * 20);
		try {
			InputStream in1 = new FileInputStream(new File("c:\\test\\1-temp-第01章_Java开发入门_01_计算机基本概念与DOS命令.avi"));
			InputStream in2 = new FileInputStream(new File("c:\\test\\2-temp-第01章_Java开发入门_01_计算机基本概念与DOS命令.avi"));
			InputStream in3 = new FileInputStream(new File("c:\\test\\3-temp-第01章_Java开发入门_01_计算机基本概念与DOS命令.avi"));
			InputStream in4 = new FileInputStream(new File("c:\\test\\4-temp-第01章_Java开发入门_01_计算机基本概念与DOS命令.avi"));
			InputStream in5 = new FileInputStream(new File("c:\\test\\5-temp-第01章_Java开发入门_01_计算机基本概念与DOS命令.avi"));
			// 集合工具类，内部实现使用了数组
			Vector<InputStream> v = new Vector<>();
			v.add(in1);
			v.add(in2);
			v.add(in3);
			v.add(in4);
			v.add(in5);
			Enumeration<InputStream> es = v.elements();
			merge(es);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
```

#### 字符串流

- 以一个字符串为数据源，来构造一个**字符流**
- **场景**：在WEB开发中，我们经常要从服务器上获取数据，数据的返回格式通过是一个字符串（XML, JSON），我们需要把这个字符串构造成一个字符流，然后再用第三方的数据解析器来解析数据。

- **StringReader**：字符串输入流

- **StringWriter**：字符串输出流，可以用其回收在字符串缓冲区中的输出来构造字符串， 关闭 StringWriter 无效。此类中的方法在关闭该流后仍可被调用，而不会产生任何 IOException。

```java
// ====== 字符串流 ======
import java.io.IOException;
import java.io.StreamTokenizer;
import java.io.StringReader;
public class StringStreamDemo {
  // === 字符串输入流 ===
	private static void stringReader(){
		String info = "good good study day day up";
		StringReader sr = new StringReader(info);
		StreamTokenizer st = new StreamTokenizer(sr); // 流标记器
		int count = 0;
		while(st.ttype != StreamTokenizer.TT_EOF){ // 是否结束了流
			try {
				if(st.nextToken() == StreamTokenizer.TT_WORD){ // 读取一个单词时
					count++;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		sr.close();
		System.out.println("count=" + count);
	}
}
```

#### 管道流

- 管道输入流应该连接到管道输出流；管道输入流提供要写入管道输出流的所有数据字节。通常，数据由某个线程从 PipedInputStream 对象读取，并由其他线程将其写入到相应的 PipedOutputStream。不建议对这两个对象尝试使用单个线程，因为这样可能死锁线程。管道输入流包含一个缓冲区，可在缓冲区限定的范围内将读操作和写操作分离开。如果向连接管道输出流提供数据字节的线程不再存在，则认为该管道已损坏。
- **场景**：用于线程之间的数据通讯
- **案例**：一个线程写入，一个线程读取。如下：

```java
// ====== 管道流 ======
import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
// 写入数据的线程
class WriteThread implements Runnable {
	private PipedOutputStream pout; // 输出管道
	WriteThread(PipedOutputStream pout) {
		this.pout = pout;
	}
	public void run() {
		try {
			pout.write("一个美女...".getBytes()); // 管道输出流
			pout.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
// 读取数据的线程
class ReadThread implements Runnable {
	private PipedInputStream pin; // 输入管道
	ReadThread(PipedInputStream pin){
		this.pin = pin;
	}
	public void run(){
		try {
			byte[] buf = new byte[1024];
			int len = pin.read(buf); // read阻塞
			String s = new String(buf, 0, len);
			System.out.println("读到：" + s);
			pin.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
// Test
public class PipedStreamDemo {
	public static void main(String[] args) {
		PipedInputStream pin = new PipedInputStream();
	  PipedOutputStream pout = new PipedOutputStream();
	  try {
			pin.connect(pout); // 两个管道进行链接
		} catch (IOException e) {
			e.printStackTrace();
		}
		// 输入流与输出流连接
    ReadThread readTh   = new ReadThread(pin);
    WriteThread writeTh = new WriteThread(pout);
    new Thread(readTh).start();
    new Thread(writeTh).start();
	}
}
```

#### RandomAccessFile 类

- RandomAccessFile 是 IO 包的类，从 Object 直接继承而来。 只可以对文件进行操作，可以对文件进行读取和写入。
- 当模式为 **r** 时，文件不存在时会报异常。
- 当模式为 **rw** 时，文件不存在时，会自己动创建文件，当文件已经存在时不会对原有文件进行覆盖。
- RandomAccessFile 有强大的文件读写功能，其内部是大型 byte[]，可以通过seek()，getFilePointer()等方法操作的指针，方便对数据进行写入与读取。还可以对基本数据类型进行直接的读和写操作。
- **RandomAccessFile的绝大多数功能，已经被 jdk1.4 的 nio 的“内存映射文件(memory-mapped files)”给取代了，你该考虑一下是不是用“内存映射文件”来代替RandomAccessFile了**。

```java
// ====== RandomAccessFile 类 ======
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
public class RandromAccessFileDemo {
	public static void main(String[] args) {
		try {
			// 读取文件
			RandomAccessFile r = new RandomAccessFile("c:\\3D0.jpg", "r");
			// 写入文件
			RandomAccessFile w = new RandomAccessFile("c:\\test\\3D0.jpg", "rw");
			byte[] bytes = new byte[1024];
			int len = -1;
			while((len = r.read(bytes)) != -1){
				w.write(bytes,0,len);
			}
			w.close();
			r.close();
		} catch (FileNotFoundException|IOException e) {
			e.printStackTrace();
		}
	}
}
```

#### Properties 类

- 主要用于读取 Java 的 properties 配置文件，各种语言都有自己所支持的配置文件，配置文件中很多变量是经常改变的，这样做也是为了方便用户，让用户能够脱离程序本身去修改相关的变量设置。在 javaweb javaee 开发中通常会用到。
- **Properties** 不仅可以读取，还能够写入 properties 配置文件。**但是**，**ResouceBundle** 只能读取 properties 配置文件。

##### 方法

- **getProperty ( String key)**：用指定的键在此属性列表中搜索属性，也就是通过参数 key ，得到 key 所对应的 value。

- **load ( InputStream inStream)**：从输入流中读取属性列表（键和元素对），通过对指定的文件（比如说上面的 test.properties 文件）进行装载来获取该文件中的所有键 - 值对。以供 getProperty ( String key) 来搜索。

- **setProperty ( String key, String value)** ：调用 Hashtable 的方法 put ，它通过调用基类的 put 方法来设置 键 - 值对。

- **store ( OutputStream out, String comments)**：以适合使用 load 方法加载到 Properties 表中的格式，将此 Properties 表中的属性列表（键和元素对）写入输出流。与 load 方法相反，该方法将键 - 值对写入到指定的文件中去。

-  **clear ()**：清除所有装载的 键 - 值对，该方法在基类中提供。

```java
// ====== Properties 类 ======
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;
public class PropertiesDemo {
	public static String version = "";
	// 静态代码块，只会执行一次
	static{
		readConfig();
	}
	// === 读取 properties 配置文件 ===
	private static void readConfig(){
		Properties p = new Properties(); // 新建一个 Properties 类实例
		try
			// 通过当前线程的类加载器对象，来加载指定包下的配置文件，目录是相对于项目的根目录的
			InputStream in = Thread.currentThread().getContextClassLoader()
        .getResourceAsStream("com/res/config.properties");
			// InputStream in = new FileInputStream("com/res/config.properties"); // 目录会有问题
			p.load(in); // 将 properties 配置文件中的内容装载到 Properties 实例中
			version = p.getProperty("app.version"); // 从 Properties 实例中获取数据
			in.close();
		} catch (FileNotFoundException|IOException e) {
			e.printStackTrace();
		}
	}
  // === 写入 properties 配置文件 ===
	private static void writeConfig(String version){
		Properties p = new Properties();
		p.put("app.version", version); // 设置键值对到 Properties 实例中
		try {
			OutputStream out = new FileOutputStream("config.properties");
			p.store(out, "update config"); // 将 Properties 实例中的内容写入到 properties 配置文件中
			out.close();
		} catch (FileNotFoundException|IOException e) {
			e.printStackTrace();
		}
	}
}
```

#### 文件压缩与解压缩

- **ZipOutputStream**

  - 实现文件的压缩，创建新的 ZIP 输出流
  - ZipOutputStream(OutputStream out) 

  - **void putNextEntry(ZipEntry e) **：开始写入新的 ZIP 文件条目并将流定位到条目数据的开始处

  - **ZipEntry(String name)  **：使用指定名称创建新的 ZIP 条目

- **ZipInputStream**

  - 实现文件的解压，创建新的 ZIP 输入流

  - ZipInputStream(InputStream in) 

  - **ZipEntry getNextEntry() **：读取下一个 ZIP 文件条目并将流定位到该条目数据的开始处

```java
// ====== 文件压缩与解压缩 ======
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;
public class CompressionAndDecompressionDemo {
	// === 压缩 ===
	private static void compression(String zipFileName, File targetFile){
		System.out.println("正在压缩...");
		try {
			// 构造压缩的输出流
			ZipOutputStream out = new ZipOutputStream(new FileOutputStream(zipFileName));
			BufferedOutputStream bos = new BufferedOutputStream(out);
			zip(out, targetFile, targetFile.getName(), bos);
			bos.close();
			out.close();
		} catch (FileNotFoundException|IOException e) {
			e.printStackTrace();
		}
		System.out.println("压缩完成");
	}
	// zip
	private static void zip(ZipOutputStream zOut, File targetFile, String name,
                          BufferedOutputStream bos) throws IOException {
		if (targetFile.isDirectory()) { // 如果是个目录
			File[] files = targetFile.listFiles();
			if(files.length == 0){ // 处理空目录
				zOut.putNextEntry(new ZipEntry(name + "/"));
			}
			for (File f: files) { // 递归处理
				zip(zOut, f, name + "/" + f.getName(), bos);
			}
		} else { // 处理文件
			zOut.putNextEntry(new ZipEntry(name));
			InputStream in = new FileInputStream(targetFile);
			BufferedInputStream bis = new BufferedInputStream(in);
			byte[] bytes = new byte[1024];
			int len = -1;
			while((len = bis.read(bytes)) != -1){
				bos.write(bytes, 0, len);
			}
			bis.close();
		}
	}
	// === 解压 ===
	private static void decompression(String targetFileName, String parent){
		try {
			// 构造解压的输入流
			ZipInputStream zIn = new ZipInputStream(new FileInputStream(targetFileName));
			ZipEntry entry = null;
			File file = null;
			while((entry = zIn.getNextEntry()) != null && !entry.isDirectory()){
				file = new File(parent, entry.getName());
				if(!file.exists()){
					new File(file.getParent()).mkdirs(); // 创建此文件的上级目录
				}
				OutputStream out = new FileOutputStream(file);
				BufferedOutputStream bos = new BufferedOutputStream(out);
				byte[] bytes = new byte[1024];
				int len = -1;
				while((len = zIn.read(bytes)) != -1){
					bos.write(bytes, 0, len);
				}
				bos.close();
				System.out.println(file.getAbsolutePath() + " 解压成功");
			}
		} catch (FileNotFoundException|IOException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		compression("c:\\test.zip", new File("c:\\test"));
		decompression("c:\\test.zip", "C:\\QMDownload\\");
	}
}
```

#### 装饰者模式

- **Component**（被装饰对象基类）

  定义对象的接口，可以给这些对象动态增加职责；

- **ConcreteComponent**（具体被装饰对象）

  定义具体的对象，Decorator可以给它增加额外的职责；

- **Decorator**（装饰者抽象类）

  维护指向Component实例的引用，定义与Component一致的接口；

- **ConcreteDecorator**（具体装饰者）

  具体的装饰对象，给内部持有的具体被装饰对象增加具体的职责；

```java
// ====== 被装饰者的接口 ======
public interface Drink {
  float cost(); // 计算价格
  String description(); // 描述
}

// ====== 装饰者的基类 ======
public abstract class Decorator implements Drink{
	private Drink drink; // 要装饰的对象
	public Decorator(Drink drink){
		this.drink = drink;
	}
	@Override
	public float cost() {
		return drink.cost();
	}
	@Override
	public String description() {
		return drink.description();
	}
}

// ====== 具体的被装饰者类 豆浆 ======
public class SoyaBeanMilk implements Drink{
  @Override
  public float cost() {
    return 10f;
  }
  @Override
  public String description() {
    return "纯豆浆";
  }
}

// ====== 具体的装饰者类 豆浆+糖 ======
public class SugarDecorator extends Decorator {
	public SugarDecorator(Drink drink) {
		super(drink);
	}
	@Override
	public float cost() {
		return super.cost() + 1.0f;
	}
	@Override
	public String description() {
		return super.description() + "+糖";
	}
}

// ====== 具体的装饰者类 豆浆+鸡蛋 ======
public class EggDecorator extends Decorator {
	public EggDecorator(Drink drink) {
		super(drink);
	}
	@Override
	public float cost() {
		return super.cost() + 3.0f;
	}
	@Override
	public String description() {
		return super.description() + "+鸡蛋";
	}
}

// ====== 测试类 ======
public class Test {
	public static void main(String[] args) {
    // 回顾之前的例子
		// OutputStream out = new FileOutputStream("xxx");
		// BufferedOutputStream bos = new BufferedOutputStream(out);
		// PrintStream ps = new PrintStream(bos);
		// ps.print(..);
    
		// 自写的例子
		Drink drink = new SoyaBeanMilk();
		SugarDecorator sugar = new SugarDecorator(drink);
		EggDecorator egg = new EggDecorator(sugar);
		System.out.println("你点的豆浆是：" + egg.description()); // 你点的豆浆是：豆浆+糖+鸡蛋
		System.out.println("一共花了：" + egg.cost() + "元"); // 一共花了：14元
	}
}
```

### NIO

#### 要点

- **为什么要使用 NIO ?**

  - NIO 是 jdk1.4 加入的新包，NIO 的创建目的是为了让 Java 程序员可以实现高速 I/O 而无需编写自定义的本机代码。**NIO 将最耗时的 I/O 操作（即填充和提取缓冲区）转移回操作系统**，因而可以极大地提高速度。
  - 原来的 I/O 以 **流** 的方式处理数据，而NIO 以 **块** 的方式处理数据。

- **流与块的比较**

  - 面向流的 I/O 系统以 **一次一个字节** 地处理数据，一个输入流产生一个字节的数据，一个输出流消费一个字节的数据，不利的一面是，面向流的 I/O 通常相当慢。
  - 面向块的 I/O 系统以 **一次一个数据块** 的形式处理数据，每一个操作都在一步中产生或者消费一个数据块。按块处理数据比按(流式的)字节处理数据要快得多。但是，面向块的 I/O 缺少一些面向流的 I/O 所具有的优雅性和简单性。

- **缓冲区**

  - **在 NIO 库中，所有数据都是用缓冲区处理的**。在读取数据时，它是直接读到缓冲区中的。在写入数据时，它是写入到缓冲区中的。任何时候访问 NIO 中的数据，您都是将它放到缓冲区中。

  - **缓冲区实质上是一个数组**。通常它是一个字节数组，但是也可以使用其他种类的数组，但是一个缓冲区不 仅仅是一个数组，缓冲区提供了对数据的结构化访问，而且还可以跟踪系统的读/写进程。

  - **缓存区状态**

    - **position**：当前位置
    - **limit**：限制值
    - **capacity**：容量

  - **缓冲区类型**

    - 最常用的缓冲区类型是 ByteBuffer，一个 ByteBuffer 可以在其底层字节数组上进行 get/set 操作（即字节的获取和设置）。ByteBuffer 不是 NIO 中唯一的缓冲区类型，事实上，对于每一种基本 Java 类型都有一种缓冲区类型，如下：

    - ByteBuffer，CharBuffer，ShortBuffer，IntBuffer，LongBuffer，FloatBuffer，DoubleBuffer

- **Channel (通道)** 

  - Channel 是一个对象，可以通过它读取和写入数据。拿 NIO 与原来的 I/O 做个比较，通道就像是流。

  - 所有数据都通过 Buffer 对象来处理，您永远不会将字节直接写入通道中，相反，您是将数据写入包含一个或者多个字节的缓冲区。同样，您不会直接从通道中读取字节，而是将数据从通道读入缓冲区，再从缓冲区获取这个字节。
  - 执行顺序：程序  >  缓冲区  >  通道  >  文件

```java
// ====== 缓存区 ======
import java.nio.ByteBuffer;
public class NIODemo {
	public static void main(String[] args) {
		// 创建 一个字节缓冲区，申请内存空间为8字节
		ByteBuffer buf = ByteBuffer.allocate(8);
		System.out.println("position=" + buf.position()); // 0
		System.out.println("limit=" + buf.limit()); // 8
		System.out.println("capacity=" + buf.capacity()); // 8
		// 向缓冲区中写入数据
		buf.put((byte)10);
		buf.put((byte)20);
		buf.put((byte)30);
		buf.put((byte)40);
		System.out.println("position=" + buf.position()); // 4
		System.out.println("limit=" + buf.limit()); // 8
		System.out.println("capacity=" + buf.capacity()); // 8
		// 缓冲区反转，方便后续取数据(即执行 limit = position; position = 0; 操作)
		buf.flip();
		System.out.println("position=" + buf.position()); // 0
		System.out.println("limit=" + buf.limit()); // 4
		System.out.println("capacity=" + buf.capacity()); // 8
		// 开始取数据
		if(buf.hasRemaining()){ // 告知在当前位置和限制之间是否有元素
			// remaining() 返回当前位置与限制之间的元素数。
			for(int i = 0; i < buf.remaining(); i++){
				byte b = buf.get(i);
				System.out.println(b);
			 }
		}
    // 读取操作不会影响缓存区的状态变量
		System.out.println("position=" + buf.position()); // 0
		System.out.println("limit=" + buf.limit()); // 4
		System.out.println("capacity=" + buf.capacity());// 8
	}
}
```

##### 复制文件案例

```java
// ====== 复制文件案例 ======
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;
/**
 * IO操作的性能比较：
 * 1、内存映射最快
 * 2、NIO读写文件
 * 3、使用了缓存的IO流
 * 4、无缓存的IO流
 */
public class CopyFileDemo {
	// 通过文件通道实现文件的复制
	private static void copyFile() throws Exception{
    // 方式一 创建输入/输出文件的通道
		FileChannel fcIn = new FileInputStream("c:\\3D0.jpg").getChannel();
		FileChannel fcOut = new FileOutputStream("c:\\test\\3D0.jpg").getChannel();
		ByteBuffer buf = ByteBuffer.allocate(1024);
		while(fcIn.read(buf) != -1){
			buf.flip();
			fcOut.write(buf);
			buf.clear();
		}
		fcIn.close();
		fcOut.close();
	}
	// 方式二 通过内存映射实现 randomAccessFile 的文件的复制
	private static void randomAccessFileCopy() throws Exception{
		RandomAccessFile in = new RandomAccessFile("c:\\3D0.jpg", "r");
		RandomAccessFile out = new RandomAccessFile("c:\\test\\3D0.jpg", "rw");
    // 获取通道
		FileChannel fcIn = in.getChannel();
		FileChannel fcOut = out.getChannel();
		long size = fcIn.size(); // 输入流的字节大小
    // 将此文件的区域直接映射到内存中
		MappedByteBuffer inBuf = fcIn.map(MapMode.READ_ONLY, 0, size); // 输入流的缓冲区
		MappedByteBuffer outBuf = fcOut.map(MapMode.READ_WRITE, 0, size); // 输出流的缓冲区
		for(int i = 0; i < size; i++){
			outBuf.put(inBuf.get());
		}
		// 关闭（关闭通道时会写入数据块）
		fcIn.close();
		fcOut.close();
		in.close();
		out.close();
	}
}
```

#### Path 接口，Paths 类，Files 类

- **Path 接口，Paths 类**
  1. Path表示的是一个目录名序列，其后还可以跟着一个文件名，路径中第一个部件是根部件时就是绝对路径，例如 / 或 C:\ ，而允许访问的根部件取决于文件系统。
  2. 以根部件开始的路径是绝对路径，否则就是相对路径。
  3. 静态的Paths.get方法接受一个或多个字符串，字符串之间自动使用默认文件系统的路径分隔符连接起来（Unix是 /，Windows是 \ ），这就解决了跨平台的问题，接着解析连接起来的结果，如果不是合法路径就抛出 InvalidPathException 异常，否则就返回一个 Path 对象。

- asd

```java
// ====== Path 接口，Paths 类，Files 类 (JDK1.7) ======
import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;
public class PathFilesDemo {
	public static void main(String[] args) {
		File file = new File("c:\\test\\3D0.jpg");
		// === Path 接口, Paths 类===
		Path p1 = Paths.get("c:\\test", "3D0.jpg"); // c:\test\3D0.jpg
		Path p2 = file.toPath(); // c:\test\3D0.jpg
		// 其实 Paths.get() 内部就是采用 FileSystems.getDefault().getPath() 来获取Path的
		Path p3 = FileSystems.getDefault().getPath("c:\\test", "3D0.jpg"); // c:\test\3D0.jpg
		// === Files 类 ===
		Path p4 = Paths.get("c:\\test\\vince.txt");
		String info = "村花到我家，一起...";
		// 写入文件
		try {
			Files.write(p4, info.getBytes("gb2312"), StandardOpenOption.APPEND);
		} catch (IOException e) {
			e.printStackTrace();
		}
		// 读取文件
		try {
			byte[] bytes = Files.readAllBytes(p4);
			System.out.println(new String(bytes));
		} catch (IOException e) {
			e.printStackTrace();
		}
		// 复制文件
		try {
			Files.copy(p3, Paths.get("c:\\3D0.jpg"), StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			e.printStackTrace();
		}
		// 移动文件
		try {
			Files.move(p3, Paths.get("c:\\3D0.jpg"),StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			e.printStackTrace();
		}
		// 删除文件
		try {
			Files.delete(p3); // static boolean deleteIfExists(Path path)
		} catch (IOException e) {
			e.printStackTrace();
		}
		// 创建新目录，除了最后一个部件，其他必须是已存在的
		try {
			Files.createDirectory(Paths.get("c:\\BB"));
			// Files.createDirectories(path); // 创建多级不存在的目录
		} catch (IOException e) {
			e.printStackTrace();
		}
		// 创建文件
		try {
			Files.createFile(Paths.get("c:\\BB.txt"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		// 添加前/后缀创建临时文件或临时目录
		Path newPath = Files.createTempFile(dir, prefix, suffix);
		Path newPath = Files.createTempDirectory(dir, prefix);
	}
}
```

### 集合

集合中分为三大接口：**Collection**、**Iterator**、**Map**

![](https://upload-images.jianshu.io/upload_images/5097954-903ce322199c61ee.png)

https://upload-images.jianshu.io/upload_images/5097954-97764e273e4b9d1c.png

#### Collection 接口

- **定义：**public interface **Collection<E>** extends Iterable<E>
- Collection 层次结构中的 **根接口**。
- Collection **用于存储单个对象的集合**，表示一组对象，这些对象也称为 Collection 的元素。一些 Collection 允许有重复的元素，而另一些则不允许。一些 Collection 是有序的，而另一些则是无序的。JDK 不提供此接口的任何直接实现，它提供更具体的子接口（如 Set 和 List）实现。此接口通常用来传递 Collection，并在需要最大普遍性的地方操作这些 Collection。 

#### List 接口

- **定义：**public interface **List<E>** extends Collection<E>
- **有序且可以重复的 collection**（也称为**序列**）。
- 可以对列表中每个元素的插入位置进行精确地控制，用户可以根据元素的整数索引（在列表中的位置）访问元素，并搜索列表中的元素。
- 允许存放多个 null 元素。
- 具体的实现有常用的：**ArrayList**，**Vector**，**LinkedList**
- 在实际开发中，我们如何选择list的具体实现？
  1. 安全性问题
  2. 是否频繁插入，删除操作（LinkedList）
  3. 是否是存储后遍历

##### ArrayList 类

- **定义：**public class **ArrayList**<E> extends AbstractList<E> implements List<E>, RandomAccess, Cloneable, Serializable

- 实现原理：**采用动态对象数组实现**，默认构造方法创建了一个空数组
- 第一次添加元素，扩展容量为10，之后的扩充算法：原来数组大小 + 原来数组的一半
- **不适合进行删除或插入操作**
- 为了防止数组动态扩充次数过多，建议创建 ArrayList 时，给定初始容量
- **多线程中使用不安全，适合 在单线程访问时使用，效率较高**
- jdk1.2 开始

##### Vector 类

- **定义：**public class **Vector**<E> extends AbstractList<E> implements List<E>, RandomAccess, Cloneable, Serializable
- Vector 类可以实现可增长的对象数组。与数组一样，它包含可以使用整数索引进行访问的组件。但是，Vector 的大小可以根据需要增大或缩小，以适应创建 Vector 后进行添加或移除项的操作。 
- 实现原理：**采用动态对象数组实现**，默认构造方法创建了一个大小为10的对象数组
- 扩充的算法：当增量为0时，扩充为原来大小的2倍，当增量大于0时，扩充为原来大小 + 增量
- **不适合删除或插入操作**
- 为了防止数组动态扩充次数过多，建议创建 Vector 时，给定初始容量
- **线程安全，适合在多线程访问时使用，在单线程下使用效率较低**

##### LinkedList 类

- **定义：**public class **LinkedList**<E> extends AbstractSequentialList<E> implements List<E>, Deque<E>, Cloneable, Serializable
- 实现原理，**采用双向链表结构实现**
- **适合插入，删除操作，性能高。但 不适合查询操作**

```java
// ====== List 接口 ======
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;
public class ListDemo {
	// === ArrayList 类 ===
	private static void  arrayList(){
		List<String> list = new ArrayList<>();
		list.add("苍老师");
		list.add("李老师");
		// 遍历集合
		int size = list.size(); // 2 获取 List 的长度
		for(int i = 0; i < size; i++){
			System.out.println(list.get(i)); // 查询元素
		}
		System.out.println(list.contains("苍老师")); // true 是否包含指定元素
		list.remove("毕老师"); // 删除元素
		String[] array = list.toArray(new String[]{}); // List 转成数组
		for(String s: array){
			System.out.println(s);
		}
	}
	// === Vector 类 ===
	private static void vector(){
		Vector<String> v = new Vector<>();
		v.add("苍老师");
		v.add("李老师");
		for(int i = 0; i < v.size(); i++){
			System.out.println(v.get(i));
		}
	}
	// === LinkedList 类 ===
	private static void linkedList(){
		LinkedList<String> list = new LinkedList<>();
		list.add("苍老师");
		list.add("李老师");
		for(int i = 0;i < list.size(); i++){
			System.out.println(list.get(i));
		}
	}
}
```

#### Set 接口

- **定义：**public interface **Set<E>** extends Collection<E>
- 一个不包含重复元素的 collection。更确切地讲，set 不包含满足 e1.equals(e2) 的元素对 e1 和 e2，并且最多包含一个 null 元素。
- **无序的**（不保证顺序）
- **不允许重复元素**

- 具体的实现常用的有：**HashSet**、**TreeSet**、**LinkedHashSet**

- 选择要点：

  - 如果要排序，选择 treeSet

   * 如果不要排序，也不用保正顺序选择 HashSet
   * 不要排序，要保正顺序，选择 LinkedHashSet

##### TreeSet 类

- **定义：**public class **TreeSet**<E> extends AbstractSet<E> implements NavigableSet<E>, Cloneable, Serializable
- 实现原理：**基于TreeMap(二叉树数据结构)，对象需要比较大小，通过对象比较器来实现，因为对象比较器可以用来去除重复的元素**
- **有序的**，使用元素的自然顺序对元素进行排序，或者根据创建 set 时提供的 Comparator 进行排序，具体取决于使用的构造方法。
- **如果自定义的数据类，没有实现比较器接口，将无法添加到 TreeSet 集合中**

##### HashSet 类

- **定义：**public class **HashSet**<E> extends AbstractSet<E> implements Set<E>, Cloneable, Serializable

- 实现原理：**基于哈希表（实际上是一个 HashMap 实例）实现**，添加元素时把元素作为 HashMap 的 key 存储，HashMap 的 value 使用一个固定的 object 对象
- **不保证迭代顺序**，特别是它不保证该顺序恒久不变。
- **不允许重复**，可以有一个 null 元素
- 不保证顺序恒久不变
- 判断两个对象是否相同，**先** 判断两个对象的 **hashCode** 是否相同，如果不同，则两个对象不是同一个对象，如果相同，**再** 进行 **equals** 判断，equals 相同则是同一个对象，不同则不是同一个对比象。
- **自定义对象要认为属性值都相同时为同一个对象，有这种需求时，那么我们要重写对象所在类的 hashCode 和 equals 方法。**

##### LinkedHashSet 类

- **定义：**public class **LinkedHashSet**<E> extends HashSet<E> implements Set<E>, Cloneable, Serializable
- 实现原理：**哈希表+链表 实现，维护着一个运行于所有条目的双重链表。按照插入顺序（即将元素插入到 set 中的顺序）进行迭代。**
- 如何把对象存储到哈希表中：先计算对象的 hashCode 值，再对数组的长度求余数，来决定对象要存储在数组中的哪个位置

```java
// ====== Set 接口 ======
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;
public class SetDemo {
  // === TreeSet 类 ===
	private static void treeSet(){
		TreeSet<Cat> tree = new TreeSet<>(new CatComparator());
		Cat c1 = new Cat("miaomiao", 5, 1);
		Cat c2 = new Cat("huahua", 2, 2);
		tree.add(c1);
		tree.add(c2);
		System.out.println(tree.size());
		for(Cat c: tree){
			System.out.println(c);
		}
	}
  // === HashSet 类 ===
	private static void hashSet(){
		Set<String> set = new HashSet<>();
		set.add("飞飞");
		set.add("亮亮");
		set.add("关关");
		set.add("亮亮");
		System.out.println(set.size());
		String[] names = set.toArray(new String[]{});
		for(String s: names){
			System.out.println(s);
		}
		Cat c1 = new Cat("miaomiao", 5, 1);
		Cat c2 = new Cat("huahua", 2, 2);
		Set<Cat> cats = new HashSet<>();
		cats.add(c1);
		cats.add(c2);
		System.out.println(cats.size());
		for(Cat c: cats){
			System.out.println(c);
		}
		System.out.println("c1=" + c1.hashCode());
		System.out.println("c2=" + c2.hashCode());
	}
  // === LinkedHashSet 类 ===
	private static void linkedHashSet(){
		LinkedHashSet<Cat> set = new LinkedHashSet<>();
		Cat c1 = new Cat("miaomiao", 5, 1);
		Cat c2 = new Cat("huahua", 2, 2);
		set.add(c1);
		set.add(c2);
		for(Cat c: set){
			System.out.println(c);
		}
	}
}

// ====== Cat.java ======
public class Cat {
	private String name;
	private int age;
	private int id;
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	public int getAge() { return age; }
	public void setAge(int age) { this.age = age; }
	public int getId() { return id; }
	public void setId(int id) { this.id = id; }
	@Override
	public String toString() {
		return "Cat [name=" + name + ", age=" + age + ", id=" + id + "]";
	}
	public Cat(String name, int age, int id) {
		super();
		this.name = name;
		this.age = age;
		this.id = id;
	}
	public Cat() { super(); }
	@Override
	public int hashCode() {
		final int prime = 31; // 系数  31*1+5  * 31+1   11111
		int result = 1;
		result = prime * result + age;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		Cat other = (Cat) obj;
		if (age != other.age) return false;
		if (id != other.id) return false;
		if (name == null) {
			if (other.name != null) return false;
		} else if (!name.equals(other.name)) return false;
		return true;
	}
}
```

#### 集合遍历

- 遍历集合的方式有以下几种：**Iterator**，**ListIterator**，**Enumeration** ，**foreach**

- **其中 Iterator 的使用率最高，在 jdk1.5 后新增的 foreach 也被大量使用**

##### Iterator 接口

- 定义：public interface **Iterator**<E>
- 对 collection 进行迭代的迭代器。迭代器取代了 Enumeratio

| 方法              | 释义                                                       |
| ----------------- | ---------------------------------------------------------- |
| boolean hasNext() | 如果仍有元素可以迭代，则返回 true。                        |
| E next()          | 返回迭代的下一个元素。                                     |
| void remove()     | 从迭代器指向的 collection 中移除迭代器返回的最后一个元素。 |

##### ListIterator 接口

- 定义：public interface **ListIterator**<E> extends Iterator<E>
- 系列表迭代器，允许程序员按任一方向遍历列表、迭代期间修改列表，并获得迭代器在列表中的当前位置

| 方法                  | 释义                 |
| --------------------- | -------------------- |
| void add(E e)         | 增加元素             |
| boolean hasPrevious() | 判断是否有前一个元素 |
| E previous()          | 取出前一个元素       |
| void set(E e)         | 修改元素的内容       |
| int previousIndex()   | 前一个索引位置       |
| int nextIndex()       | 下一个索引位置       |

##### Enumeration 接口

- public interface **Enumeration<E>**

- 实现 Enumeration 接口的对象，它生成一系列元素，一次生成一个。连续调用 nextElement 方法将返回一系列的连续元素。
- **注：**此接口的功能与 Iterator 接口的功能是重复的。此外，Iterator 接口添加了一个可选的移除操作，并使用较短的方法名，新的实现应该优先考虑使用 Iterator 接口而不是 Enumeration 接口。

| 方法                      | 释义                 |
| ------------------------- | -------------------- |
| boolean hasMoreElements() | 判断是否有下一个元素 |
| E nextElement()           | 取出当前元素         |

##### forEach 方法

- 在使用 forEach 输出的时候 **一定要注意创建集合时要指定操作泛型的类型**。

```java
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
public class IteratorDemo {
	// === Iterator (1.5之前统一的迭代集合方式) ===
	private static void iterator(Collection<Cat> c){
		Iterator<Cat> iter = c.iterator();
		while(iter.hasNext()){
			System.out.println(iter.next());
		}
	}
	// === for(T t: ts) ===foreach(1.5后)
	private static void foreach(Collection<Cat> c){
		for(Cat cat: c){
			System.out.println(cat);
		}
	}
	// === forEach (jdk1.8新的迭代方法) === jdk1.8新的迭代方法
	private static void foreach(){
		List<String> list = new ArrayList<>();
		list.add("tom");
		list.add("jack");
		list.forEach(s -> System.out.println(s));
		// list.forEach(System.out::println);
	}
	// === Enumeration ===
	private static void enumeration(){
		Vector<String> vs = new Vector<>();
		vs.add("tom");
		vs.add("jack");
		Enumeration<String> es = vs.elements();
		while(es.hasMoreElements()){
			System.out.println(es.nextElement());
		}
	}
	public static void main(String[] args) {
		List<Cat> list = new ArrayList<>();
		list.add(new Cat("miaomiao", 5, 1));
		list.add(new Cat("huahua", 2, 2));
		iterator(list);
		foreach(list);
	}
}
```



#### 一些使用 lambda 表达式的常见接口 (jdk1.8)

```java
// ====== **定义** 一些使用 Lambda 表达式的常见接口的 (jdk1.8特性) ======
// === Consumer 消费者接口(有1个入参，没有返回值) ===
public interface Consumer<T> {
  void accept(T t);
}
// === Supplier 代表结果供应商(没有入参，只有返回值) ===
public interface Supplier<T> {
  T get();
}
// === Predicate 断言接口(有1个入参，返回布尔值) ===
public interface Predicate<T> {
  boolean test(T t);
}
// === Function 表示接受1个参数并产生结果的函数(有1个入参，也有返回值) ===
public interface Function<T, R> {
  R apply(T t);
}
// === BiFunction 表示接受2个参数并产生结果的函数(有2个入参，也有返回值) ===
public interface BiFunction<T, U, R> {
  R apply(T t, U u);
}
// ====== ** 使用 ** ======
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
public class IteratorDemo {
	// === Consumer 消费者接口(有一个入参，没有返回值) ===
	private static void consumerTest(){
		List<String> list = Arrays.asList("Larry", "Moe", "Curly", "Tom", "QF_vince");
		list.forEach(s -> selfPrint(s, c -> System.out.println(c)));
	}
	private static void selfPrint(String s, Consumer<String> c){
		c.accept(s);
	}
	// === Supplier 代表结果供应商(没有入参，只有返回值) ===
	private static void supplierTest(){
		List<Integer> list = getNums(10, () -> (int)(Math.random() * 100));
		list.forEach(System.out::println);
	}
	private static List<Integer> getNums(int num, Supplier<Integer> sup){
		 List<Integer> list = new ArrayList<>();
		 for(int i = 0; i < num; i++){
			 list.add(sup.get());
		 }
		 return list;
	}
	// === Predicate 断言接口(有一个入参，返回布尔值) ===
	private static void predicateTest(){
		List<String> list = Arrays.asList("Larry", "Moe", "Curly", "Tom", "QF_vince");
		List<String> result = filter(list, (s) -> s.contains("o"));
		result.forEach(System.out::println);
	}
	private static List<String> filter(List<String> list, Predicate<String> p){
		List<String> results = new ArrayList<>();
		for (String s : list) {
			if(p.test(s)){ // 测试是否符合要求
				results.add(s);
			}
		}
		return results;
	}
	// === Function 表示接受一个参数并产生结果的函数(有一个入参，也有返回值) ===
	private static void functionTest(){
		String s = strToUpp("qf_vince", (str) -> str.toUpperCase());
		System.out.println(s);
	}
	public static String strToUpp(String str, Function<String, String> f){
		return f.apply(str);
	}
}
```

#### Stream 接口 (jdk1.8)

- 不是存储数据结构，数据源可以是一个集合，为了函数式编程创造 
- **惰式执行，数据只能被消费一次**
- 两种类型的操作方法
  - 中间操作（生成一个Stream）
  - 结束操作（执行计算操作）

| 返回值        | 方法                                                         | 释义                                                         |
| ------------- | ------------------------------------------------------------ | ------------------------------------------------------------ |
| <R> Stream<R> | map(Function<? super T, ? extends R> mapper)                 | 返回由给定函数应用于此流的元素的结果组成的流。               |
| <R> Stream<R> | flatMap(Function<? super T, ? extends Stream<? extends R>> mapper) | 返回由通过将提供的映射函数应用于每个元素而产生的映射流的内容来替换该流的每个元素的结果的流。 |
| Stream<T>     | filter(Predicate<? super T>   predicate)                     | 返回由与此给定谓词匹配的此流的元素组成的流。                 |
| void          | forEach(Consumer<? super T>   action)                        | 对此流的每个元素执行操作。                                   |
| Optional<T>   | findFirst()                                                  | 返回描述此流的第一个元素的Optional如果流为空，则返回一个空的Optional   。 |
| Optional<T>   | reduce(BinaryOperator<T>   accumulator)                      | 使用associative累积函数对此流的元素执行 reduction，并返回描述减小值的 Optional （如果有）。 |
| Stream<T>     | peek(Consumer<? super T> action)                             | 返回由该流的元素组成的流，另外在从生成的流中消耗元素时对每个元素执行提供的操作。 |
| Stream<T>     | sorted()                                                     | 返回由此流的元素组成的流，根据自然顺序排序。                 |

```java
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
public class StreamDemo {
	public static void main(String[] args) {
		// 获取 stream 流
		Stream<String> stream1 = Stream.of("good", "good", "study", "day", "day", "up");
		// count(获取集合中元素的数量)
		System.out.println(stream1.count());
		// foreach(遍历)
		stream1.forEach(str -> System.out.println(str));
		// stream1.forEach(System.out::println);
		// filter(过滤)
		stream1.filter(s -> s.length() > 3).forEach(System.out::println);
		// distinct(去重)
		stream1.distinct().forEach(s -> System.out.println(s));
		// map(遍历得到结果的集合)
		stream1.map(s -> s.toUpperCase()).forEach(s -> System.out.println(s));
		// flatMap(合并)
		Stream<List<Integer>> stream2 = Stream.of(Arrays.asList(1, 2, 3), Arrays.asList(4, 5));
		stream2.flatMap(list -> list.stream()).forEach(System.out::println);
		// reduce(聚合)
		Optional<String> opt = stream1.reduce((s1, s2) -> s1.length() >= s2.length() ? s1 : s2);
		System.out.println(opt.get());
		// 返回一个 IntStream，其中包含将给定函数应用于此流的元素的结果
		System.out.println(stream1.mapToInt(s -> s.length()).sum());
		// collect(把 stream 转换成 List/Set/Map)
		List<String> list = stream1.collect(Collectors.toList());
		list.forEach(s -> System.out.println(s));
		// :: 方法引用
		// 引用静态方法     	Integer::valueOf
		// 引用对象的方法  	list::add
		// 引用构造方法			ArrayList::new
	}
}
```

#### Map 接口

- 定义：public interface **Map**<K, V>
- 键值对存储一组对象，**Key不能重复（唯一），Value可以重复**
- 具体的实现类：HashMap TreeMap Hashtable LinkedHashMap

| 方法                       | 释义          |
| --------------------------------------------- | ------------------------------- |
| void clear()                        | 清空Map集合中的内容           |
| boolean containsKey(Object   key)   | 判断集合中是否存在指定的key   |
| boolean containsValue(Object value) | 判断集合中是否存在指定的value |
| Set<Map.Entry<K,V>>   entrySet()    | 将Map接口变为Set集合          |
| V get(Object key)                   | 根据key找到其对应的value      |
| boolean isEmpty()                             | 判断是否为空                    |
| Set<K> keySet()                               | 将全部的key变为Set集合          |
| Collection<V> values()                        | 将全部的value变为Collection集合 |
| V put(K key,V   value)                        | 向集合中增加内容                |
| void putAll(Map<? extends K,?   extends V> m) | 增加一组集合                    |
| V remove(Object key)                          | 根据key删除内容                 |

##### HashMap

- public class **HashMap**<K, V> extends AbstractMap<K, V>  implements Map<K,V>, Cloneable, Serializable

- 基于哈希表（数组+链表+二叉树(红黑树) ）的 Map 接口的实现。此实现提供所有可选的映射操作，并允许使用 null 值和 null 键。（除了非同步和允许使用 null 之外，HashMap 类与 Hashtable 大致相同。）此类不保证映射的顺序，特别是它不保证该顺序恒久不变。
- 默认加载因子为 0.75，默认数组大小是 16
- **存储原理：**
  - 把 key 对象通过 hash() 方法计算 hash 值，然后用这个 hash 值对数组长度取余数（默认16），来决定该对 key 对象
  - 在数组中存储的位置 ，当这个位置有多个对象时，以链表结构存储，JDK1.8 后，当链表长度大于8时，链表将转换为红黑树结构存储。这样的目的，是为了取值更快，存储的数据量越大，性能的表现越明显

- **扩充原理：**当数组的容量超过了 75% 时，当前数组容量 <<1 （相当于是乘2），扩大1倍，扩充次数过多，会影响性能，每次扩充表示哈希表重新散列（重新计算每个对象的存储位置），我们在开发中尽量要减少扩充次数带来的性能问题。

 * **线程不安全，适合在单线程中使用**

##### Hashtable

- public class **Hashtable**<K, V> extends Dictionary<K, V> implements Map<K,V>, Cloneable, Serializable

- 基于哈希表实现（数组+链表），该哈希表将键映射到相应的值。任何非 null 对象都可以用作键或值。 为了成功地在哈希表中存储和获取对象，**用作键的对象必须实现 hashCode 方法和 equals 方法**。
- 加载因子 0.75，默认数组大小为 11
- **扩充方式：**原数组大小 <<1 (*2) +1
- **线程安全的，用在多线程访问时**

##### LinkedHashMap

- public class **LinkedHashMap**<K, V> extends HashMap<K, V> implements Map<K, V>

- LinkedHashMap 是 HashMap 的子类，由于 HashMap 不能保正顺序恒久不变，此类使用一个双重链表来维护元素添加的顺序。

##### TreeMap

- public class **TreeMap**<K, V> extends AbstractMap<K, V> implements NavigableMap<K, V>, Cloneable, Serializable

- 基于二叉树（红黑树）的实现，该映射根据其键的自然顺序进行排序，或者根据创建映射时提供的 Comparator 进行排序，具体取决于使用的构造方法。 

```java
// ====== Map ======
import java.util.Collection;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
public class MapDemo {
	// === TreeMap ===
	private static void treeMap(){
		Map<String, String> map = new TreeMap<>();
		// map.put("one", "Lily");
		// map.put("two", "Tom");
		// map.forEach((key, value) -> System.out.println(key + "->" + value));
		Map<Dog, String> dogs = new TreeMap<>();
		dogs.put(new Dog(1, "2ha", 3), "dog1");
		dogs.put(new Dog(1, "wangwang", 2), "dog2");
		dogs.put(new Dog(3, "hsq", 4), "dog3");
		dogs.forEach((key, value) -> System.out.println(key + "->" + value));
	}
	// === LinkedHashMap ===
	private static void linkedHashMap(){
		Map<String, String> table = new LinkedHashMap<>();
		table.put("one", "Lily");
		table.put("two", "Tom");
		table.forEach((key, value) -> System.out.println(key + "->" + value));
	}
	// === Hashtable ===
	private static void hashtable(){
		Map<String, String> table = new Hashtable<>();
		table.put("one", "Lily");
		table.put("two", "Tom");
		table.forEach((key, value) -> System.out.println(key + "->" + value));
	}
	// === HashMap ===
	private static void hashMap(){
		Map<Integer,String> map = new HashMap<>();
		map.put(1, "Tom");
		map.put(2, "Jack");
		System.out.println("size=" + map.size()); // 获取元素的数量
		System.out.println(map.get(1)); // 通过 key 取 value
		// === Map的遍历 ===
		// 1 遍历Entry
		Set<Entry<Integer, String>> entrySet = map.entrySet();
		for(Entry e: entrySet){
			System.out.println(e.getKey() + "->" + e.getValue());
		}
		// 2 遍历键
		Set<Integer> keys = map.keySet();
		for(Integer i: keys){
			String value = map.get(i);
			System.out.println(i + "->" + value);
		}
		// 3 遍历值
		Collection<String> values = map.values();
		for(String value: values){
			System.out.println(value);
		}
		// 4 foreach
		map.forEach((key, value) -> System.out.println(key + "->" + value));
		// 判断集合中是否存在指定的key
		System.out.println(map.containsKey(7));
		// 判断集合中是否存在指定的value
		System.out.println(map.containsValue("Vince"));
	}
}

// ====== Dog.java ======
public class Dog implements Comparable<Dog>{
	private int id;
	private String name;
	public int getId() { return id; }
	public void setId(int id) { this.id = id; }
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	public Dog(int id, String name, int age) {
		super();
		this.id = id;
		this.name = name;
	}
	public Dog() { super(); }
	@Override
	public String toString() {
		return "Dog [id=" + id + ", name=" + name + "]";
	}
	@Override
	public int compareTo(Dog o) {
		return this.id - o.id;
	}
}
```

##### Map 接口的新方法 (jdk1.8)

```java
// ====== Map 接口的新方法 (jdk1.8) ======
import java.util.HashMap;
import java.util.Map;
public class MapNewMethodDemo {
	public static void main(String[] args) {
		Map<Integer, String> map = new HashMap<>();
		map.put(1, "jack");
		map.put(2, "tom");
		// 获取，没有的话使用默认值
		String value = map.getOrDefault(4, "null");
		// 只会添加不存在相同 key 的值
		String val = map.putIfAbsent(3, "vince");
		// 根据键和值都匹配时才删除
		map.remove(1, "jack");
    // key 存在时才会用 vince 替换
		map.replace(3, "vince");
    // key 和 value 都相等时才会用 vince 替换
		map.replace(3, "lily", "vince");
		// 把Lambda表达式计算后的值作为该key对应的键值
		map.compute(1, (k, v1) -> v1 + "1");
    // 如果指定的 key 不存在(或映射到 null),才把Lambda表达式计算后的值作为该key对应的键值，否则保持不变
		map.computeIfAbsent(5, val -> val + "test"); // value key
		// 如果指定的 key 不存在则把 888 put到该key对应的键值，如果存在，则把Lambda表达式计算后的值作为该key对应的键值
		map.merge(8, "888", (oldVal, newVal) -> oldVal.concat(newVal));
		map.forEach((k, v) -> System.out.println(k + "->" + v));
	}
}
```

#### Collections 类

- Collections工具类提供了大量针对Collection/Map的操作，总体可分为四类，都为静态（static）方法。

1. **排序操作（主要针对 List 接口相关）**

   - **reverse**(List list)：**反转 **指定 List 集合中元素的顺序
   - **shuffle**(List list)：对 List 中的元素进行 **随机排序**（洗牌）
   - **sort**(List list)：对List里的元素 **根据自然升序排序**
   - **sort**(List list, Comparator c)：**自定义比较器进行排序**
   - **swap**(List list, int i, int j)：将指定List集合中 i 处元素和 j 出元素进行 **交换**
   - **rotate**(List list, int distance)：将所有元素向 **右移** 位指定长度，如果 distance 等于 size 那么结果不变

2. **查找和替换（主要针对 Collection 接口相关）**

   - **binarySearch**(List list, Object key)：使用 **二分搜索法**，以获得指定对象在 List 中的索引，前提是集合已经排序

   - **max**(Collection coll)：返回 **最大元素**

   - **max**(Collection coll, Comparator comp)：**根据自定义比较器，返回最大元素**

   - **min**(Collection coll)：返回 **最小元素**

   - **min**(Collection coll, Comparator comp)：**根据自定义比较器，返回最小元素**

   - **fill**(List list, Object obj)：使用指定对象 **填充**

   - **frequency**(Collection Object o)：返回指定集合中 **指定对象出现的次数**

   - **replaceAll**(List list, Object old, Object new)：**替换**

3. **同步控制**

   - Collections 工具类中提供了多个 synchronizedXxx 方法，该方法返回指定集合对象对应的同步对象，从而解决多线程并发访问集合时线程的安全问题。HashSet、ArrayList、HashMap都是线程不安全的，如果需要考虑同步，则使用这些方法。这些方法主要有：synchronizedSet、synchronizedSortedSet、synchronizedList、synchronizedMap、synchronizedSortedMap。

   - **特别需要指出的是，在使用迭代方法遍历集合时需要手工同步返回的集合。**

4. **设置不可变集合**

   - Collections 有三类方法可返回一个不可变集合：
     - **emptyXxx()**：返回一个空的不可变的集合对象
     - **singletonXxx()**：返回一个只包含指定对象的，不可变的集合对象。
     - **unmodifiableXxx()**：返回指定集合对象的不可变视图

5. **其它**

   - **disjoint**(Collection<?> c1, Collection<?> c2) ：如果两个指定 collection 中没有相同的元素，则返回 true

   - **addAll**(Collection<? super T> c, T... a) ：将所有指定元素添加到指定 collection 中

   - Comparator<T> **reverseOrder**(Comparator<T> cmp) ：返回一个比较器，它强行反转指定比较器的顺序。如果指定比较器为 null，则此方法等同于 reverseOrder()（换句话说，它返回一个比较器，该比较器将强行反转实现 Comparable 接口那些对象 collection 上的自然顺序）

#### Optional 容器类（jdk1.8）

这是一个可以为 null 的容器对象，如果值存在则 isPresent() 方法会返回 true，调用 get() 方法会返回该对象

- **of：**为非 null 的值创建一个 Optional

- **ofNullable：**为指定的值创建一个 Optional，如果指定的值为 null，则返回一个空的 Optional

- **isPresent：**如果值存在返回 true，否则返回 false

- **get：**如果 Optional 有值则将其返回，否则抛出 NoSuchElementException

- **ifPresent：**如果 Optional 实例有值则为其调用 consumer，否则不做处理

- **orElse：**如果有值则将其返回，否则返回指定的其它值
- **orElseGet：**orElseGet 与 orElse 方法类似，区别在于得到的默认值。orElse 方法将传入的字符串作为默认值，orElseGet 方法可以接受 Supplier 接口的实现用来生成默认值

- **orElseThrow：**如果有值则将其返回，否则抛出 supplier 接口创建的异常

- **map：**如果有值，则对其执行调用mapping函数得到返回值。如果返回值不为 null，则创建包含 mapping 返回值的 Optional 作为 map 方法返回值，否则返回空 Optional

- **flatMap：**如果有值，为其执行 mapping 函数返回 Optional 类型返回值，否则返回空 Optional。flatMap 与map（Funtion）方法类似，区别在于 flatMap 中的 mapper 返回值必须是 Optional。调用结束时，flatMap不会对结果用Optional封装

- **filter：**如果有值并且满足断言条件返回包含该值的 Optional，否则返回空 Optional

```java
// ====== Collections 工具类 ======
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class CollectionsDemo {
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("jack");
		list.add("lily");
		list.add("lily");
		Collections.reverse(list); // 反转
		Collections.shuffle(list); // 随机排序
		Collections.sort(list); // 根据自然升序排序
		Collections.sort(list, c); // 自定义比较器进行排序
		Collections.swap(list, 0, 2); // 交换
		Collections.rotate(list, 1); // 右移
  	// 需要事先排好序的list否则可能会找不到
		System.out.println(Collections.binarySearch(list, "tom")); // 二分搜索法
		System.out.println(Collections.max(list)); // 最大元素
		System.out.println(Collections.min(list)); // 最小元素
		Collections.fill(list, "bin"); // 填充
		System.out.println(Collections.frequency(list, "lily")); // 指定对象出现的次数
		Collections.replaceAll(list, "lily", "bin"); // 替换
    // 返回指定集合对象对应的同步对象
		List<String> syncList = Collections.synchronizedList(new ArrayList<String>());
		List<String> sList = Collections.emptyList(); // 返回一个空的不可变的集合对象
		sList.add("bin");
    // 返回一个比较器，它强行反转指定比较器的顺序
		Collections.sort(list,Collections.reverseOrder());
		System.out.println(list);
	}
}

// ====== Optional JDK1.8 容器类 ======
import java.util.Optional;
public class OptionalDemo {
	public static void main(String[] args) {
		// // 为非 null 的值创建一个 Optional
		Optional<String> optional = Optional.of("bin");
		// 为指定的值创建一个 Optional，如果指定的值为 null，则返回一个空的 Optional
		Optional<String> optional2 = Optional.ofNullable("bin");
		Optional<String> optional3 = Optional.empty();
		// 如果值存在返回 true，否则返回 false
		System.out.println(optional.isPresent());
		// 如果 Optional 有值则将其返回，否则抛出 NoSuchElementException
		System.out.println(optional.get());
		// 如果 Optional 实例有值则为其调用 consumer，否则不做处理
		optional.ifPresent(value -> System.out.println(value));
		// 如果有值则将其返回，否则返回指定的其它值
		System.out.println(optional.orElse("无值"));
		// 接受 Supplier 接口的实现用来生成默认值
		System.out.println(optional.orElseGet(() -> "default"));
		try {
			// 如果有值则将其返回，否则抛出 supplier 接口创建的异常
			optional3.orElseThrow(Exception::new);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 如果有值，则对其执行调用mapping函数得到返回值。如果返回值不为 null，则创建包含 mapping 返回值的 Optional 作为 map 方法返回值，否则返回空 Optional
		Optional<String> optional4 = optional.map(value -> value.toUpperCase());
		System.out.println(optional4.orElse("no found"));
		// 如果有值，为其执行 mapping 函数返回 Optional 类型返回值，否则返回空 Optional
		optional4 = optional.flatMap(value -> Optional.of(value.toUpperCase() + "-flatMap"));
		System.out.println(optional4.orElse("no found"));
		// 如果有值并且满足断言条件返回包含该值的 Optional，否则返回空 Optional
		optional4 = optional.filter(value -> value.length() > 3);
		System.out.println(optional4.orElse("这个值的长度小于3"));
	}
}
```

#### Queue，Deque 接口，Stack类

```java
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
public class QueueDequeDemo {
	// === Queue 接口 (队列，先进先出) ===
	private static void queue(){
    // LinkedList 类实现了 queue 接口
		Queue<String> queue = new LinkedList<>();
		// 入队
		queue.add("小花");
		queue.add("小黑");
		queue.add("小小");
		System.out.println(queue.size());
		// 获取但不移除此队列的头；如果此队列为空，则返回 null
		System.out.println(queue.peek());
		// 获取并移除此队列的头，如果此队列为空，则返回 null
		System.out.println(queue.poll());
	}
	// === Deque 接口 (双端队列，支持在两端插入和移除元素) ===
	private static void deque(){
		Deque<String> deque = new LinkedList<>();
		deque.add("小花");
		deque.add("小黑");
		deque.add("小小");
		System.out.println(deque.getFirst());
		System.out.println(deque.getLast());
	}
	// === Stack 类 (栈，先进后出) ===
	private static void stack(){
		Stack<String> s = new Stack<>();
		// 压栈
		s.push("Bin");
		s.push("Tom");
		s.push("Lily");
		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.pop());
	}
}
```

#### 迭代器设计模式

- **迭代器角色（Iterator）: **定义遍历元素所需要的方法，一般来说会有这么三个方法：取得下一个元素的方法next()，判断是否遍历结束的方法 hasNext()），移出当前对象的方法 remove(),

- **具体迭代器角色（Concrete Iterator）：**实现迭代器接口中定义的方法，完成集合的迭代。

- **容器角色(Aggregate)：**一般是一个接口，提供一个 iterator() 方法，例如 java 中的 Collection 接口，List 接口，Set 接口等

- **具体容器角色（ConcreteAggregate）：**就是抽象容器的具体实现类，比如 List 接口的有序列表实现ArrayList，List 接口的链表实现 LinkedList，Set 接口的哈希列表的实现 HashSet 等。

```java
// ====== 容器的接口 ======
public interface MyList {
  void add(Object e);
  Object get(int index);
  Iterator iterator();
  int getSize();
}

// ====== 迭代器的接口 ======
public interface Iterator {
  public boolean hasNext();
  public Object next();
}

// ====== 迭代器接口的具体实现类 ======
public class ConcreteIterator implements Iterator{
	private MyList list = null;
	private int index; // 迭代器的指针
	public ConcreteIterator(MyList list) { this.list = list; }
	@Override
	public boolean hasNext() {
		if(index >= list.getSize())
			return false;
		else return true;
	}
	@Override
	public Object next() {
		Object obj = list.get(index);
		index++;
		return obj;
	}
}

// ====== 容器接口的具体实现类 ======
public class ConcreteAggregate implements MyList{
	private Object[] elements; // 对象数组
	private int size;
	private int index;
	public ConcreteAggregate() { elements = new Object[100]; }
	@Override
	public void add(Object e) {
		elements[index++] = e;
		size++;
	}
	@Override
	public Object get(int index) { return elements[index]; }
	@Override
	public Iterator iterator() { return new ConcreteIterator(this); }
	@Override
	public int getSize() { return size; }
}

// ====== Test.java ======
public class Test {
	public static void main(String[] args) {
		MyList list = new ConcreteAggregate();
		list.add("刘备");
		list.add("张飞");
		list.add("关羽");
		Iterator iter = list.iterator();
		while(iter.hasNext()){
			System.out.println(iter.next());
		}
	}
}
```

#### guava

- Guava工程包含了若干被Google的 Java项目广泛依赖 的核心库，例如：集合 [collections] 、缓存 [caching] 、原生类型支持 [primitives support] 、并发库 [concurrency libraries] 、通用注解 [common annotations] 、字符串处理 [string processing] 、I/O 等等。 所有这些工具每天都在被Google的工程师应用在产品服务中。
- Guava对JDK集合的扩展，这是 Guava 最成熟和为人所知的部分。
  - 不可变集合：用不变的集合进行防御性编程和性能提升。
  - 新集合类型： multisets，multimaps，tables 等
  - 强大的集合工具类：提供 java.util.Collections 中没有的集合工具
  - 扩展工具类：让实现和扩展集合类变得更容易，比如创建 Collection 的装饰器，或实现迭代器

```java
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.junit.Test;
import com.google.common.base.Function;
import com.google.common.base.Functions;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.BiMap;
import com.google.common.collect.Collections2;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.HashMultiset;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;
import com.google.common.collect.Sets;
import com.google.common.collect.Sets.SetView;
import com.google.common.collect.Table;
import com.google.common.collect.Table.Cell;
public class GuavaDemo {
	// 双键的Map -> Table -> rowKey+columnKye+value
	@Test
	public void testGuava10(){
		Table<String, String, Integer> table = HashBasedTable.create();
		table.put("jack", "java", 80);
		table.put("tom", "php", 70);
		Set<Cell<String, String, Integer>> cells = table.cellSet();
		for(Cell c: cells){
			System.out.println(c.getRowKey() + "-" + c.getColumnKey() + "-" + c.getValue());
		}
	}
	// BiMap：双向Map(bidirectional Map) 键与值不能重复
	@Test
	public void testGuava9(){
		BiMap<String, String> map = HashBiMap.create();
		map.put("finally_test", "18201583398");
		map.put("bin_test", "18388881521");
		String name = map.inverse().get("18201583398");
		System.out.println(name);
		// System.out.println(map.inverse().inverse() == map);
	}
	// Multimap：key可重复
	@Test
	public void testGuava8() {
		Map<String, String> map = new HashMap<>();
		map.put("Java从入门到精通", "bin");
		map.put("Android从入门到精通", "bin");
		Multimap<String, String> mmap = ArrayListMultimap.create();
		Iterator<Map.Entry<String, String>> iter = map.entrySet().iterator();
		while(iter.hasNext()){
			Map.Entry<String, String> entry = iter.next();
			mmap.put(entry.getValue(), entry.getKey());
		}
		Set<String> keySet = mmap.keySet();
		for(String key: keySet){
			Collection<String> values = mmap.get(key);
			System.out.println(key + "->" + values);
		}
	}
	// Multiset：无序可重复
	@Test
	public void testGuava7() {
		String s = "good good study day day up";
		String[] ss = s.split(" ");
		HashMultiset<String> set = HashMultiset.create();
		for (String str : ss) {
			set.add(str);
		}
		Set<String> set2 = set.elementSet();
		for (String str : set2) {
			System.out.println(str + ":" + set.count(str));
		}
	}
	// 集合操作：交集、差集、并集
	@Test
	public void testGuava6() {
		Set<Integer> set1 = Sets.newHashSet(1, 2, 3);
		Set<Integer> set2 = Sets.newHashSet(3, 4, 5);
		// 交集
		SetView<Integer> v1 = Sets.intersection(set1, set2);
		// v1.forEach(System.out::println);
		// 差集
		SetView<Integer> v2 = Sets.difference(set1, set2);
		// v2.forEach(System.out::println);
		// 并集
		SetView<Integer> v3 = Sets.union(set1, set2);
		v3.forEach(System.out::println);
	}
	// 加入约束：非空、长度验证
	@Test
	public void testGuava5() {
		Set<String> set = Sets.newHashSet();
		// 14版可用
		Constraint<String> constraint = new Constraint<>(){
			@Override
			public String checkElement(String element){}
		}
		Preconditions.checkArgument(expression);
		Preconditions.checkNotNull(reference)
	}
	// 组合式函数
	@Test
	public void testGuava4() {
		List<String> list = Lists.newArrayList("java", "php", "jack", "h5", "javascript");
		Function<String, String> f1 = new Function<String, String>() {
			@Override
			public String apply(String t) {
				return t.length() > 4 ? t.substring(0, 4) : t;
			}
		};
		Function<String, String> f2 = new Function<String, String>() {
			@Override
			public String apply(String t) {
				return t.toUpperCase();
			}
		};
		Function<String, String> f = Functions.compose(f1, f2);
		Collection<String> coll = Collections2.transform(list, f);
		coll.forEach(System.out::println);
	}
	// 转换
	@Test
	public void testGuava3() {
		Set<Long> timeSet = Sets.newHashSet(20121212L, 20170520L, 20160808L);
		Collection<String> timeCollect = Collections2.transform(timeSet, (e) -> new SimpleDateFormat("yyyy-MM-dd").format(e));
		timeCollect.forEach(System.out::println);
	}
	// 过滤器
	@Test
	public void testGuava2() {
		List<String> list = Lists.newArrayList("java", "php", "jack", "h5", "javascript");
		Collection<String> result = Collections2.filter(list, (e) -> e.startsWith("j"));
		result.forEach(System.out::println);
	}
}
```

### 线程

#### 进程

- **程序** 是 **指令和数据的有序集合，其本身没有任何运行的含义**，是一个 **静态** 的概念。

- 而 **进程** 是 **程序在处理机上的一次执行过程**，它是一个 **动态** 的概念。

- 进程是一个 **具有一定独立功能的程序，一个实体，每一个进程都有它自己的地址空间**。

- 进程执行时的间断性，决定了进程可能具有多种状态，运行中的进程具有以下三种基本状态。

  就绪状态（Ready），运行状态（Running），阻塞状态（Blocked）

![](https://upload-images.jianshu.io/upload_images/5097954-abe1947f811fc9ae.png)

#### 线程

- 线程实际上是在进程基础之上的进一步划分，一个进程启动之后，里面的若干程序又可以划分成若干个线程。

- 线程是进程中的一个执行路径，共享一个内存空间，线程之间可以自由切换，并发执行，一个进程最少有一个线程（单线程程序）

- 并行与并发

  - 并行：就是两个任务同时运行(多个CPU)

  - 并发：是指两个任务同时请求运行，而处理器一次只能接受一个任务，就会把两个任务安排轮流执行，由于CPU时间片运行时间较短,就会感觉两个任务在同时执行

#### 实现线程的两种方式

```java
public class ThreadDemo1 {
  public static void main(String[] args) {
    MyThread mt = new MyThread();
    MyRunnable mr = new MyRunnable(); // 推荐
    Thread t2 = new Thread(mr);
    mt.start(); // 启动线程
    t2.start();
    for (int i = 0; i < 100; i++) {
      System.out.println(Thread.currentThread().getName() + "-" + i); // 主线程(main)
      try {
        Thread.sleep(500); // 线程进入休眠
      } catch (InterruptedException e) { // 线程中断异常
        e.printStackTrace();
      }
    }
  }
}
// 第一种方式：继承 Thread 类
class MyThread extends Thread {
  @Override
  public void run() {
    for (int i = 0; i < 100; i++) {
      System.out.println(Thread.currentThread().getName() + "-" + i);
      try {
        Thread.sleep(500);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}
// 第二种方式：实现 Runnable 接口
class MyRunnable implements Runnable {
  @Override
  public void run() {
    for (int i = 0; i < 100; i++) {
      System.out.println(Thread.currentThread().getName() + "-" + i);
    }
  }
}
```

##### Thread 类

- **public void start()：**此线程开始执行，Java虚拟机会调用此线程的 run 方法。

- **public static Thread currentThread()：**返回对当前正在执行的线程对象的引用。

- **public static void sleep()：**使当前正在执行的线程以指定的毫秒数 **暂时停止执行**，具体取决于系统定时器和调度程序的精度和准确性，**线程不会丢失任何显示器的所有权**。

- **public static void yield()：**让出本次CPU执行时间片。

- **public final void setPriority / getPriority()：**更改 / 获取此线程的优先级。

  - **static int MAX_PRIORITY：**线程可以具有的最高优先级。 
  - **static int MIN_PRIORITY：**线程可以具有的最低优先级。 
  - **static int NORM_PRIORITY：**分配给线程的默认优先级

- **public final boolean isAlive()：**返回线程是否处于活动状态。

- **public void interrupt()：**中断这个线程。

- **public boolean isInterrupted()：**测试这个线程是否被中断，**线程的 中断状态 不受此方法的影响**。忽略线程中断，因为线程在中断时不存在将被该方法返回 false 所反映。

- **public static boolean interrupted()：**测试当前线程是否中断，**该方法会清除线程的中断状态** 。即如果这个方法被连续调用两次，那么第二个调用将返回false（除非当前线程再次中断，在第一个调用已经清除其中断状态之后，在第二个调用之前已经检查过）

- **public final void setName / getName()：**更改 / 获取此线程的名称。

- **public final ThreadGroup getThreadGroup()：**返回此线程所属的线程组， 如果线程已经死机（停止），此方法返回null。

- **public final void join()：**等待这个线程死亡，调用此方法的行为方式与调用 join(0) 完全相同。

- **public final void setDaemon(boolean on)：**将此线程标记为 守护线程(daemon线程，on为true) 或 用户线程(User线程，on为false)，当运行的唯一线程都是守护进程线程时，Java虚拟机将退出，线程启动前必须调用此方法。

  >  Java线程分为两类分别为daemon线程（守护线程）和User线程（用户线程），在JVM启动时候会调用main函数，main函数所在的线程是一个用户线程，这个是我们可以看到的线程，其实JVM内部同时还启动了好多守护线程，比如垃圾回收线程。那么守护线程和用户线程有什么区别那？区别之一是当最后一个非守护线程结束时候，JVM会正常退出，而不管当前是否有守护线程，也就是说守护线程是否结束并不影响JVM的退出，言外之意是只要有一个用户线程还没结束正常情况下JVM就不会退出。

- **public final boolean isDaemon()：**返回这个线程是否为守护线程。

- **Object 类关于线程的方法：**

  - **public final void wait()：**使当前线程进入等待，直到另一个线程调用该对象的 notify() 方法或 notifyAll() 方法，**线程会丢失显示器的所有权**。
  - **public final void notify / notifyAll()：**唤醒正在等待对象监视器的单个 / 全部线程。 如果是单个的，那么这个唤醒的线程的选择是任意的，并且由实施的判断发生。

- [Java线程状态操作和锁与监视器的区别](https://my.oschina.net/kdy1994/blog/1930911)
- **sleep 与 wait 的区别：**
   * sleep：让线程进入休眠状态，让出CPU的时间片，不释放对象监视器的所有权（对象锁）
   * wait：让线程进入等待状态，让出CPU的时间片，并释放对象监视器的所有权，等待其它线程通过notify方法来唤醒

#### 中断线程的方法

```java
// ====== 方式一 使用 interrupt 方法来中断线程，设置一个中断状态（标记） ======
// ...
// ====== 方式二 自定义标记的方式(推荐使用) ======
public class ThreadDemo2 {
  public static void main(String[] args){
    MyRunable3 mr3 = new MyRunable3();
    Thread t2 = new Thread(mr3);
    t2.start();
    for (int i = 0; i < 50; i++) {
      System.out.println(Thread.currentThread().getName() + "--" + i);
      try {
        Thread.sleep(300);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      if(i == 20){
        mr3.flag = false;
      }
    }
  }
}
class MyRunable3 implements Runnable{
  public boolean flag = true;
  public MyRunable3(){
    flag = true;
  }
  @Override
  public void run() {
    int i = 0;
    while(flag){
      System.out.println(Thread.currentThread().getName() + "===" + (i++));
      try {
        Thread.sleep(300);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}
```

![](https://upload-images.jianshu.io/upload_images/5097954-e640555d308cfd2a.png)

#### 线程同步

##### 线程同步准则

- 使代码块保持简短。把不随线程变化的预处理和后处理移出synchronized 块。

- 不要阻塞，如 InputStream.read()。
- **不要在一个同步方法中调用了另一个对象的同步方法，可能产生死锁**。

```java
import java.util.concurrent.locks.ReentrantLock;
public class ThreadDemo4 {
  public static void main(String[] args) {
    MyRunnable5 mr5 = new MyRunnable5();
    Thread t1 = new Thread(mr5);
    Thread t2 = new Thread(mr5);
    t1.start();
    t2.start();
  }
}
class MyRunnable5 implements Runnable {
  private int ticket = 10; // 售票
  // private Object obj = new Object(); // 同步锁
  @Override
  public void run() {
    for (int i = 0; i < 300; i++) {
      // 方式一 使用同步代码块
      // this 为要同步的对象，必须让所有要同步的线程使用同一个同步锁对象才能保证这个同步是正常的
      // synchronized (this) {
      //   if (ticket > 0) {
      //     System.out.println("您购买的票剩余" + --ticket + "张");
      //     try {
      //       Thread.sleep(1000);
      //     } catch (InterruptedException e) {
      //       e.printStackTrace();
      //     }
      //   }
      // }
      // method();
      method2();
    }
  }
  // 方式二 使用同步方法，同步的对象是当前对象(this)
  // private synchronized void method() {
  //   if (ticket > 0) {
  //     System.out.println("您购买的票剩余" + --ticket + "张");
  //     try {
  //       Thread.sleep(1000);
  //     } catch (InterruptedException e) {
  //       e.printStackTrace();
  //     }
  //   }
  // }
  // 方式三 使用Lock（更灵活的代码控制）互斥锁
  ReentrantLock lock = new ReentrantLock();
  private void method2() {
    lock.lock(); // 锁
    try {
      if (ticket > 0) {
        System.out.println("您购买的票剩余" + --ticket + "张");
        try {
          Thread.sleep(1000);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    } finally {
      lock.unlock(); // 释放锁
    }
  }
}
```

#### 线程池

```java
// ====== 创建线程池(4种) ======
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
public class ThreadDemo5 {
  public static void main(String[] args) {
    // 创建一个单线程的线程池（串行）
    ExecutorService es1 = Executors.newSingleThreadExecutor();
    es1.execute(new MyRunable6()); // 执行线程（先）
    es1.execute(new MyRunable6()); // 执行线程（后）
    // 创建一个固定大小的线程池
    ExecutorService es2 = Executors.newFixedThreadPool(1);
    es2.execute(new MyRunable6()); // 执行线程（先）
    es2.execute(new MyRunable6()); // 执行线程（后）
    ExecutorService es3 = Executors.newFixedThreadPool(2);
    es3.execute(new MyRunable6()); // 执行线程（并行）
    es3.execute(new MyRunable6()); // 执行线程（并行）
    // 创建一个可缓存的线程池，如果线程池的大小超过了处理任务所需要的线程，那么就会回收部分空闲（60秒不执行任务）的线程，当任务数增加时，此线程池又可以智能的添加新线程来处理任务。此线程池不会对线程池大小做限制，线程池大小完全依赖于操作系统（或者说JVM）能够创建的最大线程大小。
    ExecutorService es4 = Executors.newCachedThreadPool();
    es4.execute(new MyRunable6()); // 执行线程（并行）
    es4.execute(new MyRunable6()); // 执行线程（并行）
    // 创建一个大小无限的线程池，此线程池支持定时以及周期性执行任务的需求，参数为初始化线程数量。
    ScheduledExecutorService es5 = Executors.newScheduledThreadPool(3);
    es5.schedule(new MyRunable6(), 3000, TimeUnit.MILLISECONDS);
    es5.shutdown(); // 结束线程
  }
}
class MyRunable6 implements Runnable{
  @Override
  public void run() {
    for (int i = 0; i < 10; i++) {
      System.out.println(Thread.currentThread().getName()+"---"+i);
      try {
        Thread.sleep(300);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}
```

### 网络编程

#### 程序开发结构

- **C/S（客户端/服务器）**

  - 开发两套程序，两套程序需要同时维护，例如：QQ。

  - CS 程序一般比较稳定。

- **B/S（浏览器/服务器）**

  - 开发一套程序，客户端使用浏览器进行访问，例如：各个论坛。
  - BS 程序一般稳定性较差，而且安全性较差。
  - 但是 C/S 的程序开发在实际的 Java 应用中毕竟很少了，而且整个 java 基本上都是以 B/S 为主。

#### TCP程序

- **TCP连接** 是一个 **可靠的** 协议，**面向连接** 的协议。

- **ServerSocket：**此类实现 **服务端** 套接字。

- **Socket：**此类实现 **客户端** 套接字（也可以就叫“套接字”）。
- **数据发送过程**

![](https://upload-images.jianshu.io/upload_images/5097954-903bd5a3a95c1387.png)

- **数据接收过程**

![](https://upload-images.jianshu.io/upload_images/5097954-1a650e4287418044.png)

```java
// ====== ServerSocket 服务端 ======
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
public class EchoServerDemo {
  public static void main(String[] args) {
    try {
      // 创建一个服务器端的Socket(1024-65535)
      ServerSocket server = new ServerSocket(6666);
      System.out.println("服务器已启动，正在等待客户端的连接...");
      // 等待客户端的连接，造成阻塞，如果有客户端连接成功，立即返回一个Socket对象
      Socket socket = server.accept();
      System.out.println("客户端连接成功:" + server.getInetAddress().getHostAddress());
      // 获取输入流，接收客户端的消息
      BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
      // 通过输入流读取网络数据(该例中客户端 println 方法发送的数据)，如果没有数据，那么会阻塞
      String info = br.readLine();
      System.out.println(info);
      // 获取输出流，向客户端返回消息
      PrintStream ps = new PrintStream(new BufferedOutputStream(socket.getOutputStream()));
      ps.println("echo:" + info); // 向客户端返回数据
      ps.flush(); // 刷新流
      ps.close(); // 关闭流
      br.close(); // 关闭流
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}

// ====== Socket 客户端 ======
import java.io.*;
import java.net.Socket;
public class EchoClientDemo {
  public static void main(String[] args) {
    try {
      // 创建一个客户端的Socket对象，指定要连接的服务器
      Socket socket = new Socket("localhost", 6666);
      // 获取socket的输入输出流
      PrintStream ps = new PrintStream(new BufferedOutputStream(socket.getOutputStream()));
      BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
      ps.println("hello,my name is Bin"); // 向服务端发送数据
      ps.flush(); // 刷新流
      // 读取服务器端返回的数据(该例中服务端 println 方法发送的数据)，如果没有数据，那么会阻塞
      String info = br.readLine();
      System.out.println(info);
      ps.close(); // 关闭流
      br.close(); // 关闭流
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
```

#### 服务器与多客户端通信

```java
// ====== ServerSocket 服务端 ======
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/**
 * 处理多个客户端
 * 主线程用于监听客户端的连接，每次有连接成功，开启一个线程来处理该客户端的消息
 */
public class MutilServerDemo {
  public static void main(String[] args) {
    ExecutorService es = Executors.newFixedThreadPool(3);
    try {
      ServerSocket server = new ServerSocket(6666);
      System.out.println("服务器已启动，正在等待连接。。。");
      while(true){ // 循环接收需要建立连接的客户端
        Socket s = server.accept();
        System.out.println(s.getInetAddress().getHostAddress());
        es.execute(new UserThread(s)); // 为每个与客户端的连接启动一个线程
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
// 用来处理客户端请求的线程任务
class UserThread implements Runnable{
  private Socket s;
  public UserThread(Socket s){
    this.s = s;
  }
  @Override
  public void run() {
    try {
      BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
      PrintStream ps = new PrintStream(new BufferedOutputStream(s.getOutputStream()));
      String info = br.readLine();
      System.out.println(info);
      ps.println("echo:" + info);
      ps.flush();
      ps.close();
      br.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}

// ====== Socket 客户端 ======
import java.io.*;
import java.net.Socket;
import java.util.Scanner;
public class MutilClientDemo {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    try {
      Socket socket = new Socket("localhost", 6666);
      // 获取socket的输入输出流
      PrintStream ps = new PrintStream(new BufferedOutputStream(socket.getOutputStream()));
      BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
      System.out.println("请输入：");
      String info = input.nextLine();
      ps.println(info);
      ps.flush();
      info = br.readLine(); // 读取服务器端返回的数据
      System.out.println(info);
      ps.close();
      br.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
```

#### 多客户端之间的通信

```java
// ====== 服务端 ======
import javax.security.sasl.SaslClient;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
public class Server {
  public static void main(String[] args) {
    // 保存客户端处理的线程
    Vector<UserThread> vector = new Vector<>();
    ExecutorService es = Executors.newFixedThreadPool(5);
    // 创建服务器端的Socket
    try {
      ServerSocket server = new ServerSocket(8888);
      System.out.println("服务器已启动，正在等待连接...");
      while(true){ // 循环接收需要建立连接的客户端
        Socket socket = server.accept();
        UserThread user = new UserThread(socket, vector);
        es.execute(user); // 为每个与客户端的连接启动一个线程
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
// 客户端处理的线程
class UserThread implements Runnable{
  private String name; // 客户端的用户名称（唯一）
  private Socket socket;
  private Vector<UserThread> vector; // 客户端处理线程的集合
  private ObjectInputStream ois;
  private ObjectOutputStream oos;
  private boolean flag = true;
  public UserThread(Socket socket,Vector<UserThread> vector){
    this.socket = socket;
    this.vector = vector;
    vector.add(this);
  }
  @Override
  public void run() {
    try{
      System.out.println("客户端" + socket.getInetAddress().getHostAddress() + "已连接");
      ois = new ObjectInputStream(socket.getInputStream());
      oos = new ObjectOutputStream(socket.getOutputStream());
      while (flag) {
        // 读取消息对象
        Message msg  = (Message)ois.readObject();
        int type = msg.getType();
        switch (type){
          // 转发消息
          case MessageType.TYPE_SEND:
            String to = msg.getTo();
            UserThread ut;
            int size = vector.size();
            // 遍历找出需要通信的客户端并转发消息
            for (int i = 0; i < size; i++) {
              ut = vector.get(i);
              if (to.equals(ut.name) && ut != this){
                ut.oos.writeObject(msg);
                break;
              }
            }
            break;
          // 登录应答
          case MessageType.TYPE_LOGIN:
            name = msg.getFrom();
            msg.setInfo("欢迎你：");
            oos.writeObject(msg);
            break;
        }
      }
      ois.close();
      oos.close();
    } catch (IOException | ClassNotFoundException e){
      e.printStackTrace();
    }
  }
}

// ====== 客户端 ======
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
public class Client {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    ExecutorService es = Executors.newSingleThreadExecutor();
    try {
      Socket socket = new Socket("localhost", 8888);
      System.out.println("服务器连接成功");
      ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
      ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
      // 向服务器发送登录信息
      System.out.println("请输入名称：");
      String name = input.nextLine();
      Message msg = new Message(name, null, MessageType.TYPE_LOGIN, null);
      oos.writeObject(msg);
      // 读取登录的服务端应答消息
      msg = (Message) ois.readObject();
      System.out.println(msg.getInfo() + msg.getFrom());
      es.execute(new ReadInfoThread(ois)); // 启动读取消息的线程
      // 使用主线程来实现发送消息
      boolean flag = true; // 发送消息的开关
      while(flag){
        msg = new Message();
        System.out.println("To:");
        msg.setTo(input.nextLine());
        msg.setFrom(name);
        msg.setType(MessageType.TYPE_SEND);
        System.out.println("Info:");
        msg.setInfo(input.nextLine());
        oos.writeObject(msg);
      }
    } catch (IOException|ClassNotFoundException e) {
      e.printStackTrace();
    }
  }
}
// 读取消息
class ReadInfoThread implements Runnable {
  private ObjectInputStream in;
  public ReadInfoThread(ObjectInputStream in){ this.in = in; }
  private boolean flag = true;
  public void setFlag(boolean flag) { this.flag = flag; }
  @Override
  public void run() {
    try {
      while (flag) {
        Message message = (Message) in.readObject();
        System.out.println("[" + message.getFrom() + "]对我说：" + message.getInfo());
      }
      if(in != null){
        in.close();
      }
    } catch (IOException|ClassNotFoundException e) {
      e.printStackTrace();
    }
  }
}

// ====== Message 消息 ======
import java.io.Serializable;
public class Message implements Serializable{
    private String from; // 发送者
    private String to; // 接收者
    private int type; // 消息类型
    private String info; // 消息
    public String getFrom() { return from; }
    public void setFrom(String from) { this.from = from; }
    public String getTo() { return to; }
    public void setTo(String to) { this.to = to; }
    public int getType() { return type; }
    public void setType(int type) { this.type = type; }
    public String getInfo() { return info; }
    public void setInfo(String info) { this.info = info; }
    public Message() {}
    public Message(String from, String to, int type, String info) {
        this.from = from;
        this.to = to;
        this.type = type;
        this.info = info;
    }
    @Override
    public String toString() {
        return "Message{" + "from='" + from + '\'' + ", to='" + to + '\'' + ", type=" + type + ", info='" + info + '\'' + '}';
    }
}

// ====== MessageType 消息类型 ======
public final class MessageType {
    public static final int TYPE_LOGIN = 0x1; // 登录消息类型
    public static final int TYPE_SEND = 0x2; // 发送消息的类型
}
```

#### UDP 程序

- **UDP协议** 是一种 **不可靠的**、 **无连接** 的协议。
- **DatagramPacket：**此类表示数据报包。
- **DatagramSocket：**此类表示用来发送和接收数据报包的套接字。

```java
// ====== DatagramSocket 服务端 ======
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.SAXConnector;
import java.io.IOException;
import java.net.*;
public class UDPServerDemo {
  public static void main(String[] args) {
    String info = "good good 学习，天天 UP";
    byte[] bytes = info.getBytes();
    try {
      /** 封装一个数据报包
        buf - 数据包数据。
        offset - 分组数据偏移量。
        length - 分组数据长度。
        address - 目的地址。
        port - 目的端口号。 */
      DatagramPacket dp = new DatagramPacket(bytes, 0, bytes.length, InetAddress.getByName("127.0.0.1"), 8000);
      DatagramSocket socket = new DatagramSocket(9000); // 创建一个服务端，端口为9000
      socket.send(dp); // 发送数据
      socket.close();
    } catch (UnknownHostException|SocketException|IOException e){
      e.printStackTrace();
    }
  }
}

// ====== DatagramSocket 客户端 ======
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
public class UDPClientDemo {
  public static void main(String[] args) {
    byte[] bytes = new byte[1024];
    DatagramPacket dp = new DatagramPacket(bytes, bytes.length);
    try {
      DatagramSocket socket = new DatagramSocket(8000); // 创建一个客户端
      System.out.println("正在接收数据中...");
      socket.receive(dp); // 接收数据
      String s = new String(dp.getData(), 0, dp.getLength());
      System.out.println(s);
      socket.close();
    } catch (SocketException|IOException e) {
      e.printStackTrace();
    }
  }
}
```

#### URL 类

- URL 代表一个统一资源定位符，它是指向互联网“资源”的指针。
- 抽象类 **URLConnection**  是所有类的超类，它代表应用程序和 URL  之间的通信链接。

```java
// ====== URL 类 (本例为下载一张图片)======
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
public class URLDemo {
  public static void main(String[] args) {
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
```

#### MINA 框架

- 一个简洁易用的基于 TCP/IP 通信的 JAVA 框架。

```java
// ====== NioSocketAcceptor 服务端 ======
package com.vince.mina;

import org.apache.mina.core.filterchain.DefaultIoFilterChainBuilder;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.serialization.ObjectSerializationCodecFactory;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.transport.socket.SocketAcceptor;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;
import java.io.IOException;
import java.net.InetSocketAddress;
public class Server {
  public static void main(String[] args) {
    // 创建一个非阻塞的 Server 端 Socket NIO
    SocketAcceptor acceptor = new NioSocketAcceptor();
    // 获取过滤链
    DefaultIoFilterChainBuilder chain = acceptor.getFilterChain();
    // 设定一个过滤器，一行一行的读取数据（即以 /r/n 结尾，myChin 为过滤器的一个标识名）
    // chain.addLast("myChin", new ProtocolCodecFilter(new TextLineCodecFactory()));
    // 设定一个过滤器，以对象为单位读取数据(objectFilter 为过滤器的一个标识名)
    chain.addLast("objectFilter", new ProtocolCodecFilter(new ObjectSerializationCodecFactory()));
    acceptor.setHandler(new MinaServerHandler()); // 设置服务端的消息处理器
    int port = 9999; // 服务器的端口号
    try {
      // 绑定端口，启动服务器(不会阻塞，立即返回)
      acceptor.bind(new InetSocketAddress(port));
    } catch (IOException e) {
      e.printStackTrace();
    }
    System.out.println("Mina Server running, listener on : " + port);
  }
}

// ====== 服务端处理器 ======
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IoSession;
public class MinaServerHandler extends IoHandlerAdapter {
  // 一次会话被打开
  @Override
  public void sessionOpened(IoSession session) throws Exception {
    super.sessionOpened(session);
    System.out.println("welcome client " + session.getRemoteAddress());
  }
  // 会话关闭
  @Override
  public void sessionClosed(IoSession session) throws Exception {
    super.sessionClosed(session);
    System.out.println("client closed");
  }
  // 接收消息
  @Override
  public void messageReceived(IoSession session, Object message) throws Exception {
    super.messageReceived(session, message);
    // String msg = (String) message; // 接收到的消息对象
    Message msg = (Message) message;
    System.out.println("收到客户端发来的消息：" + msg);
    msg.setInfo("吃好吃的");
    session.write(msg); // 向客户端发送消息对象
  }
}

// ====== NioSocketConnector 客户端 ======
import org.apache.mina.core.filterchain.DefaultIoFilterChainBuilder;
import org.apache.mina.core.future.ConnectFuture;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.serialization.ObjectSerializationCodecFactory;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.transport.socket.nio.NioSocketConnector;
import java.net.InetSocketAddress;
import java.util.Scanner;
public class Client {
  public static void main(String[] args) {
    // 创建连接
    NioSocketConnector connector = new NioSocketConnector();
    // 获取过滤链
    DefaultIoFilterChainBuilder chain = connector.getFilterChain();
    // 设定一个过滤器，一行一行的读取数据（即以 /r/n 结尾，myChin 为过滤器的一个标识名）
    // chain.addLast("myChin", new ProtocolCodecFilter(new TextLineCodecFactory()));
    // 设定一个过滤器，以对象为单位读取数据(objectFilter 为过滤器的一个标识名)
    chain.addLast("objectFilter", new ProtocolCodecFilter(new ObjectSerializationCodecFactory()));
    // 设置客户端的消息处理器
    connector.setHandler(new MinaClientHandler());
    connector.setConnectTimeoutMillis(10000); // 设置连接超时的失效时间
    // 连接服务器
    ConnectFuture cf = connector.connect(new InetSocketAddress("localhost", 9999));
    cf.awaitUninterruptibly(); // 等待连接成功
    Scanner input = new Scanner(System.in);
    while(true) {
      // System.out.println("请输入:");
      // String info = input.nextLine();
      // cf.getSession().write(info); // 发送消息
      // 以对象的方式传输数据
      Message msg = new Message();
      System.out.println("form:");
      msg.setFrom(input.nextLine());
      System.out.println("to:");
      msg.setTo(input.nextLine());
      System.out.println("info:");
      msg.setInfo(input.nextLine());
      msg.setType("send");
      cf.getSession().write(msg);
    }
    // 等待服务器连接关闭，结束长连接(会阻塞)
    // cf.getSession().getCloseFuture().awaitUninterruptibly();
    // connector.dispose(); // 关闭连接
  }
}

// ====== 客户端处理器 ======
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IoSession;
import javax.sound.midi.Soundbank;
public class MinaClientHandler extends IoHandlerAdapter {
  @Override
  public void sessionOpened(IoSession session) throws Exception {
    super.sessionOpened(session);
    System.out.println("sessionOpened");
  }
  @Override
  public void sessionClosed(IoSession session) throws Exception {
    super.sessionClosed(session);
    System.out.println("sessionClosed");
  }
  @Override
  public void messageReceived(IoSession session, Object message) throws Exception {
    super.messageReceived(session, message);
    // String msg = (String) message;
    Message msg = (Message)message;
    System.out.println(msg);
  }
}

// ====== Message 消息 ======
import java.io.Serializable;
public class Message implements Serializable {
  private String from;
  private String to;
  private String type;
  private String info;
  public String getFrom() { return from; }
  public void setFrom(String from) { this.from = from; }
  public String getTo() { return to; }
  public void setTo(String to) { this.to = to; }
  public String getType() { return type; }
  public void setType(String type) { this.type = type; }
  public String getInfo() { return info; }
  public void setInfo(String info) { this.info = info; }
  @Override
  public String toString() {
    return "Message{" + "from='" + from + '\'' + ", to='" + to + '\'' + ", type='" + type + '\'' + ", info='" + info + '\'' + '}';
  }
}
```

### 反射与内省

- **Class 类是一切的反射根源**。
- 得到 Class 类的对象有三种方式：

```java
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.junit.Test;
import java.lang.reflect.*;
public class ReflectionDemo {
  // === 获取Class对象的三种形式 ===
  @Test
  public void test1(){
    // 方式一 通过对象实例的getClass()方法
    Dog dog = new Dog("wangwang", 4, "白色");
    Class<Dog> aClass = dog.getClass();
    // 方式二 通过类.class
    Class<Dog> dogClass = Dog.class;
    // 方式三 通过Class.forName方法
    try {
      Class<Dog> aClass1 = Class.forName("com.vince.Dog");
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
  }
  // === 通过反射来实例化对象 ===
  public void test2(){
    Class<Dog> dogClass = Dog.class;
    try {
      // 通过Class对象实例化类对象，调用了默认无参的构造方法
      Dog dog = (Dog) dogClass.newInstance();
    } catch (InstantiationException|IllegalAccessException e) {
      e.printStackTrace();
    }
  }
  // === 获取所有构造方法 ===
  @Test
  public void test3(){
    Class<Dog> dogClass = Dog.class;
    Constructor<?>[] constructors = dogClass.getConstructors(); // 获取所有构造方法
    for (int i = 0; i < constructors.length; i++) {
      System.out.println(constructors[i].getName()); // 获取构造方法的名字
      System.out.println(constructors[i].getParameterCount()); // 获取构造方法的参数
    }
    try {
      // 获取一个指定的构造方法
      Constructor<Dog> constructor = dogClass.getConstructor(String.class, int.class, String.class);
      // 调用带参数的构造器来实例化对象
      Dog dog = constructor.newInstance("小白", 5, "白色");
    } catch (NoSuchMethodException|IllegalAccessException|InstantiationException|InvocationTargetException e) {
      e.printStackTrace();
    }
  }
  // === 获取所有的属性 ===
  @Test
  public void test4(){
    Dog dog = new Dog("wangwang", 4, "白色");
    Class<Dog> dogClass = Dog.class;
    // 获取非私有属性
    Field[] fields = dogClass.getFields();
    System.out.println(fields.length);
    // 获取所有属性（包括私有属性）
    Field[] declaredFields = dogClass.getDeclaredFields();
    // System.out.println(declaredFields.length);
    for (int i = 0; i < declaredFields.length; i++) {
      if (declaredFields[i].getName().equals("name")) {
        System.out.println(declaredFields[i].get(dog)); // 在 dog 实例上获取该属性值
        System.out.println(declaredFields[i].set(dog, "旺财")); // 在 dog 实例上设置该属性值
      }
      // public Class<?> getType() // 获取属性类型
      int modifiers = declaredFields[i].getModifiers(); // 获取修饰符
      System.out.println(Modifier.toString(modifiers) + " " + declaredFields[i].getType() + " " + declaredFields[i].getName());
    }
  }
  // === 获取包名，方法 ===
  @Test
  public void test5(){
    Dog dog = new Dog("wangwang", 4, "白色");
    Class<Dog> dogClass = Dog.class;
    // 获取类的包名
    Package aPackage = dogClass.getPackage();
    System.out.println(aPackage.getName());
    // 获取公共的方法，包括继承的公有方法
    Method[] methods = dogClass.getMethods();
    for (int i = 0; i < methods.length; i++) {
      // public Class<?> getReturnType() // 获取返回值类型
			// public Class<?>[] getParameterTypes() // 获取参数类型
			// public Class<?>[] getExceptionTypes() // 获取异常的类型
      if (methods[i].getName().equals("toString")){
        try {
          String s = (String)methods[i].invoke(dog); // 在 dog 对象上调用方法
          System.out.println(s);
        } catch (IllegalAccessException|InvocationTargetException e) {
          e.printStackTrace();
        }
      }
    }
    // 访问私有方法，获取到本类中定义的所有方法（不包括父类）
    Method[] declaredMethods = dogClass.getDeclaredMethods();
    for (int i = 0; i < declaredMethods.length; i++) {
      if (declaredMethods[i].getName().equals("set")){
        // 设置 私有方法 可以被访问（去除访问修饰符的检查）
        declaredMethods[i].setAccessible(true);
        try {
          declaredMethods[i].invoke(dog); // 在 dog 对象上调用方法
        } catch (IllegalAccessException|InvocationTargetException e) {
          e.printStackTrace();
        }
      }
    }
  }
}
```

#### 动态代理

```java
// ====== 用于动态生成一个代理对象 ======
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
public class CreateProxy implements InvocationHandler {
  private Object target; // 被代理的对象
  public Object create(Object target){ // 用于创建代理对象的方法
    this.target = target;
    Object proxy = Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    return proxy;
  }
  /** 代理对象要执行的方法
   * @param proxy  代理类对象
   * @param method 被代理对象的方法
   * @param args 被代理对象方法的参数
   */
  @Override
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    System.out.println("上海外寻找客户需要的产品...");
    System.out.println("跟客户确认产品");
    method.invoke(target, args);
    System.out.println("完成本次海淘");
    return null;
  }
}

// ====== Test 类 ======
import org.junit.Test;
public class TestDemo {
  @Test
  public void testProxy(){
    CreateProxy cp = new CreateProxy(); // 用来创建代理对象的对象
    Hotel person = new Person();
    Hotel proxy = (Hotel) cp.create(person);
    // proxy.shopping(); // invoke
    proxy.reserve();
  }
}

// ====== Hotel 接口 ======
public interface Hotel {
  public void reserve();
}
// ====== Subject 接口 ======
public interface Subject {
  public void shopping();
}
// ====== Person 实现类 ======
public clss Person implements Subject, Hotel {
  @Override
  public void shopping() {
    System.out.println("付款，买到心仪的比基尼");
  }
  @Override
  public void reserve() {
    System.out.println("付预定款，打飞的前往目的地");
  }
}
```

#### 类什么时候被初始化

1. 创建类的实例，也就是new一个对象
2. 访问某个类或接口的静态变量，或者对该静态变量赋值
3. 调用类的静态方法
4. 反射（Class.forName("com.vince.Dog")）
5. 初始化一个类的子类（会首先初始化子类的父类）
6. JVM启动时标明的启动类，即文件名和类名相同的那个类

#### JavaBean

- Bean 为组件意思， JavaBean就是 Java 组件，也是一个类。
- 对于组件来说，关键在于要具有“能够被IDE构建工具侦测其属性和事件”的能力，通常在 Java 中。

##### JavaBean要具备这样的命名规则：

1. 对于一个名称为 xxx 的属性，通常你要写两个方法：getXxx() 和 setXxx()，任何浏览这些方法的工具，都会把get 或 set 后面的第一个字母自动转换为小写。
2. 对于布尔型属性，可以使用以上 get 和 set 的方式，不过也可以把 get 替换成 is。
3. Bean的普通方法不必遵循以上的命名规则，不过它们必须是 public 的。
4. 对于事件，要使用 Swing 中处理监听器的方式。如 addWindowListener，removeWindowListener

```java
// ====== BeanUtils ======
import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;
import java.lang.reflect.InvocationTargetException;
public class BeanTest {
  @Test
  public void test(){
    // 从客户端获取到的数据
    String name = "bin";
    String age = "18";
    Emp emp = new Emp();
    try {
      BeanUtils.setProperty(emp, "name", name);
      BeanUtils.setProperty(emp, "age", age);
      BeanUtils.setProperty(emp, "salary", salary);
    } catch (IllegalAccessException|InvocationTargetException e) {
      e.printStackTrace();
    }
    System.out.println(emp.getInfo());
  }
}

// ====== Emp.java ======
public class Emp {
  private String name;
  private int age;
  public String getName() { return name; }
  public void setName(String name) { this.name = name; }
  public int getAge() { return age; }
  public void setAge(int age) { this.age = age; }
  public String getInfo(){
    return "name=" + name + ",sage=" + age;
  }
}
```

#### Introspector 内省

- 是 Java 语言对 Bean 类属性、事件的一种缺省处理方法。例如类 A 中有属性 name，那我们可以通过 getName，setName 来得到其值或者设置新的值，这也是默认的规则。

```java
// ====== Test.java ======
import org.junit.Test;
public class BeanTest {
  @Test
  public void getBeanTest(){
    Config bean = (Config)BeanFactory.getBean("bean.name");
    System.out.println(bean);
  }
}

// ===通过内省的API来装配一个Bean对象，Bean对象的值是通过配置文件中来获取，目的是为了提高维护性 ===
import com.sun.corba.se.impl.ior.WireObjectKeyTemplate;
import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;
public class BeanFactory {
  private static Properties prop = new Properties();
  static { // 使用静态代码块读取配置文件
    InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream("com/vince/introspector/config.properties");
    try {
      prop.load(in);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
  // 获取一个Bean
  public static Object getBean(String name){
    Object bean = null;
    String beanName = prop.getProperty(name);
    try {
      Class<?> aClass = Class.forName(beanName);
      bean = aClass.newInstance();
      // 通过类信息获取javaBean的描述信息
      BeanInfo beanInfo = Introspector.getBeanInfo(aClass);
      // getMethodDescriptors() 获取该类的所有方法描述器(然后通过 getMethod() 获得此 MethodDescriptor 封装的方法)
      // getPropertyDescriptors() 获取该类的所有属性描述器
      PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
      for (int i = 0; i < propertyDescriptors.length; i++) {
        String propertyName = propertyDescriptors[i].getName(); // 获得属性名
        // getReadMethod() 获得用于读取属性值的方法
        // getWriteMethod() 获得用于写入属性值的方法
        Method writeMethod = propertyDescriptors[i].getWriteMethod();
        if("username".equals(propertyName)) {
          // 调用属性的set方法，写入该属性值
          writeMethod.invoke(bean, prop.getProperty("bean.username"));
        } else if ("password".equals(propertyName)){
          writeMethod.invoke(bean, prop.getProperty("bean.password"));
        } else if("url".equals(propertyName)){
          writeMethod.invoke(bean, prop.getProperty("bean.url"));
        }
      }
    } catch (ClassNotFoundException|IntrospectionException|IllegalAccessException|
             InstantiationException|InvocationTargetException e) {
      e.printStackTrace();
    }
    return bean;
  }
}

// ====== Config.java ======
public class Config {
  private String username;
  private String password;
  private String url;
  public Config(String username, String password, String url) {
    this.username = username;
    this.password = password;
    this.url = url;
  }
  public String getUsername() { return username; }
  public void setUsername(String username) { this.username = username; }
  public String getPassword() { return password; }
  public void setPassword(String password) { this.password = password; }
  public String getUrl() { return url; }
  public void setUrl(String url) { this.url = url; }
  public Config() {
  }
  @Override
  public String toString() {
    return "Config{" + "username='" + username + '\'' + ", password='" + password + '\'' + ", url='" + url + '\'' + '}';
  }
}
```

```properties
# ====== config.properties ======
bean.name=com.vince.introspector.Config
bean.username=admin
bean.password=123
bean.url=http://www.163.com
```

#### 可配置AOP框架的简单实现

- 面向切面编程
- 主要用于 权限、缓存、错误处理、调试、记录跟踪、持久化、同步、事务等。

```java
// ====== Test ======
import org.junit.Test;
import java.io.InputStream;
public class AOPTest {
    @Test
    public void test(){
        // 1 读取配置 文件
        InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream("com/vince/aop/bean.properties");
        // 2 创建Bean的工厂对象
        BeanFactory beanFactory = new BeanFactory(in);
        // 3 获取代理对象
        ProxyFactoryBean proxyFactoryBean = (ProxyFactoryBean) beanFactory.getBean("bean");
        IManager proxy = (IManager) proxyFactoryBean.getProxy();
        proxy.add("我是一只猫");
    }
}

// ====== BeanFactory.java ======
import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;
public class BeanFactory {
  Properties prop = new Properties();
  public BeanFactory(InputStream in){
    try {
      prop.load(in);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
  // 获取一个bean实例
  public Object getBean(String name){
    String className = prop.getProperty(name);
    Object bean = null;
    try {
      // 获取ProxyFactoryBean的class对象
      Class<?> aClass = Class.forName(className);
      bean = aClass.newInstance(); // 实例化对象
      // 根据配置文件实例化target和advice对象
      Object target = Class.forName(prop.getProperty(name + ".target")).newInstance();
      Object advice = Class.forName(prop.getProperty(name + ".advice")).newInstance();
      // 通过内省实现对 ProxyFactoryBean的属性赋值
      BeanInfo beanInfo = Introspector.getBeanInfo(aClass);
      PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
      for(PropertyDescriptor pd: propertyDescriptors){
        String propertyName = pd.getName();
        Method writeMethod = pd.getWriteMethod();
        if("target".equals(propertyName)){
          writeMethod.invoke(bean, target);
        } else if("advice".equals(propertyName)){
          writeMethod.invoke(bean, advice);
        }
      }
    } catch (ClassNotFoundException|IllegalAccessException|InstantiationException|
             IntrospectionException|InvocationTargetException e) {
      e.printStackTrace();
    }
    return bean;
  }
}

// ======  ProxyFactoryBean.java ======
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
public class ProxyFactoryBean implements InvocationHandler {
  private Object target;
  private Advice advice;
  public Object getProxy(){
    Object proxy = Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    return proxy;
  }
  @Override
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    advice.beforeAdvice();
    Object obj = method.invoke(target, args);
    advice.afterAdvice();
    return obj;
  }
  public Object getTarget() { return target; }
  public void setTarget(Object target) { this.target = target; }
  public Advice getAdvice() { return advice; }
  public void setAdvice(Advice advice) { this.advice = advice; }
}

// ====== IManagerImpl.java 类 ======
import java.util.ArrayList;
public class IManagerImpl implements IManager {
  private ArrayList<String> list = new ArrayList<>();
  @Override
  public void add(String item) {
    // System.out.println("add start "+ System.currentTimeMillis());
    list.add(item);
    System.out.println(item);
    // System.out.println("add end "+ System.currentTimeMillis());
  }
}
// ====== IManager.java 接口 ======
public interface IManager {
  public void add(String item);
}

// ====== 切面的实现类 LogAdvice.java ======
public class LogAdvice implements Advice{
  @Override
  public void beforeAdvice() {
    System.out.println("start time:" + System.currentTimeMillis());
  }
  @Override
  public void afterAdvice() {
    System.out.println("end time:" + System.currentTimeMillis());
  }
}
// ====== Advice.java 接口 ======
public interface Advice {
  public void beforeAdvice();
  public void afterAdvice();
}

```

```properties
# ====== bean.properties ======
bean.target=com.vince.aop.IManagerImpl
bean.advice=com.vince.aop.LogAdvice
bean=com.vince.aop.ProxyFactoryBean
```

### 泛型

- 泛型，即 “ **参数化类型** ”，是将类型由原来的具体的类型参数化，类似于方法中的变量参数，此时类型也定义成参数形式（可以称之为类型形参），然后在使用/调用时传入具体的类型（类型实参），即类中的属性的类型可以由外部决定。

#### 泛型类 / 泛型接口

T : 参数化类型，在实际使用时才会指定具体的类型，泛型只作用于编译期检查，在编译后，会被檫除

```java
// ====== 泛型类 ======
public class Node<T> {
  private T data;
  public Node(){}
  public Node(T data){
    this.data = data;
  }
  public T getData() {
    return data;
  }
  public void setData(T data) {
    this.data = data;
  }
  // 使用
  public static void main(String args) {
    Node<String> data = new Node();
    Node<String> data = new Node<>();
    Node<String> data = new Node<String>();
  }
  public static void getData(Node<String> data) {
    System.out.println("data :" + data.getData());
  }
}
// ====== 泛型接口 ======
public interface Function<T, R> {
  R apply(T t);
}
```

#### ? 通配符

- 使用通配符定义泛型类型，此时只能输出，不能修改。

```java
public static void getData(Node<?> data) {
  System.out.println("data :" + data.getData());
}
```

#### 泛型的上限与下限

```java
public static void getUpperNumberData(Node<? extends Number> data){ // 只能是 Number 类及其子类
  System.out.println("data :" + data.getData());
}
public static void getUpperNumberData(Node<? super Number> data){ // 只能是 Number 类及其父类
  System.out.println("data :" + data.getData());
}
```

#### 泛型方法

```java
// ====== 泛型方法 ======
public static <T> T[] func(T[] array, int i, int t){
  T temp = array[i];
  array[i] = array[t];
  array[t] = temp;
  return array;
}
```

#### 泛型嵌套使用

```java
Set<Entry<Integer, String>> entrys = map.entrySet();
```

### 正则表达式

#### Matcher 类，Pattern 类

```java
// ====== 正则表达式 ======
import org.junit.Test;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class RegexDemo {
  @Test
  public void test1(){
    // 创建一个匹配模式（模板）
    Pattern p = Pattern.compile("a*b");
    Matcher matcher = p.matcher("sb");
    boolean b = matcher.matches(); // 匹配
    System.out.println(b);
  }
  @Test
  public void test2(){
    String s = "5201314";
    boolean b = s.matches("[0-9]+");
    boolean b1 = s.matches("\\d+");
    System.out.println(b + "-" + b1);
  }
}
```

### 枚举

- jdk 1.5 之后

- 使用 enum 关键字定义的枚举类，实际上就相当于定义了一个类，此类继承了 Enum 类而已。
- 在 jdk 1.5 之后，对于 Set 和 Map 接口而言又增加了EnumSet、EnumMap 两个子类。

#### 一般定义

```java
public enum Color {
	RED,
  BLUE;
}
// 访问
Color c = Color.RED;
```

#### 带构造方法的枚举

```java
public enum Color {
	RED(10),
  BLUE(10);
	private Color() {}
	private int color;
	private Color(int color){
		this.color = color;
	}
}
```

#### 实现接口的枚举

```java
// ====== Info 接口 ======
public interface Info {
  public int getColor();
}
// ====== 实现接口的枚举 ======
public enum Color implements Info{
  RED(10) {
    @Override
    public String getColor2() { // 实现接口中定义的抽象方法
      return "red";
    }
  },
  GREEN(20) {
    @Override
    public String getColor2() { // 实现接口中定义的抽象方法
      return "green";
    }
  },
  BLUE {
    @Override
    public String getColor2() { // 实现接口中定义的抽象方法
      return "blue";
    }
  };
  private int color;
  private Color(){} // 无参构造器
  private Color(int color){ this.color = color; } // 有参构造器
  @Override
  public int getColor() { return color; } // 实现接口的方法
  public abstract String getColor2(); // 在接口中定义抽象方法
}
```

#### 枚举类型及其成员的操作方法

```java
public enum Color {
	RED,
  BLUE;
}
// 将枚举类型成员以数组形式返回
System.out.println(Color.values().length); // 2
System.out.println(Color.values()[0]); // RED
// 将普通类型转换为字符串
System.out.println(Color.valueOf('BLUE') === Color.BLUE); // true
// 比较两个枚举成员在定义时候的顺序
System.out.println(Color.BLUE.compareTo(Color.RED)); // 1
System.out.println(Color.BLUE.compareTo(Color.BLUE)); // 0
// 获取枚举成员的位置索引
System.out.println(Color.RED.ordinal()); // 0
System.out.println(Color.BLUE.ordinal()); // 1
```

### 注解

- jdk1.5 开始，Java增加了对元数据（即类的组成单元数据）的支持，也就是（Annotation）注解，它是代码里做的特殊标记，这些标记可以在编译，类加载，运行时在不改变原有逻辑的情况下，被读取，并执行相应的处理，通过使用Annotation，程序员可以在源文件中嵌入一些补充的信息。代码分析工具，开发工具和部署工具可以通过这些补充信息进行验证或者进行部署。Annotation类似于修饰符一样被使用，可以用于包，类，构造方法，方法，成员变量，参数，局部变量的声明。
- Annotation是一个接口。

#### 系统提供的 @Override、@Deprecated、@SuppressWarnings 三个注解

- **@Override**

  表示当前的方法定义将覆盖超类中的方法。如果你不小心拼写错误，或者方法签名对不上被覆盖的方法，编译器就会发出错误提示。

- **@Deprecated**

  表示的是一个类或方法已经不再建议继续使用了，标记为已过时。

- **@SuppressWarnings**

  表示关闭不当的编译器警告信息。

  - @SuppressWarnings(“unchecked”) // 未检查的转化，如集合没有指定类型

  - @SuppressWarnings(“unused”)  // 未使用的变量

  - @SuppressWarnings(“resource”)  // 有泛型未指定类型

  - @SuppressWarnings(“path”)  // 在类路径，原文件路径中有不存在的路径

  - @SuppressWarnings("deprecation")  // 使用了某些不赞成使用的类和方法

  - @SuppressWarnings("fallthrough") // switch语句执行到底没有break关键字

  - @SuppressWarnings("serial") // 某类实现Serializable 但是没有定义serialVersionUID 这个需要但是不必须的字段 

  - @SuppressWarnings("rawtypes")  // 没有传递带有泛型的参数

  - @SuppressWarnings("all")  // 全部类型的警告 

#### 自定义注解

- 格式：访问控制权限 @interface  Annotation 名称 { }

##### @Retention

- 确定注解的作用范围，而 Retention 指定的范围由 RetentiontPolicy 决定。

| 范围                                          | 描述                    |
| --------------------------------------------- | ----------------------- |
| public static final RetentionPolicy   SOURCE  | 在java源程序中存在      |
| public static final RetentionPolicy   CLASS   | 在java生成的class中存在 |
| public static final RetentionPolicy   RUNTIME | 在java运行的时候存在    |

##### @Documented

- 用于生成文档，表示可以添加注释。

##### @Target

- 表示的是一个Annotation的使用范围

| 范围                                              | 描述                       |
| ------------------------------------------------- | -------------------------- |
| public static final ElementType   TYPE            | 只能在类或接口或枚举上使用 |
| public static final ElementType   FIELD           | 在成员变量使用             |
| public static final ElementType   METHOD          | 在方法中使用               |
| public static final ElementType   PARAMETER       | 在参数上使用               |
| public static final ElementType   CONSTRUCTOR     | 在构造中使用               |
| public static final ElementType   LOCAL_VARIABLE  | 局部变量上使用             |
| public static final ElementType   ANNOTATION_TYPE | 只能在Annotation中使用     |
| public static final ElementType   PACKAGE         | 只能在包中使用             |

##### @Inherited

- 表示注解能否被其子类继承。

```java
// ====== 自定义注解 ======
import java.lang.annotation.*;
// 用于生成文档
@Documented
// 表示该注解的作用范围在运行时存在
@Retention(RetentionPolicy.RUNTIME)
// 用于表示注解的应用范围（类型，方法，属性，构造器，参数，局部变量，包，Annotation）
@Target(ElementType.TYPE)
// 表示注解可以被其子类继承
@Inherited
public @interface MyAnnotation {
  // 定义变量
  public String name();
  public int age() default 2; // 给变量设置默认值
  public String[] like(); // 定义一个数组变量
  public Color color(); // 定义一个枚举类型的变量
}

// ====== 使用注解 ======
import java.util.Arrays;
@MyAnnotation(name = "bin", like = {"金鱼", "鲫鱼", "鲤鱼"}, color = Color.GREEN)
public class Cat {
  private String name;
  private int age;
  private Color color;
  private String[] like;
  public String[] getLike() { return like; }
  public void setLike(String[] like) { this.like = like; }
  public Color getColor() { return color; }
  public void setColor(Color color) { this.color = color; }
  public String getName() { return name; }
  public void setName(String name) { this.name = name; }
  public int getAge() { return age; }
  public void setAge(int age) { this.age = age; }
  // 用于验证方法是否覆盖父类中的方法
  @Override
  public String toString() {
    return "Cat{" + "name='" + name + '\'' + ", age=" + age + ", color=" + color + ", like=" + Arrays.toString(like) + '}';
  }
  // 用于标记方法已过时，不建议使用
  @Deprecated
  public String printInfo(){
    return "Cat{" + "name='" + name + '\'' + ", age=" + age + '}';
  }
  public Cat() {}
  public Cat(String name, int age) {
    this.name = name;
    this.age = age;
  }
}

// ====== 对应用了注解的类进行反射操作的类 ======
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
// 关闭全部类型的警告
@SuppressWarnings("all")
public class AnnotationDemo {
  // 反射来处理注解
  @Test // Test注解，可以进行指定的方法测试
  public void test2(){
    Class<Cat> catClass = Cat.class;
    // 获取类上应用的指定注解
    MyAnnotation annotation = catClass.getAnnotation(MyAnnotation.class);
    // 获取注解上变量值
    String name = annotation.name();
    int age = annotation.age();
    Color color = annotation.color();
    String[] like = annotation.like();
    try {
      // 把注解上获取到的值应用到实例中
      Cat cat = catClass.newInstance();
      cat.setName(name);
      cat.setAge(age);
      cat.setLike(like);
      cat.setColor(color);
      System.out.println(cat);
    } catch (InstantiationException|IllegalAccessException e) {
      e.printStackTrace();
    }
  }
}
```

### XML 与 JSON

#### SAX 解析 XML

- SAX 是读取和操作 XML 数据更快速、更轻量的方法。
- SAX 允许您在读取文档时处理它，从而不必等待整个文档被存储之后才采取操作，它不涉及 DOM 所必需的开销和概念跳跃。
- SAX API 是一个基于事件的 API ，适用于处理数据流，即随着数据的流动而依次处理数据。
- SAX API 在其解析您的文档时发生一定事件的时候会通知您，在您对其响应时，您不作保存的数据将会被抛弃。
- 主要有四种处理事件的接口，它们分别是ContentHandler，DTDHandler， EntityResolver 和 ErrorHandler 。实际上只要继承 DefaultHandler 类就可以，DefaultHandler 实现了这四个事件处理器接口，然后提供了每个抽象方法的默认实现。

```java
// ====== SAX 解析 XML ======
import org.junit.Test;
import org.xml.sax.SAXException;
import javax.print.Doc;
import javax.xml.parsers.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class XMLDemo {
  /** SAX 解析的特点
   * 1、基于事件驱动
   * 2、顺序读取，速度快
   * 3、不能任意读取节点（灵活性差）
   * 4、解析时占用的内存小
   * 5、SAX更适用于在性能要求更高的设备上使用（Android开发中）
   */
  @Test
  public void saxParseXML() throws ParserConfigurationException, SAXException, IOException {
    // 1、创建一个SAX解析器工厂对象
    SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
    // 2、通过工厂对象创建SAX解析器
    SAXParser saxParser = saxParserFactory.newSAXParser();
    // 3、创建一个数据处理器（需要我们自己来编写）
    PersonHandler personHandler = new PersonHandler();
    // 4、开始解析
    InputStream is = Thread.currentThread().getContextClassLoader()
      .getResourceAsStream("com/vince/xml/person.xml");
    saxParser.parse(is, personHandler);
    List<Person> persons = personHandler.getPersons();
    for (Person p: persons) {
      System.out.println(p);
    }
  }
}

// ====== personHandler 数据处理器 ======
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.ArrayList;
import java.util.List;
public class PersonHandler extends DefaultHandler{
  private List<Person> persons = null;
  private Person p; // 当前正在解析的person
  private String tag; // 用于记录当前正在解析的标签名
  public List<Person> getPersons() { return persons; }
  // 开始解析文档时调用
  @Override
  public void startDocument() throws SAXException {
    super.startDocument();
    persons = new ArrayList<>();
    System.out.println("开始解析文档...");
  }
  // 在XML文档解析结束时调用
  @Override
  public void endDocument() throws SAXException {
    super.endDocument();
    System.out.println("解析文档结束.");
  }
  /**
   * 解析开始元素时调用
   * @param uri 命名空间
   * @param localName 不带前缀的标签名
   * @param qName 带前缀的标签名
   * @param attributes 当前标签的属性集合
   */
  @Override
  public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
    super.startElement(uri, localName, qName, attributes);
    if ("person".equals(qName)){
      p = new Person();
      String personid = attributes.getValue("personid");
      p.setPersonid(personid);
    }
    tag = qName;
    System.out.println("startElement--" + qName);
  }
  // 解析结束元素时调用
  @Override
  public void endElement(String uri, String localName, String qName) throws SAXException {
    super.endElement(uri, localName, qName);
    if ("person".equals(qName)) {
      persons.add(p);
    }
    tag = null;
    System.out.println("endElement--" + qName);
  }
  // 解析文本内容时调用
  @Override
  public void characters(char[] ch, int start, int length) throws SAXException {
    super.characters(ch, start, length);
    if (tag != null) {
      if ("name".equals(tag)) {
        p.setName(new String(ch, start, length));
      } else if ("address".equals(tag)){
        p.setAddress(new String(ch, start, length));
      } else if ("tel".equals(tag)){
        p.setTel(new String(ch, start, length));
      } else if ("fax".equals(tag)){
        p.setFax(new String(ch, start, length));
      } else if ("email".equals(tag)){
        p.setEmail(new String(ch, start, length));
      }
      System.out.println(ch);
    }
  }
}
```

```xml
<!-- person.xml -->
<?xml version="1.0" encoding="UTF-8"?>
<people>
  <person personid="E01">
    <name>Tony Blair</name>
    <address>10 Downing Street, London, UK</address>
    <tel>(061) 98765</tel>
    <fax>(061) 98765</fax>
    <email>blair@everywhere.com</email>
  </person>
  <person personid="E02">
    <name>Bill Clinton</name>
    <address>White House, USA</address>
    <tel>(001) 6400 98765</tel>
    <fax>(001) 6400 98765</fax>
    <email>bill@everywhere.com</email>
  </person>
</people>
```

#### DOM 解析 XML

- Document Object Model（文档对象模型）
- 定义一组 Java 接口，基于对象，与语言和平台无关将 XML 文档表示为树，在内存中解析和存储 XML 文档，允许随机访问文档的不同部分。
- **DOM的优点：**由于树在内存中是持久的，因此可以修改后更新。它还可以在任何时候在树中上下导航，API使用起来也较简单。

```java
// ====== DOM 解析 XML ======
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import javax.print.Doc;
import javax.xml.parsers.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class XMLDemo {
  /** DOM解析XML
   * 1、基于树型结构，通过解析器一次性把文档加载到内存中，所以会比较占用内存，可以随机访问
   * 更加灵活，更适合在WEB开发中使用
   */
  @Test
  public void domParseXML() throws ParserConfigurationException, IOException, SAXException {
    // 1、创建一个DOM解析器工厂对象
    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    // 2、通过工厂对象创建解析器对象
    DocumentBuilder documentBuilder = factory.newDocumentBuilder();
    // 3、解析文档
    InputStream is = Thread.currentThread().getContextClassLoader()
      .getResourceAsStream("com/vince/xml/person.xml");
    // 此代码完成后，整个XML文档已经被加载到内存中，以树状形式存储
    Document doc = documentBuilder.parse(is);
    // 4、从内存中读取数据
    // 获取节点名称为person的所有节点，返回节点集合
    NodeList personNodeList = doc.getElementsByTagName("person");
    ArrayList<Person> persons = new ArrayList<>();
    Person p = null;
    // 此循环会迭代两次
    for (int i = 0; i < personNodeList.getLength(); i++) {
      Node personNode = personNodeList.item(i); // 返回 personNodeList 中的第 i 个节点
      p = new Person();
      // 获取节点的属性值
      String personid = personNode.getAttributes().getNamedItem("personid").getNodeValue();
      p.setPersonid(personid);
      // 获取当前节点的所有子节点
      NodeList childNodes = personNode.getChildNodes();
      for (int j = 0; j < childNodes.getLength(); j++){
        Node item = childNodes.item(j);
        String nodeName = item.getNodeName();
        if ("name".equals(nodeName)) {
          p.setName(item.getFirstChild().getNodeValue());
        } else if ("address".equals(nodeName)) {
          p.setAddress(item.getFirstChild().getNodeValue());
        } else if ("tel".equals(nodeName)) {
          p.setTel(item.getFirstChild().getNodeValue());
        } else if ("fax".equals(nodeName)) {
          p.setFax(item.getFirstChild().getNodeValue());
        } else if ("email".equals(nodeName)) {
          p.setEmail(item.getFirstChild().getNodeValue());
        }
      }
      persons.add(p);
    }
    System.out.println("结果:");
    System.out.println(Arrays.toString(persons.toArray()));
  }
}
```

#### JDOM 解析 XML

- 简化了与 XML 的交互并且比使用 DOM 实现更快
- JDOM 仅使用具体类而不使用接口。这在某些方面简化了 API，但是也限制了灵活性。
- JDOM 的 API 大量使用了 Collections 类，简化了那些已经熟悉这些类的 Java 开发者的使用。

```java
// ====== JDOM 解析 XML ======
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.junit.Test;
import org.xml.sax.SAXException;
import javax.print.Doc;
import javax.xml.parsers.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class XMLDemo {
  /** JDOM解析 XML
   * 1、与DOM类似基于树型结构，
   * 2、与DOM的区别：
   * （1）第三方开源的组件
   * （2）实现使用 JAVA 的 Collection 接口
   * （3）效率比 DOM 更快
   */
  @Test
  public void jdomParseXML() throws JDOMException, IOException {
    SAXBuilder builder = new SAXBuilder(); // 创建JDOM解析器
    InputStream is = Thread.currentThread().getContextClassLoader()
      .getResourceAsStream("com/vince/xml/person.xml");
    org.jdom2.Document build = builder.build(is); // 获取DOM文档对象
    Element rootElement = build.getRootElement(); // 获取根元素
    List<Person> list = new ArrayList<>();
    Person person = null;
    List<Element> children = rootElement.getChildren();
    for(Element element: children){
      person = new Person();
      String personid = element.getAttributeValue("personid");
      person.setPersonid(personid);
      List<Element> children1 = element.getChildren();
      for (Element e: children1) {
        String tag = e.getName();
        if ("name".equals(tag)){
          person.setName(e.getText());
        } else if ("address".equals(tag)){
          person.setAddress(e.getText());
        } else if ("tel".equals(tag)){
          person.setTel(e.getText());
        } else if ("fax".equals(tag)){
          person.setFax(e.getText());
        } else if ("email".equals(tag)){
          person.setEmail(e.getText());
        }
      }
      list.add(person);
    }
    System.out.println("结果：");
    System.out.println(Arrays.toString(list.toArray()));
  }
}
```

#### DOM4J 解析 XML

- dom4j 是一个非常非常优秀的 Java XML API，具有性能优异、功能强大和极端易用使用的特点，同时它也是一个开放源代码的软件，可以在SourceForge上找到它。
- 在对主流的 Java XML API 进行的性能、功能和易用性的评测，dom4j 无论在那个方面都是非常出色的。
- 如今你可以看到越来越多的Java软件都在使用dom4j来读写XML，特别值得一提的是连 Sun 的 JAXM 也在用dom4j，这是必须使用的jar包， Hibernate用它来读写配置文件。

```java
// ====== DOM4J 解析 XML ======
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;
import org.junit.Test;
import org.xml.sax.SAXException;
import javax.print.Doc;
import javax.xml.parsers.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
public class XMLDemo {
  /** DOM4J解析XML
   * 基于树型结构，第三方组件
   * 解析速度快，效率更高，使用的JAVA中的迭代器实现数据读取，在WEB框架中使用较多（Hibernate)
   */
  @Test
  public void dom4jParseXML() throws DocumentException {
    SAXReader reader = new SAXReader(); // 创建DOM4J的解析器对象
    InputStream is = Thread.currentThread().getContextClassLoader()
      .getResourceAsStream("com/vince/xml/person.xml");
    org.dom4j.Document doc = reader.read(is); // 获取DOM文档对象
    org.dom4j.Element rootElement = doc.getRootElement(); // 获取根元素
    Iterator<org.dom4j.Element> iterator = rootElement.elementIterator();
    ArrayList<Person> persons = new ArrayList<>();
    Person p = null;
    while(iterator.hasNext()){
      p = new Person();
      org.dom4j.Element e = iterator.next();
      p.setPersonid(e.attributeValue("personid"));
      Iterator<org.dom4j.Element> iterator1 = e.elementIterator();
      while (iterator1.hasNext()) {
        org.dom4j.Element next = iterator1.next();
        String tag = next.getName();
        if ("name".equals(tag)) {
          p.setName(next.getText());
        } else if ("address".equals(tag)){
          p.setAddress(next.getText());
        } else if ("tel".equals(tag)){
          p.setTel(next.getText());
        } else if ("fax".equals(tag)){
          p.setFax(next.getText());
        } else if ("email".equals(tag)){
          p.setEmail(next.getText());
        }
      }
      persons.add(p);
    }
    System.out.println("结果：");
    System.out.println(Arrays.toString(persons.toArray()));
  }
}
```

#### 使用第三方 xstream 组件解析与生成 XML

```java
// ====== 使用第三方 xstream 组件解析与生成 XML ======
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.Xpp3DomDriver;
import com.thoughtworks.xstream.io.xml.Xpp3Driver;
import org.junit.Test;
import org.xml.sax.SAXException;
import javax.print.Doc;
import javax.xml.parsers.*;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class XMLDemo {
  // === 使用第三方 xstream 组件解析与生成 XML ===
  @Test
  public void xStream(){
    Person p = new Person();
    p.setPersonid("1212");
    p.setAddress("北京");
    p.setEmail("vince@163.com");
    p.setFax("6768789798");
    p.setTel("13838389438");
    p.setName("38");
    XStream xs = new XStream(new Xpp3Driver());
    xs.alias("person", Person.class);
    xs.useAttributeFor(Person.class, "personid");
    String xml = xs.toXML(p);
    System.out.println(xml);
    // 解析 XML
    Person person = (Person)xs.fromXML(xml);
    System.out.println(person);
  }
  // === 从 XML 文件中读取对象 ===
  @Test
  public void xmlDecoder() throws FileNotFoundException {
    BufferedInputStream in = new BufferedInputStream(new FileInputStream("test.xml"));
    XMLDecoder decoder = new XMLDecoder(in);
    Person p = (Person)decoder.readObject();
    System.out.println(p);
  }
  // === 把对象转成 XML 文件写入 ===
  @Test
  public void xmlEncoder() throws FileNotFoundException {
    BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("test.xml"));
    XMLEncoder xmlEncoder = new XMLEncoder(bos);
    Person p = new Person();
    p.setPersonid("1212");
    p.setAddress("北京");
    p.setEmail("vince@163.com");
    p.setFax("6768789798");
    p.setTel("13838389438");
    p.setName("38");
    xmlEncoder.writeObject(p);
    xmlEncoder.close();
  }
}
```

#### XML 解析方法比较

- JDOM 和 DOM 在性能测试时表现不佳，在测试 10M 文档时内存溢出。
- SAX表现较好，这要依赖于它特定的解析方式，一个 SAX 检测即将到来的XML流，但并没有载入到内存（当然当XML流被读入时，会有部分文档暂时隐藏在内存中）。
- **DOM4J 是这场测试的获胜者**，目前许多开源项目中大量采用 DOM4J，例如大名鼎鼎的 Hibernate 也用 DOM4J 来读取 XML 配置文件。

#### GSON 解析 JSON

##### 使用 JsonReader

```java
// ====== 使用 JsonReader 解析复杂的 JSON 数据 ======
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import org.junit.Test;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
public class JsonDemo2 {
  @Test
  public void parseJSONMessages(){
    InputStream is = Thread.currentThread().getContextClassLoader().
      getResourceAsStream("com/vince/json/message.json");
    InputStreamReader in = new InputStreamReader(is);
    JsonReader jsonReader = new JsonReader(in);
    ArrayList<Message> list = readMessageArray(jsonReader);
    for (Message m: list){
      System.out.println(m);
    }
  }
  // 读取 Message 数组
  private ArrayList<Message> readMessageArray(JsonReader jsonReader) {
    ArrayList<Message> list = new ArrayList<>();
    try {
      jsonReader.beginArray();
      while (jsonReader.hasNext()) {
        list.add(readMessage(jsonReader));
      }
      jsonReader.endArray();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return list;
  }
  // 解析一个Message对象
  private Message readMessage(JsonReader jsonReader) {
    Message m = new Message();
    try {
      jsonReader.beginObject();
      while (jsonReader.hasNext()) {
        String name = jsonReader.nextName();
        if ("id".equals(name)) {
          m.setId(jsonReader.nextLong());
        } else if ("text".equals(name)){
          m.setText(jsonReader.nextString());
        } else if ("geo".equals(name) && jsonReader.peek()!= JsonToken.NULL){
          m.setGeo(readGeo(jsonReader));
        } else if ("user".equals(name)){
          m.setUser(readUser(jsonReader));
        } else {
          jsonReader.skipValue();
        }
      }
      jsonReader.endObject();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return m;
  }
  // 解析 User 对象
  private User readUser(JsonReader jsonReader) {
    User user = new User();
    try {
      jsonReader.beginObject();
      while (jsonReader.hasNext()){
        String name = jsonReader.nextName();
        if ("name".equals(name)) {
          user.setName(jsonReader.nextString());
        } else if ("followers_count".equals(name)){
          user.setFollowers_count(jsonReader.nextInt());
        } else {
          jsonReader.skipValue();
        }
      }
      jsonReader.endObject();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return user;
  }
  // 解析 GEO
  private ArrayList<Double> readGeo(JsonReader jsonReader) {
    ArrayList<Double> list = new ArrayList<>();
    try {
      jsonReader.beginArray();
      while (jsonReader.hasNext()){
        list.add(jsonReader.nextDouble());
      }
      jsonReader.endArray();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return list;
  }
}
```

```json
# ====== message.json ======
[
  {
    "id": 912345678901,
    "text": "How do I read a JSON stream in Java?",
    "geo": null,
    "user": {
      "name": "json_newb",
      "followers_count": 41
    }
  },
  {
    "id": 912345678902,
    "text": "@json_newb just use JsonReader!",
    "geo": [50.454722, -104.606667],
    "user": {
      "name": "jesse",
      "followers_count": 2
    }
  }
]
```

##### 使用Gson

```java
// ====== 使用 Gson ======
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonToken;
import org.junit.Test;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
public class JsonDemo3 {
  // === 生成 JSON ===
  @Test
  public void createJSON(){
    List<Name> list = new ArrayList<>();
    list.add(new Name("vince", "ma", "1791705739@qq.com"));
    list.add(new Name("jack", "wang", "jack@qq.com"));
    JsonArray array = new JsonArray();
    for (Name n: list) {
      JsonObject obj = new JsonObject();
      obj.addProperty("firstName", n.getFirstName());
      obj.addProperty("lastName", n.getLastName());
      obj.addProperty("email", n.getEmail());
      array.add(obj);
    }
    System.out.println(array.toString());
  }
  // === 把一个 JSON 对象转换成 JAVA 对象，或把一个 JAVA 对象转换成 JSON 对象 ===
  @Test
  public void gson1(){
    Gson gson = new Gson();
    InputStream is = Thread.currentThread().getContextClassLoader()
      .getResourceAsStream("com/vince/json/name.json");
    InputStreamReader in = new InputStreamReader(is);
    Name name = gson.fromJson(in, Name.class);
    System.out.println(name);
    String json = gson.toJson(name);
    System.out.println(json);
  }
  // === 把一组 JSON 对象转换成一个 JAVA 对象集合，或者把一个 JAVA 对象集合转换成 JSON 数组 ===
  @Test
  public void gson2(){
    Gson gson = new Gson();
    InputStream is = Thread.currentThread().getContextClassLoader()
      .getResourceAsStream("com/vince/json/names.json");
    InputStreamReader in = new InputStreamReader(is);
    TypeToken<List<Name>> typeToken = new TypeToken<List<Name>>(){};
    List<Name> list = gson.fromJson(in, typeToken.getType());
    System.out.println(list);
    String json = gson.toJson(list, typeToken.getType());
    System.out.println(json);
  }
}
```

```json
# ====== name.json ======
{
  "firstName": "Vince",
  "lastName": "Ma",
  "email": "1791705739@qq.com"
}
```

```json
# ====== names.json ======
[
  {
    "firstName": "Vince",
    "lastName": "Ma",
    "email": "1791705739@qq.com"
  },
  {
    "firstName": "Jason",
    "lastName": "Hunter",
    "email": "jason@google.com"
  }
]
```

















