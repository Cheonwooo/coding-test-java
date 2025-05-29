package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex11403 {
	
	private static final int INF = (int)1e9;
	private static int n;
	private static int[][] map;

	public static void main(String[] args) throws IOException{
		inputValues();
		
		floyd();
		
		printAnswer();
	}
	
	private static void inputValues() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		map = new int[n+1][n+1];
		
		makeMap(br);
	}
	
	private static void makeMap(BufferedReader br) throws IOException{
		for (int i = 0; i < n+1; i++) {
			for (int j = 0; j < n+1; j++) {
				map[i][j] = INF;
			}
		}
		
		for (int i = 1; i < n+1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j < n+1; j++) {
				if (Integer.parseInt(st.nextToken()) == 1) {
					map[i][j] = 1;
				}
			}
		}
	}
	
	private static void floyd() {
		for (int k = 1; k < n+1; k++) {
			for (int i = 1; i < n+1; i++) {
				for (int j = 1; j < n+1; j++) {
					map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
				}
			}
		}
	}
	
	private static void printAnswer() {
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < n+1; i++) {
			for (int j = 1; j < n+1; j++) {
				if (map[i][j] != INF) sb.append(1 + " ");
				else sb.append(0 + " ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
