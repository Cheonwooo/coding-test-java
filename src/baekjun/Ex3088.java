package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex3088 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		boolean[] isBroken = new boolean[1_000_001];
		int[][] pots = new int[n][3];
		
		int answer = 0;
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			pots[i][0] = Integer.parseInt(st.nextToken());
			pots[i][1] = Integer.parseInt(st.nextToken());
			pots[i][2] = Integer.parseInt(st.nextToken());
			
			if (!isBroken[pots[i][0]] && !isBroken[pots[i][1]] && !isBroken[pots[i][2]]) {
				answer++;
			}
			isBroken[pots[i][0]] = true;
			isBroken[pots[i][1]] = true;
			isBroken[pots[i][2]] = true;
		}
		System.out.println(answer);
	}
}
