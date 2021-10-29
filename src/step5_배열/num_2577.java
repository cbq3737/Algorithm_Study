package step5_배열;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class num_2577 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int aNum = Integer.parseInt(br.readLine()); 
		int bNum = Integer.parseInt(br.readLine());
		int cNum = Integer.parseInt(br.readLine());
		int mul = aNum*bNum*cNum;
		String strMul = String.valueOf(mul);
		int num_0=0;int num_1=0;int num_2=0;int num_3=0;int num_4=0;
		int num_5=0;int num_6=0;int num_7=0;int num_8=0;int num_9=0;
		for(int i=0;i<strMul.length();i++) {
			int num = Character.getNumericValue(strMul.charAt(i));
			switch(num) {
				case 0:
					num_0+=1;
					break;
				case 1:
					num_1+=1;
					break;
				case 2:
					num_2+=1;
					break;
				case 3:
					num_3+=1;
					break;
				case 4:
					num_4+=1;
					break;
				case 5:
					num_5+=1;
					break;
				case 6:
					num_6+=1;
					break;
				case 7:
					num_7+=1;
					break;
				case 8:
					num_8+=1;
					break;
				case 9:
					num_9+=1;
					break;
				default:
					break;
			}
		}
		bw.write(num_0+"\n"+num_1+"\n"+num_2+"\n"+num_3+"\n"+num_4+
				"\n"+num_5+"\n"+num_6+"\n"+num_7+"\n"+num_8+"\n"+num_9+"\n");
		br.close();
		bw.flush();
		bw.close();
	}
}
