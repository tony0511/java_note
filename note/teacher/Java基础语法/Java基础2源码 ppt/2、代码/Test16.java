/**
	if 语句的嵌套(2)
	多条件嵌套分支，设计一个程序，根据天气情况选择外出或在家，外出是逛街还是逛公园，在家是看电影还是玩游戏。

*/
import java.util.Scanner;
public class Test16{
	public static void main(String[] args){

		Scanner input = new Scanner(System.in);
		System.out.println("今天天气如何(1好，2霾)：");
		int weather = input.nextInt();

		if(weather==1){
			System.out.println("今天天气太好了，我是逛街还是逛公园呢(1逛街，2逛公园)");
			int flag = input.nextInt();
			if(flag==1){
				System.out.println("陪女票逛街");
			}else if(flag==2){
				System.out.println("去公园遛女票");
			}
		}else if(weather==2){
			System.out.println("今天天气不好，在家看电影还是玩游戏(1看电影2玩游戏)");
			int flag = input.nextInt();
			if(flag==1){
				System.out.println("陪女票看动作电影");
			}else if(flag==2){
				System.out.println("背着女票玩游戏");
			}
		}
	}
}