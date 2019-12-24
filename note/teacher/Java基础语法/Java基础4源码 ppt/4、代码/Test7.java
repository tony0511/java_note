/**
	代码块：
	1、普通代码块，在方法中写的代码块
	2、构造块，是在类中定义的代码块，在创建对象时被调用，优于构造方法执行
	3、在类中使用static声明的代码块称为静态代码块
		在第一次使用的时候被调用（创建对象），只会执行一次，优于构造块执行
		我们在项目开发中，通常会使用静态代码块来初始化只调用一次的数据。比如说：
	小结：重点会使用的顺序是静态代码块，普通代码块，同步代码块，构造代码块

*/
public class Test7{
	public static void main(String[] args){

		//Student s = new Student();
		//Student s1 = new Student();
		//Student s = null;
	}
}

class Student{

	static{
		System.out.println("我是静态代码块");
	}

	public Student(){
		System.out.println("构造方法");
	}
	{
		System.out.println("我是构造代码块");
	}
	public void study(){

		//限制作用域
		{
			int i = 10;
			System.out.println("我是普通代码块");
		}


	}
}