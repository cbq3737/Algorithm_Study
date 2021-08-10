package swea_im_test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class num_2564 {
	static char[][] block;
	static char[] shop;
	static int idx = 0;
	static int dong_i = 0;
	static int dong_j = 0;
	static int[][] deltas = {{-1,0},{1,0},{0,-1},{0,1}};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(br.readLine());
		int col = Integer.parseInt(tk.nextToken());
		int row = Integer.parseInt(tk.nextToken());
		block = new char[row+1][col+1];
		int nNum = Integer.parseInt(br.readLine());
		shop = new char[nNum];
		int sum =0;
		for(int i=0;i<nNum;i++) {
			tk= new StringTokenizer(br.readLine());
			int dir = Integer.parseInt(tk.nextToken()); //위치
			int dis = Integer.parseInt(tk.nextToken()); //경계까지 거리
			block_loc(dir,dis,row,col,0,idx);//상점 위치, 마지막 가게면 0, 동근이면 1\
			//입력받을 때, 좌표 정보, 위치정보만 받아놓고, 아래서 동근이 위치정보받고 반대방향인지 붙어있는지 비교
		}
		tk = new StringTokenizer(br.readLine());
		int dongen_dir = Integer.parseInt(tk.nextToken());
		int dongen_dis = Integer.parseInt(tk.nextToken());
		block_loc(dongen_dir,dongen_dis,row,col,1,idx);
		while(idx>=0) {
			char c = shop[--idx];
			int i = dong_i;
			int j = dong_j;
			int cnt =0;
			switch(c) 
			{
			case 'N':
//				cnt = check_shop_ns(c,i,j,row,col);
				sum+=cnt;
				break;
			case 'S':

				break;
			case 'W':
				
				break;
			case 'E':
				
				break;
			}
		}
	}
	
	public static int check_shop(char c,int i,int j,int row, int col,int cnt) {
		//동근이이와 반대방향 , 똑같음
		//NS, 일때		//오 col-동근이 j 위치+,col-샵 j 위치 + row크기
		//              //왼  동근의 j 위치 +,샵 j위치+row
		//EW 				 row-동근이 i위치+row-샵i위치 +col크기
		//					동근의 i위치+샵 i위치+col
		//바로 샵이 옆이라면, 가장 최단거리
//동근이 NS 일때 샵이 서쪽일때  N은  동근j위치+ 샵i위치;		
		//      동쪽일때 N은 col-동근j위치 +샵i위치;
		//  	서쪽일때 S은 동근j위치+ row-샵i위치;
		//		 동쪽일때 S은  col-동근 j위치+ row-샵i위치;
		
//동근이 EW 일때  샵이 북쪽일때 W은 동근의i위치+샵으j위치
		//       남쪽일때 W은 row -동근 i위치+동근j위치
		//		북족일때 E 은  동근의 i위치+col-샵의 j위치
		//		남쪽일 때 E   동근의 row-위치+col-샵의j위치
		
		//위에서 조건을 줄 때 row,col만 바꿔서 주면 될 듯.
		//아래 위치를 선정하는걸  위에서 직접 받아서 바로 함수로 보내줘서 비교하면 될 듯.
		//샵의 위치 i,j정보는 하나의배열로 String으로 넣어놓으면 될 듯. [0][위치],[row][위치]
		return 0;
	}
	public static void block_loc(int dir,int dis,int row,int col,int who,int idx) {
		if(dir==1) {
			if(who==0) {	
				block[0][dis] = 'N'; //북쪽
				shop[idx++] = 'N';
			}else {
				//동근의 위치
				dong_i =0;
				dong_j = dis;
			}
		
		}else if(dir==2) {
			if(who==0) {				
				block[row][dis] = 'S'; //남쪽
				shop[idx++] = 'S';
			}else {
				 //동근의 위치
				dong_i =row;
				dong_j = dis;
			}
		}else if(dir==3) {
			if(who ==0) {
				block[dis][0] = 'W'; //서쪽				
				shop[idx++] = 'W';
			}else {
				 //동근의 위치				
				dong_i =dis;
				dong_j = 0;
			}
		}else {
			if(who==0) {
				block[dis][col] = 'E';//동쪽				
				shop[idx++] = 'E';
			}else {				
				//동쪽				
				dong_i =dis;
				dong_j = col;
			}
		}
	}
}

