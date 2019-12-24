import java.util.Scanner;
public class Test10{
	public static void main(String[] args){

		int[][] scores = {{78,98,88},{87,96,85},{67,78,89}};
		int classLen = scores.length;
		for(int i=0;i<classLen;i++){
			int sum = 0;
			int count = scores[i].length;
			for(int j=0;j<count;j++){
				sum+=scores[i][j];
			}
			int avg = sum/count;
			System.out.println("µÚ"+(i+1)+"°àµÄÆ½¾ù³É¼¨ÊÇ£º"+avg);
		}
	}
}



/*
78  98  88
87  96  85
67  78  89
*/