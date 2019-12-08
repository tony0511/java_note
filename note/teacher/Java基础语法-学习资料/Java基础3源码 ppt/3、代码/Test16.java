/**
	Arrays工具类的使用


*/
import java.util.Scanner;
import java.util.Arrays;

public class Test16{
	public static void main(String[] args){

		int[] num = {45,65,76,87,98,901};

		//二分查找
		int index = Arrays.binarySearch(num,98);
		System.out.println("找到的下标是："+index);

		//输出数组
		for(int n: num){
			System.out.println(n);
		}
		//在测试输出数据时，可以使用，更加方便
		System.out.println(Arrays.toString(num));

		//排序
		int[] num2 = {10,32,11,44,543,22,12};
		Arrays.sort(num2);//快速排序
		System.out.println(Arrays.toString(num2));

		//数组的复制
		int[] num3 = Arrays.copyOf(num2,10);
		System.out.println(Arrays.toString(num3));

		//
		int[] newNum = new int[num2.length];
		System.arraycopy(num2,0,newNum,0,num2.length);
		System.out.println(Arrays.toString(newNum));

		//小结，数组的复制：
		/*
			效率由高到低排序是：System.arraycopy -> Arrays.copyOf -> for
		*/

		//判断两个数组的值是否相等
		System.out.println(Arrays.equals(num2,newNum));

		//填充数组
		Arrays.fill(newNum,0);
		System.out.println(Arrays.toString(newNum));
	}


}



