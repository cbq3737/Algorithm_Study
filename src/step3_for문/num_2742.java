package step3_for문;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class num_2742 {

	public static void main(String[] args) throws NumberFormatException, IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			int nNum = Integer.parseInt(br.readLine());
			for(int i=nNum;i>0;i--) {
				bw.write(i+"\n");
			}
			br.close();
			bw.flush();
			bw.close();
			
	}
}
