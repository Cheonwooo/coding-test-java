package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Ex2628 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		
		List<Integer>[] list = new List[2];
		for (int i = 0; i < 2; i++) {
			list[i] = new ArrayList<>();
		}
		
		list[0].add(0);
		list[1].add(0);
		
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			st = new StringTokenizer(br.readLine());
			
			int q = Integer.parseInt(st.nextToken());
			int next = Integer.parseInt(st.nextToken());
			
			list[q].add(next);
		}
		
		for (int i = 0; i < 2; i++) {
			Collections.sort(list[i]);
		}
		list[0].add(n);
		list[1].add(m);
		
		int answer = 0;
		for (int i = 0; i < list[0].size() - 1; i++) {
			int h = list[0].get(i+1) - list[0].get(i);
			for (int j = 0; j < list[1].size() - 1; j++) {
				int w = list[1].get(j+1) - list[1].get(j);
				answer = Math.max(h*w, answer);
			}
		}
		System.out.println(answer);
	}

}
