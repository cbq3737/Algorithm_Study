package step5_배열;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class num_10818 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int nNum = Integer.parseInt(br.readLine());

		int[] arr = new int[nNum];
		StringTokenizer tk = new StringTokenizer(br.readLine()); // token이 하나씩 있을때마다 입력할 수 있음. 대신 각 입력에 공백을 없애는 역할
		for (int i = 0; i < nNum; i++) {
			arr[i] = Integer.parseInt(tk.nextToken());
		}

		int min = arr[0], max = arr[0];

		for (int i = 0; i < nNum; i++) {
			if (arr[i] < min) {
				min = arr[i];
			}
			if (arr[i] > max) {
				max = arr[i];
			}
		}
		bw.write(String.valueOf(min) + " " + String.valueOf(max));
		br.close();
		bw.close();
	}
}
