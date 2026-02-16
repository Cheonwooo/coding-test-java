package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Ex1722 {
	
	private static int n;
	private static int[] temp;
	private static long[] factorial;
	private static boolean[] visited;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		n = Integer.parseInt(br.readLine());
		
		temp = new int[n];
		visited = new boolean[n+1];
		
		factorial = new long[21];
		factorial[0] = 1;
		for (int i = 1; i < 21; i++) {
			factorial[i] = factorial[i-1] * i;
		}
		
		List<Integer> permList = new ArrayList<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int query = Integer.parseInt(st.nextToken());
		if (query == 1) {
			long seq = Long.parseLong(st.nextToken());
			
			for (int i = 0; i < n; i++) {
				for (int j = 1; j < n+1; j++) {
					if (visited[j]) continue;
					if (seq - factorial[n - 1 - i] > 0) {
						seq -= factorial[n - 1 - i];
					} else {
						visited[j] = true;
						permList.add(j);
						break;
					}
				}
			}
			
			for (int num : permList) {
				sb.append(num + " ");
			}
			System.out.println(sb);
		} else {
			long answer = 0;
			temp = new int[n];
			for (int i = 0; i < n; i++) {
				temp[i] = Integer.parseInt(st.nextToken());
			}
			
			for (int i = 0; i < n; i++) {
				for (int j = 1; j < temp[i]; j++) {
					if (visited[j]) continue;
					
					answer += factorial[n - 1 - i];
				}
				visited[temp[i]] = true;
			}
			System.out.println(answer + 1L);
		}
	}
}
