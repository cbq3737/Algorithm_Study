package step9_기본수학2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class num_2581 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int mNum = Integer.parseInt(br.readLine());
		int nNum = Integer.parseInt(br.readLine());
		int sum =0;
		int min =0;
		for(int i=mNum;i<=nNum;i++) {
			int mok = 1;
			boolean brun = true;
			if(i==1) {
				brun = false;
			}
			while(i>mok) {
				mok++;
				if(i % mok==0 && i !=mok) {
					brun = false;
					break;
				}
			}
			if(brun==true) {
				sum+=i;
				if(min==0) {
					min = i;
				}
			}
		}
		if(sum==0) {
			System.out.println(-1);
			}
		else {
			System.out.println(sum+"\n"+min);
		}
	}
}
