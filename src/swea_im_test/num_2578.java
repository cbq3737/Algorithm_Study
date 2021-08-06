package swea_im_test;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class num_2578 { 			

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[][] bingo = new int[5][5];
							// 하 우상 우 우하
		int[][] deltas = { { 1, 0 }, { -1, 1 }, { 0, 1 }, { 1, 1 } };// 탐색방향
		int[][] deltas_del = { { 0, 1 }, { 1, -1 }, { 0, -1 }, { -1, -1 } }; // 반대방향
		boolean[][] visited = new boolean[5][5];
		for (int i = 0; i < 5; i++) {
			StringTokenizer tk = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				bingo[i][j] = Integer.parseInt(tk.nextToken());
			}
		}
		int cnt =0;
		for (int i = 0; i < 5; i++) {
			StringTokenizer tk = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				int num = Integer.parseInt(tk.nextToken());// 사회자가 부른 번호
				cnt++;
				int find_i = 0;
				int find_j = 0;

				for (int row = 0; row < 5; row++) {
					for (int col = 0; col < 5; col++) {
						if (bingo[row][col] == num) {
							find_i = row;
							find_j = col; // 위치 찾아주기
							break;
						}
					}
				}
				visited[find_i][find_j] = true; // 사회자가 부른곳 표시
				int sum = 0;
				for (int d = 0; d < deltas.length; d++) {
					int ni = find_i + deltas[d][0];
					int nj = find_j + deltas[d][1];
					if (ni >= 0 && nj >= 0 && ni < bingo.length && nj < bingo.length&&visited[ni][nj]==true) {
						if (check_bingo(bingo, deltas, visited, find_i, find_j, d)&&check_bingo(bingo, deltas_del, visited, find_i, find_j, d)) {
							sum += 1;
						}
					}
				}
				if (sum >= 3) {
					System.out.println(cnt);// 몇번쨰인지 출력
					break;
				}
			}
		}
	}
	public static boolean check_bingo(int[][] bingo,int[][] deltas ,boolean[][] visited,int i,int j, int d) {
		if(i<0||j<0||i>=bingo.length||j>=bingo.length) { //끝에 도달했다면, 처음 호출될 땐 다음 범윌 검사하고 들어와서 안걸림
			return true;
		}
		//여기서 판단 ,가로,세로,대각선 빙고인지 
		//여기 왓을 때 지금 들어온 위치에서 5개가 빙고인지 판단하는것도 있지만, 다른 방향에서도 빙고인지 판단을 해줘야한다. 
		//다른 사람들은 가로,세로,우,좌 대각선을 아예 처음부터 세서 맞는지 판단
		int ni = i+deltas[d][0];
		int nj = j+deltas[d][1]; //빙고방향
		if(visited[i][j]) {	//현재 빙고 위치인지			
			if(check_bingo(bingo,deltas,visited,ni,nj,d)) {//정방향이 맞다면
					return true;
			}
		}
		return false;
	}
}
