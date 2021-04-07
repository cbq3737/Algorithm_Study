package step7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class num_1152 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] strArray = br.readLine().split(" ");
		int count=0;
	
		for(int i=0;i<strArray.length;i++) {
			if(strArray[i].equals("") || strArray[i].equals("\n")) {
				continue;
			}
			else {
				++count;
			}
		}
		System.out.println(count);
	}
//	int count = 0;
//	int pre_str = 32;	// 공백을 의미한다.
//	int str ;
//	
//	
//	while(true) {
//		str = System.in.read();
//        
//		// 입력받은 문자가 공백일 때,
//		if(str == 32) {
//			// 이전의 문자가 공백이 아니면
//			if(pre_str != 32) count++;
//		}
//
//		// 입력받은 문자가 개행일때 ('\n')
//		else if(str == 10) {
//			// 이전의 문자가 공백이 아니면
//			if(pre_str != 32) count++;
//			break;
//		}
//		
//		pre_str = str;
//		
//	}
//	
//	System.out.println(count);
}
//32 = space
//10 = \n