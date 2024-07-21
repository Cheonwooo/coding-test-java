package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Ex17837_2 {
	
	public static class Horse {
		int x;
		int y;
		int number;
		int d;
		
		public Horse(int x, int y, int number, int d) {
			this.x = x;
			this.y = y;
			this.number = number;
			this.d = d;
		}
	}
	
	private static int n;
	private static int[] dx = {0, 0, -1, 1};
	private static int[] dy = {1, -1, 0, 0};
	private static int[][] color;
	private static Horse[] horses;
	private static Deque<Horse>[][] dq;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		color = new int[n][n];
		dq = new Deque[n][n];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				color[i][j] = Integer.parseInt(st.nextToken());
				dq[i][j] = new LinkedList<>();
			}
		}
		
		horses = new Horse[k];
		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			
			int x = Integer.parseInt(st.nextToken()) - 1;
			int y = Integer.parseInt(st.nextToken()) - 1;
			int d = Integer.parseInt(st.nextToken()) - 1;
			
			dq[x][y].add(new Horse(x, y, i, d));
			horses[i] = new Horse(x, y, i, d);//말의 위치 정보 저장
		}
		
		int count = 0;
		boolean out = false;
		while (count < 1000 && !out) {
			count++;
			for (int i = 0; i < k; i++) {
				Horse h = horses[i];
				move(h.x, h.y, i, h.d);
//				printMap();
				if (check()) {
					out = true;
					break;
				}
			}
		}
		
		if (count == 1000) {
			System.out.println(-1);
		} else {
			System.out.println(count);
		}
	}
	
	public static void move(int x, int y, int number, int d) {
		int nextColor = checkColor(x, y, d);
		int pollCount = calculatePollCount(x, y ,number);
		
		if (nextColor == 2) {//파
			moveBlue(x, y, d, pollCount);
		} else if (nextColor == 1) {//빨
			moveRed(x, y, d, pollCount);
		} else {//흰
			moveWhite(x, y, d, pollCount);
		}
	}
	
	public static int checkColor(int x, int y, int d) {
		int nx = x + dx[d];
		int ny = y + dy[d];
		
		if (nx < 0 || nx >= n || ny < 0 || ny >= n) return 2;
		return color[nx][ny];
	}
	
	public static int calculatePollCount(int x, int y, int number) {
		
		int pollCount = 1;
		while (true) {
			Horse h = dq[x][y].pollFirst();
			
			if (h.number == number) {
				dq[x][y].addFirst(h);
				break;
			}
			pollCount++;
			dq[x][y].addLast(h);
		}
		return dq[x][y].size() - pollCount;
	}
	
	public static void moveWhite(int x, int y, int d, int pollCount) {
		int nx = x + dx[d];
		int ny = y + dy[d];
		
		for (int i = 0; i <= pollCount; i++) {
			Horse h = dq[x][y].pollFirst();
			dq[nx][ny].addLast(h);
			horses[h.number] = new Horse(nx, ny, h.number, h.d); 
		}
	}
	
	public static void moveRed(int x, int y, int d, int pollCount) {
		int nx = x + dx[d];
		int ny = y + dy[d];
		
		Stack<Horse> stack = new Stack<>();
		for (int i = 0; i <= pollCount; i++) {
			Horse h = dq[x][y].pollFirst();
			stack.push(h);
		}
		
		while (!stack.isEmpty()) {
			Horse h = stack.pop();
			dq[nx][ny].addLast(h);
			horses[h.number] = new Horse(nx, ny, h.number, h.d); 
		}
	}
	
	public static void moveBlue(int x, int y, int d, int pollCount) {
		int changeDir = resetDir(d);
		
		int nx = x + dx[changeDir];
		int ny = y + dy[changeDir];
		
		Horse h = dq[x][y].pollFirst();
		horses[h.number] = new Horse(x, y, h.number, changeDir);
		dq[x][y].addFirst(horses[h.number]);
		
		if (nx < 0 || nx >= n || ny < 0 || ny >= n || color[nx][ny] == 2) {
			for (int i = 0; i <= pollCount; i++) {
				h = dq[x][y].pollFirst();
				dq[x][y].addLast(h);
			}
			return;
		}
		if (color[nx][ny] == 0) {
			moveWhite(x, y, changeDir, pollCount);
			return;
		} 
		if (color[nx][ny] == 1) {
			moveRed(x, y, changeDir, pollCount);
			return;
		}
	}
	
	public static int resetDir(int d) {
		if (d == 0 || d == 1) {
			return (d+1) % 2;
		}
		if (d == 2) return 3;
		return 2;
	}
	
	public static boolean check() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (dq[i][j].size() >= 4) return true;
			}
		}
		return false;
	}
//	public static void printMap() {
//		for (int i = 0; i < n; i++) {
//			for (int j = 0; j < n; j++) {
//				System.out.print(dq[i][j].size() + " ");
//			}
//			System.out.println();
//		}
//		System.out.println();
//
//		for (int i = 0; i < n; i++) {
//			for (int j = 0; j < n; j++) {
//				if (dq[i][j].size() != 0) {
//					int size = dq[i][j].size();
//
//					for (int k = 0; k < size; k++) {
//						Horse h = dq[i][j].pollFirst();
//						System.out.print("number = " + h.number + ", dir = " + h.d + "   ||   ");
//						dq[i][j].addLast(h);
//					}
//					System.out.println();
//				}
//			}
//		}
//	}
}
/*
4 4
0 0 2 0
0 0 1 0
0 0 1 2
0 1 0 2
2 1 2
3 2 3
2 2 1
4 3 2 
 */
		