package step11_브루트포스;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class num_17626 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int nNum = Integer.parseInt(br.readLine());
		int cnt = check(nNum);
		System.out.println(cnt);
	}
	public static int check(int nNum) {
		if(Math.sqrt(nNum)%1==0) {//1로 나눠떨어지면
			return 1;
		}
		
		for(int i=1;i<Math.sqrt(nNum)+1;i++) {
			for(int j=i;j<Math.sqrt(nNum)+1;j++) {
				if(nNum==Math.pow(i, 2)+Math.pow(j, 2)) {
					return 2;
				}
			}
		}
		
		for(int i=1;i<Math.sqrt(nNum)+1;i++) {
			for(int j=i;j<Math.sqrt(nNum)+1;j++) {
				for(int k=j;k<Math.sqrt(nNum)+1;k++) {					
					if(nNum==Math.pow(i, 2)+Math.pow(j, 2)+Math.pow(k, 2)) {
						return 3;
					}
				}
			}
		}
		
		return 4;
	}

}
