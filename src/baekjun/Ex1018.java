package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * ���̵�� : �־��� �迭�� 8x8�� �ڸ���
 * �ڸ� �迭���� B �Ǵ� W�� �������� ��Ÿ���� ����(��,��) ã��, ���� �ٲٱ� -> X
 * ó������ ������ 2���� �������� 8x8�� �ڸ� ü���ǰ� ������
 * 
 * �ð����⵵ : 42 * 42 * 64
 * 
 * �ڷᱸ�� : String[][]
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
