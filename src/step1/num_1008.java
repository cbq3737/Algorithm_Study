package step1;

import java.util.Scanner;

public class num_1008 {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		while(sc.hasNextInt()) {
			double aNum = sc.nextInt();
			double bNum = sc.nextInt();
			System.out.println(aNum/bNum);
		}
	}

}
