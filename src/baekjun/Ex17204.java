package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex17204 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[n];
		
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		boolean[] visited = new boolean[n];
		visited[0] = true;
		int start = 0;
		int answer = 0;
		for (int i = 0; i < n; i++) {
			int next = arr[start];
			
			if (visited[next]) break;
			visited[next] = true;
			answer++;
			if (next == k) break;
			start = next;
		}
		
		if (visited[k]) {
			System.out.println(answer);
		} else {
			System.out.println(-1);
		}
	}

}
