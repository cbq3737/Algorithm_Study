package step9;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class num_1929 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int mNum = Integer.parseInt(tk.nextToken());
		int nNum = Integer.parseInt(tk.nextToken());
		boolean[] prime = new boolean[nNum+1];
		prime[0] = prime[1]= true;
		
		for(int i=2;i<=Math.sqrt(prime.length);i++) {
			if(prime[i]==true) {
				continue;
			}
			for(int j = i*i;j<prime.length;j=j+i) {
				prime[j]= true;
			}
		}
		
		for(int i=mNum;i<=nNum;i++) {
			if(prime[i]!=true) {
				sb.append(i).append("\n");;
			}
		}
		System.out.println(sb);
		
	}
}
