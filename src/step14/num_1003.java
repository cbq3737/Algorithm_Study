package step14;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class num_1003 {
	static Integer[][] count = new Integer[41][2];
	
	public static Integer[] Fibo(int N) {
		if(count[N][0] ==null || count[N][1]==null) {
			count[N][0] = Fibo(N-1)[0]+Fibo(N-2)[0];
			count[N][1] = Fibo(N-1)[1]+Fibo(N-2)[1];
		}
		return count[N];
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int nNum= Integer.parseInt(br.readLine());
		StringBuilder sb= new StringBuilder();
		count[0][0] = 1;
		count[0][1] = 0;
		count[1][0] = 0;
		count[1][1] = 1;
		for(int i=0;i<nNum;i++) {
			int N = Integer.parseInt(br.readLine());	
			Fibo(N);
			sb.append(count[N][0]+" "+count[N][1]).append("\n");
		}
		System.out.println(sb);
	}
}
