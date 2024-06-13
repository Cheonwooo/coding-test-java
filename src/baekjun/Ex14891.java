package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex14891 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[][] gears = new int[4][8];
		for (int i = 0; i < 4; i++) {
			String[] str = br.readLine().split("");
			for (int j = 0; j < 8; j++) {
				gears[i][j] = Integer.parseInt(str[j]);
			}
		}
		
		int k = Integer.parseInt(br.readLine());
		for (int i = 0; i < k; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int gearNumber = Integer.parseInt(st.nextToken())-1;
			int dir = Integer.parseInt(st.nextToken());
			boolean[] checkTurn = new boolean[4];
			int[] turnDir = new int[4];
			
			move(checkTurn, gears, turnDir, gearNumber, dir);
		}
		
		int answer = calculateScore(gears);
		System.out.println(answer);
	}
	
	public static int[][] move(boolean[] checkTurn, int[][] gears, int[] turnDir, int gearNumber, int dir) {
		int rightDir = dir;
		int leftDir = dir;
		int number = gearNumber;
		checkTurn[number] = true;
		turnDir[number] = dir;
		while (true) {
			if (rightCheck(gears, number)) {
				checkTurn[number+1] = true;
				if(rightDir == 1) {
					turnDir[number+1] = -1;
					rightDir = -1;
				} else {
					turnDir[number+1] = 1;
					rightDir = 1;
				}
				number++;
			} else break;
		}
		
		number = gearNumber;
		while (true) {
			if (leftCheck(gears, number)) {
				checkTurn[number-1] = true;
				if (leftDir == 1) {
					turnDir[number-1] = -1;
					leftDir = -1;
				} else {
					turnDir[number-1] = 1;
					leftDir = 1;
				}
				number--;
			} else break;
		}
		
		for (int i = 0; i < 4; i++) {
			if (checkTurn[i]) {
				if (turnDir[i] == 1) {
					turn(gears, i);
				} else {
					turnReverse(gears, i);
				}
			}
		}
		return gears;
	}
	
	public static boolean rightCheck(int[][] gears, int gearNumber) {
		if (gearNumber + 1 >= 4) return false;
		if (gears[gearNumber][2] == gears[gearNumber+1][6]) return false;
		return true;
	}
	
	public static boolean leftCheck(int[][] gears, int gearNumber) {
		if (gearNumber - 1 < 0) return false;
		if (gears[gearNumber][6] == gears[gearNumber-1][2]) return false;
		return true;
	}
	
	public static void turn(int[][] gears, int gearNumber) {
		int temp = gears[gearNumber][7];
		for (int i = 7; i >= 1; i--) {
			gears[gearNumber][i] = gears[gearNumber][i-1];
		}
		gears[gearNumber][0] = temp;
	}
	
	public static void turnReverse(int[][] gears, int gearNumber) {
		int temp = gears[gearNumber][0];
		for (int i = 0; i < 7; i++) {
			gears[gearNumber][i] = gears[gearNumber][i+1];
		}
		gears[gearNumber][7] = temp;
	}
	
	public static int calculateScore(int[][] gears) {
		int sum = 0;
		for (int i = 0; i < 4; i++) {
			if (gears[i][0] == 1) {
				sum += (int)Math.pow(2, i);
			}
		}
		return sum;
	}

}
