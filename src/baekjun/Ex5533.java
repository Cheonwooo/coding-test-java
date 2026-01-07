package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex5533 {
	
	private static int n;
	private static int[][] players;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		n = Integer.parseInt(br.readLine());
		players = new int[n][3];
		
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			players[i][0] = a;
			players[i][1] = b;
			players[i][2] = c;
		}
		
		for (int i = 0; i < n; i++) {
			int score = 0;
			for (int j = 0; j < 3; j++) {
				if (checkDuplication(i, j, players[i][j])) {
					score += players[i][j];
				}
			}
			sb.append(score + "\n");
		}
		System.out.println(sb);
	}

	private static boolean checkDuplication(int playerSeq, int scoreSeq, int score) {
		for (int i = 0; i < n; i++) {
			if (playerSeq == i) continue;
			
			if (score == players[i][scoreSeq]) return false;
		}
		return true;
	}
}
