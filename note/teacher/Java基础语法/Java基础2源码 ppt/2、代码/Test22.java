/**
	while循环
	2、计算10的阶乘
*/
import java.util.Scanner;
public class Test22{
	public static void main(String[] args){

		int i = 1;
		int num = 1;
		while(i<=10){
			num *= i;
			i++;
		}
		System.out.println(num);

	}
}