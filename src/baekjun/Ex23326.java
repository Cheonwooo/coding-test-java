package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Ex23326 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());
		int[] arr = new int[n];
		
		TreeSet<Integer> set = new TreeSet<>();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			if (arr[i] == 1) {
				set.add(i+1);
			}
		}
		
		int dohyun = 1;
		for (int i = 0; i < q; i++) {
			st = new StringTokenizer(br.readLine());
			int query = Integer.parseInt(st.nextToken());
			
			if (query == 1) {
				int pos = Integer.parseInt(st.nextToken());
				if (set.contains(pos)) {
					set.remove(pos);
				} else {
					set.add(pos);
				}
			} else if (query == 2) {
				int pos = Integer.parseInt(st.nextToken());
				dohyun = (dohyun + pos) % n;
				if (dohyun == 0) {
					dohyun = n;
				}
			} else {
				Integer nextSpot = set.ceiling(dohyun);
				if (nextSpot == null) {
					if (!set.isEmpty()) {
						nextSpot = set.first();
						sb.append((n - dohyun + nextSpot) + "\n");
					} else {
						sb.append(-1 + "\n");
					}
				} else {
					sb.append((nextSpot - dohyun) + "\n");
				}
			}
		}
		System.out.println(sb);
	}
}
