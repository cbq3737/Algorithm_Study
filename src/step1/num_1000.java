package step1;

import java.io.IOException;
import java.util.Scanner;

public class num_1000 {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextInt()) {
			int aNum = sc.nextInt();
			int bNum = sc.nextInt();

			System.out.println(aNum+bNum);
		}
	
	}
}
