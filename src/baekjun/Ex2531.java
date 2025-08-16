package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Ex2531 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int[] sushi = new int[n];
		
		for (int i = 0; i < n; i++) {
			sushi[i] = Integer.parseInt(br.readLine());
		}
		
		int max = Integer.MIN_VALUE;
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < n; i++) {
//			boolean pass = false;
			set.clear();
			for (int j = i; j < i + k; j++) {
//				if (set.contains(sushi[j%n])) {
//					pass = true;
//					break;
//				}
				set.add(sushi[j%n]);
			}
			
//			if (pass) continue;
			
			if (!set.contains(c)) set.add(c);
			max = Math.max(max, set.size());
		}
		System.out.println(max);
	}

}
