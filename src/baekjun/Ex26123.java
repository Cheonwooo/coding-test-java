package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Ex26123 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		
		int[] count = new int[300_001];
		TreeSet<Integer> set = new TreeSet<>(Collections.reverseOrder());
		int[] height = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			height[i] = Integer.parseInt(st.nextToken());
			count[height[i]]++;
			set.add(height[i]);
		}
		
		long answer = 0;
		for (int i = 0; i < d; i++) {
			int next = set.pollFirst();
			if (next == 0) break;
			
			int c = count[next];
			answer += c;
			count[next] = 0;
			next--;
			count[next] += c;
			set.add(next);
		}
		System.out.println(answer);
	}

}
