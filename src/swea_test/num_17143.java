package swea_test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class num_17143 {
	public static class shark {
		int i;
		int j;
		int s;// 속력
		int d;// 이동방향
		int z;// 크기

		public shark(int i, int j, int s, int d, int z) {
			this.i = i;
			this.j = j;
			this.s = s;
			this.d = d;
			this.z = z;
		}
	}

	public static int[][] deltas = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };// 상,하,우,좌
	public static List<shark> list = new ArrayList<>();
	public static int rNum;
	public static int cNum;
	public static int sum;
	public static shark[][] new_map ;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(br.readLine());
		rNum = Integer.parseInt(tk.nextToken());
		cNum = Integer.parseInt(tk.nextToken());
		int mNum = Integer.parseInt(tk.nextToken());
		new_map = new shark[rNum][cNum];
		for (int i = 0; i < mNum; i++) {
			tk = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(tk.nextToken());
			int c = Integer.parseInt(tk.nextToken());
			int s = Integer.parseInt(tk.nextToken());
			int d = Integer.parseInt(tk.nextToken());
			int z = Integer.parseInt(tk.nextToken());
			list.add(new shark(r - 1, c - 1, s, d - 1, z));
		}
		int king_j = -1;
		while (king_j != cNum - 1) {
			// 오른쪽 한칸 이동
			king_j++;
			// 낚시왕 열 중 땅과 제일 가까운 상어 잡기
			catch_shark(king_j);
			// 상어의 이동 - 단 이동을 마친 후 두마리가 존재할 때 큰 상어가 작은 상어 먹음
			move_shark();
		}
		System.out.println(sum);
	}

	public static void catch_shark(int king_j) {
		int idx = -1;
		int min_i = Integer.MAX_VALUE;
		int size = list.size();
		for (int i = 0; i < size; i++) {
			shark sk = list.get(i);
			if (king_j == sk.j) {// 낚시왕과 같은 열이라면
				if (min_i > sk.i) {// 제일 땅과 가까운 애
					min_i = sk.i;
					idx = i;
				}
			}
		}
		if(!list.isEmpty()&&idx!=-1) { //리스트에 지워줄게 있고 낚시왕이 잡을게 잇을 때만
			sum += list.get(idx).z;			
			list.remove(idx);// 제일 가까운 상어 제거
		}
	}

	public static void move_shark() {
		// 이동하고 난 후 맵
		int size = list.size();
		for (int i = 0; i < size; i++) {
			shark sk = list.get(i);
			int r = sk.i;
			int c = sk.j;// 상어 위치
			if (sk.s != 0) {
				for (int j = 0; j < sk.s; j++) {// 속력만큼 이동
					r += deltas[sk.d][0];
					c += deltas[sk.d][1];
					if (r < 0 || c < 0 || r >= new_map.length || c >= new_map[r].length) {// 끝에 다 다랏다면
						// 상어 자체의 방향을 바꿔준다. 상<->하 0<->1, 우<->좌 2<->3
						if (sk.d == 0) {
							sk.d = 1;
						} else if (sk.d == 1) {
							sk.d = 0;
						} else if (sk.d == 2) {
							sk.d = 3;
						} else if (sk.d == 3) {
							sk.d = 2;
						}
						r += deltas[sk.d][0];
						c += deltas[sk.d][1];
						j--;
					}
				}
			}
			// 새롭게 이동한 위치에 크기 저장
			if (new_map[r][c] == null) {// 새로운 위치에 아무것도 없다면
				new_map[r][c] = sk;// 위치 할당
			} else {// 새로운 위치에 뭔가 있다 = 두마리 이상
					// i, new_map[r][c]-> 인덱스가 저장
				if (sk.z > new_map[r][c].z) {// 새로운 애가 크다
					new_map[r][c] = sk;
				}
			}
		}
		list.clear();//리스트 초기화
		for (int i = 0; i < rNum; i++) {
			for (int j = 0; j < cNum; j++) {
				if (new_map[i][j] != null) {
					shark sk = new_map[i][j];//기존 있던 객체
					list.add(new shark(i,j,sk.s,sk.d,sk.z));//새로운 정보 갱신
					new_map[i][j] = null; //다시 초기화 
				}
			}
		}
	}
}
