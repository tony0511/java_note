/* 模拟双色球 */

import java.util.Random;
import java.util.Arrays;
import java.util.Scanner;

class Cat {
  private String name;
  private int age;
  public void setName (String name) {
    this.name = name;
  }
  public String getName () {
    return name;
  }
  public void setAge (int age) {
    this.age = age;
  }
}

public class RedBall {

  public RedBall (int n) {
    System.out.println("红球" + n);
  }

  public static void main (String[] args) {
    Cat cat = new Cat();
    cat.setName("咪咪");
    cat.setAge(3);
    System.out.println(cat.getName());
    // play();
  }

  public static void play () {
    int[] sysRedBall = new int[6];
    int sysBlueBall = 0;
    int[] userRedBall = new int[6];
    int userBlueBall = 0;
    int[] allRedBall = new int[33];

    int allLn = allRedBall.length;
    for (int i = 0; i < allLn; i++) {
      allRedBall[i] = i + 1;
    }
    Random r = new Random();

    // 获取系统随机中奖号码
    int sysLn = sysRedBall.length;
    for (int i = 0; i < sysLn; i++) {
      int nowAllLn = allRedBall.length;
      int rNum = r.nextInt(nowAllLn);
      sysRedBall[i] = allRedBall[rNum];
      allRedBall[rNum] = allRedBall[nowAllLn - 1];
      allRedBall = Arrays.copyOf(allRedBall, nowAllLn - 1);
    }
    sysBlueBall = r.nextInt(16) + 1;
    Arrays.sort(sysRedBall);

    Scanner input = new Scanner(System.in);

    // 用户输入号码
    int userLn = userRedBall.length;
    for (int i = 0;;) {
      int num;
      if (i < 6) {
        System.out.print("请输入第" + (i + 1) + "个红球号码：");
        num = input.nextInt();
        if (num > 33 || num < 1) {
          System.out.print("红球数字必须在1~33之间，请继续输入：");
        } else if (Arrays.binarySearch(userRedBall, num) > 0) {
          System.out.print("红球数字重复了，请继续输入：");
        } else {
          userRedBall[userLn - i - 1] = num;
          Arrays.sort(userRedBall);
          i += 1;
        }
      } else if (i == 6) {
        System.out.print("请输入一个蓝球号码：");
        num = input.nextInt();
        if (num > 16 || num < 1) {
          System.out.print("蓝球数字必须在1~16之间，请继续输入：");
        } else {
          userBlueBall = num;
          i += 1;
        }
      } else break;
    }

    // 打印出系统的中奖号码
    System.out.println("中奖号码为：");
    System.out.println("红球：" + Arrays.toString(sysRedBall));
    System.out.println("蓝球：" + sysBlueBall);

    // 打印用户的号码
    System.out.println("用户选择的号码为：");
    System.out.println("红球：" + Arrays.toString(userRedBall));
    System.out.println("蓝球：" + userBlueBall);

    int rightRedBall = 0;
    int rightBlueBall = 0;

    for (int x:userRedBall) {
      if (Arrays.binarySearch(sysRedBall, x) > 0) rightRedBall += 1;
    }
    if (userBlueBall == sysBlueBall ) rightBlueBall = 1;

    // 打印中奖情况：
    System.out.println("用户中奖球个数为：\n红球：" + rightRedBall + "个，蓝球：" + rightBlueBall + "个");
    if (rightBlueBall == 1 && rightRedBall < 3) {
      System.out.println("恭喜你中了：六等奖（5元）");
    } else if (rightBlueBall + rightRedBall == 4) {
      System.out.println("恭喜你中了：五等奖（10元）");
    } else if (rightBlueBall + rightRedBall == 5) {
      System.out.println("恭喜你中了：四等奖（200元）");
    } else if (rightBlueBall == 1 && rightRedBall == 5) {
      System.out.println("恭喜你中了：三等奖（3000元）");
    } else if (rightBlueBall == 0 && rightRedBall == 6) {
      System.out.println("恭喜你中了：二等奖（当期最高等奖奖金的30%）");
    } else if (rightBlueBall == 1 && rightRedBall == 6) {
      System.out.println("恭喜你中了：一等奖（几百万甚至千万大奖）");
    } else {
      System.out.println("很遗憾没能中奖😞，如需继续投注请输入 1，否则输入其他数字：");
      int str = input.nextInt();
      if (str == 1) {
        System.out.println("==== 请继续投注 ====");
        play();
      }
    }
  }
}

