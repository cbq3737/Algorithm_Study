package step13;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class num_1987 {
	public static int max = Integer.MIN_VALUE;
	public static List<Character> list;
	public static char[][] carr;
	public static int[][] deltas= {{-1,0},{1,0},{0,1},{0,-1}};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk= new StringTokenizer(br.readLine());
		int rNum = Integer.parseInt(tk.nextToken());
		int cNum = Integer.parseInt(tk.nextToken());
		carr = new char[rNum][cNum];
		for(int i=0;i<rNum;i++) {
			String str = br.readLine();
			for(int j=0;j<cNum;j++) {
				carr[i][j] = str.charAt(j);
			}
		}
		list = new ArrayList<Character>();
		list.add(carr[0][0]);
		setBoard(1,0,0,rNum,cNum);
		System.out.println(max);
	}
	public static void setBoard(int cnt,int row,int col,int rNum,int cNum) {
			if(max<cnt) {
				max = cnt;
			}
			for(int i=0;i<4;i++) {
				int ni = row+deltas[i][0];
				int nj = col+deltas[i][1];
				if(isMove(cnt,ni,nj,rNum,cNum)) {
					list.add(carr[ni][nj]);
					setBoard(cnt+1, ni, nj, rNum, cNum);
					list.remove(list.size()-1);
				} 	
			}
	}
	public static boolean isMove(int cnt,int ni,int nj,int rNum,int cNum) {
		if(ni<0||nj<0||ni>=rNum||nj>=cNum) {//범위를 벗어나거나
			return false;
		}else {
			for(int i=0;i<list.size();i++) { 
				if(list.get(i)==carr[ni][nj]) { //기존에 알파벳이 존재한다면
					return false;
				}
			}
		}
		return true;
	}
}

