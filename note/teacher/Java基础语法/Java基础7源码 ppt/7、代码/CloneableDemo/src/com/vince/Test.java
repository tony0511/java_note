package com.vince;

import java.io.IOException;

public class Test {

	public static void main(String[] args) {

		Cat cat = new Cat("喵喵小白",2);
		try {
			Cat newCat = (Cat) cat.clone();


			System.out.println("cat="+cat);
			System.out.println("new cat="+newCat);
			System.out.println(cat==newCat);
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}

	}

}
