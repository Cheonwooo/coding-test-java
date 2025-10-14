package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex1057 {
	
	private static int answer = -1;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		boolean[] check = new boolean[100_001];
		check[a] = true;
		check[b] = true;
		gameStart(check, n, 1);
		System.out.println(answer);
	}
	
	private static void gameStart(boolean[] check, int n, int round) {
		if (n == 0) return; 
		
		boolean[] newCheck = new boolean[100_001];
		for (int i = 1; i < n+1; i+=2) {
			if (check[i] && check[i+1]) {
				answer = round;
				return;
			}
			
			if (check[i] || check[i+1]) {
				newCheck[(i+1) / 2] = true;
			}
		}
		gameStart(newCheck, (n/2 == 0) ? n/2 : n/2 + 1,round+1);
	}
}
