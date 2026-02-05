package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Ex8980 {
	
	private static class Parcel implements Comparable<Parcel>{ 
		int pre;
		int next;
		int quantity;

		public Parcel(int pre, int next, int quantity) {
			this.pre = pre;
			this.next = next;
			this.quantity = quantity;
		}

		public int compareTo(Parcel o) {
			if (this.next == o.next) {
				return this.pre - o.pre;
			}
			return this.next - o.next;
		}
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		List<Parcel> graph = new ArrayList<>();
		
		int m = Integer.parseInt(br.readLine());
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int q = Integer.parseInt(st.nextToken());
			
			graph.add(new Parcel(a, b, q));
		}
		
		int[] quantity = new int[n+1];
		Arrays.fill(quantity, c);
		
		Collections.sort(graph);
		int answer = 0;
		for (int i = 0; i < graph.size(); i++) {
			Parcel p = graph.get(i);
			
			int minQuantity = 10001;
			//시작점 ~ 도착점 - 1 까지 최솟값 혹은 배달량만큼
			for (int j = p.pre; j < p.next; j++) {
				minQuantity = Math.min(minQuantity, quantity[j]);
			}
			
			int parcelQuantity = p.quantity;
			if (minQuantity < parcelQuantity) {
				parcelQuantity = minQuantity;
			}
			
			answer += parcelQuantity;
			for (int j = p.pre; j < p.next; j++) {
				quantity[j] -= parcelQuantity;
			}
		}
		System.out.println(answer);
	}
}
