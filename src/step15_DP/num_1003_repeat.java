package step15_DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class num_1003_repeat {
	public static Integer[][] count;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tcase = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<tcase;i++) {
			int nNum = Integer.parseInt(br.readLine());
			count = new Integer[nNum+1][2];
			if(nNum==0) {
				count[0][0] = 1;
				count[0][1] = 0;
			}else if(nNum==1) {
				count[1][0] = 0;
				count[1][1] = 1;				
			}else {				
				count[0][0] = 1;
				count[0][1] = 0;
				count[1][0] = 0;
				count[1][1] = 1;				
				Fibonacci(nNum);
			}
			sb.append(count[nNum][0]+" "+count[nNum][1]+"\n");
		}
		System.out.println(sb);
	}
	public static Integer[] Fibonacci(int n) {
		if(count[n][0]==null || count[n][1]==null) {
			count[n][0] = Fibonacci(n-1)[0]+Fibonacci(n-2)[0];
			count[n][1] = Fibonacci(n-1)[1]+Fibonacci(n-2)[1];
		}
		return count[n];
	}
}
