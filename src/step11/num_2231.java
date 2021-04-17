package step11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class num_2231 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int nNum = Integer.parseInt(br.readLine());
		int result = 0;
		for(int i=0;i<nNum;i++) {
			int number = i;
			int sum = 0;
			
			while(number!=0) {
				sum+=number%10;
				number /=10;
			}
			
			if(sum+i==nNum) {
				result =i;
				break;
			}
		}
		System.out.println(result);
	}
}
