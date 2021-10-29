package step5_배열;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class num_8958 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int num = Integer.parseInt(br.readLine());
		String[] strs= new String[num];
		for(int i=0;i<strs.length;i++) {
			StringTokenizer tk = new StringTokenizer(br.readLine());
			strs[i]= tk.nextToken();
			int count = 0;
			int score =0;
			for(int j=0;j<strs[i].length();j++) {
				if(strs[i].charAt(j)=='O'||strs[i].charAt(j)=='o') {
					score +=1; //보다 단순한 방법
//					if(j==0) {
//						score = 1;
//					}
//					else if(strs[i].charAt(j-1)=='O'||strs[i].charAt(j-1)=='o') {
//						score +=1;
//					}
//					else {
//						score = 1;
//					}
				}
				else {
					score = 0;
				}
				count+=score;
				
			}
			bw.write(String.valueOf(count));
			bw.newLine();
		}
		br.close();
		bw.flush();
		bw.close();
	}
}
