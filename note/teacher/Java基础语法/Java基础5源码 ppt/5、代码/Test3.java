
/**
	 final关键字
	 1、使用final声明一个属性，就是常量，常量的命名规则建议使用全大写,常量必须在定义时或在构造器中初始化
	 2、使用final声明的方法，不能被子类重写，只能被继承
	 3、使用final关键字声明一个类，该类就转变为最终类，没有子类的类，fianl修饰的类无法被继承。
*/
public class Test3{

	public static void main(String[] args){

		System.out.println(Constant.PERSON_NUM);

		FinalClass fc = new FinalClass();
		fc.setLength(10);
	}
}

//常量类(工具类):在实际项目开发中，常量类通常用于定义项目中一些公共的，不变的，数据

final class Constant{
	public static final int PERSON_NUM = 10; //人数
	public static final String SERVER_ROOT_URL = "http://www.baidu.com";
    public static final String CACHE_PATH = "data_cache";

}

class FinalClass{
	public final int DAY_NUMBER;//工作天数

	public FinalClass(){
		DAY_NUMBER = 22;
	}

	public final void print(){
		System.out.println("我是final方法");
	}

	public void setLength(final int size){
		final int x = 20;
		size++;
		System.out.println(size);
	}
}

class SubClass extends FinalClass{
	/*public void print(){
		System.out.println("我是final方法");
	}*/
}









