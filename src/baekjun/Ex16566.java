package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Ex16566 {
	
	private static int[] parents;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		parents = new int[m+1];
		for (int i = 0; i < m+1; i++) {
			parents[i] = i;
		}
		
		int[] arr = new int[m];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < k; i++) {
			int num = Integer.parseInt(st.nextToken());
			
			int left = 0;
			int right = m-1;
			int mid = 0;
			while (left < right) {
				mid = (left + right) / 2;
				
				if (arr[mid] <= num) {
					left = mid + 1;
				} else {
					right = mid;
				}
			}
			int index = findParent(left);
			sb.append(arr[index] + "\n");
			union(index, index + 1);
		}
		System.out.println(sb);
	}
	
	private static void union(int a, int b) {
		int pa = findParent(a);
		int pb = findParent(b);
		
		if (pa < pb) parents[pa] = pb;
		else parents[pb] = pa;
	}
	
	private static int findParent(int a) {
		if (parents[a] == a) return a;
		else return parents[a] = findParent(parents[a]);
	}
}
