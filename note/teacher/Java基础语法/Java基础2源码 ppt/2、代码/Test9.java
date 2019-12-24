
/**
根据天数（46）计算周数和剩余的天数，天数是通过键盘输入。
*/
import java.util.Scanner;
public class Test9{
  public static void main(String[] args){
    Scanner input = new Scanner(System.in);
    System.out.println("请输入天数：");
    int day = input.nextInt();
    System.out.println("周数是："+(day/7));
    System.out.println("剩余的天数："+(day%7));

  }
}
