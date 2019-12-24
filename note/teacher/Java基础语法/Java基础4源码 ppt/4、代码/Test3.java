
/**
	构造方法:构造方法是在类中定义的，构造方法的定义格式：方法名称与类名称相同，无返回值类型的声明。
	1、构造方法就是类构造对象时调用的方法，用于对象的初始化工作
	2、构造方法是实例化一个类的对象时，也就是new 的时候，最先调用的方法。


*/
public class Test3{
	public static void main(String[] args){
		//Dog dog = new Dog();
		Dog dog1 = new Dog("wangwang",5);
	}
}

class Dog{

	//默认构造方法,通常有其它构造方法时，要保留默认构造方法
	public Dog(){
		//System.out.println("构造方法执行了");
	}
	public Dog(String name){
		this.name = name;
		System.out.println("带一个参数的构造方法执行了");

	}
	public Dog(String name,int age){
		this(name);//调用其它构造方法时，此语句需要在第一句,在构造方法相互调用时必须要有出口
		//this.name = name;
		this.age = age;
		System.out.println("带两个参数的构造方法执行了");

	}

	private String name;
	private int age;
	public void setName(String name){
		this.name = name;
	}
	public String getName(){
		return name;
	}
	public void setAge(int age){
		this.age = age;
	}
	public int getAge(){
		return age;
	}
}