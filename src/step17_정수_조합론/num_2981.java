package step16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class num_2981 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int nNum = Integer.parseInt(br.readLine());
		int[] arr = new int[nNum];
		for (int i = 0; i < nNum; i++) {
			arr[i] = Integer.parseInt(br.readLine());	
		}
		Arrays.sort(arr);
		int gcd_val =  arr[1]-arr[0];
		for(int i=2;i<nNum;i++) {
			gcd_val = gcd(gcd_val,(arr[i]-arr[i-1]));
		}
		for(int i= 2;i<=gcd_val;i++) {
			if((gcd_val%i) ==0) {
				System.out.print(i+" ");
			}
		}
		
	}
	public static int gcd(int a, int b) {
		
		while(b!=0) {
			int r = a % b;
			a = b;
			b = r;
		}
		return a;
	}
}
