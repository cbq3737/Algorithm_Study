package step7;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class num_11720 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int nNum = Integer.parseInt(br.readLine());
		String str = br.readLine();
		int sum=0;
		for(int i=0;i<nNum;i++) {
			sum+=Character.getNumericValue(str.charAt(i));
		}
		bw.write(String.valueOf(sum));
		br.close();
		bw.close();
	}
}
