package step5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class num_2562 {

	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw =new BufferedWriter(new OutputStreamWriter(System.out));
		int[] arr = new int[9];
		int max = 0;
		int count =0;
		
		for(int i=0;i<arr.length;i++) {
			StringTokenizer tk = new StringTokenizer(br.readLine());
			arr[i] = Integer.parseInt(tk.nextToken());
		}
		for(int i=0;i<arr.length;i++) {
			if(arr[i]>max) {
				max = arr[i];
				count = i+1;
			}
		}
		bw.write(String.valueOf(max));
		bw.newLine();
		bw.write(String.valueOf(count));
		
		br.close();
		bw.flush();
		bw.close();
	}
}
