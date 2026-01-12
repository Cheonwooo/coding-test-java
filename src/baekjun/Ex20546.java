package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex20546 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int money = Integer.parseInt(br.readLine());
		
		int[] stock = new int[14];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 14; i++) {
			stock[i] =Integer.parseInt(st.nextToken());
		}
		
		int j = bnp(money, stock);
		int s = timing(money, stock);
		
		if (j > s) {
			System.out.println("BNP");
		} else if (j < s) {
			System.out.println("TIMING");
		} else {
			System.out.println("SAMESAME");
		}
	}
	
	private static int bnp(int money, int[] stock) {
		int profit = 0;
		int stockCount = 0;
		for (int i = 0; i < 14; i++) {
			if (money / stock[i] != 0) {
				int quo = money / stock[i];
				if (quo > 0) {
					stockCount += quo;
					money -= quo * stock[i];
				}
			}
		}
		return profit += money + stockCount * stock[13];
	}

	private static int timing(int money, int[] stock) {
		int profit = 0;
		int stockCount = 0;
		
		int upCount = 0;
		int downCount = 0;
		
		int standardStockPrice = stock[0];
		for (int i = 1; i < 14; i++) {
			if (standardStockPrice < stock[i]) {
				upCount++;
				downCount = 0;
			} else if (standardStockPrice > stock[i]) {
				upCount = 0;
				downCount++;
			}
			standardStockPrice = stock[i];
			
			if (upCount == 3) {
				profit += stockCount * stock[i];
				stockCount = 0;
				upCount--;
			} else if (downCount == 3) {
				int quo = money / stock[i];
				if (quo > 0) {
					stockCount += quo;
					money -= quo * stock[i];
				}
				downCount--;
			}
		}
		return profit += money + stockCount * stock[13];
	}
}
