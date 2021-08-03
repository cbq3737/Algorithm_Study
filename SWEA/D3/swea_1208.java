
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//D3
public class swea_1208 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for(int tc=0;tc<10;tc++) {
			int dump = Integer.parseInt(br.readLine());
			StringTokenizer tk = new StringTokenizer(br.readLine());
			int[] arr = new int[100];
			
			int min = Integer.MAX_VALUE;
			int min_index = 0;
			int max = Integer.MIN_VALUE;
			int max_index = 0;
			for(int i=0;i<arr.length;i++) {
				arr[i]= Integer.parseInt(tk.nextToken());
				if(min>arr[i]) {
					min = Math.min(arr[i], min); //min_index를 잡기위함.
					min_index = i;
				}
				if(max<arr[i]) {
					max = Math.max(arr[i], max);
					max_index = i;
				}
			}
			while(dump>0) {
				//dump
				if(arr[max_index]!= arr[min_index] && (arr[max_index]-arr[min_index])>1 ) {					
					arr[max_index]=arr[max_index]-1;
					arr[min_index]=arr[min_index]+1;//덤프해주고
					for(int j=0;j<arr.length;j++) {
						if(arr[min_index]>arr[j]) { //바뀐 값으로 최솟값 비교
							min_index = j; //j가 더 작다면 최솟값
						}
						if(arr[max_index]<arr[j]) {
							max_index = j;
						}
					}
					
				}else {		
					break;
				}
				dump--;
			}
			int sub = arr[max_index]- arr[min_index];
			sb.append("#"+(tc+1)+" "+sub+"\n");
		}
		System.out.println(sb);
	}
}
