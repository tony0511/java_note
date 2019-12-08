/**
	switch分支语句
	直接用JDK1.7的字符串条件判断，确定两个数是执行加、减、乘、除操作。

*/
import java.util.Scanner;
public class Test19{
	public static void main(String[] args){

		Scanner input = new Scanner(System.in);
		System.out.println("请输入第一个数");
		int num1 = input.nextInt();
		System.out.println("请输入第二个数");
		int num2 = input.nextInt();
		System.out.println("请输入操作符（+,-,*,/）");
		String op = input.next();
		switch(op){
			case "+":
				int i = 10;
				System.out.println("num1+num2="+(num1+num2));
				System.out.println("i="+i);
				break;

			case "-":
				i = 20;
				System.out.println("num1-num2="+(num1-num2));
				System.out.println("i="+i);
			break;
			case "*":
				System.out.println("num1*num2="+(num1*num2));
			break;
			case "/":
				System.out.println("num1/num2="+(num1/num2));
			break;
			default:
				System.out.println("输入的操作符有误");
				break;
		}
	}
}