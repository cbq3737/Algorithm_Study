package step7_문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class num_2941 {

	public static void main(String[] args) throws IOException {

		int count_num=0;
		int pre=0;
		int morepre=0;
		int string;
		boolean brun= true;
		while(brun) {
			string = System.in.read();
			if(string==61) { //=
				if(pre==122) { //z
					if(morepre==100) { //d
						count_num-=1;			
						}
					else {
						count_num=count_num;
					}
				}
				if(pre==115 ||pre==99) { //s
					count_num=count_num;				}
			}
			else if(string==106) {
				if(pre==108 || pre==110) { //j
				//n or l
					count_num=count_num;
				}
				else {
					count_num+=1;
				}
			}
			else if(string==45) {//-
					if(pre==99 || pre==100) { //c
						count_num=count_num;
					}
					else {
						count_num+=1;
					}
			}
			else if(string<=32) {
				brun = false;
			}
			else {
				count_num+=1;
			}
			morepre = pre;
			pre=string;
			
		}
		System.out.println(count_num);
	}
}
