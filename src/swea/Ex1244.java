package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex1244 {
	private static int max;
	private static String[] numbers;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(br.readLine());
		
		for (int T = 1; T <= t; T++) {
			sb.append("#").append(T).append(" ");
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			numbers = st.nextToken().split("");
			int changeCount = Integer.parseInt(st.nextToken());
			
			if (numbers.length < changeCount) {
				changeCount = numbers.length;
			}
			
			max = Integer.MIN_VALUE;
			dfs(0, changeCount, 0);
			
			sb.append(max).append("\n");
		}
		System.out.println(sb);
	}
	
	public static void dfs(int start, int changeCount, int depth) {
		if (depth == changeCount) {
			String answer = "";
			for (String val : numbers) {
				answer += val;
			}
			max = Math.max(max, Integer.parseInt(answer));
			return;
		}
		
		for (int i = start; i <numbers.length; i++) {
			for (int j = i+1; j < numbers.length; j++) {
				swap(numbers, i, j);
				dfs(i, changeCount, depth+1);
				swap(numbers, j, i);
			}
		}
	}
	
	public static void swap(String[] numbers, int index1, int index2) {
		String temp = numbers[index1];
		numbers[index1] = numbers[index2];
		numbers[index2] = temp;
	}

}
