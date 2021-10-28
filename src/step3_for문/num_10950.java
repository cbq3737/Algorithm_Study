package step3_for문;

import java.util.Scanner;

public class num_10950 {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		while(sc.hasNextInt()) {
			int tNum = sc.nextInt();
			int[] arr = new int[tNum];
			for(int i=0;i<tNum;i++) {
				int aNum = sc.nextInt();
				int bNum = sc.nextInt();			
				int result = aNum+bNum;
				arr[i] = result;
			}
			for(int i=0;i<tNum;i++) {
				System.out.println(arr[i]);
			}
		}
	}
}
