/**
选择排序算法
每一趟从待排序的数据元素中选出最小（或最大）的一个元素，
顺序放在已排好序的数列的最后，直到全部待排序的数据元素排完。
选择排序是不稳定的排序方法。


*/
import java.util.Scanner;
public class Test13{
	public static void main(String[] args){

		int[] nums = {34,4,56,17,90,65};//待排序的数列
		int minIndex = 0;//用于记录每次比较的最小值下标
		//控制轮数
		for(int i=0;i<nums.length-1;i++){

			minIndex = i;//每轮假设一个最小值下标

			for(int j=i+1;j<nums.length;j++){

				if(nums[minIndex]>nums[j]){
					minIndex = j;
				}
			}
			//判断需要交换的数下标是否为自己
			if(minIndex!=i){
				nums[minIndex] = nums[minIndex]+nums[i];
				nums[i] = nums[minIndex]-nums[i];
				nums[minIndex] = nums[minIndex]-nums[i];
			}

		}

		//输出结果：
		for(int n: nums){
			System.out.println(n);
		}

	}


}


/*
34 4 56 17 90 65
4 34 56 17 90 65 第一轮 5次
4 17 56 34 90 65 第二轮 4次
4 17 34 56 90 65 第三轮 3次
4 17 34 56 90 65 第四轮 2次
4 17 34 56 65 90 第五轮 1次



*/
