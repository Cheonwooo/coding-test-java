package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Ex10471 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int w = Integer.parseInt(st.nextToken());
		int p = Integer.parseInt(st.nextToken());
		int[] partition = new int[p+1];
		
		Set<Integer> set = new TreeSet<>();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < p; i++) {
			partition[i] = Integer.parseInt(st.nextToken());
			set.add(partition[i]);
		}
		partition[p] = w;
		set.add(w);
		
		for (int i = 0; i < p; i++) {
			for (int j = i+1; j < p+1; j++) {
				set.add(partition[j] - partition[i]);
			}
		}
		
		for (int area : set) {
			System.out.print(area + " ");
		}
	}

}
