package step1_입출력과_사칙연산;

import java.util.Scanner;

public class num_10430 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextInt()) {
			int aNum = sc.nextInt();
			int bNum = sc.nextInt();
			int cNum = sc.nextInt();
			
			System.out.println((aNum+bNum)%cNum);
			System.out.println(((aNum%cNum)+(bNum%cNum))%cNum);
			System.out.println((aNum*bNum)%cNum);
			System.out.println(((aNum%cNum)*(bNum%cNum))%cNum);
			
		}		
	}
}
