
/**
	内部类
	1、成员内部类：直接在类中定义的类
	2、方法内部类：在一个类中的方法内定义一个类
		(1)方法内部类只能在定义该内部类的方法内实例化，不可以在此方法外对其实例化
		(2)方法内部类对象不能使用该内部类所在方法的非final局部变量。
	3、静态内部类，在类中定义一个静态修饰的内部类，
		静态的含义是该内部类可以像其他静态成员一样，没有外部类对象时，也能够访问它。
		静态嵌套类仅能访问外部类的静态成员和方法。
	4、匿名内部类就是没有名字的内部类。
		匿名内部类的三种情况：
		（1）继承式的匿名内部类
		（2）接口式的匿名内部类
		（3）参数式的匿名内部类
*/
public class Test13{
	public static void main(String[] args){

		Outer outer = new Outer();
		//在外部创建成员内部类的实例,因为成员内部类需要依赖外部类的对象,
		//通常情况下，我们不建议这样来实例化内部类的对象
		//Outer.Inner inner = outer.new Inner();
		//inner.print();

		outer.innerPrint();
		outer.show(5);

		Outer.Inner3 inner3 = new Outer.Inner3();
		inner3.print();

		outer.print1();
		outer.print2();

		//参数式匿名内部类
		outer.print3(new Eat(){
			public void eat(){
				System.out.println("参数式匿名内部类");
			}
		});
	}
}


class Outer{
	private String name = "Outer";

	//--------成员内部类----------------
	//建议在外部类中定义一个方法，对外提供访问内部类的接口
	public void innerPrint(){
		Inner inner = new Inner();
		inner.print();
	}
	//成员内部类
	private class Inner{
		public void print(){
			System.out.println("成员内部类"+name);
		}
	}

	//.---------方法内部类-----------
	//show方法的局部变量或方法的参数，实际必须是常量 final
	public void show(final int y){
		final int x = 10;
		class Inner2{
			public void print(){
				//x++;// 从内部类引用的本地变量必须是最终变量或实际上的最终变量
				System.out.println("方法内部类"+x+y+name);
			}
		}
		Inner2 inner2 = new Inner2();
		inner2.print();
	}

	//--------------静态内部类------------------
	//无法从静态上下文中引用非静态变量
	static class Inner3{
		public void print(){

			System.out.println("静态内部类");
		}
	}

	//--------------匿名内部类------------------
	//继承式
	public void print1(){
		Cat cat = new Cat(){
			public void eat(){
				System.out.println("eat:继承式匿名内部类");
			}
		};
		cat.eat();
	}
	//接口式
	public void print2(){
		Eat eat = new Eat(){
			public void eat(){
				System.out.println("eat:接口式匿名内部类");
			}
		};
		eat.eat();
	}

	//参数式
	public void print3(Eat eat){
		eat.eat();
	}
}

interface Eat{
	public void eat();
}

abstract class Cat{
	public abstract void eat();
}

/**
class A extends B{
	class D extends C{

	}
}
*/




