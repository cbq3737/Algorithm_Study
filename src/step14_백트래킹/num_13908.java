package step14_백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class num_13908 {// 비밀번호
	public static int[] number;
	public static int cnt;
	public static int mNum;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(br.readLine());
		int nNum = Integer.parseInt(tk.nextToken());// 순열길이
		mNum = Integer.parseInt(tk.nextToken());// 들어가는 수 갯수
		number = new int[mNum];
		if (mNum > 0) {
			tk = new StringTokenizer(br.readLine());
			for (int i = 0; i < mNum; i++) {
				number[i] = Integer.parseInt(tk.nextToken());// 비밀번호 특정 숫자
			}
		}
		cnt = 0;
		// 중복순열조합으로 길이만큼 만들기
		makePermutation(0, new int[nNum]);
		System.out.println(cnt);
	}

	public static void makePermutation(int isSelect, int[] select) {
		if (isSelect == select.length) {// 중복순열이 완성되었다면
			if (mNum>0&&isCheck(select)) { // 해당 수가 들어가는지 체킹
				// 체크가 맞다면 +1
				cnt++;
			}else if(mNum==0){//0일경우를 체크해줬어야한다.0이면 아무것도 모르므로 
				cnt++;
			}
			return;
		}

		for (int i = 0; i <= 9; i++) {
			select[isSelect] = i;
			makePermutation(isSelect + 1, select);
		}
	}

	public static boolean isCheck(int[] select) {
		for (int i = 0; i < number.length; i++) {
			int num = number[i];
			boolean flag = false;
			for (int j = 0; j < select.length; j++) {
				if (select[j] == num) {// 값이 존재한다면
					flag = true;
				}
			}
			if (!flag) {
				return false;
			}
		}
		return true;
	}
}

