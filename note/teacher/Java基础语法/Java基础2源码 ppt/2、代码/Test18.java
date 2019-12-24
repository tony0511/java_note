/**
	switch分支语句
	输入一个月数，然后输出对应月份有多少天（不考虑闰年），将天数输出。
*/
import java.util.Scanner;
public class Test18{
	public static void main(String[] args){

		Scanner input = new Scanner(System.in);
		System.out.println("请输入月份（1-12）");
		int month = input.nextInt();
		switch(month){

			case 1:
				System.out.println("31天");
				break;
			case 2:
				System.out.println("28天");
				break;
			case 3:
				System.out.println("31天");
				break;
			case 4:
				System.out.println("30天");
				break;
			case 5:
				System.out.println("31天");
				break;
			case 6:
				System.out.println("30天");
				break;
			case 7:
				System.out.println("31天");
				break;
			case 8:
				System.out.println("31天");
				break;
			case 9:
				System.out.println("30天");
				break;
			case 10:
				System.out.println("31天");
				break;
			case 11:
				System.out.println("30天");
				break;
			case 12:
				System.out.println("31天");
				break;
			default:
				System.out.println("地球上没有这个月份，请回火星");
				break;

		}

	}
}