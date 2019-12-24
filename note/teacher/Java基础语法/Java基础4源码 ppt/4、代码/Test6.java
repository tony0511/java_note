
/**
	static 关键字
	1、静态变量或方法不属于对象，依赖类
	2、静态变量是全局变量，生命周期从类被加载后一直到程序结束
	3、静态变量只有存一份，在静态方法区中存储
	4、静态变量是本类所有对象共享一份
	5、建议不要使用对象名去调用静态数据，直接使用类名调用
	6、static修饰一个方法，那么该方法属于类，不属于对象，直接用类名调用
	7、静态方法不能访问非静态属性和方法，只能访问静态。


*/
public class Test6{
	public static void main(String[] args){

		System.out.println(args.length);
		for(String s: args){
			System.out.println(s);
		}
		//Role beibei = new Role("刘备","蜀国");
		//Role yunchang = new Role("云长","蜀国");
		//Role feifei = new Role("张飞","蜀国");
		Role beibei = new Role("刘备");
		Role yunchang = new Role("云长");
		Role feifei = new Role("张飞");

		System.out.println(beibei.getInfo());
		System.out.println(yunchang.getInfo());
		System.out.println(feifei.getInfo());

		System.out.println(beibei.country);
		System.out.println(yunchang.country);
		System.out.println(feifei.country);

		beibei.country = "秦国";
		System.out.println("------------------");
		System.out.println(beibei.country);
		System.out.println(yunchang.country);
		System.out.println(feifei.country);

		System.out.println("------------------");

		System.out.println(Role.country);//用类名调用静态变量
	}
}

//角色
class Role{
	private String name;
	static String country = "蜀国";//静态变量（全局变量）
	public Role(String name,String country){
		this.name = name;
		this.country = country;
	}
	public Role(String name){
		this.name = name;
	}
	public void setName(String name){
		this.name = name;
	}
	public String getName(){
		return name;
	}

	//静态方法不能访问非静态的数据
	public static void setCountry(String country){
		Role.country = country;
	}
	/*
	public void setCountry(String country){
		this.country = country;
	}
	public String getCountry(){
		return country;
	}
	*/
	public String getInfo(){
		return "name="+name+",country="+country;
	}
}