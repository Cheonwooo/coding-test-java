package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Ex9229 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			sb.append("#" + t + " ");
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			int[] snacks = new int[N];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				snacks[i] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(snacks);
			
			int left = 0;
			int right = N-1;
			int answer = -1;
			
			while (left < right) {
				int sum = snacks[left] + snacks[right];
				if (sum == M) {
					answer = M;
					break;
				}
				
				if (sum < M) {
					left++;
					answer = Math.max(answer, sum);
				} else if (sum > M) {
					right--;;
				}
			}
			sb.append(answer).append("\n");
		}
		System.out.println(sb);
	}

}
