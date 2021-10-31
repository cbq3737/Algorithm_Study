package step6_함수;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class num_1065 {
	public static int hansu_count(int num) {
		int count =0;
		if(num<100) {
			return num; //어차피 100보다 작으면 모두 수열
		}
		else {
			count = 99;
			for(int i=100;i<=num;i++) {
				int hundred = (i/10)/10;
				int ten = (i / 10)%10;
				int one = i %10;
				if((hundred-ten)==(ten-one)) {
					count +=1;
				}
			}
		}
		return count;
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int count_num = hansu_count(Integer.parseInt(br.readLine()));
		bw.write(String.valueOf(count_num));
		br.close();
		bw.close();
	}
}
