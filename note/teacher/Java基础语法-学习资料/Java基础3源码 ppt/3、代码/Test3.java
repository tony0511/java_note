/**
	方法（函数）
	方法的返回值 :1、判断任意给定年份是否是闰年
*/
import java.util.Scanner;
public class Test3{
	public static void main(String[] args){

		//调用方法
		//杯子 = 榨汁机(烂香蕉，红苹果，鸡蛋);
		boolean bool = isRunNian(2017);
		if(bool){
			System.out.println("闰年");
		}else{
			System.out.println("平年");
		}

		//
		print();
	}

	public static boolean isRunNian(int year){

		if((year%4==0 && year%100!=0) || year%400==0){
			return true;
		}else{
			return false;
		}
	}

	public static void print(){
		for(int i=0;i<10;i++){
			if(i==5){
				return;//表示方法结束
			}
			System.out.println(i);
		}
	}
}