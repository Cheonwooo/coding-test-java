package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex1209 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for (int t = 1; t <= 10; t++) {
			int T = Integer.parseInt(br.readLine());
			sb.append("#" + t + " ");
			
			int[][] arr = new int[100][100];
			for (int i = 0; i < 100; i++) {
				
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 100; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int max = Integer.MIN_VALUE;
			int rowSum = 0;
			int colSum = 0;
			//가로합
			//세로합
			for (int i = 0; i < 100; i++) {
				rowSum = 0;
				colSum = 0;
				for (int j = 0; j < 100; j++) {
					rowSum += arr[i][j];
					colSum += arr[j][i];
				}
				max = Math.max(max, Math.max(colSum, rowSum));
			}
			
			//우하합
			//좌상합
			int rightDownSum = 0;
			int leftUpSum = 0;
			for (int i = 0; i < 100; i++) {
				rightDownSum += arr[i][i];
				leftUpSum += arr[i][arr.length-1-i];
			}
			max = Math.max(max, Math.max(rightDownSum, leftUpSum));
			
			sb.append(max).append("\n");
		}
		System.out.println(sb);
		
	}

}
