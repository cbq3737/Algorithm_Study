
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_1873 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		for (int t = 0; t < tc; t++) {
			StringTokenizer tk = new StringTokenizer(br.readLine());
			int h = Integer.parseInt(tk.nextToken());
			int w = Integer.parseInt(tk.nextToken());
			char[][] map = new char[h][w];
			int i_idx = 0;
			int j_idx = 0;
			int d = 0;
			int[][] deltas = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };// 위 아래 왼 오
			for (int i = 0; i < h; i++) {
				String str = br.readLine();
				for (int j = 0; j < w; j++) {
					map[i][j] = str.charAt(j);
					if (map[i][j] == '>') {
						d = 3;
					} else if (map[i][j] == '<') {
						d = 2;
					} else if (map[i][j] == '^') {
						d = 0;
					} else if (map[i][j] == 'v') {
						d = 1;
					}
					if(map[i][j]!='*'&&map[i][j]!='#'&&map[i][j]!='-' && map[i][j]!='.') {
						i_idx = i;
						j_idx = j;
					}
				}
			}
			int nNum = Integer.parseInt(br.readLine());
			char[] carr = new char[nNum];
			String str= br.readLine();
			for (int i = 0; i < nNum; i++) {
				carr[i] = str.charAt(i);
			}
			for (int i = 0; i < nNum; i++) {
				char c = carr[i];
				switch (c) {
				case 'U':
					map[i_idx][j_idx] = '^';//생긴거 변경
					d = 0; //방향 바꿔주고
					if (i_idx - 1 < 0 || map[i_idx - 1][j_idx] == '#' || map[i_idx - 1][j_idx] == '*'
							|| map[i_idx - 1][j_idx] == '-') {

					} else { //이동할 수 있다면 
						map[i_idx][j_idx] = '.'; //기존 모양 평지로  바꿔주고
						
						i_idx = i_idx + deltas[d][0];
						j_idx = j_idx + deltas[d][1];		//방향 이동	
						map[i_idx][j_idx] = '^'; //생긴거 바꿔주고
					}
					break;
				case 'D':
					map[i_idx][j_idx] = 'v';
					d = 1;
					if (i_idx + 1 >= h || map[i_idx + 1][j_idx] == '#' || map[i_idx + 1][j_idx] == '*'
							|| map[i_idx + 1][j_idx] == '-') {

					} else {
						map[i_idx][j_idx] = '.'; 
						i_idx = i_idx + deltas[d][0];
						j_idx = j_idx + deltas[d][1];
						map[i_idx][j_idx] = 'v';	
					}
					break;
				case 'L':
					map[i_idx][j_idx] = '<';
					d = 2;
					if (j_idx -1 < 0 || map[i_idx][j_idx -1] == '#' || map[i_idx][j_idx -1] == '*'
					|| map[i_idx][j_idx -1] == '-') {

					} else {
						map[i_idx][j_idx] = '.'; 
						i_idx = i_idx + deltas[d][0];
						j_idx = j_idx + deltas[d][1];
						map[i_idx][j_idx] = '<';
					}
					break;
				case 'R':
					map[i_idx][j_idx] ='>';
					d = 3;
					if (j_idx +1 >= w || map[i_idx][j_idx +1] == '#' || map[i_idx][j_idx +1] == '*'
					|| map[i_idx][j_idx +1] == '-') {

					} else {
						map[i_idx][j_idx] = '.'; 
						i_idx = i_idx + deltas[d][0];
						j_idx = j_idx + deltas[d][1];
						map[i_idx][j_idx] ='>';
					}
					break;
				case 'S':
					int shoot_i = i_idx;
					int shoot_j = j_idx;
					while (true) {
						shoot_i = shoot_i + deltas[d][0];
						shoot_j = shoot_j + deltas[d][1];
						if (shoot_i <0 ||shoot_i >= h ||shoot_j >= w ||shoot_j<0 || map[shoot_i][shoot_j] == '#') {
							break;
						} else if (map[shoot_i][shoot_j] == '*') {
							map[shoot_i][shoot_j] = '.';
							break;
						}
					}
					break;
				default:
					break;
				}
			}//for문
			sb.append("#"+(t+1)+" ");
			for(int i=0;i<h;i++) {
				for(int j=0;j<w;j++) {
					sb.append(map[i][j]);
				}
				sb.append("\n");
			}
		}
		System.out.println(sb);
	}
}