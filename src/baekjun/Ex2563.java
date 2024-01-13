package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 아이디어 : 좌변과 아랫변 제외한 모든 점을 true
 * 
 * 시간복잡도 : 1
 * 
 * 자료구조 : boolean[]
 */

public class Ex2563 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		boolean[][] arr = new boolean[101][101];
		
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int left = Integer.parseInt(st.nextToken());
			int bottom = Integer.parseInt(st.nextToken());
			
			arr = changeArr(arr, left, bottom);
		}
		
		int answer = calculateArea(arr);
		System.out.println(answer);
		
	}
	
	private static boolean[][] changeArr(boolean[][] arr, int left, int bottom) {
		
		for (int i = left+1; i <= left+10; i++) {
			for (int j = bottom+1; j <= bottom+10; j++) {
				arr[i][j] = true;
			}
		}
		return arr;
	}
	
	private static int calculateArea(boolean[][] arr) {
		int answer = 0;
		for (int i = 0; i < 101; i++) {
			for (int j = 0; j < 101; j++) {
				if(arr[i][j]) answer++;
			}
		}
		return answer;
	}
}
