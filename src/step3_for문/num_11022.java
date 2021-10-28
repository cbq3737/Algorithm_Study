package step3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class num_11022 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int tNum = Integer.parseInt(br.readLine());
		for(int i=0;i<tNum;i++) {
			String[] strs = br.readLine().split(" ");
			int aNum = Integer.parseInt(strs[0]);
			int bNum = Integer.parseInt(strs[1]);
			int result = aNum+bNum;
			bw.write("Case #"+(i+1)+": "+aNum+" + "+bNum+" = "+result+"\n");
		}
		br.close();
		bw.flush();
		bw.close();
	}
}
