package step9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class num_9020 {
	public static boolean[] barr = new boolean[10000];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		get_prime();
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			int nNum = Integer.parseInt(br.readLine());
			int half_a  = nNum/2;
			int half_b  = nNum/2;
			while(true) {
				if(barr[nNum/2]!=true) {
					sb.append((nNum/2)+" "+(nNum/2)+"\n");
					break;
				}
				else if(barr[half_a]!=true && barr[half_b]!=true) {
					sb.append(half_a+" "+half_b+"\n");
					break;
				}
				half_a--;
				half_b++;
			}
		}
		System.out.println(sb);
	}

	public static void get_prime() {
		barr[0] = barr[1] = true;
		for (int i = 2; i <= Math.sqrt(barr.length); i++) {
			if (barr[i] == true) {
				continue;
			}
			for (int j = i * i; j < (barr.length); j += i) {
				barr[j] = true;
			}
		}
	}
}
