package step8_기본수학1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class num_1093 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int xNum = Integer.parseInt(br.readLine());
		int n=0;
		while(true) {
			if(n*(n+1)/2>=xNum) {
				if(n%2==0) {
					int cha = (n*(n+1)/2)-xNum;
					System.out.println((n-cha)+"/"+(1+cha));
				}
				else if(n%2!=0) {
					int cha = (n*(n+1)/2)-xNum;
					System.out.println((1+cha)+"/"+(n-cha));		
				}
				break;
			}
			++n;
		}
	}
}
