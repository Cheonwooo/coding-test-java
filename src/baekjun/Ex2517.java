package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ex2517 {
	
	private static class Runner {
		int index;
		int ability;

		public Runner(int index, int ability) {
			this.index = index;
			this.ability = ability;
		}
	}
	
	private static final int SIZE = 1 << 20;
	private static final int LEN = 1 << 19;
	
	private static int n;
	private static int[] runner, tree;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		n = Integer.parseInt(br.readLine());
		List<Runner> runner = new ArrayList<>();
		for(int i = 0; i < n; i++) {
			runner.add(new Runner(i, Integer.parseInt(br.readLine())));
		}
		
		Collections.sort(runner, (o1, o2) -> o1.ability - o2.ability);
		for (int i = 0; i < n; i++) {
			runner.get(i).ability = i;
		}
		Collections.sort(runner, (o1, o2) -> o1.index - o2.index);
		
		tree = new int[SIZE];
		
		for (int i = 0; i < n; i++) {
			int ability = runner.get(i).ability;
			sb.append((i) - (getSum(1, 0, LEN-1, 0, ability-1))+1 + "\n");
			update(ability, 1);
		}
		System.out.println(sb);
	}

	private static void update(int idx, int value) {
		idx += LEN;
		tree[idx] += value;
		idx /= 2;
		
		while (idx >= 1) {
			tree[idx] = tree[idx * 2] + tree[idx * 2 + 1];
			idx /= 2;
		}
	}
	
	private static int getSum(int node, int s, int e, int ts, int te) {
		if (s > te || e < ts) return 0;
		if (ts <= s && e <= te) return tree[node];
		
		int mid = (s + e) / 2;
		
		int left = getSum(node * 2, s, mid, ts, te);
		int right = getSum(node * 2 + 1, mid + 1, e, ts, te);
		
		return left + right;
	}
}

//2 8 10 7 1 9 4 15