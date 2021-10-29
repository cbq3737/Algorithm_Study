package step5_배열;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class num_4344 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int cases = Integer.parseInt(br.readLine());
		for(int i=0;i<cases;i++) {
			StringTokenizer tk = new StringTokenizer(br.readLine());
			int studentNum = Integer.parseInt(tk.nextToken());
			int[] score = new int[studentNum];
			double sum = 0;
			double avg = 0;
			int count = 0;
			for(int j=0;j<studentNum;j++) {
				score[j]= Integer.parseInt(tk.nextToken());
				sum+= score[j];				
			}
			avg = sum/(studentNum);
			for(int j=0;j<studentNum;j++) {
				if(score[j]>avg) {
					count+=1;
				}		
			}
			double avgRatio = ((double)count/(studentNum))*100;
			bw.write(String.format("%.3f", avgRatio)+"%");
			bw.newLine();
		}
		br.close();
		bw.close();
	}
}
