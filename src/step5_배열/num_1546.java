package step5_배열;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class num_1546 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int subject = Integer.parseInt(br.readLine());
		StringTokenizer tk = new StringTokenizer(br.readLine());
		double[] arr = new double[subject];
		int maxScore = 0;
		double avgScore = 0;
		for(int i=0;i<arr.length;i++) {
			arr[i] = Integer.parseInt(tk.nextToken());
			if(arr[i]>maxScore) {
				maxScore = (int) arr[i];
			}
		}
		for(int i=0;i<arr.length;i++) {
			arr[i] = ((double)arr[i]/maxScore)*100;
			avgScore+=arr[i];
		}
		bw.write(String.valueOf(avgScore/arr.length));
		br.close();
		bw.flush();
		bw.close();
	}
}
