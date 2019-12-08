
/**
	继承:继承是从已有的类创建新类的过程。
	继承一个父类，只能继承非私有的数据（属性和方法）
	protected访问权限修饰符，在继承关系中使用，在父类中使用protected修饰的属性或方法可以被子类继承
	创建子类对象时，父类的构造方法也会被调用，为什么？
	因为子类要使用到父类的数据，那么就要通过父类的构造方法来初始化数据
	//如果创建子类对象时使用默认的构造方法，那么父类的默认构造方法也会被调用
	如果创建子类对象时会调用父类的默认构造方法

	当父类中没有无参构造方法时，子类必须显示的调用父类的带参构造方法，怎么调用呢？
	可以在子类中显示的使用super(...)调用父类的构造方法，只能出现在第一句

	面试题 ：overloading与overriding的区别？
	overloading:方法的重载，发生在同一个类中，方法名相同，参数列表不同，返回值无关。
	overriding：方法的重写，发生在子父类中，方法名相同，参数列表相同，返回值相同，子类的访问修饰符要大于或等于父类
	的访问修饰符，子类的异常声明必须小于或等于父类的异常声明。如果方法被private,static,final修饰，那么不能被重写

*/
public class Test1{
	public static void main(String[] args){

		HomeDog homeDog = new HomeDog("旺财");
		homeDog.print();
		homeDog.eat();

		HuskyDog hd = new HuskyDog();
		hd.eat();

	}
}

class Dog{
	protected String name;
	private String sex;
	public Dog(String name,String sex){
		this.name = name;
		this.sex = sex;
		System.out.println("我是Dog的构造方法");
	}
	protected void eat(){
		System.out.println("吃饭");
	}
}
class HomeDog extends Dog{
	public HomeDog(String name){
		super(name,"公");//只能在第一句
		System.out.println("我是HomeDog的构造方法");
	}
	protected void print(){
		//super.属性 表示调用父类的属性,如果是继承过来的属性，那么super可以省略
		System.out.println(super.name+"我是一只家狗,wangwang");
	}
	//重写父类的方法
	public void eat(){
		super.eat();//调用父类的方法
		System.out.println("我是家狗，我喜欢吃骨头");
	}

}

class HuskyDog extends Dog{
	public HuskyDog(){
		super("哈士奇","母");
		System.out.println("我是HuskyDog的构造方法");
	}
	public void show(){
		System.out.println(name+"我是husky，我能跳舞");
	}
	public void eat(){
		System.out.println("我是husky，我喜欢吃鸡肝");
	}
}



