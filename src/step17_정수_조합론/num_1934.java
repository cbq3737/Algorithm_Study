package step17_정수_조합론;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class num_1934 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int nNum = Integer.parseInt(br.readLine());
		for (int i = 0; i < nNum; i++) {
			StringTokenizer tk = new StringTokenizer(br.readLine());
			int left = Integer.parseInt(tk.nextToken());
			int right = Integer.parseInt(tk.nextToken());
			int gcd = gcd(left, right);
			System.out.println((left * right) / gcd);
		}
	}

	public static int gcd(int left, int right) {
		if (left > right) {
			int a = right;
			right = left;
			left = a;
		}
		while (left != 0) {
			int r = right % left;
			right = left;
			left = r;
		}
		return right;
	}
}
