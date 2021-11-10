package step15_DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class num_9184 {
	//결과만 따로 따지긴위해서 각각 값들이 들어있는 배열들을 만들어야하는데 각 수에 맞는 결과배열을 만든다.
	//메모이제이션은 결과값과 연산값들의 갯수가 중요하다.
	public static int[][][] result = new int[21][21][21];
	public static int w(int a, int b,int c) {
		if((a>=0)&&(a<=20)&&(b>=0)&&(b<=20)&&(c>=0)&&(c<=20)) {
			if(result[a][b][c]!=0) {
				return result[a][b][c];
			}
		}
		if((a<=0)||(b<=0)||(c<=0)) {	
			return 1;
		}
		if((a>20)||(b>20)||(c>20)) {
			return result[20][20][20] = w(20,20,20);
		}
		if((a<b) && (b<c)) {
			return result[a][b][c] = w(a,b,c-1)+w(a,b-1,c-1)-w(a,b-1,c);
		}
		return result[a][b][c]=w(a-1,b,c)+w(a-1,b-1,c)+w(a-1,b,c-1)-w(a-1,b-1,c-1);
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		boolean brun = true;
	
		while (brun) {
			StringTokenizer tk = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(tk.nextToken());
			int b = Integer.parseInt(tk.nextToken());
			int c = Integer.parseInt(tk.nextToken());
			if ((a == -1) && (b == -1) && (c == -1)) {
				brun = false;
				break;
			}
			sb.append("w("+a+", "+b+", "+c+") = "+w(a,b,c)).append("\n");
		}
		System.out.println(sb);
	}
}
