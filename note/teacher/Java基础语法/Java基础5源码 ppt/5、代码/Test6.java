
/**
	多态性：

*/
public class Test6{
	public static void main(String[] args){
		//用父类的引用指向子类对象（用大的类型来表示小的类型），自动转换（向上转型）
		Chicken hc = new HomeChicken("小鸡鸡");
		//hc.eat();

		Chicken yc = new YeChicken("大鸡鸡");
		//yc.eat();

		//hc = yc;
		//hc.eat();
		//eat(hc);
		//eat(yc);

		Chicken jjc = new JianJiaoChicken("尖叫鸡");
		eat(jjc);
		eat(hc);
		eat(yc);
	}

	//抽象(粒度) 面向抽象编程（面向接口编程）
	public static void eat(Chicken c){
		System.out.println("鸡吃饭");
		c.eat();
		//当我们需要把父类的实例强制转换为子类引用时，为了避免类型转换异常 java.lang.ClassCastException
		//那么我们需要在转换之前作类型检查（判断）
		if(c instanceof JianJiaoChicken){ //成立的条件是，对象本身及对象的父类型，都可以通过检查
			JianJiaoChicken jjc = (JianJiaoChicken)c;//大的类型转换为小的类型，强制转换（向下转型）
			jjc.song();
		}
	}
}

//鸡
abstract class Chicken{
	private String name;
	public Chicken(){}
	public Chicken(String name){
		this.name = name;
	}
	public void setName(String name){
		this.name = name;
	}
	public String getName(){
		return name;
	}
	public abstract void eat();
}
//家鸡
class HomeChicken extends Chicken{

	public HomeChicken(String name){
		super(name);
	}
	public void eat(){
		System.out.println(this.getName()+"，我爱吃米");
	}
}
//野鸡
class YeChicken extends Chicken{

	public YeChicken(String name){
		super(name);
	}
	public void eat(){
		System.out.println(this.getName()+"，我爱吃虫子");
	}
}
class JianJiaoChicken extends Chicken{
	public JianJiaoChicken(String name){
		super(name);
	}
	public void eat(){
		System.out.println(this.getName()+"，我不吃东西");
	}
	public void song(){
		System.out.println("唧唧复唧唧，我是尖叫鸡");
	}
}