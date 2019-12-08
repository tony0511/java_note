/**
/**
	模拟双色球综合案例
	0、准备相关的变量
	1、用户选择是机选还是手选号码
	2、接收用户选号（6红，1蓝）
	3、生成系统号码（6红，1蓝）
	4、比较系统号码和用户号码，记录个数
	5、验证是否中奖
	6、系统号码排序
	7、公布结果
*/

import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;
public class Test17{
	public static void main(String[] args){

		//定义相关的变量
		int[] userRedBall = new int[6];//用户选择的红球号码
		int[] sysRedBall = new int[6];//系统生成的红球号码
		int userBlueBall = 0; //用户选择的蓝球
		int sysBlueBall = 0; //系统生成的蓝球
		int redCount = 0;//记录用户选择正确的红球数
		int blueCount = 0;//记录用户选择正确的蓝球数
		int[] redBall = new int[33];//用于存储1-33的红球号码
		//需要随机生成6个在1-33之间不重复的数（算法）
		for(int i=0;i<redBall.length;i++){
			redBall[i] = i+1;
		}

		//游戏开始，系统提示
		System.out.println("双色球游戏开始，good luck!");
		System.out.println("请问您是要机选或手选号码（1：机选，2：手选）：");

		Scanner input = new Scanner(System.in);
		Random r = new Random();//生成随机数的工具

		boolean flag = true;//用于判断是否要重新输入机选或手选，（意思就是除了1和2之外的数都必须重输）
		while(flag){

			int isAuto = input.nextInt();
			switch(isAuto){

				case 1:
					//机选
					computerSelection(redBall,userRedBall);//机选红球
					userBlueBall = r.nextInt(16)+1; //机选蓝球
					flag = false;
					break;

				case 2:
					//手选
					System.out.println("请选择6个红球号码（1-33）：");
					for(int i=0;i<userRedBall.length;i++){
						userRedBall[i] = input.nextInt();
					}
					System.out.println("请选择1个蓝球号码（1-16）：");
					userBlueBall = input.nextInt();
					flag = false;
					break;
				default:
					System.out.println("请问您是要机选或手选号码（1：机选，2：手选）：");
					break;
			}

		}

		//系统随机生成号码
		//红球
		computerSelection(redBall,sysRedBall);
		//蓝球
		sysBlueBall = r.nextInt(16)+1;


		//统计结果：
		//统计红球
		for(int i=0;i<userRedBall.length;i++){
			for(int j=0;j<sysRedBall.length-redCount;j++){
				if(userRedBall[i]==sysRedBall[j]){
					int temp = sysRedBall[j];
					sysRedBall[j] = sysRedBall[sysRedBall.length-1-redCount];
					sysRedBall[sysRedBall.length-1-redCount] = temp;
					redCount++;
					break;
				}
			}
		}
		//统计蓝球
		if(userBlueBall==sysBlueBall){
			blueCount = 1;
		}

		//验证是否中奖(从条件成功率高的排前面)
		if(blueCount==0 && redCount<=3){
			System.out.println("革命尚未成功，同志还需努力！");
		}else if(blueCount==1 && redCount<3){
			System.out.println("中了六等奖，5块钱！");
		}else if((blueCount==1 && redCount==3) || (blueCount==0 && redCount==4)){
			System.out.println("中了五等奖，10块钱！");
		}else if((blueCount==1 && redCount==4) || (blueCount==0 && redCount==5)){
			System.out.println("中了四等奖，200块钱！");
		}else if(blueCount==1 && redCount==5){
			System.out.println("中了三等奖，3000块钱！");
		}else if(blueCount==0 && redCount==6){
			System.out.println("中了二等奖，150W！");
		}else if(blueCount==1 && redCount==6){
			System.out.println("中了一等奖，500W！");
		}else{
			System.out.println("系统有误，中奖无效！");
		}


		//公布系统号码
		System.out.println("本期中奖红球号码为：");
		sort(sysRedBall);
		System.out.println(Arrays.toString(sysRedBall));
		System.out.println("本期中奖蓝球号码为："+sysBlueBall);

		//公布用户号码
		System.out.println("您选择的红球号码为：");
		sort(userRedBall);
		System.out.println(Arrays.toString(userRedBall));
		System.out.println("您选择的蓝球号码为："+userBlueBall);

		System.out.println("买双色球，造福你我他！谢谢");

	}

	//冒泡排序
	public static void sort(int[] ball){
		for(int i=0;i<ball.length-1;i++){
			for(int j=0;j<ball.length-1-i;j++){
				if(ball[j]>ball[j+1]){
					ball[j] = ball[j]+ball[j+1];
					ball[j+1] = ball[j]-ball[j+1];
					ball[j] = ball[j]-ball[j+1];
				}
			}
		}
	}

	//用于在指定数列中，随机生成多个不重复的数算法
	public static void computerSelection(int[] redBall,int[] userRedBall){

		Random r = new Random();
		int index = -1;
		for(int i=0;i<userRedBall.length;i++){
			index = r.nextInt(redBall.length-i);
			userRedBall[i] = redBall[index];

			int temp = redBall[index];
			redBall[index] = redBall[redBall.length-1-i];
			redBall[redBall.length-1-i] = temp;

		}

	}
}



