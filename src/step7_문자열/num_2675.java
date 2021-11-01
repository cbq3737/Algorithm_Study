package step7_문자열;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class num_2675 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tNum = Integer.parseInt(br.readLine());
		for(int i=0;i<tNum;i++) {
			StringTokenizer tk = new StringTokenizer(br.readLine());
			int pNum = Integer.parseInt(tk.nextToken());
			String str = tk.nextToken();
			for(int j=0;j<str.length();j++) {
				for(int k=0;k<pNum;k++) {					
					sb.append(str.charAt(j));
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
		br.close();
	}
}
