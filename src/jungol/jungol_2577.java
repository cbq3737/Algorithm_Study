package jungol;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class jungol_2577 {// 슬라이딩 윈도우, 투포인터
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int nNum = Integer.parseInt(tk.nextToken());// 접시의 수
		int dNum = Integer.parseInt(tk.nextToken());// 초밥의 가짓수
		int kNum = Integer.parseInt(tk.nextToken());// 연속해서먹는 갯수
		int cNum = Integer.parseInt(tk.nextToken());// 쿠폰 번호

		int[] cnt_arr = new int[dNum];// 초밥카운트
		int[] dish = new int[nNum];

		for (int i = 0; i < nNum; i++) {
			dish[i] = Integer.parseInt(br.readLine());
		}

		int max = Integer.MIN_VALUE;
		int cnt = 0;//종류갯수
		for (int j = 0; j < kNum; j++) {// 제일 먼저 4개씩 담기
			if (cnt_arr[dish[j % nNum] - 1] == 0) {// 이 초밥종류 아직 안먹었다면
				cnt++;//종류
			}
			cnt_arr[dish[j % nNum] - 1] += 1;//우선먹었다고 표시
		}
		
		//현재 4개 이미 먹음.
		for (int i = 1; i < dish.length; i++) { // 접시
			cnt_arr[dish[(i-1)%nNum]-1]-=1;//맨앞꺼 빼주고
			if(cnt_arr[dish[(i-1)%nNum]-1]==0) {//걔 갯수가 0되버리면 빼줘야한다.
				cnt--; //0되면 안먹은거나 다름없으니까 빼준다.
			}			
			if(cnt_arr[dish[(i+kNum-1)%nNum]-1]==0) {//다음 4번째꺼 안먹었으면 메뉴하나 증가
				cnt++;//새로운거 먹었으니까 종류+1
			}
			cnt_arr[dish[(i+kNum-1)%nNum]-1]+=1;//어차피 먹었으니 먹은 갯수 표시
			if(cnt_arr[cNum-1]==0) {//쿠폰용 먹었니??
				max = Math.max(max, cnt+1);//안먹었으면 쿠폰+1포함해서 출력
			}else {
				max = Math.max(max, cnt);
			}
		}
		sb.append(max);
		System.out.println(sb);
	}
}
