package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Ex20061 {
	
	private static int answer = 0;
	private static int[] dx = {0, 1};
	private static int[] dy = {1, 0};
	private static boolean[][] blue = new boolean[4][10];
	private static boolean[][] green = new boolean[10][4];
	

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int t = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			
			start(t, x, y);
//			printMap();
		}
		System.out.println(answer);
		System.out.println(calculateColorBlock());
	}
	
	public static void start(int t, int x, int y) {
		overloadBlock(t, x, y);
		calculateScore();
		pullUncoloredBlock();
	}

	public static void overloadBlock(int t, int x, int y) {
		int cx = x;
		int cy = y;
		if (t == 1) {
			while (true) {
				int nx = cx + dx[0];
				int ny = cy + dy[0];
				if (ny == 10 || blue[nx][ny]) {
					blue[cx][cy] = true;
					break;
				}
				cx = nx;
				cy = ny;
			}
			
			cx = x;
			cy = y;
			while (true) {
				int nx = cx + dx[1];
				int ny = cy + dy[1];
				if (nx == 10 || green[nx][ny]) {
					green[cx][cy] = true;
					break;
				}
				cx = nx;
				cy = ny;
			}
		} else if (t == 2) {
			while (true) {
				int nx = cx + dx[0];
				int ny = cy + dy[0];
				if ((ny+1) == 10 || blue[nx][ny+1]) {
					blue[cx][cy] = true;
					blue[cx][cy+1] = true;
					break;
				}
				cx = nx;
				cy = ny;
			}
			
			cx = x;
			cy = y;
			while (true) {
				int nx = cx + dx[1];
				int ny1 = cy + dy[1];
				int ny2 = cy+1 + dy[1];
				
				if (nx == 10 || green[nx][ny2] || green[nx][ny1]) {
					green[cx][cy] = true;
					green[cx][cy+1] = true;
					break;
				}
				cx = nx;
				cy = ny1;
			}
		} else {
			while (true) {
				int nx1 = cx + dx[0];
				int nx2 = cx+1 + dx[0];
				int ny = cy + dy[0];
				
				if (ny == 10 || blue[nx1][ny] || blue[nx2][ny]) {
					blue[cx][cy] = true;
					blue[cx+1][cy] = true;
					break;
				}
				cx = nx1;
				cy = ny;
			}
			
			cx = x;
			cy = y;
			while (true) {
				int nx = cx + dx[1];
				int ny = cy + dy[1];
				
				if ((nx+1) == 10 || green[nx+1][ny]) {
					green[cx+1][cy] = true;
					green[cx][cy] = true;
					break;
				}
				cx = nx;
				cy = ny;
			}
		}
	}
	
	
	public static void calculateScore() {
		addBlueScore();
		addGreenScore();
	}
	
	public static void addBlueScore() {
		List<Integer> blueDeleteBlockLine = new ArrayList<>();
		for (int i = 6; i < 10; i++) {
			int count = 0;
			for (int j = 0; j <4; j++) {
				if (blue[j][i]) count++;
			}
			
			if (count == 4) {
				answer++;
				blueDeleteBlockLine.add(i);
				for (int j = 0; j < 4; j++) {
					blue[j][i] = false;
				}
			}
		}
		if (blueDeleteBlockLine.size() != 0) {
			pullBlueOneBlock(blueDeleteBlockLine);
		}
	}
	
	public static void addGreenScore() {
		List<Integer> greenDeleteBlockLine = new ArrayList<>();
		//green
		for (int i = 6; i < 10; i++) {
			int count = 0;
			for (int j = 0; j < 4; j++) {
				if (green[i][j]) count++;
			}
			
			if (count == 4) {
				answer++;
				greenDeleteBlockLine.add(i);
				for (int j = 0; j < 4; j++) {
					green[i][j] = false;
				}
			}
		}
		if (greenDeleteBlockLine.size() != 0) {
			pullGreenOneBlock(greenDeleteBlockLine);
		}
	}
	
	public static void pullBlueOneBlock(List<Integer> blueDeleteBlockLine) {
		for (int index : blueDeleteBlockLine) {
			for (int i = 0; i < 4; i++) {
				for (int j = index; j > 4; j--) {
					blue[i][j] = blue[i][j-1];
				}
				blue[i][4] = false;
			}
		}
	}
	
	public static void pullGreenOneBlock(List<Integer> greenDeleteBlockLine) {
		for (int index : greenDeleteBlockLine) {
			for (int i = 0; i < 4; i++) {
				for (int j = index; j > 4; j--) {
					green[j][i] = green[j-1][i];
				}
				green[4][i] = false;
			}
		}
	}
	
	public static void printMap() {
		System.out.println("=========blue=========");
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 10; j++) {
				if(!blue[i][j]) System.out.print(0 + " ");
				else System.out.print(1 + " ");
			}
			System.out.println();
		}
		
		System.out.println("=========green========");
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 4; j++) {
				if(!green[i][j]) System.out.print(0 + " ");
				else System.out.print(1 + " ");
			}
			System.out.println();
		}
	}
	
	public static void pullUncoloredBlock() {
		int blueCount = checkBlue();
		pullBlueAllBlock(blueCount);
		int greenCount = checkGreen();
		pullGreenAllBlock(greenCount);
	}
	
	public static int checkBlue() {
		int count = 0;
		for (int i = 4; i < 6; i++) {
			for (int j = 0; j < 4; j++) {
				if (blue[j][i]) {
					count++;
					break;
				}
			}
		}
		return count;
	}
	
	public static int checkGreen() {
		int count = 0;
		for (int i = 4; i < 6; i++) {
			for (int j = 0; j < 4; j++) {
				if (green[i][j]) {
					count++;
					break;
				}
			}
		}
		return count;
	}
	
	public static void pullBlueAllBlock(int count) {
		while (count-- > 0) {
			for (int i = 0; i < 4; i++) {
				for (int j = 9; j > 4; j--) {
					blue[i][j] = blue[i][j-1];
				}
				blue[i][4] = false;
			}
		}
	}
	
	public static void pullGreenAllBlock(int count) {
		while (count-- > 0) {
			for (int i = 0; i < 4; i++) {
				for (int j = 9; j > 4; j--) {
					green[j][i] = green[j-1][i];
				}
				green[4][i] = false;
			}
		}
	}
	
	public static int calculateColorBlock() {
		int blueSum = calculateBlueBlock();
		int greenSum = calculateGreenBlock();
		return blueSum + greenSum;
	}
	
	public static int calculateBlueBlock() {
		int sum = 0;
		for (int i = 0; i < 4; i++) {
			for (int j = 6; j < 10; j++) {
				if (blue[i][j]) sum++;
			}
		}
		return sum;
	}
	
	public static int calculateGreenBlock() {
		int sum = 0;
		for (int i = 0; i < 4; i++) {
			for (int j = 6; j < 10; j++) {
				if (green[j][i]) sum++;
			}
		}
		return sum;
	}
}