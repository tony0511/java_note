
/**
	简单工厂模式是由一个工厂对象决定创建出哪一种产品类的实例。简单工厂模式是工厂模式家族中最简单实用的模式。

*/
public class Test10{
	public static void main(String[] args){
		//使用者和被使用者两者之间，耦合，产生了依赖，当被使用者改变时，会影响使用者
		//使用工厂模式来降低两者之间的依赖
		//Product phone = new Phone();
		Product phone = ProductFactory.getProduct("phone");
		if(null!=phone){
			phone.work();
		}
	}
}

//工厂类
class ProductFactory{
	public static Product getProduct(String name){
		if("phone".equals(name)){
			return new Phone();
		}else if("computer".equals(name)){
			return new Computer();
		}else{
			return null;
		}

	}
}

interface Product{
	public void work();
}

class Phone implements Product{
	public void work(){
		System.out.println("手机开始工作...");
	}
}
class Computer implements Product{
	public void work(){
		System.out.println("电脑开始工作...");
	}
}