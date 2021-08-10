package step2;

import java.util.Scanner;

public class num_2884 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNextInt()) {
			int hNum = sc.nextInt();
			int mNum = sc.nextInt();
			if (mNum < 45) {
				if (hNum == 0) {
					hNum = 23;
				} else {
					hNum = hNum - 1;
				}
				mNum = mNum + 15;
				System.out.println(hNum + " " + mNum);
			} else if (mNum >= 45) {
				mNum = mNum - 45;
				System.out.println(hNum + " " + mNum);
			} else {
				System.out.println("잘못된 입력");
			}
		}
	}
}
