package step12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class num_10989 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int nNum = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		int[] arr = new int[10001];
		for(int i=0;i<nNum;i++) {
			arr[Integer.parseInt(br.readLine())]++;
		}
		
		for(int i=1;i<10001;i++) {
			while(arr[i]>0) {
				sb.append(i+"\n");
				arr[i]--;
			}
		}
		System.out.println(sb);
	}
}
