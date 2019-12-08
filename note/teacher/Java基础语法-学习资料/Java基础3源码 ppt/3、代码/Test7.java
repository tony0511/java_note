/**
	数组的遍历

*/
import java.util.Scanner;
public class Test7{
	public static void main(String[] args){

		int[] scores = {59,75,83,93,100};
		System.out.println("数组的长度："+scores.length);

		//for遍历
		int len = scores.length;
		for(int i=0;i<len;i++){

			int score = scores[i];
			System.out.println(score);
		}
		System.out.println(scores);

		System.out.println("-----------------");
		//forearch JDK1.5之后新增的特性
		for(int x:scores){
			System.out.println(x);
		}
		System.out.println("--------------");
		//调用方法
		//print(scores);
		//print2(59,75,83,93,100);

		//print3(null);

		print4(scores);


		//new关键字表示创建一个数组，
		int[] nums = new int[]{1,2,3,4,5};

	}

	public static void print(int[] x){
		int len = x.length;
		for(int i=0;i<len;i++){

			System.out.println(x[i]);
		}
	}

	//JDK1.5可变参数
	//可变参数只能是参数列表中的最后一个
	//可变参数作为数组使用
	public static void print2(int k,int... x){
		int len = x.length;
		for(int i=0;i<len;i++){

			System.out.println(x[i]);
		}
	}

	//测试数组的异常NullPointerException(空指针)
	public static void print3(int[] x){
		// java.lang.NullPointerException
		//当一个变量为null（没有赋值时）时，我们去调用了该变量的属性和方法
		System.out.println("数组的长度为："+x.length);
	}
	//测试数组的异常,数组下标越界
	// java.lang.ArrayIndexOutOfBoundsException
	public static void print4(int[] x){
		for(int i=0;i<=x.length;i++){
			System.out.println(x[i]);
		}
	}
}



