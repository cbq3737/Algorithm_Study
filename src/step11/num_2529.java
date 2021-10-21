package step11;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class num_2529 {//부등호
	public static char[] carr;
	public static long min;
	public static long max;
	public static String min_str;
	public static String max_str;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int nNum = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		carr =  new char[nNum]; //부등호 배열
		boolean[] visited = new boolean[10];
		StringTokenizer tk = new StringTokenizer(br.readLine());
		for(int i=0;i<nNum;i++) {
			carr[i] = tk.nextToken().charAt(0);
		}
		int[] arr = new int[nNum+1];//부등호가 오기에 적합한 숫자배열 생성
		
		min = Long.MAX_VALUE;
		max = Long.MIN_VALUE;
		check_num(arr,0,0,visited);
		sb.append(max_str+"\n"+min_str);
		System.out.println(sb);
	}
	//들어올 숫자 체크 ,순열처럼 하나하나씩 넣어가며 체크
	public static void check_num(int[] arr,int idx,int c_idx,boolean visited[]) {
		if(idx==arr.length) {
			String str = "";
			for(int i=0;i<arr.length;i++) {
				str+=arr[i];
			}
			long num = Long.parseLong(str);
			if(max<num) {
				max = num;
				max_str = str;
			}
			if(min>num) {
				min = num;
				min_str = str;
			}
			return;
		}
		for(int i=0;i<10;i++) {//순열 배열로 값 할당
			if(idx==0) { //맨처음
				visited[i] = true;
				arr[idx] = i;
				check_num(arr,idx+1,c_idx,visited);
				visited[i] = false;
			}else {
				if(!visited[i]&&check(arr,i,idx,c_idx)) {//방문체크 및 부등호에 따른 값 할당
					visited[i] = true;
					arr[idx]= i;
					check_num(arr,idx+1,c_idx+1,visited);//부등호 인덱스도 변경
					visited[i] = false;
				}
			}
		}
	}
	public static boolean check(int[] arr,int num,int idx,int c_idx) {//숫자와 부등호 체크
		if(carr[c_idx]=='<') {
			if(arr[idx-1]<num) {
				return true;
			}
			
		}else if(carr[c_idx]=='>') {
			if(arr[idx-1]>num) {
				return true;
			}
		}
		return false;
	}
	 
}
