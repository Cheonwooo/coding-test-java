package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex17822 {
	private static int n, m;
	private static int[] dx = { -1, 0, 1, 0 };
	private static int[] dy = { 0, 1, 0, -1 };
	private static int[][] arr, temp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(st.nextToken());
		arr = new int[n + 1][m + 1];

		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < t; i++) {
			st = new StringTokenizer(br.readLine());

			int x = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());// 0시계 1반시계
			int k = Integer.parseInt(st.nextToken());

			temp = new int[n+1][m+1];
			temp = copyMap(arr);
			rotate(x, d, k);
//			printMap();
			arr = copyMap(temp);
			checkSameNumber();
			arr = copyMap(temp);
//			printMap();
		}
		System.out.println(calculateSum());
	}
	
	public static int[][] copyMap(int[][] original) {
		int[][] copy = new int[n+1][m+1];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				copy[i][j] = original[i][j];
			}
		}
		return copy;
	}

	public static void rotate(int x, int d, int k) {
		for (int i = 0; i < k; i++) {
			if (d == 0) {
				rotateForward(x);
			} else {
				rotateReverse(x);
			}
		}
	}

	public static void rotateForward(int x) {
		for (int i = x; i < arr.length; i += x) {
			int tempNumber = temp[i][arr[i].length - 1];
			for (int j = arr[i].length - 1; j > 1; j--) {
				temp[i][j] = temp[i][j - 1];
			}
			temp[i][1] = tempNumber;
		}
	}

	public static void rotateReverse(int x) {
		for (int i = x; i < arr.length; i += x) {
			int tempNumber = temp[i][1];
			for (int j = 1; j < arr[i].length - 1; j++) {
				temp[i][j] = temp[i][j+1];
			}
			temp[i][arr[i].length-1] = tempNumber;
		}
	}
	
	public static void checkSameNumber() {
		boolean isSame = false;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (arr[i][j] != 0 && isSameNumber(i, j)) {
					isSame = true;
				}
			}
		}
		if (!isSame) {
			fixNumber();
		}
	}
	
	public static boolean isSameNumber(int x, int y) {
		boolean isSame = false;
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if (nx < 1 || nx > n) continue;
			if (ny == 0) ny = m;
			if (ny == arr[nx].length) ny = 1;
			if (arr[x][y] == arr[nx][ny]) {
				isSame = true;
				temp[nx][ny] = 0;
			}
		}
		if (isSame) temp[x][y] = 0;
		
		return isSame;
	}
	
	public static void fixNumber() {
		double avg = calculateAvg();
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (temp[i][j] != 0) {
					if (temp[i][j] < avg) {
						temp[i][j] += 1;
					} else if (temp[i][j] > avg) {
						temp[i][j] -= 1;
					}
				}
			}
		}
	}
	
	public static double calculateAvg() {
		int sum = 0;
		int count = 0;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (temp[i][j] != 0) {
					sum += temp[i][j];
					count++;
				}
			}
		}
		return (double)sum/count;
	}
	
	public static int calculateSum() {
		int sum = 0;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				sum += temp[i][j];
			}
		}
		return sum;
	}
	
	public static void printMap() {
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				System.out.print(temp[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
}
