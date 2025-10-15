package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Ex407 {
	
	private static int n, scene;
	private static boolean[] visited = new boolean[1_000_001];
	private static List<Integer> stage = new ArrayList<>();
	private static List<Integer> answer = new ArrayList<>();

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		dfs(0, 0);
		System.out.println(scene-1);
		for (int ans : answer) {
			System.out.println(ans+1);
		}
	}
	
	private static void dfs(int x, int y) {
		if (x != 0 && y == 0 && x > scene) {
			scene = x;
			answer = new ArrayList<>(stage);
			return;
		}
		
		for (int i = 0; i < n; i++) {
			if (((1 << i) & y) > 0) {//i번째 배우가 등장했다면
				int next = (~(1 << i)) & y;//i번째 배우 내리고 진행
				if ((x != 0 && next == 0) || !visited[next]) {
					visited[next] = true;
					stage.add(i);
					dfs(x + 1, next);
					stage.remove(stage.size() - 1);
				}
				
			}
			
			if (((1 << i) & y) == 0) {//i번째 배우가 없다면
				int next = (1 << i) | y;//i번째 배우 올리고 진행
				if (!visited[next]) {
					visited[next] = true;
					stage.add(i);
					dfs(x + 1, next);
					stage.remove(stage.size() - 1);
				}
			}
		}
	}
}
