/**
	do while循环：先执行，再判断，最少执行一次
	1、逆序输出10~0

*/
import java.util.Scanner;
public class Test24{
	public static void main(String[] args){

		int i = 10;
		do{
			//循环体
			System.out.println(i);
			i--;
		}while(i>=0);//循环条件

	}
}