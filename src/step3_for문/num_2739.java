package step3;

import java.util.Scanner;

public class num_2739 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextInt()) {
			int nNum = sc.nextInt();
			for(int i=1;i<10;i++) {
				System.out.println(nNum+" * "+i+" = "+(i*nNum));
			}
		}
	}
}
