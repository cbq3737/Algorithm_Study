package step11;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class num_14501 {
	public static int[][] arr;
	public static int nNum;
	public static int max;
	public static void main(String[] args) throws NumberFormatException, IOException {//퇴사
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
	nNum= Integer.parseInt(br.readLine());
	arr = new int[nNum][2];
	for(int i=0;i<nNum;i++) {
		StringTokenizer tk = new StringTokenizer(br.readLine());
		for(int j=0;j<2;j++) {
			arr[i][j]= Integer.parseInt(tk.nextToken());//상담 일정표
		}
	}
	max = Integer.MIN_VALUE;	
	//부분집합
	powerSet(0,new boolean[nNum]);
	System.out.println(max);
	}
	public static void powerSet(int isSelect,boolean[] visited) {
		if(isSelect==visited.length) {
			if(check_day(visited)) {//가능한 조합인지	 체크
				check_benefit(visited);//최댓값 구하기
			}
			return;
		}
		visited[isSelect]=true;
		powerSet(isSelect+1,visited);
		
		visited[isSelect]=false;
		powerSet(isSelect+1,visited);
	}
	public static boolean check_day(boolean[] visited) {
		int idx =0;
		for(int i=0;i<visited.length;i++) {
			if(visited[i]) {
				int day = i;//당일 날짜
				idx= day+arr[i][0];//다음 상담날
				if(idx<=nNum) { //다음상담날짜가 주어진 날짜보다 작거나 같다면, 1일도 포함
					for(int j=i+1;j<idx;j++) {
						if(visited[j]) {
							return false; //다음 날짜 전에 이미 상담날짜가 조합 중에 존재한다면 성립이 안됌.
						}
					}	
				}else {//인덱스가 상담날짜를 벗어난다면
					return false;
				}
			}
		}
		return true;
	}
	public static void check_benefit(boolean[] visited) {
		int cnt =0;
		for(int i=0;i<visited.length;i++) {
			if(visited[i]) {
				cnt+=arr[i][1];//값 누적
			}
		}
		if(max<cnt) {//값 갱신
			max=cnt;
		}
	}
}
