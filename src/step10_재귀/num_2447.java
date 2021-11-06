package step10_재귀;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class num_2447 {
	static char arr[][];
	public static void star(int x,int y,int nNum,boolean blank) {
		if(blank) {
			for(int i=x;i<x+nNum;i++) {
				for(int j=y;j<y+nNum;j++) {
					arr[i][j]=' ';
				}
			}
			return;
		}
		if(nNum==1) {
			arr[x][y] ='*';
			return;
		}
		
		int size=  nNum/3;
		int count=0;
		for(int i=x;i<x+nNum;i+=size) {
			for(int j=y;j<y+nNum;j+=size) {
				count++;
				if(count==5) {
					star(i,j,size,true);
				}
				else {
					star(i,j,size,false);
				}
			}
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int nNum = Integer.parseInt(br.readLine());
		arr = new char[nNum][nNum];
		star(0,0, nNum,false);
		
		for(int i=0;i<nNum;i++) {
			for(int j=0;j<nNum;j++) {
				sb.append(arr[i][j]);
			}
			sb.append('\n');
		}
		System.out.println(sb);
	}
}
