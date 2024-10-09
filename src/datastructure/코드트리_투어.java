package codetree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class 코드트리_투어2 {
		
	private static class Product implements Comparable<Product> {
		int id;
		int revenue;
		int dest;
		int cost;

		public Product(int id, int revenue, int dest, int cost) {
			this.id = id;
			this.revenue = revenue;
			this.dest = dest;
			this.cost = cost;
		}
		
		public int compareTo(Product o) {
			if (this.cost == o.cost) {
				return this.id - o.id;
			}
			return o.cost - this.cost;
		}

		@Override
		public String toString() {
			return "Product [id=" + id + ", revenue=" + revenue + ", dest=" + dest + ", cost=" + cost + "]";
		}
		
		
	}
	
	private static int n, maxIndex = 0, nowStartPoint = 0;
	private static final int INF = (int) 1e9;
	private static int[] d;
	private static boolean[] isAlive;
	private static Product[] products;
	private static Map<Integer, Product> idList;
	private static List<int[]>[] list;
	private static TreeMap<Product, Boolean> optimizeList;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int Q = Integer.parseInt(br.readLine());
		for (int i = 0; i < Q; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int command = Integer.parseInt(st.nextToken());
			if (command == 100) {
				init(br, st);
			} else if (command == 200) {
				int id = Integer.parseInt(st.nextToken());
				int revenue = Integer.parseInt(st.nextToken());
				int dest = Integer.parseInt(st.nextToken());
				createProduct(id, revenue, dest);
			} else if (command == 300) {
				int id = Integer.parseInt(st.nextToken());
				deleteProduct(id);
			} else if (command == 400) {
				sellOptimizeProduct();
			} else if (command == 500) {
				int newStartPoint = Integer.parseInt(st.nextToken());
				changeStartPoint(newStartPoint);
			}
		}
	}

	private static void init(BufferedReader br, StringTokenizer st) {
		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		list = new List[n+1];
		d = new int[n+1];
		isAlive = new boolean[30001];
		products = new Product[30001];
		optimizeList = new TreeMap<>();
		idList = new HashMap<>();
		
		for (int i = 0; i < n+1; i++) {
			list[i] = new ArrayList<>();
		}
		
		Arrays.fill(isAlive, true);
		Arrays.fill(d, INF);
		
		for (int i = 0; i < m; i++) {
			int from = Integer.parseInt(st.nextToken()); 
			int to = Integer.parseInt(st.nextToken()); 
			int dis = Integer.parseInt(st.nextToken());
			
			list[from].add(new int[] {to, dis});
			list[to].add(new int[] {from, dis});
		}
		
		dijkstra();
	}

	private static void createProduct(int id, int revenue, int dest) {
		int cost = revenue - d[dest];
		if (d[dest] == -1) cost = -1;
		if (cost < 0) cost = -1;

		Product product = new Product(id, revenue, dest, cost);
		products[id] = product;
		optimizeList.put(products[id], true);
		idList.put(id, products[id]);
		maxIndex = Math.max(maxIndex, id);
	}

	private static void deleteProduct(int id) {
		if (!idList.containsKey(id)) return;
		Product product = idList.get(id);
		optimizeList.remove(products[id]);
		products[id] = null;
		idList.remove(id);
		isAlive[id] = false;
	}

	private static void sellOptimizeProduct() {
//		for (Product key : optimizeList.keySet()) {
//			System.out.println(key);
//		}
//		System.out.println("========================");
		if (optimizeList == null ) {
			System.out.println(-1);
			return;
		}
		
		while (true) {
			if (optimizeList.size() == 0) {
				System.out.println(-1);
				break;
			}
			Product product = optimizeList.firstKey();
			if (!isAlive[product.id]) {
				optimizeList.remove(product);
				continue;
			}
//			System.out.println(product);
			if (product.cost == -1) { 
				System.out.println(-1);
			} else {
				isAlive[product.id] = false; 
				System.out.println(product.id);
				optimizeList.remove(product);
			}
			break;
		}
	}

	private static void changeStartPoint(int newStartPoint) {
		nowStartPoint = newStartPoint;
		Arrays.fill(d, INF);
		
		dijkstra();
		for (int key : idList.keySet()) {
			if (!isAlive[key] || products[key] == null) continue;
			Product p = idList.get(key);
			
			int cost = p.revenue - d[p.dest];
			if (d[p.dest] == -1) cost = -1;
			if (cost < 0) cost = -1;

			optimizeList.remove(products[p.id]);
			products[p.id].cost = cost;
			optimizeList.put(products[p.id], true);
//			System.out.println("change " + products[p.id]);
		}
	}
	
	private static void dijkstra() {
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
		pq.add(new int[] {nowStartPoint, 0});
		d[nowStartPoint] = 0;
		
		while (!pq.isEmpty()) {
			int[] p = pq.poll();
			
			int now = p[0];
			int dis = p[1];
			
			if (d[now] < dis) continue;
			
			for (int i = 0; i < list[now].size(); i++) {
				int cost = dis + list[now].get(i)[1];
				if (cost < d[list[now].get(i)[0]]) {
					d[list[now].get(i)[0]] = cost;
					pq.add(new int[] {list[now].get(i)[0], cost});
				}
			}
		}
		
//		for (int i = 0; i < n+1; i++) {
//			if (d[i] == INF) {
//				System.out.println(INF);
//			} else {
//				System.out.println(d[i]);
//			}
//		}
//		System.out.println(nowStartPoint + "==================");
	}
}

//28
//100 9 17 8 8 2 1 0 5 3 0 1 6 3 1 6 3 3 2 2 4 0 1 1 8 4 3 6 5 5 3 6 5 5 2 4 6 5 5 4 6 5 5 4 1 5 3 3 2 4 3 8 3 1
//300 4
//300 14
//200 19 7 6
//300 19
//200 7 10 3
//200 5 6 1
//200 1 2 2
//200 14 7 6
//500 8
//200 27 3 2
//300 7
//400
//300 8
//300 22
//200 29 2 6
//300 29
//400
//500 2
//200 23 3 5
//200 15 9 6
//200 17 7 4
//300 17
//400
//300 14
//300 27
//400
//200 18 2 5
