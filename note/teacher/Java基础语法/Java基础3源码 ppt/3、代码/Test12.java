/**
	冒泡排序算法
冒泡排序算法的运作如下：（从后往前）
比较相邻的元素。如果第一个比第二个大，就交换他们两个。
对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对。在这一点，最后的元素应该会是最大的数。
针对所有的元素重复以上的步骤，除了最后一个。
持续每次对越来越少的元素重复上面的步骤，直到没有任何一对数字需要比较。
相同元素的前后顺序并没有改变，所以冒泡排序是一种稳定排序算法。


*/
import java.util.Scanner;
public class Test12{
	public static void main(String[] args){

		int[] nums = {34,4,56,56,90,65};//待排序的数列

		//外循环控制轮数
		for(int i=0;i<nums.length-1;i++){ //比较轮数等于数列的长度-1

			for(int j=0;j<nums.length-1-i;j++){

				if(nums[j]>nums[j+1]){
					nums[j] = nums[j]+nums[j+1];
					nums[j+1] = nums[j]-nums[j+1];
					nums[j] = nums[j]-nums[j+1];
				}
			}
		}

		//输出结果
		for(int n : nums){

			System.out.println(n);
		}

	}


}


/*
34 4 56 17 90 65

4 34 17 56 65 90	//第一轮 5次
4 17 34 56 65		//第二轮 4次
4 17 34 56			//第三轮 3次
4 17 34				//第四轮 2次
4 17				//第五轮 1次
*/
