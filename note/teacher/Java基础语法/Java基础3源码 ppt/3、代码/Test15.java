/**
	二分法查找（折半查找）：前提是在已经排好序的数组中，
	通过将待查找的元素与中间索引值对应的元素进行比较，若大于中间索引值对应的元素，
	去右半部分查找，否则，去左半部分查找。
	依此类推。直到找到为止；找不到返回一个负数。
*/
import java.util.Scanner;
public class Test15{
	public static void main(String[] args){

		//必须保正数列是有序的
		int[] num = {10,20,50,65,88,90};
		int index = binarySearch(num,100);
		System.out.println(index);

	}

	//二分查找算法
	public static int binarySearch(int[] num,int key){
		int start = 0;//开始下标
		int end = num.length-1;//结束下标

		while(start<=end){
			int middle = (start+end)/2; //>>>1
			if(num[middle]>key){
				end = middle-1;
			}else if(num[middle]<key){
				start = middle+1;
			}else{
				return middle;
			}
		}

		return -1;
	}
}



