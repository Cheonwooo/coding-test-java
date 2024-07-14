package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Ex17140 {
	public static class Pair implements Comparable<Pair> {
		int number;
		int count;
		
		public Pair(int number, int count) {
			this.number = number;
			this.count = count;
		}
		
		public int compareTo(Pair other) {
			if (this.count == other.count) {
				return this.number - other.number;
			}
			return this.count - other.count;
		}
	}
	
	private static int[][] map;
	private static PriorityQueue<Pair>[] pq;
	private static Map<Integer, Integer> numberCount;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken())-1;
		int c = Integer.parseInt(st.nextToken())-1;
		int k = Integer.parseInt(st.nextToken());
		map = new int[3][3];
		
		for (int i = 0; i < 3; i++) {
			st= new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		if(map.length >= r && map[0].length >= c && map[r][c] == k) {
			System.out.println(0);
		} else {
			int count = 0;
			int answer = -1;
			int maxCount = 3;
			
			while (count++ <= 100) {
				int row = map.length;
				int col = map[0].length;
				maxCount = Math.max(row, col);
				
				pq = new PriorityQueue[maxCount];
				
				if (row >= col) {
					int max = checkRow(row, col);
					makeRowMap(row, max);
				} else {
					int max = checkCol(row, col);
					makeColMap(col, max);
				}
				
				if (map.length < r+1 || map[0].length < c+1) continue;
				if (map[r][c] == k) {
					answer = count;
					break;
				}
			}
			System.out.println(answer);
		}
	}
	
	public static int checkRow(int row, int col) {
		int max = 0;
		for (int i = 0; i < row; i++) {
			
			pq[i] = new PriorityQueue<>();
			numberCount = new HashMap<Integer, Integer>();
			
			for (int j = 0; j < col; j++) {
				if (map[i][j] == 0) continue;
				numberCount.put(map[i][j], numberCount.getOrDefault(map[i][j], 0) + 1);
			}
			
			for (int key : numberCount.keySet()) {
				pq[i].add(new Pair(key, numberCount.get(key)));
			}
			
			max = Math.max(max, pq[i].size()*2);
		}
		return max;
	}
	
	public static void makeRowMap(int row, int max) {
		map = new int[row][max];
		for (int i = 0; i < row; i++) {
			int index = 0;
			while (!pq[i].isEmpty()) {
				if (index >= 100) break;
				
				Pair pair = pq[i].poll();
				map[i][index] = pair.number;
				map[i][index+1] = pair.count;
				index += 2;
			}
		}
	}
	
	public static int checkCol(int row, int col) {
		int max = 0;
		for (int i = 0; i < col; i++) {
			
			pq[i] = new PriorityQueue<>();
			numberCount = new HashMap<Integer, Integer>();
			
			for (int j = 0; j < row; j++) {
				if (map[j][i] == 0) continue;
				numberCount.put(map[j][i], numberCount.getOrDefault(map[j][i], 0) + 1);
			}
			
			for (int key : numberCount.keySet()) {
				pq[i].add(new Pair(key, numberCount.get(key)));
			}
			
			max = Math.max(max, pq[i].size()*2);
		}
		return max;	
	}
	
	public static void makeColMap(int col, int max) {
		map = new int[max][col];
		for (int i = 0; i < col; i++) {
			int index = 0;
			while (!pq[i].isEmpty()) {
				if (index >= 100) break;
				
				Pair pair = pq[i].poll();
				map[index][i] = pair.number;
				map[index+1][i] = pair.count;
				index += 2;
			}
		}
	}
	
}