/**
	方法（函数）
	方法的形参和实参
*/
import java.util.Scanner;
public class Test2{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.println("请输入要打印星星的行数：");
		int num = input.nextInt();
		//在调用方法时传入的参数，称为实参
		printStar(num);

	}

	/**
		带参数的方法,
		形参：在方法定义时的参数称为形参
	*/
	public static void printStar(int line){  //line = num
		//外循环控制行数
		for(int i=1;i<=line;i++){

			//内循环控制列数
			for(int j=1;j<=i;j++){

				System.out.print("*");
			}
			System.out.println();
		}
	}
}