package step7_문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class num_1316 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		boolean[] barr = new boolean[26];
		int count = 0;
		int temp;
		for (int i = 0; i < num; i++) {
			String str = br.readLine();
			temp = str.charAt(0);
			for (int j = 0; j < str.length(); j++) {
				char ch = str.charAt(j);
				barr[temp - 97] = true;
				if (str.length() <= 1) {
					break;
				} 
				else if (j < str.length() - 1 && str.charAt(j + 1) != ch) {
					temp = str.charAt(j + 1);
					if (barr[temp - 97] == true) {
						++count;
						break;
					}
				}
			}
			Arrays.fill(barr, false);
		}
		System.out.println(num - count);
	}
}
