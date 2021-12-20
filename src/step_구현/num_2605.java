package step_구현;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
	//ArrayList를 이용한 조작문제
public class num_2605 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int nNum =Integer.parseInt(br.readLine());
		List<Integer> student = new ArrayList<>(); 
		StringBuilder sb= new StringBuilder();
		int[] number = new int[nNum];
		StringTokenizer tk = new StringTokenizer(br.readLine());
		for(int i=0;i<nNum;i++) {
			number[i] = Integer.parseInt(tk.nextToken());
			student.add((student.size()-number[i]),i+1);
		}
		for(int i=0;i<student.size();i++) {
			sb.append(student.get(i)+" ");
		}
		System.out.println(sb);
	}
}
