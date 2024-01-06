package baekjun;

/*
 * 아이디어 : Collections.swap 사용해서 순서 바꾸기
 * 
 * 시간복잡도 : m
 * 
 * 자료구조 : List
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Ex10813 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		List<Integer> box = new ArrayList<Integer>();
		
		for(int i = 0; i < n; i++) {
			box.add(i+1);
		}
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			
			int p = Integer.parseInt(st.nextToken());
			int q = Integer.parseInt(st.nextToken());
			
			Collections.swap(box, p-1, q-1);
		}
		
		for(int i = 0; i < n; i++) {
			System.out.print(box.get(i) + " ");
		}
	}

}
