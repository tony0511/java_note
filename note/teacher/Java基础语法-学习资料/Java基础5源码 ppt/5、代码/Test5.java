
/**
	接口
*/
public class Test5{
	public static void main(String[] args){
		Girl mm = new Girl("马丽");
		mm.sleep();
		mm.eat();
		mm.run();
		mm.print();

	}
}

interface IEat{
	//public abstract void eat();//接口中只能定义抽象方法
	void eat(); //接口中定义的方法没有声明修饰符，默认为 public abstract
	//public static final int NUM = 10;//在接口中定义一个常量
	int NUM = 10;//常量
	//在JDK1.8后新特性，可以被所有实现类继承
	public default void print(){
		System.out.println("eat");
	}
}

interface IRun{
	void run();
}
//接口之间可以多继承（注意：类是只能单继承）
interface ISleep extends IEat,IRun{
	void sleep();
}

//具体类实现接口必须实现接口的所有方法
class Girl implements ISleep,IEat{
	private String name;
	public Girl(String name){
		this.name = name;
	}
	public Girl(){}
	public void sleep(){
		System.out.println("我爱睡觉");
	}
	public void eat(){
		System.out.println("我是"+name+",我爱吃猪脚");
	}
	public void run(){
		System.out.println("吃完就跑");
	}
}



