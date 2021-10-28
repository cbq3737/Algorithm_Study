package step3_for문;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class num_10871 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int nNum = Integer.parseInt(st.nextToken());
		int xNum = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[nNum];
		String[] strs = br.readLine().split(" ");
		for (int i = 0; i < nNum; i++) {
			int arrNum = Integer.parseInt(strs[i]);
			arr[i] = arrNum;
			if(arr[i]<xNum) {
				bw.write(arr[i]+" ");
			}
		}
		br.close();
		bw.flush();
		bw.close();
	}
}
