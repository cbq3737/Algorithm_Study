package step11_브루트포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class num_15661 {//링크와 스타트 
	public static int[][] grid;
	public static int nNum;//사람 수
	public static ArrayList<Integer> start = new ArrayList();
	public static ArrayList<Integer> link = new ArrayList();
	public static int sub_score;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		nNum = Integer.parseInt(br.readLine());//인원 수 
		grid = new int[nNum][nNum];
		
		for(int i=0;i<nNum;i++) {
			StringTokenizer tk = new StringTokenizer(br.readLine());
			for(int j=0;j<nNum;j++) {
				grid[i][j] = Integer.parseInt(tk.nextToken());
			}
		}
		
		sub_score = Integer.MAX_VALUE;
		//만들 수 있는 모든 팀 조합 만들고
		for(int i=2;i<=nNum-2;i++) {
			makeCombi(0,new int[i],0,new boolean[nNum]);			
		}
	
		System.out.println(sub_score);
	}
	public static void makeCombi(int isSelect,int[] select,int startIdx,boolean[] visited) {
		if(isSelect == select.length) {
			//배열로 만들어서 두 팀으로 나누기
			for(int i=0;i<visited.length;i++) {
				if(visited[i]) {
					start.add(i) ;
				}else {
					link.add(i);
				}
			}
			//점수 체킹 
			if(Math.abs(cal_score(start)-cal_score(link))<sub_score) { //더 적은 값이 최솟값 
				sub_score = Math.abs(cal_score(start)-cal_score(link));
			}  	
			start.clear();
			link.clear();
			return;
		}
		
		for(int i = startIdx;i<nNum;i++) {
			select[isSelect] = i;
			visited[i] = true;
			makeCombi(isSelect+1,select,i+1,visited);
			visited[i]= false;
		}
	}
	//점수 합치기
	public static int cal_score(ArrayList<Integer> arr) {
		int cnt = 0;
		for(int i=0;i<arr.size()-1;i++) {
			for(int j=i+1;j<arr.size();j++) {
				cnt+=grid[arr.get(i)][arr.get(j)] + grid[arr.get(j)][arr.get(i)];
			}
		}
		return cnt;
	}
}
