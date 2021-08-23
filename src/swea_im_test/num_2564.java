package swea_im_test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class num_2564 {
	static char[][] block;
	static int idx = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(br.readLine());
		int col = Integer.parseInt(tk.nextToken());
		int row = Integer.parseInt(tk.nextToken());
		int nNum = Integer.parseInt(br.readLine());
		int[][] shop = new int[nNum][2];

		for (int i = 0; i < nNum; i++) {
			tk = new StringTokenizer(br.readLine());
			int dir = Integer.parseInt(tk.nextToken()); // 위치
			int dis = Integer.parseInt(tk.nextToken()); // 경계까지 거리
			shop[i][0] = dir;
			shop[i][1] = dis;
		}
		tk = new StringTokenizer(br.readLine());
		int dongen_dir = Integer.parseInt(tk.nextToken());
		int dongen_dis = Integer.parseInt(tk.nextToken());
		int sum = 0;
		for (int i = 0; i < nNum; i++) {
			int shop_dir = shop[i][0];
			int shop_dis = shop[i][1];
			int dist1 = 0;
			int dist2 = 0;
			int min = 0;
			if (dongen_dir == 1 && shop_dir == 2 || dongen_dir == 2 && shop_dir == 1) {// 반대방향,NS
				dist1 = shop_dis + dongen_dis + row; // 왼
				dist2 = (col - shop_dis) + row + (col - dongen_dis); // 오른쪽
				min = Math.min(dist1, dist2);
			} else if (dongen_dir == 3 && shop_dir == 4 || dongen_dir == 4 && shop_dir == 3) { // 반대방향 , EW
				dist1 = col + dongen_dis + shop_dis;
				dist2 = col + (row - dongen_dis) + (row - shop_dis);
				min = Math.min(dist1, dist2);
			} else if (dongen_dir == 1 || dongen_dir == 2) {
				if (dongen_dir == 1 && shop_dir == 3) { // 동: N, 샵 : W
					min = shop_dis + dongen_dis;
				} else if (dongen_dir == 1 && shop_dir == 4) { // 동 :N, 샵: E
					min = col - dongen_dis + shop_dis;
				} else if (dongen_dir == 2 && shop_dir == 3) { // 동: S, 샵:W
					min = dongen_dis + row - shop_dis;
				} else if (dongen_dir == 2 && shop_dir == 4) { // 동 :S, 샵: E
					min = col - dongen_dis + row - shop_dis;
				}
			} else if (dongen_dir == 3 || dongen_dir == 4) {
				if (dongen_dir == 4 && shop_dir == 1) { // 동:E, 샵: N
					min = col - shop_dis + dongen_dis;
				} else if (dongen_dir == 4 && shop_dir == 2) { // 동: E,샵: S
					min = row - dongen_dis + col - shop_dis;
				} else if (dongen_dir == 3 && shop_dir == 1) { // 동:W, 샵: N
					min = shop_dis + dongen_dis;
				} else if (dongen_dir == 3 && shop_dir == 2) { // 동:W, 샵:S
					min = shop_dis + row - dongen_dis;
				}
			}
			if (dongen_dir == shop_dir) {
				min = Math.abs(shop_dis - dongen_dis);
			}
			sum += min;
		}
		System.out.println(sum);
	}
}

//동근이와 반대방향 , 똑같음
// NS, 일때 //오 col-동근이 j 위치+,col-샵 j 위치 + row크기
// //왼 동근의 j 위치 +,샵 j위치+row
// EW row-동근이 i위치+row-샵i위치 +col크기
// 동근의 i위치+샵 i위치+col
// 바로 샵이 옆이라면, 가장 최단거리

//동근이 NS 일때 샵이 서쪽일때  N은  동근j위치+ 샵i위치;		
// 동쪽일때 N은 col-동근j위치 +샵i위치;
// 서쪽일때 S은 동근j위치+ row-샵i위치;
// 동쪽일때 S은 col-동근 j위치+ row-샵i위치;

//동근이 EW 일때  샵이 북쪽일때 W은 동근의i위치+샵으j위치
// 남쪽일때 W은 row -동근 i위치+동근j위치
// 북족일때 E 은 동근의 i위치+col-샵의 j위치
// 남쪽일 때 E 동근의 row-위치+col-샵의j위치

// 위에서 조건을 줄 때 row,col만 바꿔서 주면 될 듯.
// 아래 위치를 선정하는걸 위에서 직접 받아서 바로 함수로 보내줘서 비교하면 될 듯.
// 샵의 위치 i,j정보는 하나의배열로 String으로 넣어놓으면 될 듯. [0][위치],[row][위치]
