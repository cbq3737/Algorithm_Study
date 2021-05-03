package step13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class num_2580 {
	public static int[][] arr = new int[9][9];
	public static StringBuilder sb = new StringBuilder();
	public static void check_num(int row,int column) {
		if(column == 9) { //행이 다 채워졌다면 다음 열
			check_num(row+1,0);
			return;
		}
		if(row == 9) { //행과 열이 다 채워진것. 출력
			for(int i=0;i<9;i++) {
				for(int j=0;j<9;j++) {
					sb.append(arr[i][j]+" ");
				}
				sb.append("\n");
			}
			System.out.println(sb);
			System.exit(0);
		}
		if(arr[row][column]==0) {			
			for(int i=1;i<=9;i++) { //1부터 9까지 검사
				if(check(row,column,i)) { //값 중복 검사
					arr[row][column]= i;
					check_num(row,column+1);
				}
			}
			arr[row][column] = 0; //답이 없을 경우 이전깊이로 돌아가야하기 때문에
			return ;
		}
		check_num(row,column+1);//위에 조건문 안걸릴 시 
		
	}
	public static boolean check(int row,int column,int value) {
		for(int i=0;i<9;i++) { //같은 행에 있는지 검사
			if(arr[row][i] == value) {
				return false;
			}
		}
		for(int i=0;i<9;i++) { //같은 열에 있는지 검사
			if(arr[i][column] ==value) {
				return false;
			}
		}
		//3x3 검사 0,3,6마다 3x3이 생김
		int set_row = (row/3)*3;
		int set_column = (column/3)*3;
		
		for(int i=set_row;i<(set_row+3);i++) {
			for(int j=set_column;j<(set_column+3);j++) {
				if(arr[i][j]== value) {
					return false;
				}
			}
		}
		return true;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i=0;i<9;i++) {
			StringTokenizer tk = new StringTokenizer(br.readLine());
			for(int j=0;j<9;j++) {
				arr[i][j] = Integer.parseInt(tk.nextToken());
			}
		}
		check_num(0,0);
	}
	
}
