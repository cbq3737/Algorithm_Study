package step15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class num_1541 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int sum = Integer.MAX_VALUE;
		StringTokenizer subs = new StringTokenizer(br.readLine(),"-");
		while(subs.hasMoreTokens()) {
			int temp =0;
			StringTokenizer addition= new StringTokenizer(subs.nextToken(),"+");
			while(addition.hasMoreTokens()) {
				temp += Integer.parseInt(addition.nextToken());
			}
			
			if(sum == Integer.MAX_VALUE) {
				sum = temp;
			}
			else {
				sum -= temp;
			}
		}
		System.out.println(sum);
	}
}
