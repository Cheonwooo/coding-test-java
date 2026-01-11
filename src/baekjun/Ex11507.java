package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Ex11507 {
	
	private static int[][] cards;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String S = br.readLine();
		cards = new int[4][14];
		
		int[] cardCount= new int[4];
		Arrays.fill(cardCount, 13);
		for (int i = 0; i < S.length(); i += 3) {
			String cardShape = S.substring(i, i+1);
			int cardNumber = Integer.parseInt(S.substring(i+1, i+3));
			
			int cardShapeNumber = transCardsShapeToNumber(cardShape);
			
			if (cards[cardShapeNumber][cardNumber] != 0) {
				System.out.println("GRESKA");
				return;
			} else {
				cards[cardShapeNumber][cardNumber]++;
				cardCount[cardShapeNumber]--;
			}
		}
		
		for (int answer : cardCount) {
			System.out.print(answer + " ");
		}
	}

	private static int transCardsShapeToNumber(String shape) {
		if (shape.equals("P")) {
			return 0;
		} else if (shape.equals("K")) {
			return 1;
		} else if (shape.equals("H")) {
			return 2;
		}else {
			return 3;
		}
	}
}
