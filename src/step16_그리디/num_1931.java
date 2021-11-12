package step15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Team implements Comparable<Team> {
	private int start;
	private int end;

	public Team(int start, int end) {
		this.start = start;
		this.end = end;
	}

	public int getStart() {
		return start;
	}

	public int getEnd() {
		return end;
	}

	@Override
	public int compareTo(Team o) {
		if(this.end==o.end) {
			return this.start - o.start;
		}
		return this.end - o.end;
	}
}

public class num_1931 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int nNum = Integer.parseInt(br.readLine());
		Team[] team = new Team[nNum];
		for (int i = 0; i < nNum; i++) {
			StringTokenizer tk = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(tk.nextToken());
			int end = Integer.parseInt(tk.nextToken());
			team[i] = new Team(start, end);
		}
		Arrays.sort(team); // 종료시간 기준 정렬
		int count = 0;
		int end_time = 0;
		for (int i = 0; i< nNum; i++) {
			if(end_time <=team[i].getStart()) {// 개 삽질 거꾸로
				end_time= team[i].getEnd();
				count++;
			}
		}
		
		System.out.println(count);
	}
}
