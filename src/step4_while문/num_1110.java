package step4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class num_1110 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int originNum = Integer.parseInt(br.readLine());
		String str= String.valueOf(originNum);
		int lNum;
		int rNum;
		int hap;
		int count = 0;
		Boolean bRun = true;
		while (true) {
			int num = Integer.parseInt(str);
			if (num < 10) {
				lNum = 0;
				rNum = num % 10;
				hap = lNum + rNum;
			} else {
				lNum = num / 10;
				rNum = num % 10;
				if (lNum + rNum > 0) {
					hap = (lNum + rNum) % 10;
				} else {
					hap = lNum + rNum;
				}
			}
			String newstr = String.valueOf(rNum) + String.valueOf(hap);
			str = newstr;
			count += 1;
			if(originNum == Integer.parseInt(str)) {
				bw.write(String.valueOf(count));
//				bRun = false;
				break;
			}
		}
		br.close();
		bw.close();
	}
}
