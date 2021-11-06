package step10_재귀;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class num_10872 {
	public static int Factorial(int nNum) {
		if (nNum == 0) {
			return 1;
		} else {
			int f = nNum * Factorial(nNum - 1);
			return f;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int nNum = Integer.parseInt(br.readLine());
		int fNum = Factorial(nNum);
		System.out.println(fNum);
	}
}
