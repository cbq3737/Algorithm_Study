package step8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class num_2869 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(br.readLine());
		int aNum = Integer.parseInt(tk.nextToken());
		int bNum = Integer.parseInt(tk.nextToken());
		int vNum = Integer.parseInt(tk.nextToken());
		int day = (vNum-bNum)/(aNum-bNum);
		if((vNum-bNum)%(aNum-bNum)!=0) {
			day++;
		}
		System.out.println(day);
	}
}
