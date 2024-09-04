package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Ex2115 {
	
	private static int n, m, c, max, answer;
	private static int[] temp;
	private static int[][] arr;
	private static boolean[][] visited;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			sb.append("#" + t + " ");
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			arr = new int[n][n];
			
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			
			int max2 = Integer.MIN_VALUE;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j <= n-m; j++) {
					answer = 0;
					start(i, j, c);//��������
					max2 = Math.max(answer, max2);
				}
			}
			sb.append(max2).append("\n");
		}
		System.out.println(sb);
		
	}
	public static void start(int x, int y, int limitAmount) {
		visited = new boolean[n][n];
		int[] selects = new int[m];
		for (int i = 0; i < m; i++) {//���� ä���� ���� ���� ����
			visited[x][y+i] = true;
			selects[i] = arr[x][y+i];
		}
		
		//���� ä���� �ְ� �ִ�� ä���� �� �ִ� ���� �� ���ϱ�
		//selects�� ���� �� �ִ� ����� �� ���ϱ�
		max = Integer.MIN_VALUE;
		for (int i = 1; i <= m; i++) {
			temp = new int[i];
			boolean[] check = new boolean[m];
			dfs(selects, temp, check, 0, i, limitAmount);
		}
		answer += max;
		makeArea(max, c);
		answer = Math.max(answer, answer += max);
	}
	
	public static void dfs(int[] selects, int[] temp, boolean[] check, int depth, int r, int limitAmount) {
		if (depth == r) {
			int sum = makeSum(selects, temp, limitAmount);
			max = Math.max(sum, max);
			return;
		}
		
		for (int i = 0; i < m; i++) {
			if (!check[i]) {
				check[i] = true;
				temp[depth] = i;
				dfs(selects, temp, check, depth+1, r, limitAmount);
				check[i] = false;
			}
		}
	}
	
	public static int makeSum(int[] selects, int[] temp, int limitAmount) {
		int sum = 0;
		for (int i = 0; i < temp.length; i++) {
			if (limitAmount < selects[temp[i]]) break;
			sum += (int)Math.pow(selects[temp[i]], 2);
			limitAmount -= selects[temp[i]];
		}
		if (sum == 242) System.out.println(Arrays.toString(temp));
		return sum;
	}
	
	public static void makeArea(int preSum, int limitAmount) {//���� ä���� ���� ���� �����ֱ�
		max = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j <= n-m; j++) {
				if (canCollect(i, j)) {
					int[] selects = new int[m];
					for (int k = 0; k < m; k++) {//���� ����
						visited[i][j+k] = true;
						selects[k] = arr[i][j+k];
					}
					
					for (int l = 1; l <= m; l++) {
						temp = new int[l];
						boolean[] check = new boolean[m];
						dfs(selects, temp, check, 0, l, limitAmount);
					}
					
					for (int k = 0; k < m; k++) {//���� ����
						visited[i][j+k] = false;
					}
				}
			}
		}
	}
	
	public static boolean canCollect(int x, int y) {//x, y��ǥ���� ä���� �� �ִ���
		for (int i = 0; i < m; i++) {
			if (visited[x][y+i]) {
				return false;
			}
		}
		return true;
	}

}
