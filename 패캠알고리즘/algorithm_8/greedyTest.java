package step15;

public class greedyTest {

	public static void main(String[] args) {
		int[] coins = {500,100,50,10};
		int price = 8370;
		int count = 0;
		
		for(int i=0;i<coins.length;i++) {
			count += price/ coins[i];
			price = price % coins[i];
			System.out.println(coins[i]+"짜리 동전"+count+"가 필요");
			count=0;
		}
	}
}
