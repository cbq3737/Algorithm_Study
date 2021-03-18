package step1;

import java.util.Scanner;

public class num_1001 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextInt()) {
			int aNum = sc.nextInt();
			int bNum = sc.nextInt();
			System.out.println(aNum-bNum);
		}
	}
}
