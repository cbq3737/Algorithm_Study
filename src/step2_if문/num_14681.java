package step2_if문;

import java.util.Scanner;

public class num_14681 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextInt()) {
			int xNum = sc.nextInt();
			int yNum = sc.nextInt();
			if(xNum > 0 && yNum > 0) {
				System.out.println("1");
			}
			if(xNum < 0 && yNum > 0) {
				System.out.println("2");
			}
			if(xNum < 0 && yNum < 0) {
				System.out.println("3");
			}
			if(xNum > 0 && yNum < 0) {
				System.out.println("4");
			}
		}
	}
}
