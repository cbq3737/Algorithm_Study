package step12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class num_1427 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String nNum = br.readLine();
		int str_length = nNum.length();
		int[] arr = new int[str_length];
		for(int i=0;i<str_length;i++) {
			arr[i] = Character.getNumericValue(nNum.charAt(i));
		}
		Arrays.sort(arr);
		for(int i=(str_length-1);i>=0;i--) {
			sb.append(arr[i]);
		}
		System.out.println(sb);
	}
}
