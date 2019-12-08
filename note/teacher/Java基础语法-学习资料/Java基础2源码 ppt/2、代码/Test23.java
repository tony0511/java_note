/**
	while循环：先判断，再执行，有可能执行0次
	3、打印100以内所有的奇数，偶数和3的倍数（不包括100）
*/
import java.util.Scanner;
public class Test23{
	public static void main(String[] args){

		int i=1;//增量
		while(i<100){
			if(i%2==0){
				System.out.println("偶数："+i);
			}else{
				System.out.println("奇数："+i);
			}
			if(i%3==0){
				System.out.println("3的倍数："+i);
			}
			i++;
		}

	}
}