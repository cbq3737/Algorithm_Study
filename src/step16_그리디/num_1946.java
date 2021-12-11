package step16_그리디;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class num_1946 {//신입사원
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tcase = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int t=0;t<tcase;t++) {
			int nNum = Integer.parseInt(br.readLine());//사원 수
			int[][] score =  new int[nNum][2];
			for(int i=0;i<nNum;i++) {				
				StringTokenizer tk = new StringTokenizer(br.readLine());
				int paper = Integer.parseInt(tk.nextToken());//서류 점수
				int meet = Integer.parseInt(tk.nextToken());//면접 점수
				score[i][0] = paper;
				score[i][1] = meet;
			}
			Arrays.sort(score,new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					return o1[0] - o2[0];
				}
			});
			//서류 점수로 정렬을 한 후에 역으로 면접점수를 보면서 내 점수보다 높은 순위가 있으면 안됌. 			
			int cnt = 1;
			int meet_max = score[0][1];//최대 면접 점수 
			for(int i=1;i<nNum;i++) {
				if(meet_max>score[i][1]) {
					cnt++;
					meet_max = score[i][1];
				}
			}
			sb.append(cnt+"\n");
		} 
		System.out.println(sb);
	}
}

//public class Main {//신입사원
//	public static void main(String[] args) throws NumberFormatException, IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		int tcase = Integer.parseInt(br.readLine());
//		StringBuilder sb = new StringBuilder();
//		for(int t=0;t<tcase;t++) {
//			int nNum = Integer.parseInt(br.readLine());//사원 수
//			int[] score = new int[nNum+1];
//			for(int i=0;i<nNum;i++) {				
//				StringTokenizer tk = new StringTokenizer(br.readLine());
//				int paper = Integer.parseInt(tk.nextToken());//서류 점수
//				int meet = Integer.parseInt(tk.nextToken());//면접 점수
//				score[paper] = meet;
//			}
//			//서류 점수로 정렬을 한 후에 역으로 면접점수를 보면서 내 점수보다 높은 순위가 있으면 안됌. 			
//			int cnt = 1;
//			int meet_max = score[1];//최대 면접 점수
//			for(int i=1;i<=nNum;i++) {
//				if(meet_max>score[i]) {
//					cnt++;
//					meet_max =score[i];
//				}
//
//			}
//			sb.append(cnt+"\n");
//		} 
//		System.out.println(sb);
//	}
//}

