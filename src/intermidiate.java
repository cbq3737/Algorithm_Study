
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class  intermidiate {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int nNum = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < nNum; i++) {
			int num = Integer.parseInt(br.readLine());
			char[][] grid = new char[num][num];
			int cnt = 0;
			int a = 'A';
			for (int j = 0; j < num; j++) {
				String s = br.readLine();
				for (int k = 0; k < num; k++) {
					grid[j][k] = s.charAt(k);
				}
			}

			for (int j = 0; j < num; j++) {
				for (int k = 0; k < num; k++) {
					if (grid[j][k] != 'X' && grid[j][k] != 'H') {
						// -> H가 있으면 X로 변경 A 1, B 2 ,C 3
						for(int d= 1; d <=(grid[j][k] - 'A' +1) ; d++) {							
							if(k+d< num && grid[j][k+d]=='H') { //동서남북
								grid[j][k+d]='X';
							}
							if(0<=k-d &&grid[j][k-d]=='H') {
								grid[j][k-d]='X';
							}
							if(j+d< num && grid[j+d][k]=='H') { //동서남북
								grid[j+d][k]='X';
							}
							if(0<=j-d &&grid[j-d][k]=='H') {
								grid[j-d][k]='X';
							}
						}
					}
				}
			}

			for (int j = 0; j < num; j++) {
				for (int k = 0; k < num; k++) {
					if (grid[j][k] == 'H') { //커버되지 않는 집 카운팅
						cnt++;
					}
				}
			}
			System.out.println("#" + (i+1) + " " + cnt);
		}
	}

}
