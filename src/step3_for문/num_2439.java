package step3_for문;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class num_2439 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int tNum = Integer.parseInt(br.readLine());
		for(int i=1;i<=tNum;i++) {
			for(int j=tNum-i;j>0;j--) {
				bw.write(" ");
			}
			for(int j=0;j<i;j++) {
				bw.write("*");				
			}
			bw.write("\n");
		}
		br.close();
		bw.flush();
		bw.close();
	}
}
