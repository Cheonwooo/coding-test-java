package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Ex2668 {

	private static int n;
	private static int[][] arr;
	private static boolean[] visited;
	private static List<Integer> temp;
	private static Set<Integer> answer = new TreeSet<>();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		arr = new int[n+1][2];
		for (int i = 1; i < n+1; i++) {
			arr[i][0] = i;
			arr[i][1] = Integer.parseInt(br.readLine());
		}
		
		for (int i = 1; i < n+1; i++) {
			visited = new boolean[n+1];
			visited[i] = true;
			temp = new ArrayList<>();
			temp.add(i);
			dfs(i, arr[i][1]);
		}
		
		
		System.out.println(answer.size());
//		Collections.sort(answer);
		for (int num : answer) {
			System.out.println(num);
		}
	}
	
	private static void dfs(int start, int next) {
		if (next == start) {
			answer.addAll(temp);
			return;
		}
		
		if (arr[next][0] == arr[next][1]) return;
		
		if (!visited[next]) {
			visited[next] = true;
			temp.add(next);
			dfs(start, arr[next][1]);
		}
	}
}
