package com.vince.decorator;

public class Test {

	public static void main(String[] args) {

		// OutputStream out = new FileOutputStream("xxx");
		// BufferedOutputStream bos = new BufferedOutputStream(out);
		// PrintStream ps = new PrintStream(bos);
		// ps.print(..);

		Drink drink = new SoyaBeanMilk();
		SugarDecorator sugar = new SugarDecorator(drink);
		EggDecorator egg = new EggDecorator(sugar);
		BlackBeanDecorator blackBean = new BlackBeanDecorator(egg);

		System.out.println("你点的豆浆是：" + blackBean.description());
		System.out.println("一共花了" + blackBean.cost() + "元");
	}

}
