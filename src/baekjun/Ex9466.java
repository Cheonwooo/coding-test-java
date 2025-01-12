package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//�޸� 301512kb, �ð� 960ms

public class Ex9466 {

	private static int n, totalCount;
	private static int[] arr;
	private static boolean[] visited, done;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			n = Integer.parseInt(br.readLine());
			totalCount = n;
			arr = new int[n+1];
			visited = new boolean[n+1];
			done = new boolean[n+1];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 1; i < n+1; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			for (int i = 1; i < n+1; i++) {
				if (!done[i]) {
					dfs(i);					
				}
			}
			System.out.println(totalCount);
		}
	}
	
	public static void dfs(int start) {
		//�� 2�� Ž��
		// !visited and !done�̶�� ó�� �湮
		// visited and !done�̶�� ����Ŭ��
		if (done[start]) return;
		if (visited[start]) {
			done[start] = true;
			totalCount--;
		} else {
			visited[start] = true;
		}
		
		int next = arr[start];
		dfs(next);
		done[start] = true;
		visited[start] = false;
		
	}

}
