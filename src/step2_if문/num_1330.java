package step2_if문;

import java.util.Scanner;

public class num_1330 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNextInt()) {
			int aNum = sc.nextInt();
			int bNum = sc.nextInt();
			if (aNum > bNum) {
				System.out.println(">");
			} else if (aNum < bNum) {
				System.out.println("<");
			} else {
				System.out.println("==");
			}
		}
	}
}
