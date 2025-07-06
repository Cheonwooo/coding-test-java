package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Ex31714 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int[][] map = new int[n][m];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken()) + ((i+1)*d);
			}
			Arrays.sort(map[i]);
		}
		
		for (int i = 0; i < n-1; i++) {
			int pre = m-1;
			int next = m-1;
			int count = 0;
			
			while (true) {
				if (map[i][pre] >= map[i+1][next]) {
					next--;
				} else {
					pre--;
					next--;
					count++;
				}
				
				if (count == m) {
					break;
				} else {
					if (next == -1) {
						System.out.println("NO");
						return;
					}
				}
			}
		}
		System.out.println("YES");
	}
}

//7 8 9 10 11
//1 2 3 4 12