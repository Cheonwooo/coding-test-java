package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex1058 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] answer = new int[n];
		char[][] arr = new char[n][n];
		
		for (int i = 0; i < n; i++) {
			arr[i] = br.readLine().toCharArray();
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0 ; j < n; j++) {
				if (i == j) continue;
				if (arr[i][j] == 'Y') {
					answer[j]++;
				} else {//arr[i][j] == 'N'
					for (int k = 0; k < n; k++) {
						if (arr[i][k] == 'Y' && arr[j][k] == 'Y') {
							answer[j]++;
							break;
						}
					}
				}
			}
		}
		
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			max = Math.max(max, answer[i]);
		}
		System.out.println(max);
	}

}
