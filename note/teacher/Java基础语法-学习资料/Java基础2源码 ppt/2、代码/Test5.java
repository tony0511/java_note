/**
	运算符
*/
import java.util.Scanner; //接收键盘输入的工具类
public class Test5{
	public static void main(String[] args){
		int a = 1;
		int b = 2;
		int c = a + b;
		System.out.println(c);
		a = 10;
		b = 3;
		System.out.println(a/b);

		System.out.println(a%b);

		a = b++; //先赋值后自增
		System.out.println("a="+a);
		System.out.println("b="+b);
		// a =3  b=4
		a = ++b;  //先自增后赋值
		System.out.println("a="+a);
		System.out.println("b="+b);

		int x = 1;
		int y = 2;
		y = x+y-(++y);
		System.out.println("x="+x);
		System.out.println("y="+y);

		//赋值运算符
		short s = 10;
		//s = s +1;
		s+=1;
		System.out.println(s);

		//关系运算符,返回值为boolean类型

		System.out.println(x==y);


		//创建一个键盘输入的工具
		Scanner input = new Scanner(System.in);
		System.out.println("请输入一个整数：");
		int x1 = input.nextInt();//从键盘接收一个整数，
		System.out.println(x1);
		System.out.println("请输入一个字符串");
		String s1 = input.next();
		System.out.println(s1);

	}
}