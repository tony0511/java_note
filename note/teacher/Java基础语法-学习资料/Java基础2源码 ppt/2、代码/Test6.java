
/**
	逻辑运算符
*/
public class Test6{
	public static void main(String[] args){

		boolean a = false;
		boolean b = false;

		//与运算，分别计算表达式两边的结果再作&运算，只有两个都为true，结果才为true,否则为false
		System.out.println(a&b);
		//或运算，分别计算表达式两边的结果再作|运算，只要有一个为true，结果就为true，两边都为false才为false
		System.out.println(a|b);

		//异或运算，两边相同为false，不同为true
		System.out.println(a^b);

		//非运算
		System.out.println(!b);

		//短路与
		System.out.println(a&&b);
		//短路或
		System.out.println(a||b);

		//面试题 ：& 和&&的区别？


	}
}