package step17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class num_10773 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int kNum = Integer.parseInt(br.readLine());
		int[] stack = new int[kNum];
		int size = 0;
		int sum =0;
		while (kNum > 0) {
			int num = Integer.parseInt(br.readLine());
			if (num == 0 && size>0) {
				sum -=stack[size-1];
				stack[size--] =0;
		
			}else {
				stack[size++] = num;
				sum+=num;
			}
			kNum--;
		}
		System.out.println(sum);
	}
}
