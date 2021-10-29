package step5_배열;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class num_3052 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int[] arr = new int[10];
		int[] countarr = new int[42];
		int count = 0;
		for(int i=0;i<arr.length;i++) {
			int num = Integer.parseInt(br.readLine())%42;
			countarr[num]++;
		}
		for(int i=0;i<countarr.length;i++) {
			if(countarr[i]!=0) {
				count++;
			}
		}
		bw.write(String.valueOf(count));
		br.close();
		bw.close();
	}	
}
