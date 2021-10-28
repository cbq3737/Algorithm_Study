package step4_while문;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class num_10952 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Boolean bRun = true;
		
		while(bRun) {
			StringTokenizer tk = new StringTokenizer(br.readLine());
			int aNum = Integer.parseInt(tk.nextToken());
			int bNum = Integer.parseInt(tk.nextToken());
			int result = aNum+bNum;
			if(aNum!=0 && bNum !=0) {
				bw.write(result+"\n");
			}
			else {	
				bRun= false;
			}
		}
		br.close();
		bw.flush();
		bw.close();
	}
}
