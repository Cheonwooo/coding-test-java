package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex33560 {
	
	private static int score, time, addScore, addTime;
	private static int[] answer;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		answer = new int[4];
		
		int n = Integer.parseInt(br.readLine());

		score = 0;
		time = 0;
		addScore = 1;
		addTime = 4;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			if (time> 240) {
				gameOver();
			}
			
			int dice = Integer.parseInt(st.nextToken());;

			if (dice == 1) {
				gameOver();
				continue;
			} else if (dice == 2) {
				if (addScore == 1) {
					addTime += 2;
				} else if (addScore > 1){
					addScore /= 2;
				}
			}else if (dice == 4) {
				time += 56;
			} else if (dice == 5) {
				if (addTime > 1) {
					addTime -= 1;
				}
			} else if (dice == 6){
				if (addScore < 32) {
					addScore *= 2;
				}
			}
			score += addScore;
			time += addTime;
		}
		
		for (int i = 0; i < 4; i++) {
			System.out.println(answer[i]);
		}
	}
	
	private static void gameOver() {	
		int finalScore = score;
		score = 0;
		time = 0;
		addScore = 1;
		addTime = 4;
		
		if (finalScore >= 35 && finalScore < 65) answer[0]++;
		else if (finalScore >= 65 && finalScore < 95) answer[1]++;
		else if (finalScore >= 95 && finalScore < 125) answer[2]++;
		else if (finalScore >= 125) answer[3]++;
		
	}

}
