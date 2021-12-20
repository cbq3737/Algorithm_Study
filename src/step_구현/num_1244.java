package step_구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class num_1244 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int switch_num = Integer.parseInt(br.readLine());
		StringTokenizer tk = new StringTokenizer(br.readLine());
		boolean[] arr = new boolean[switch_num + 1];
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= switch_num; i++) {
			if (Integer.parseInt(tk.nextToken()) > 0) {
				arr[i] = true;
			} else {
				arr[i] = false;
			}
		}
		int num = Integer.parseInt(br.readLine());
		for (int i = 0; i < num; i++) {
			tk = new StringTokenizer(br.readLine());
			int gender = Integer.parseInt(tk.nextToken());
			int number = Integer.parseInt(tk.nextToken());
			if (gender == 1) { // 남자
				int cnt = 1;
				while (number * cnt <= switch_num) {
					arr[number * cnt] = !arr[number * cnt];
					cnt++;
				}
			} else { // 여자
				int cnt =1;
				while((number-cnt)>0 && (number+cnt)<=switch_num) {
					if (arr[number-cnt] == arr[number+cnt]) {// 동일
						arr[number-cnt] = !arr[number-cnt];
						arr[number+cnt] = !arr[number+cnt];
						cnt++;
					}
					else {
						break;
					}
				}
				arr[number] = !arr[number];
			}
		}
		for(int i=1;i<=switch_num;i++) {
			if(arr[i]) {
				sb.append(1+" ");
			}else {
				sb.append(0+" ");
			}
			if(i%20==0) {
				sb.append("\n");
			}
		}
		System.out.println(sb);
	}

}