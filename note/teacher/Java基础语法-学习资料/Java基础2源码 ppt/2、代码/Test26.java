/**
	for循环
For循环的六种写法：
1、标准写法
2、表达式1省略，但在外部声明
3、表达式2省略，死循环
4、表达式3省略，但是要声明在循环内部
5、表达式1,3省略，但是要声明在循环的外部和内部
6、三个表达式都省略,死循环
*/
import java.util.Scanner;
public class Test26{
	public static void main(String[] args){

		//(1)
		for(int i=0;i<10;i++){
			if(i==5){
				continue;//跳过当次循环，进入下次循环
			}
			//System.out.println(i);

		}
		//(2)
		int j = 0;
		for(;j<10;j++){
			//System.out.println(j);
		}

		//(3)死循环

		//for(int i=0;;i++){
		//	System.out.println(i);
		//}
		//(4)
		for(int i=0;i<10;){
			//System.out.println(i);
			i++;
		}

		//(5)
		int x = 0;
		for(;x<10;){
			//System.out.println(x);
			x++;
		}
		//(6)死循环
		//for(;;){

		//}
	}
}