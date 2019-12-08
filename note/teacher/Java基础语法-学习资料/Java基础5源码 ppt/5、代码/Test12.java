
/**
	适配器模式（ Adapter ）：将一个类的接口转换成客户希望的另外一个接口。
	适配器模式使得原本由于接口不兼容而不能一起工作的那些类可以一起工作。

*/
public class Test12{
	public static void main(String[] args){

		PowerA powerA = new PowerAImpl();
		//work(powerA);

		PowerB powerB = new PowerBImpl();
		//work(powerB);
		Adapter adapter = new Adapter(powerB);
		work(adapter);
	}

	public static void work(PowerA a){
		System.out.println("正在连接...");
		a.insert();
		System.out.println("工作结束.");
	}

}

interface Animal{
	public void sing();
	public void cry();
	public void run();
	public void swim();
}

//适配器
abstract class AnimalFunction{
	public void sing(){}
	public void cry(){}
	public void run(){}
	public void swim(){}
}


class Dog extends AnimalFunction{
	public void run(){
		System.out.println("我是疯狗，疯狂的跑");
	}
}



//适配器
class Adapter implements PowerA{
	private PowerB powerB;
	public Adapter(PowerB powerB){
		this.powerB = powerB;
	}
	public void insert(){
		powerB.connet();
	}
}

interface PowerB{
	public void connet();
}

class PowerBImpl implements PowerB{
	public void connet(){
		System.out.println("电源B开始工作");
	}
}

interface PowerA{
	public void insert();
}
class PowerAImpl implements PowerA{
	public void insert(){
		System.out.println("电源A开始工作");
	}
}
