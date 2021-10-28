package step3;

import java.util.Scanner;

public class num_8393 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextInt()) {
			int nNum = sc.nextInt();
			int sum =0;
			for(int i=0;i<=nNum;i++) {
				sum+=i;
			}
			System.out.println(sum);
		}		
	}
}
