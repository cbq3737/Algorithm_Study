package step_구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class num_2578 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] order = new String[26];
		for (int i = 0; i < 5; i++) {
			StringTokenizer tk = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) { //받는 부분
				order[Integer.parseInt(tk.nextToken())] = Integer.toString(i)+","+Integer.toString(j) ;
			}
		}

		int[] row = new int[5];
		int[] col = new int[5];
		int[] right_x = new int[1];
		int[] left_x = new int[1];
		int sum=0;
		int cnt =0;
		for (int i = 0; i < 5; i++) {
			StringTokenizer tk = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				cnt++;
				StringTokenizer tk_2 = new StringTokenizer(order[Integer.parseInt(tk.nextToken())],",");
				int row_num = Integer.parseInt(tk_2.nextToken());
				int col_num = Integer.parseInt(tk_2.nextToken());
				if(row_num==col_num) {//좌하 방향
					right_x[0]++;
					if(right_x[0]==5) {
						sum+=1;
					}
				}
				if((row_num+col_num)==4) { //우상 방향
					left_x[0]++;
					if(left_x[0]==5) {
						sum+=1;
					}
				}				
				row[row_num]++;
				col[col_num]++;
				if(row[row_num]==5) {
					sum+=1;
				}
				if(col[col_num]==5){
					sum+=1;
				}
				if(sum>=3) {	
					break;
				}
			}
			if(sum>=3) {
				System.out.println(cnt);
				break;
			}
		}
	}
}
