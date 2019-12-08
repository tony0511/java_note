/**
	方法（函数）
	方法的重载:在同一个类中，方法名相同，参数列表不同，返回值不能作为重载的条件。
*/
import java.util.Scanner;
public class Test5{
	public static void main(String[] args){

		int result = add(10,20);
		System.out.println(result);
	}

	public static int add(int a,int b){
		return a+b;
	}
	public static float add(float a,float b){
		return a+b;
	}
	public static float add(int a,float b){
		return a+b;
	}
}