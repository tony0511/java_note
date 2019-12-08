/**
直接插入排序算法
（从后向前找到合适位置后插入）
基本思想：每步将一个待排序的记录，按其顺序码大小插入到前面已经排序的子序列的合适位置（从后向前找到
合适位置后），直到全部插入排序完为止。


*/
import java.util.Scanner;
public class Test14{
	public static void main(String[] args){
		int[] nums = {34,4,56,17,90,65};//待排序的数列
		//控制比较的轮数：
		for(int i=1;i<nums.length;i++){

			int temp = nums[i];  //记录操作数
			int j = 0;
			for(j=i-1;j>=0;j--){
				if(nums[j]>temp){
					nums[j+1] = nums[j];
				}else{
					break;
				}
			}
			if(nums[j+1]!=temp){
				nums[j+1] = temp;
			}
		}
		//输出结果：
		for(int n : nums){
			System.out.println(n);
		}
	}
}

/*
34 4 56 17 90 65




*/

