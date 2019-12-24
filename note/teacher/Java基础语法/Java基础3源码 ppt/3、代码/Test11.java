/**
	求最大值和最小值算法

*/
import java.util.Scanner;
public class Test11{
	public static void main(String[] args){

		int[] num = {12,3,54,67,88,34};
		int max = max(num);
		System.out.println("数列中的最大值是："+max);
		int min = min(num);
		System.out.println("数列中的最小值是："+min);
	}

	//求数列中的最大值
	public static int max(int[] num){
		int max = num[0];
		int len = num.length;
		for(int i=1;i<len;i++){
			if(num[i]>max){
				num[i] = num[i]+max;
				max = num[i]-max;
				num[i] = num[i]-max;
			}
		}
		return max;
	}

	//求数列中的最小值
	public static int min(int[] num){
		int min = num[0];
		int len = num.length;
		for(int i=1;i<len;i++){
			if(num[i]<min){
				num[i] = num[i]+min;
				min = num[i]-min;
				num[i] = num[i]-min;
			}
		}
		return min;
	}
}



