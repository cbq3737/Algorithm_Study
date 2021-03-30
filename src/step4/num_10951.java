package step4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class num_10951 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String str = "";
		while((str=br.readLine()) != null) {
			StringTokenizer tk = new StringTokenizer(str);
			int aNum = Integer.parseInt(tk.nextToken());
			int bNum = Integer.parseInt(tk.nextToken());
			int result = aNum+bNum;
			bw.write(result+"\n");
		}	
		br.close();
		bw.close();
	}
}
