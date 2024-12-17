package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

//�޸� 20452kb, �ð� 160ms

public class Ex1949 {
	
	private static int n;
	private static int[] arr;
	private static int[][] dp;
	private static List<Integer>[] list;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		arr = new int[n+1];
		dp = new int[n+1][2];
		list = new List[n+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i < n+1; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			list[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < n-1; i++) {
			st = new StringTokenizer(br.readLine());
			
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			list[from].add(to);
			list[to].add(from);
		}
		
		dfs(1, 0);
		
		
		System.out.println(Math.max(dp[1][0], dp[1][1]));
	}

	public static void dfs(int start, int parent) {
		
		//������ ���õ��� ���� �̿��� ��� �ǳʶپ����.
		//0�� ��� �̿� ��� �����ص��ǰ� ���ص���
		//1�� ��� �̿� ��� ����
		for (int neighbor : list[start]) {
			if (neighbor != parent) {
				dfs(neighbor, start);
				dp[start][0] += Math.max(dp[neighbor][0], dp[neighbor][1]);
				dp[start][1] += dp[neighbor][0];
			}
		}
		
		dp[start][1] += arr[start];
	}
}
