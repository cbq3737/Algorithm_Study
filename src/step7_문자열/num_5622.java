package step7_문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class num_5622 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str= br.readLine(); 
		int count=0;
		for(int i=0;i<str.length();i++) {
			char c = str.charAt(i);
			if(c>='A'&&c<='C') {
				count+=3;
			}
			else if(c>='D'&&c<='F') {
				count+=4;
			}
			else if(c>='G'&&c<='I') {
				count+=5;
			}
			else if(c>='J'&&c<='L') {
				count+=6;
			}
			else if(c>='M'&&c<='O') {
				count+=7;
			}
			else if(c>='P'&&c<='S') {
				count+=8;
			}
			else if(c>='T'&&c<='V') {
				count+=9;
			}
			else if(c>='W'&&c<='Z') {
				count+=10;
			}
		}
		System.out.println(count);
	}
}
