
/**
	if分支语句
	1、输入一个字符，判断是大写字母还是小写字母，输出提示信息。
*/
import java.util.Scanner;
public class Test13{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.println("请输入一个字母:");
		int c = input.nextInt();
		if(c>=65 && c<=90){
			System.out.println("您输入的是一个大写字母"+(char)c);
		}else {
			System.out.println("您输入的是一个小写字母"+(char)c);
		}


		//写一个程序，判断某一年是否为闰年（被4整除但不能被100整除能被400整除)是闰年否则是平年
		System.out.println("请输入年份");
		int year = input.nextInt();
		if((year%4==0 && year%100!=0) || year%400==0){

			System.out.println("是闰年");
		}else{
			System.out.println("平年");
		}
	}
}