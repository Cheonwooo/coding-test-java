package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Ex7578 {
	
	private static final int SIZE = 1 << 20;
	private static final int LEN = 1 << 19;
	
	private static int n;
	private static long answer;
	private static int[] a, b;
	private static int[] visitTree;
	private static Map<Integer, Integer> lineA = new HashMap<>();
	private static Map<Integer, Integer> lineB = new HashMap<>();

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		a = new int[n];
		b = new int[n];
		visitTree = new int[SIZE];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			int next = Integer.parseInt(st.nextToken());
			a[i] = next;
			lineA.put(next, i);
		}
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			int next = Integer.parseInt(st.nextToken());
			b[i] = next;
			lineB.put(next, i);
		}
		
		for (int i = 0; i < n; i++) {
			int bIndex = lineB.get(a[i]);
			
			update(bIndex, 1);//방문처리
			answer += getCount(1, 0, LEN - 1, bIndex + 1, n-1);//뒤에 방문처리된 수 구하기
		}
		System.out.println(answer);
	}
	
	private static void update(int index, int value) {
		index += LEN;
		visitTree[index] = 1;
		index /= 2;
		
		while (index >= 1) {
			visitTree[index] = visitTree[index * 2] + visitTree[index * 2 + 1]; 
			index /= 2;
		}
	}
	
	private static int getCount(int index, int s, int e, int ts, int te) {
		if (s > te || e < ts) return 0;
		if (ts <= s && e <= te) return visitTree[index];
		
		int mid = (s + e) / 2;
		
		int left = getCount(index * 2, s, mid, ts, te);
		int right = getCount(index * 2 + 1, mid + 1, e, ts, te);
		
		return left + right;
	}
}
