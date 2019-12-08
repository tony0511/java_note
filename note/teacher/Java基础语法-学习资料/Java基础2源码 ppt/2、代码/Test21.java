/**
	while循环
	1、计算1-100之间所有整数之和。5050

*/
import java.util.Scanner;
public class Test21{
	public static void main(String[] args){

		int num = 0; //计算总数
		int i = 1; //增量
		while(i<=100){
			num+=i;
			i++;
		}
		System.out.println(num);

	}
}