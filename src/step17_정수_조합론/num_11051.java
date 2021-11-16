package step16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class num_11051 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(br.readLine());
		int nNum = Integer.parseInt(tk.nextToken());
		int kNum = Integer.parseInt(tk.nextToken());
		long factorial_number = Factorial(nNum) / (Factorial(kNum)*(Factorial(nNum-kNum)));
		System.out.println(factorial_number%10007);
	}
	public static int Factorial(int n) {
		if(n<=1) {
			return 1;
		}
		return n*Factorial(n-1);
	}
}
