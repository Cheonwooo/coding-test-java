package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 아이디어
 * N명중 N/2명 고르기
 * (N/2)C2의 모든 경우의 수를 구하고 합 구하기
 */

public class Ex14889 {
	private static int totalSum = 0, min = Integer.MAX_VALUE;
	private static int[] teamA, teamB;
	private static int[][] arr;
	private static boolean[] visitedForPlayer;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				totalSum += arr[i][j];
			}
		}
		
		teamA = new int[n/2];
		teamB = new int[n/2];
		visitedForPlayer = new boolean[n];
		comb(0, n, n/2, 0);
		
		System.out.println(min);
	}

	public static void comb(int start, int n, int r, int depth) {
		if (depth == r) {
			int index = 0;
			for (int i = 0; i < visitedForPlayer.length; i++) {
				if (!visitedForPlayer[i]) {
					teamB[index] = i;
					index++;
				}
			}
			
			int sumA = calculateSum(teamA);
			int sumB = calculateSum(teamB);
			
			min = Math.min(min, (int)Math.abs(sumA-sumB));
			return;
		}
		
		for (int i = start; i < n; i++) {
			if (!visitedForPlayer[i]) {
				visitedForPlayer[i] = true;
				teamA[depth] = i;
				comb(i+1, n, r, depth+1);
				visitedForPlayer[i] = false;
			}
		}
	}
	
	public static int calculateSum(int[] players) {
		int sum = 0;
		for (int i = 0; i < players.length-1; i++) {
			for (int j = i+1; j < players.length; j++) {
				sum += arr[players[i]][players[j]];
				sum += arr[players[j]][players[i]];
			}
		}
		return sum;
	}
}
