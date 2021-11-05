package step9_기본수학2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class num_11653 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int nNum = Integer.parseInt(br.readLine());
		int mok=2;
		if(nNum==1) {
			
		}
		else {
			while(nNum>1) {
				if(nNum%mok==0) {
					System.out.println(mok);
					nNum = nNum / mok;
					mok = 2;
				}
				else {
					mok++;
				}
				
			}
		}
	}
}
