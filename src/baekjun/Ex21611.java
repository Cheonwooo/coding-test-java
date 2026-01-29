package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Ex21611 {
	
	private static int n;
	private static int[] dx = {-1, 1, 0, 0};
	private static int[] dy = {0, 0, -1, 1};
	private static int[] bdx = {0, 1, 0, -1};
	private static int[] bdy = {-1, 0, 1, 0};
	private static int[] bombCount = new int[4];
	private static int[][] arr;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		arr = new int[n][n];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			
			int d = Integer.parseInt(st.nextToken()) - 1;
			int s = Integer.parseInt(st.nextToken());
			
			breakBead(d, s);
			explodeBead();
			remakeArr();
		}
		int answer = calculateAnswer();
		System.out.println(answer);
	}
	
	private static void breakBead(int d, int s) {
		int cx = n/2;
		int cy = n/2;
		for (int i = 0; i < s; i++) {
			int nx = cx + dx[d] * (i + 1);
			int ny = cy + dy[d] * (i + 1);
			
			arr[nx][ny] = 0;
		}
	}
	
	private static void printBead() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	private static void explodeBead() {
		boolean isBroken = true;
		while (true) {
			if (!isBroken) break;
			isBroken = false;
			
			Queue<int[]> savedPos = new LinkedList<>();
			int sd = 0;
			int sx = n/2 + bdx[sd];
			int sy = n/2 + bdy[sd++];
			int preNumber = arr[sx][sy];
			savedPos.offer(new int[] {sx, sy});

			int dCount = 1;//d 방향으로 움직이는 횟수
			int dChangeCount = 1;//dCount의 횟수를 카운트하는 변수
			int duplicatedNumber = 1;
			while (sx != 0 || sy != 0) {
				if (dChangeCount == 2) {
					dChangeCount = 0;
					dCount++;
				}
				dChangeCount++;
				
				for (int i = 0; i < dCount; i++) {
					int nx = sx + bdx[sd];
					int ny = sy + bdy[sd];
				
					if (nx < 0 || nx >= n || ny < 0 || ny >= n) break;
					if (arr[nx][ny] == preNumber && arr[nx][ny] != 0) {
						duplicatedNumber++;
						savedPos.offer(new int[] {nx, ny});
					} else if (arr[nx][ny] != preNumber && arr[nx][ny] != 0){
						if (duplicatedNumber >= 4) {
							bombCount[preNumber] += duplicatedNumber;
							
							while (!savedPos.isEmpty()) {
								int[] cur = savedPos.poll();
								
								arr[cur[0]][cur[1]] = 0;
							}
							isBroken = true;
						}
						duplicatedNumber = 1;
						preNumber = arr[nx][ny];
						savedPos.clear();
						savedPos.offer(new int[] {nx, ny});
					}
					
					sx = nx;
					sy = ny;
				}
				sd = (sd + 1) % 4;
			}
			if (duplicatedNumber >= 4) {
				bombCount[preNumber] += duplicatedNumber;
				
				while (!savedPos.isEmpty()) {
					int[] cur = savedPos.poll();
					
					arr[cur[0]][cur[1]] = 0;
				}
				isBroken = true;
			}
		}
	}
	
	private static void remakeArr() {
		Queue<Integer> duplicatedCountAndNumber = new LinkedList<>();
		countDuplicatedNumber(duplicatedCountAndNumber);
		makeNewArr(duplicatedCountAndNumber);
		
	}
	
	private static void countDuplicatedNumber(Queue<Integer> duplicatedCountAndNumber) {
		int sd = 0;
		int sx = n/2 + bdx[sd];
		int sy = n/2 + bdy[sd++];
		int preNumber = arr[sx][sy];
		
		int dCount = 1;
		int dChangeCount = 1;
		int duplicatedNumber = 1;
		while (sx != 0 || sy != 0) {
			if (dChangeCount == 2) {
				dChangeCount = 0;
				dCount++;
			}
			dChangeCount++;
			
			for (int i = 0; i < dCount; i++) {
				int nx = sx + bdx[sd];
				int ny = sy + bdy[sd];

				if (nx < 0 || nx >= n || ny < 0 || ny >= n) break;
				
				if (arr[nx][ny] == preNumber && arr[nx][ny] != 0) {
					duplicatedNumber++;
				} else if (arr[nx][ny] != preNumber && arr[nx][ny] != 0) {
					if (preNumber == 0) {
						preNumber = arr[nx][ny];
						sx = nx;
						sy = ny;
						continue;
					}
					duplicatedCountAndNumber.offer(duplicatedNumber);
					duplicatedCountAndNumber.offer(preNumber);
					duplicatedNumber = 1;
					preNumber = arr[nx][ny];
				}
				sx = nx;
				sy = ny;
			}
			sd = (sd + 1) % 4;
		}
		if (preNumber != 0) {
			duplicatedCountAndNumber.offer(duplicatedNumber);
			duplicatedCountAndNumber.offer(preNumber);
		}
	}
	
	private static void makeNewArr(Queue<Integer> duplicatedCountAndNumber) {
		arr = new int[n][n];
		int sd = 0;
		int sx = n/2;
		int sy = n/2;
		
		int dCount = 1;
		int dChangeCount = 0;
		
		while (!duplicatedCountAndNumber.isEmpty()) {
			if (sx == 0 && sy == 0) break;
			if (dChangeCount == 2) {
				dChangeCount = 0;
				dCount++;
			}
			dChangeCount++;
			
			for (int i = 0; i < dCount; i++) {
				int nx = sx + bdx[sd];
				int ny = sy + bdy[sd];
				
				if (duplicatedCountAndNumber.isEmpty()) break;
				if (nx < 0 || nx >= n || ny < 0 || ny >= n) break;
				
				int next = duplicatedCountAndNumber.poll();
				arr[nx][ny] = next;
				sx = nx;
				sy = ny;
			}
			sd = (sd + 1) % 4;
		}
	}
	
	private static int calculateAnswer() {
		int answer = 0;
		for (int i = 1; i < 4; i++) {
			answer += i * bombCount[i];
		}
		return answer;
	}
}
