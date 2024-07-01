package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex1961 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			sb.append("#" + (t+1) + " ").append("\n");
			
			int n = Integer.parseInt(br.readLine());
			int[][] arr = new int[n][n];
			int[][] rotateArr = new int[n][n];
			String[][] answer = new String[n][3];
			
			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int index = 0;
			for (int i = 0 ; i < 3; i++) {
				rotate90(arr, rotateArr, n);
				
				for (int j = 0; j < n; j++) {
					for (int k = 0; k < n; k++) {
						arr[j][k] = rotateArr[j][k];
					}
				}
				
				
				for (int j = 0; j < n; j++) {
					String str = "";
					for (int k = 0; k < n; k++) {
						str += String.valueOf(rotateArr[j][k]);
					}
					answer[j][index] = str;
				}
				index++;
			}
			
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < 3; j++) {
					sb.append(answer[i][j] + " ");
				}
				sb.append("\n");
			}
		}
		System.out.println(sb);
	}
	
	public static int[][] rotate90(int[][] arr, int[][] rotateArr, int n) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				rotateArr[i][j] = arr[n-1-j][i];
			}
		}
		return rotateArr;
	}
}
