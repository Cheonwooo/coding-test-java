package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex3448 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			int blank = 0;
			int total = 0;
			while (true) {
				String input = br.readLine();
				if (input.equals("")) break;
				
				char[] sentence = input.toCharArray();
				
				for (int i = 0; i < sentence.length; i++) {
					if (sentence[i] == '#') {
						blank++;
					}
					total++;
				}
			}
			
			double recogRatio = (double)(total - blank) / total * 100;
			recogRatio = Math.round(recogRatio * 10) / 10.0;
			if (total != 0) {
				if (recogRatio == (int)recogRatio) {
					System.out.printf("Efficiency ratio is " + (int)recogRatio);
					System.out.println("%.");
				} else {
					System.out.printf("Efficiency ratio is " + recogRatio);
					System.out.println("%.");
				}
			}
		}
		
	}

}
