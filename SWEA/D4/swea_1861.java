import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_1861 {
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		int[][] deltas = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
		for (int t = 0; t < tc; t++) {
			int nNum = Integer.parseInt(br.readLine());
			int[][] arr = new int[nNum][nNum];
			for (int i = 0; i < nNum; i++) {
				StringTokenizer tk = new StringTokenizer(br.readLine());
				for (int j = 0; j < nNum; j++) {
					arr[i][j] = Integer.parseInt(tk.nextToken());
				}
			}
			sb.append("#"+(t+1)+" ");
			check_room(nNum, arr, deltas);
		}
		System.out.println(sb);
	}

	public static void check_room(int nNum, int[][] arr, int[][] deltas) {
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < nNum; i++) {
			for (int j = 0; j < nNum; j++) {
				int row =i;
				int col =j;
				int cnt = 1;
				int cnt_change =cnt;
				while (true) {
					for (int d = 0; d < deltas.length; d++) {
						int ni = row + deltas[d][0];
						int nj = col + deltas[d][1];
						if (ni >= 0 && nj >= 0 && ni < nNum && nj < nNum && arr[ni][nj] == (arr[row][col] + 1)) {
							cnt++;
							row = ni;
							col = nj;
						}
					}
					//카운트 값 바꼇니?
					if(cnt_change != cnt) { //바껴써
						cnt_change = cnt;
					}else {
						break;
					}
				}
				if(max<=cnt&&cnt>1) {//처음값은 못들어도록
					if(max<cnt) {		//그냥 수가 더 큰수				
						min = arr[i][j];
					}
					if(max==cnt){		//동일한것중에 작은 수	
						min = Math.min(arr[i][j], min);
					}
					max = Math.max(max, cnt);
				}
			}
		}
		sb.append(min+" "+max+"\n");
	}
}
