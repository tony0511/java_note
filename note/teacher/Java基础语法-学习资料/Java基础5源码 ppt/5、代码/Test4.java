
/**
	抽象类:用abstract关键字声明的类称为抽象类，
	很多具有相同特征和行为的对象可以抽象为一个类，
	很多具有相同特征和行为的类可以抽象为一个抽象类

1、抽象类可以没有抽象方法，有抽象方法的类必须是抽象类
2、非抽象类继承抽象类必须实现所有抽象方法
3、抽象类可以继承抽象类，可以不实现父类抽象方法。
4、抽象类可以有方法实现和属性
5、抽象类不能被实例化
6、抽象类不能声明为final
7、抽象类可以有构造方法


*/
public class Test4{
	public static void main(String[] args){
		Man man = new Man();
		man.move();
		man.eat();

		Women women = new Women();
		women.move();
		women.eat();

		//Animal a = new Animal();

	}
}

abstract class Animal{
	public abstract void move();//方法的声明，抽象方法只有声明，没有实现

}

abstract class Person extends Animal{
	public abstract void eat();
	public void sleep(){
		System.out.println("睡觉");
	}
}

//继承抽象类的具体类必须实现所有抽象方法
class Man extends Person{

	public void move(){
		System.out.println("我是男人，我爱跑步");
	}
	public void eat(){
		System.out.println("我是男人，我爱吃肉");
	}
}

class Women extends Person{
	public void move(){
		System.out.println("我是女人，我爱逛街");
	}
	public void eat(){
		System.out.println("我是女人，我爱吃香蕉");
	}
}

