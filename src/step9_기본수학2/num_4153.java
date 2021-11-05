package step9_기본수학2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class num_4153 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while(true) {
			StringTokenizer tk = new StringTokenizer(br.readLine());
			int aNum = Integer.parseInt(tk.nextToken());
			int bNum= Integer.parseInt(tk.nextToken());
			int cNum = Integer.parseInt(tk.nextToken());
			if(aNum==0 && bNum==0 && cNum==0) {
				break;
			}
			if((int)Math.pow(aNum,2)+(int)Math.pow(bNum,2)==(int)Math.pow(cNum,2)) {
				sb.append("right"+"\n");
			}
			else if((int)Math.pow(aNum,2)+(int)Math.pow(cNum,2)==(int)Math.pow(bNum,2)) {
				sb.append("right"+"\n");
			}
			else if((int)Math.pow(cNum,2)+(int)Math.pow(bNum,2)==(int)Math.pow(aNum,2)) {
				sb.append("right"+"\n");
			}
			else {
				sb.append("wrong"+"\n");
			}
		}
		System.out.println(sb);
	}
}
