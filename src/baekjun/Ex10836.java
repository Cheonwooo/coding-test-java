package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex10836 {
	
	private static int m, index;
	private static int[] firstCol, firstRow;
	private static int[][] bee;
    private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		bee = new int[m][m];
		firstCol = new int[m];
		firstRow = new int[m-1];
		
		for (int i = 0; i < n; i++) {
			int[] growSpeed = new int[3];
			
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				growSpeed[j] = Integer.parseInt(st.nextToken());
			}
			
			index = 0;
			//맨 앞 열 저장
			saveFirstCol(growSpeed);
			//맨 앞 행 저장
			saveFirstRow(growSpeed);
		}
		growLarva();
		printAnswer();
	}
	
	private static void saveFirstCol(int[] growSpeed) {
		for (int j = 0; j < m; j++) {
			while (growSpeed[index] == 0) index++;
			if (growSpeed[index] != 0) {
				firstCol[j] += index;
				growSpeed[index]--;
			}
		}
	}
	
	private static void saveFirstRow(int[] growSpeed) {
		for (int j = 0; j < m-1; j++) {
			while (growSpeed[index] == 0) index++;
			if (growSpeed[index] != 0) {
				firstRow[j] += index;
				growSpeed[index]--;
			}
		}
	}
	
	private static void growLarva() {
		for (int i = 0; i < m; i++) {
			//맨 앞 열 채우기
			bee[m - 1 - i][0] += firstCol[i] + 1;
			//나머지 행/열 채우기
			for (int j = 1; j < m; j++) {
				bee[i][j] += firstRow[j-1] + 1;
			}
		}
	}
	
	private static void printAnswer() {
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < m; j++) {
				sb.append(bee[i][j] + " ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
