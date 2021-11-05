package step9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class num_1978 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int nNum = Integer.parseInt(br.readLine());
		StringTokenizer tk = new StringTokenizer(br.readLine());
		boolean[] arr = new boolean[nNum];
		int count =0;
		for (int i = 0; i < nNum; i++) {
			int num = Integer.parseInt(tk.nextToken());
			int mok = 1;
			if(num==1) {
				arr[i]=true;
			}
			while(num>mok) {				
				mok++;
				if(num % mok==0 && num!=mok) {
					arr[i]= true;
					break;
				}
			}
			if(arr[i]!=true) {
				count++;
			}
		}
		System.out.println(count);
	}
}
