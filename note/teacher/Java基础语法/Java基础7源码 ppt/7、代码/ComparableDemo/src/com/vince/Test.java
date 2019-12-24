package com.vince;

import java.util.Arrays;

public class Test {

	public static void main(String[] args) {


		int[] nums = {34,54,22,3,5,6,7,87,9};
		Arrays.sort(nums);
		System.out.println(Arrays.toString(nums));

		String[] names = {"jack","tom","菲菲","粪粪"};
		Arrays.sort(names);
		System.out.println(Arrays.toString(names));

		Cat[] cats = {new Cat("愤愤",1),new Cat("菲菲",4),new Cat("Tom",2)};
		Arrays.sort(cats);
		System.out.println(Arrays.toString(cats));

		Dog[] dogs = {new Dog("愤愤",1),new Dog("菲菲",4),new Dog("Tom",2)};
		Arrays.sort(dogs,new DogComparator());
		System.out.println(Arrays.toString(dogs));
	}

}
