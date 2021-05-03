package step13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class num_9663 {
	public static int nNum;
	public static int[] arr;
	public static int count =0;
	public static void nQueen(int depth) {
		if(depth==nNum) {
			count++;
			return;
		}
		for(int i=0;i<nNum;i++) {
			arr[depth] = i; //몇번째 열의 어디 위치인지
			if(Promising(depth)) {//놓을수 있는 위치일 경우
				nQueen(depth+1);
			}
		}
	}
	public static boolean Promising(int depth) { //인자로 인덱스번호가 들어옴
		for(int i=0;i<depth;i++) {
			if(arr[depth] == arr[i]) { //같은 열
				return false;
			}
			else if(Math.abs(depth-i)==Math.abs(arr[depth]-arr[i])) { //대각선에 위치
				return false;
			}
		}
		return true;
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			nNum = Integer.parseInt(br.readLine());
			arr = new int[nNum];
			nQueen(0);
			System.out.println(count);
	}	
}
