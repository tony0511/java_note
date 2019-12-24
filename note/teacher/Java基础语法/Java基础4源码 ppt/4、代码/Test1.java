
/**
	面向过程：以步骤为单位，一步一步完成某一个具体事情
	面向对象：以对象为单位，通过调度组合不同的对象来完成某一个事情

*/
public class Test1{
	public static void main(String[] args){

		//int i = 0;
		Horse h = null;  //声明一个类的变量(除了八种基本数据类型以外，都是引用数据类型，包括数组)

		//创建一个Horse类型的对象，实例对象
		h = new Horse();
		//有了对象，我们就可以调用对象的属性和方法
		h.name = "赤兔马";
		h.age = 350;

		h.run();//调用方法，那么方法就会被执行。

		h.eat();


		//匿名对象:只能使用一次，用完后，该对象就会被释放
		new Horse().eat();

		h =  null;//把对象释放
		//h.eat();//当对象不存在时，调用该对象的属性和方法将报错（空指针）


		//--------------------
		Horse h1 = null;
		Horse h2 = null;
		h1 = new Horse();
		//h2 = new Horse();
		h1.name = "小白";
		h1.age = 4;
		//h2.name="小黑";
		//h2.age=5;

		h2 = h1;//对象之间的赋值,相同类型才可以赋值
		h2.name="小黑";
		System.out.println(h1.name);

		System.out.println("----------------------");

		Horse h3 = null;
		Horse h4 = null;
		h3 = new Horse();
		h4 = new Horse();
		h3.name = "小白";
		h3.age = 4;
		h4.name="小黑";
		h4 = h3;
		h4.name = "嘿嘿";
		System.out.println(h3.name);


	}
}

//自定一个类（类型）
class Horse{
	//在类中定义属性（特征）
	String name;//字符串是引用类型变量，不是基本数据类型变量
	int age;
	public void run(){
		System.out.println("我是"+name+",我"+age+"岁了,我还日行千里");
	}
	public void eat(){
		System.out.println("我吃仙草，还吃得多");
	}

}