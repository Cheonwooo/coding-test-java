package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex15649_2 {
	private static int n, m;
	private static int[] arr;
	private static boolean[] check;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[m];
		check = new boolean[n];
		
		comb(0);
	}

	private static void comb(int r) {
		if (r == m) {
			for (int i = 0; i < m; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
			return;
		}
		
		for (int i = 0; i < n; i++) {
			if (!check[i]) {
				check[i] = true;
				arr[r] = i+1;
				comb(r+1);
				check[i] = false;
			}
		}
	}
}
