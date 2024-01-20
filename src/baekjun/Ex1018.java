package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 아이디어 : 주어진 배열을 8x8로 자르기
 * 자른 배열에서 B 또는 W가 연속으로 나타나는 구간(오,아) 찾고, 색을 바꾸기 -> X
 * 처음부터 정답지 2개를 만들어놓고 8x8로 자른 체스판과 비교하자
 * 
 * 시간복잡도 : 42 * 42 * 64
 * 
 * 자료구조 : String[][]
 */

public class Ex1018 {
	private static int n, m;
	private static String[][] chess, chessWhite, chessBlack;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		chess = new String[n][m];
		chessWhite = new String[n][m];
		chessBlack = new String[n][m];
		
		for (int i = 0; i < n; i++) {
			String[] color = br.readLine().split("");
			for (int j = 0; j < m; j++) {
				chess [i][j] = color[j];
			}
		}
		
		makeAnswer();
		
		int min = Integer.MAX_VALUE;
		for (int i = 0; i <= n-8; i++) {
			for (int j = 0; j <= m-8; j++) {
				min = Math.min(min, compareWithAnswer(i, j));
			}
		}
		System.out.println(min);
	}
	
	private static void makeAnswer() {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (i%2 == 0 && j%2 == 0) {
					chessWhite[i][j] = "W";
					chessBlack[i][j] = "B";
				} else if (i%2 != 0 && j%2 != 0) {
					chessWhite[i][j] = "W";
					chessBlack[i][j] = "B";
				} else {
					chessWhite[i][j] = "B";
					chessBlack[i][j] = "W";
				}
			}
		}
	}
	
	private static int compareWithAnswer(int x, int y) {
		int countWhite = 0;
		for (int i = x; i < x+8; i++) {
			for (int j = y; j < y+8; j++) {
				if (!chess[i][j].equals(chessWhite[i-x][j-y])) {
					countWhite++;
				}
			}
		}
		
		int countBlack = 0;
		for (int i = x; i < x+8; i++) {
			for (int j = y; j < y+8; j++) {
				if (!chess[i][j].equals(chessBlack[i-x][j-y])) {
					countBlack++;
				}
			}
		}
		return Math.min(countWhite, countBlack);
	}
}
