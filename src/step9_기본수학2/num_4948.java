package step9_기본수학2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class num_4948 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while(true) {
			int nNum = Integer.parseInt(br.readLine());
			int count = 0;
			if(nNum==0) {
				break;
			}
			boolean[] barr = new boolean[(2*nNum)+1];
			barr[0] = barr[1] = true;
			for(int i=2;i<=Math.sqrt(barr.length);i++) {
				if(barr[i]==true) {
					continue;
				}
				for(int j= i*i;j<(barr.length);j+=i) {
					barr[j]= true;
				}
			}
			for(int i=(nNum+1);i<(barr.length);i++) {
				if(barr[i]!=true) {
					count++;
				}
			}
			sb.append(count+"\n");
		}
		System.out.println(sb);
	}
}
