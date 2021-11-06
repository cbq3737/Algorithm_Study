package step10_재귀;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class num_10870 {
	public static int Pibo(int nNum) {
		if(nNum==0) {
			return 0;
		}
		else if(nNum==1) {
			return 1;
		}
		else {			
			int pibo = Pibo(nNum-1)+Pibo(nNum-2);
			return pibo;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int nNum = Integer.parseInt(br.readLine());
		int p = Pibo(nNum);
		System.out.println(p);
	}
}
