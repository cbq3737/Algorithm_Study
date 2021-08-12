import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class swea_6808 {
	public static int kyu_win;
	public static int kyu_lose;
	public static void check_point(int[] kyu,int[] in,int cnt,int kyu_point,int in_point) {
		if(cnt==9) {
			if(kyu_point<in_point) { //규영이가 짐
				kyu_lose++;
			}else if(kyu_point>in_point) { //규영이가 이김
				kyu_win++;
			}//무승부는 점수를 안줌.
			return;
		}
		
		if(kyu[cnt]>in[cnt]) { //규영이가 이김
			kyu_point+= kyu[cnt]+in[cnt];
		}else if(kyu[cnt]<in[cnt]){
			in_point+= kyu[cnt]+in[cnt];//인영이가 이김
		}
		
		check_point(kyu, in, cnt+1,kyu_point,in_point);
	}
	public static void makePermutation(int[] kyu,int[] in,int isSelected,int[] selected,boolean[] visited) {
		if(isSelected == 9) {
			check_point(kyu,selected,0,0,0);	//순열로 만들어진 인영의 새로운 배열을 보내줌.
			return;
		}
		for(int i=0;i<9;i++) {
			if(!visited[i]) {
				selected[isSelected] = in[i];
				visited[i] = true;
				makePermutation(kyu, in, isSelected+1, selected, visited);
				visited[i] = false;
			}
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc =Integer.parseInt(br.readLine());
		StringBuilder sb= new StringBuilder();
		for(int t= 0;t<tc;t++) {
			int[] kyu = new int[9];
			int[] in = new int[9];
			StringTokenizer tk = new StringTokenizer(br.readLine());
			for(int i=0;i<kyu.length;i++) {
				int num = Integer.parseInt(tk.nextToken()); 
				kyu[i] = num;
			}
			int idx =0;
			for(int i=1;i<=18;i++) {
				boolean flag = false;
				for(int j=0;j<kyu.length;j++) {
					if(kyu[j]==i) {
						flag= true;
					}
				}
				if(!flag) {
					in[idx++] = i;
				}
			}
			kyu_win =0;
			kyu_lose =0;
			makePermutation(kyu,in,0,new int[9],new boolean[9]);
			sb.append("#"+(t+1)+" "+kyu_win+" "+kyu_lose+"\n");
		}
		System.out.println(sb);
	}
}
