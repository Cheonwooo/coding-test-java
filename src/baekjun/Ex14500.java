package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * ���̵��
 * 5���� ��Ʈ�ι̳븦 �迭�� ����
 * 90�� ȸ�� ��Ų �� 0,0���� n,m���� �� ���ϱ� 
 * ������ �� �������� 90�� ȸ�� ��Ų �� �� ���ϱ�
 * ��Ī�� �� �� ���� �Ȱ��� �ݺ�
 * 
 * �ð����⵵
 * n * m * 2 * 4 * 5
 * 
 * �ڷᱸ��
 * ��Ʈ�ι̳��� ��ǥ�� ������ int[][]
 * �Է°��� ������ int[][]
 * ���Ⱚ�� ������ int[] 2��
 * 
 */

public class Ex14500 {
	private static int n, m, max = Integer.MIN_VALUE;
	private static int[] dx = {-1, 0, 1, 0};
	private static int[] dy = {0, 1, 0, -1};
	private static int[][] arr;
	private static boolean[][] visited;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		visited = new boolean[n][m];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				visited[i][j] = true;
				dfs(i, j, arr[i][j], 1);
				visited[i][j] = false;
			}
		}
		System.out.println(max);
	}
	
	private static void dfs(int x, int y, int sum, int depth) {
		if (depth == 4) { 
			max = Math.max(sum, max);
			return;
		}
		
		for (int i = 0 ; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if (nx<0 || nx>=n || ny<0 || ny>=m) continue;
			
			if (!visited[nx][ny]) {
				if (depth == 2) {
					visited[nx][ny] = true;
					dfs(x, y, sum + arr[nx][ny], depth+1);
					visited[nx][ny] = false;
				}
				visited[nx][ny] = true;
				dfs(nx, ny, sum + arr[nx][ny], depth+1);
				visited[nx][ny] = false;
			}
			
		}
	}
}