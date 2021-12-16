package step14_백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class num_10971 {//외판원 순회2
	public static int[][] pay;
	public static int cnt;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int nNum = Integer.parseInt(br.readLine());
		pay = new int[nNum][nNum];
		for(int i=0;i<nNum;i++) {
			StringTokenizer tk = new StringTokenizer(br.readLine());
			for(int j=0;j<nNum;j++) {
				pay[i][j] = Integer.parseInt(tk.nextToken());
			}
		}
		cnt = Integer.MAX_VALUE;
		//순열 조합 만들기 
		makePermutation(0,new int[nNum],new boolean[nNum]);
		//순열 값 + 첫번째값으로 오는 값 중 최솟값 찾기
		System.out.println(cnt);
	}
	public static void makePermutation(int isSelect,int[] select,boolean[] visited) {
		if(isSelect==select.length) {
			if(check_path(select)) {//0이면 갈수없는 길이므로 0이 나오면 안된다. 그러므로 백트래킹으로 검사 
				int money = check_pay(select); //비용 체크 
				if(money<cnt) {
					cnt = money;
				}				
			}
			return;
		}
		
		for(int i=0;i<select.length;i++) {
			if(!visited[i]) {
				select[isSelect]=i;
				visited[i] = true;
				makePermutation(isSelect+1,select,visited);
				visited[i]=false;
			}
		}
	}
	public static boolean check_path(int[] select) {
		for(int i=0;i<select.length-1;i++) {
			if(pay[select[i]][select[i+1]]==0) {
				return false;
			}
		}
		if(pay[select[select.length-1]][select[0]]==0) {
			return false;
		}
		return true;
	}
	public static int check_pay(int[] select) {
		int money = 0;
		for(int i=0;i<select.length-1;i++) {
			money+=pay[select[i]][select[i+1]];
		}
		money+=pay[select[select.length-1]][select[0]];//원래 여행지로 돌아올 때
		return money;
	}
}
