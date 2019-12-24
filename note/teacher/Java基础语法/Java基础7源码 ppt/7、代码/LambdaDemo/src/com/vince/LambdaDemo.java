package com.vince;

import java.util.Arrays;
import java.util.Comparator;

public class LambdaDemo {
	public static void main(String[] args) {
		// 没有使用lambda表达式时
		IEat ieat1 = new IEat(){
			public void eat(){
				System.out.println("eat bnana");
			}
		};
		ieat1.eat();

		// ==== 使用lambda表达式 ====
		// 好处：1. 代码更简洁，2. 不会单独生成class文件

		// 没有参数时使用
		IEat ieat2 = () -> { System.out.println("eat apple bnana"); };
		ieat2.eat();

		// 带参数时使用,参数的类型可以省略
		// 当代码块中只有一行代码
		IEat ieat3 = (thing, name) -> System.out.println("eat..." + thing + "..." + name);
		// 当代码块中有多行代码
		// IEat ieat3 = (thing,name) -> {
		// 	System.out.println("eat..." + thing);
		// 	System.out.println(name);
		// };
		ieat3.eat("apple", "大冰");

		// 带返回值(有多行代码)
		// IEat ieat4 = (thing,name)->{
		// 	System.out.println(name+ " eat "+thing);
		// 	return 10;
		// };
		// 带返回值(只有一行代码)
		IEat ieat4 = (final String thing, final String name) -> name == null ? 1 : 0;
		ieat4.eat("apple", "大冰");

		Student[] students = {
				new Student("张三",18),
				new Student("张四",28),
				new Student("张一",15)};

//		Arrays.sort(students,new Comparator<Student>() {
//			public int compare(Student o1, Student o2) {
//				return o1.getAge()-o2.getAge();
//			};
//		});

//		Comparator<Student> c = (o1,o2)->o1.getAge()-o2.getAge();
		Arrays.sort(students,(o1,o2)-> o1.getAge()-o2.getAge());
		System.out.println(Arrays.toString(students));

		IEat.method();
	}
}


//只有一个抽象方法的接口
interface IEat{
	public int eat(final String thing,final String name);
	public default void print(){
		System.out.println("print test");
	}
	public static void method(){
		System.out.println("static method..");
	}
}

//class IEatImpl implements IEat{
//	public void eat(String thing){
//		System.out.println("eat--"+thing);
//	}
//}