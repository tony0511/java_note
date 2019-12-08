/**
	for循环
	打印输出0~200之间能被7整除但不能被4整除的所有整数；
*/
import java.util.Scanner;
public class Test27{
	public static void main(String[] args){

		for(int i=0;i<200;i++){
			if(i%7==0 && i%4!=0){
				System.out.println(i);
			}
		}
	}
}