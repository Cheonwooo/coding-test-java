package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex20922 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] arr = new int[n];
		int[] visited = new int[100_001];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int left = 0;
		int right = 0;
		int answer = 0;
		int max = 0;
		while (left <= right) {
			if (right == n) break;
			
			if (visited[arr[right]] + 1 <= k) {
				visited[arr[right]]++;
				right++;
				answer++;
				max = Math.max(answer, max);
			} else {
				visited[arr[left]]--;
				left++;
				answer--;
			}
		}
		System.out.println(max);
	}
}
//1 2 6 4 5 3 6 7 8 9 6 1