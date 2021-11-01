package step7_문자열;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class num_10809 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String s = br.readLine();
		char[] carr = new char[s.length()];
		for(int i=0;i<s.length();i++) {
			carr[i] = s.charAt(i);
		}
		char[] alpha = new char[26];
		int[] alpha_arr = new int[26];
		for(int i=0;i<26;i++) {
			alpha_arr[i]= -1;
			alpha[i]= (char)(97+i);
			for(int j=0;j<carr.length;j++) {
				if(alpha[i]==carr[j]) {
					if(alpha_arr[i] != -1) {
						continue;
					}else {						
						alpha_arr[i]= j;
					}
				}
			}
			bw.write(String.valueOf(alpha_arr[i])+" ");
		}
		br.close();
		bw.close();
	}
}
