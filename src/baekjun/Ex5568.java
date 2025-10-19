package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Ex5568 {
	
	private static int n, k;
	private static int[] cards, temp;
	private static boolean[] visited;
	private static Set<Integer> answer = new HashSet<>();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		k = Integer.parseInt(br.readLine());
		
		visited = new boolean[n];
		temp = new int[k];
		cards = new int[n];
		for (int i = 0; i < n; i++) {
			cards[i] = Integer.parseInt(br.readLine());
		}
		
		dfs(0);
		System.out.println(answer.size());
	}
	
	private static void dfs(int depth) {
		if (depth == k) {
			makeNumber();
			return;
		}
		
		for (int i = 0; i < n; i++) {
			if (!visited[i]) {
				visited[i] = true;
				temp[depth] = cards[i];
				dfs(depth + 1);
				visited[i] = false;
			}
		}
	}
	
	private static void makeNumber() {
		String number = "";
		
		for (int i = 0; i < k; i++) {
			number += (temp[i]+"");
		}
		answer.add(Integer.parseInt(number));
	}
}
