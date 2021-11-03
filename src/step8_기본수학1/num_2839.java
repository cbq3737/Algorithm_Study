package step8_기본수학1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class num_2839 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int nNum = Integer.parseInt(br.readLine());
		int xNum = (nNum/3)+1;
		int yNum = (nNum/5)+1;
		int count=0;
		for(int i=0;i<xNum;i++) {
			for(int j=0;j<yNum;j++) {
				if((3*i)+(5*j)==nNum) {
					if(count==0) {						
						count = i+j;
					}
					else if(count>(i+j)) {						
						 count= i+j;
					}
				}
			}
		}
		if(count==0) {
			System.out.println(-1);
		}
		else {
			System.out.println(count);
		}
	}
}
