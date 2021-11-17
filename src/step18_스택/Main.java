package step18_스택;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			boolean flag = true;
			int idx =0;
	
			char[] carr = new char[101];
			String str = br.readLine();
			if(str.equals(".")) { //종료 	
				break;
			}
			for(int i=0;i<str.length();i++) {
				if(str.charAt(i)=='(' || str.charAt(i)=='[') {
					carr[idx++] = str.charAt(i);	
				}else if(str.charAt(i)==')' ) {
					if(idx==0 ||carr[(idx-1)]!='(') {
						flag = false;
						break;
					}else {
						idx--;
					}
				}
				else if(str.charAt(i)==']') {
					if(idx==0 || carr[(idx-1)]!='[') {
						flag = false;
						break;
					}else {
						idx--;
					}
				}
			}
			if(flag == true && idx==0) {
				System.out.println("yes");
			}else {
				System.out.println("no");
			}
		}
	}
}