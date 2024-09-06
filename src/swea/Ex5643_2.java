package swea.exam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_5643_D4_키_순서_천현우4 {
	
	private static int n, count, adjMatrix[][];

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			sb.append("#" + t + " ");

			n = Integer.parseInt(br.readLine());
			int m = Integer.parseInt(br.readLine());
			
			adjMatrix = new int[n+1][n+1];
			for (int i = 0; i < m ; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				adjMatrix[a][b] = 1;
			}
			
			for (int i = 1; i <= n; i++) {
				adjMatrix[i][0] = -1;//탐색되지 않은 학생을 나타냄(후에 탐색이 완료되면 자신보다 큰 학생 수 지정)
			}
			
			int answer = 0;
			//각 학생마다 자신보다 큰, 자신보다 작은 학생 각가 탐색
			for (int i = 1; i <= n; i++) {
				if(adjMatrix[i][0] != -1) continue;
				gtDfs(i);
			}
			
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					adjMatrix[0][j] += adjMatrix[i][j];
				}
			}
			
			for (int i = 1; i <= n; i++) {
				if (adjMatrix[i][0] + adjMatrix[0][i] == n-1) answer++;
			}
			
			sb.append(answer).append("\n");
		}
		System.out.println(sb);
	}

	public static void gtDfs(int cur) {//자신보다 큰 학생 따라 탐색
		for (int i = 1; i <= n; i++) {
			if (adjMatrix[cur][i] == 0) continue;
			if (adjMatrix[i][0] == -1) {//탐색되지 않은 학생이므로 탐색 시작
				gtDfs(i);
			}
			//나보다 키가 큰 학생이 탐색을 완료한 상태
			//i보다 키가 큰 학생이 있다면 그 학생들의 정보를 cur에게 반영
			if (adjMatrix[i][0] > 0) {
				for (int j = 1; j <= n; j++) {
					if (adjMatrix[i][j] != 0) adjMatrix[cur][j] = 1;
				}
			}
			
		}
		
		adjMatrix[cur][0] = 0;
		for (int k = 1; k <= n; k++) {
			adjMatrix[cur][0] += adjMatrix[cur][k];
		}

	}
}
