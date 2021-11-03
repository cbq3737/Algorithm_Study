package step8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class num_1712 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(br.readLine());
		int aNum = Integer.parseInt(tk.nextToken());
		int bNum = Integer.parseInt(tk.nextToken());
		int cNum = Integer.parseInt(tk.nextToken());

		if(cNum<=bNum) {
			System.out.println(-1);
		}
		else {
			System.out.println((aNum/(cNum-bNum))+1);
		}
	}
}
