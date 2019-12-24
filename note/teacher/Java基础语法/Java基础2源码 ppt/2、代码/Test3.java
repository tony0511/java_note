
/**
	基本数据类型转换
*/
public class Test3{
	public static void main(String[] args){

		byte b = 10;
		short s = b;// 把一个字节赋值给一个短整型变量，自动转换
		int i = s; //把一个短整型赋值给一个整型变量，自动转换
		long lon = i;  //

		//char -> int 自动转换
		char sex = '男';
		int sex2 = sex;
		System.out.println(sex2);

		float f = 20f;
		double d = f;
		System.out.println(d);

		//float 和 double 是属于近似值
		//byte char short int long 属于精确值
		//精确值转近似值时可能丢失精度

		int num = 2147483000;
		float num2 = num;
		//如果用于表示货币值，不建议使用float或double
		System.out.println(num2);

		//面试题：
		//byte short int 在计算时会自动转换为int类型
		short s1 = 10;
		s1 = (short)(s1 + b);
		System.out.println(s1);

		//把大的容量类型转换为小的容量类型，需要添加强制类型转换
		int x = (int)lon;

	}
}