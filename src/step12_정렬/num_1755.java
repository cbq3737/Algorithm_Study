package step12_정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class num_1755 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int[] alpha = new int[] { 9, 4, 8, 7, 2, 1, 6, 5, 0, 3 }; // 알파벳에 따른 우선순위
		int mNum = Integer.parseInt(tk.nextToken());
		int nNum = Integer.parseInt(tk.nextToken());
		List<Integer> arr = new ArrayList<>();// 입력받을 리스트
		List<Integer> list = new ArrayList<>();// 새로운 리스트 만들기

		for (int i = mNum; i <= nNum; i++) { // 범위 값 배열에 넣어주기
			arr.add(i);
		}
		int temp = 0;
		int idx = 0;
		// 1~99까지, 즉 10보다 크면 10의자리수 확인 후, 10의자리 동일하다면 1의 자리 판단
		while (!arr.isEmpty()) { // 리스트 빌 때까지
			int num = arr.get(0);
			temp = num;
			idx = 0;
			for (int j = 0; j < arr.size(); j++) {
				int num2 = arr.get(j);
				if (temp >= 10 && num2 >= 10) { // num1이 10보다 크고, num2도 10보다 크다면
					if (alpha[temp / 10] > alpha[num2 / 10]) { // 우선 순위가 크다면
						temp = num2; // 값 갱신
						idx = j;
					} else if (temp / 10 == num2 / 10 && alpha[temp % 10] > alpha[num2 % 10]) {// 10의 자리가 동일하다면 1의자리를 비교
						temp = num2;
						idx = j;
					}
				} else if (temp < 10 && num2 >= 10) { // num1이 10보다 작고, num2가 10보다 크다면
					if(temp==num2/10) { //10의 자리숫자가 동일?
						continue;
					}else if(alpha[temp]>alpha[num2/10]) {
						temp = num2;
						idx = j;	
					}
				} else {// 둘 다 10보다 작다면
					if (alpha[temp] > alpha[num2]) {
						temp = num2;
						idx = j;
					}
				}
			}
			list.add(temp); // 우선순위가 제일 작은 애가 list에 추가
			arr.remove(idx); // list 빠진 해당 인덱스 제거
		}

		int cnt = 0;
		for (int i = 0; i < list.size(); i++) {
			cnt++;
			sb.append(list.get(i) + " ");
			if (cnt % 10 == 0) {
				sb.append("\n");
				cnt = 0;
			}
		}
		System.out.println(sb);
	}
}
