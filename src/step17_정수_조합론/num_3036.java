package step17_정수_조합론;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class num_3036 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int nNum = Integer.parseInt(br.readLine());
		StringTokenizer tk = new StringTokenizer(br.readLine());
		int[] arr = new int[nNum];
		for(int i=0;i<nNum;i++) {
			arr[i] = Integer.parseInt(tk.nextToken());
		}
		int num = arr[0];
		
		for(int i=1;i<nNum;i++) {
				int gcd = gcd(num,arr[i]);
				System.out.println((num/gcd)+"/"+(arr[i]/gcd));
		}
	}
	public static int gcd(int a, int b) {
		while(b!=0) {
			int r = a % b;
			a= b;
			b= r;
		}
		return a;
	}
}
