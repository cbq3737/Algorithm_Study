package step8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class num_2292 {

	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int nNum = Integer.parseInt(br.readLine());
		int range = 2;
		int count= 1;
		if(nNum==1) {
			System.out.println(count);
		}
		else {
			while(range<=nNum) {
				range = range+ (6*count);//다음범위
				++count;
			}	
			System.out.println(count);
		}
		
	}
}
