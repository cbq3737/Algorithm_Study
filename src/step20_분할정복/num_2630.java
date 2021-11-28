package step20_분할정복;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class num_2630 {//색종이만들기
	public static int color_cnt = 0;
	public static int white_cnt = 0;
	public static boolean[][] color_map;
	public static boolean[][] white_map;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int nNum = Integer.parseInt(br.readLine());
		color_map = new boolean[nNum][nNum];
		white_map = new boolean[nNum][nNum];
		for(int i=0;i<nNum;i++) {
			StringTokenizer tk =new StringTokenizer(br.readLine());
			for(int j=0;j<nNum;j++) {
				int num = Integer.parseInt(tk.nextToken());
				if(num==1) {
					color_map[i][j] = true;
					white_map[i][j] = true;
				}
			}
		}
		check_num(0,0,nNum);
		sb.append(white_cnt+"\n");
		sb.append(color_cnt);
		System.out.println(sb);
	}
	public static void check_num(int r, int c, int nNum) {
		boolean color_flag = false;//공백 구간 판단
		boolean white_flag = false;//색상 구간 판단
		for(int i=r;i<r+nNum;i++) {
			for(int j=c;j<c+nNum;j++) {
				if(!color_map[i][j]) {
					color_flag = true;//도중에 공백구간이 있다면
				}
				if(white_map[i][j]) {
					white_flag = true;//도중에 색상 구간이 있다면
				}
			}
		}
		
		if(!white_flag) {//온통 백지구간이라면
			white_cnt++;
			for(int i=r;i<r+nNum;i++) {
				for(int j=c;j<c+nNum;j++) {
					white_map[i][j]= true;
				}
			}
		}
		
		if(!color_flag) {//색칠한 공간 구간이라면
			color_cnt++;//갯수 카운팅 +!
			for(int i=r;i<r+nNum;i++) {
				for(int j=c;j<c+nNum;j++) {
					color_map[i][j]= false;
				}
			}
			return;
		}

		if(nNum>1) {
			check_num(r,c,nNum/2);//좌상
			check_num(r,c+nNum/2,nNum/2);//우상
			check_num(r+nNum/2,c,nNum/2);//좌하
			check_num(r+nNum/2,c+nNum/2,nNum/2);//우하
		}
	}
}
