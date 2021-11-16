package step16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class num_11050 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(br.readLine());
		int nNum = Integer.parseInt(tk.nextToken());
		int kNum = Integer.parseInt(tk.nextToken());
		System.out.println(Factorial(nNum)/(Factorial(kNum)*Factorial(nNum-kNum)));
	}
	public static int Factorial(int Num) {
		if(Num<=1) {
			return 1;
		}
		return Num*Factorial(Num-1);
	}

}
