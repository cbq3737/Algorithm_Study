package step12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class num_1181 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int nNum = Integer.parseInt(br.readLine());
		StringBuilder sb= new StringBuilder();
		String[] str_arr = new String[nNum];
		for(int i=0;i<nNum;i++) {
			str_arr[i] = br.readLine();
		}
		for(int i=1;i<nNum;i++) {
			String key = str_arr[i];
			int key_length = key.length();
			for(int j=i-1;j>=0;j--) {
				if((str_arr[j].length()>key_length)) {
					str_arr[j+1] = str_arr[j]; 
					str_arr[j] = key;
				}
				if((str_arr[j].length()==key_length) && ((str_arr[j].compareTo(key))>0)) {
					str_arr[j+1] = str_arr[j]; 
					str_arr[j] = key;
				}
			}
		}
		for(int i=0;i<nNum;i++) {
			if(((i+1) != nNum) && str_arr[i].equals(str_arr[i+1]) ) {				
				continue;
			}
			else {
				sb.append(str_arr[i]+"\n");
			}
		}
		System.out.println(sb);
	}
}
