package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Ex2550 {
	
	private static class Node {
		int idx;
		int num;

		public Node(int idx, int num) {
			this.idx = idx;
			this.num = num;
		}
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Map<Integer, Integer> map = new HashMap<>();
		List<Integer> list = new ArrayList<>();
		
		int n = Integer.parseInt(br.readLine());
		int[] switches = new int[n];
		int[] arr = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			switches[i] = Integer.parseInt(st.nextToken());
			map.put(switches[i], i);
		}
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = map.get(Integer.parseInt(st.nextToken()));
		}
		
		Node[] node = new Node[n];
		
		for (int i = 0; i < n; i++) {
			int key = arr[i];
			if (list.size() == 0 || list.get(list.size() - 1) < key) {
				list.add(key);
				node[i] = new Node(list.size() - 1, key);
			} else {
				int left = 0;
				int right = list.size() -1 ;
				
				while (left < right) {
					int mid = (left + right) / 2;
					
					if (list.get(mid) < key) {
						left = mid + 1;
					} else {
						right = mid;
					}
				}
				list.set(right, key);
				node[i] = new Node(right, key);
			}
		}
		
		int idx = list.size() - 1;
		for (int i = n-1; i >= 0; i--) {
			if (node[i].idx == idx) {
				list.set(idx--, switches[node[i].num]);
			}
		}
		System.out.println(list.size());
		Collections.sort(list);
		for(int num : list) {
			System.out.print(num + " ");
		}
	}

}
