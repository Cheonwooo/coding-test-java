package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Ex4013 {
	private static class Wheel {
		int num;
		int d;

		public Wheel(int num, int d) {
			this.num = num;
			this.d = d;
		}

		@Override
		public String toString() {
			return "Wheel [num=" + num + ", d=" + d + "]";
		}
		
	}

	private static int[] d = {1, -1};
	private static int[][] wheels;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			int k = Integer.parseInt(br.readLine());
			
			StringTokenizer st;
			wheels = new int[4][8];
			for (int i = 0; i < 4; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 8; j++) {
					wheels[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			Queue<Wheel> q = new LinkedList<>();
			for (int i = 0; i < k; i++) {
				st = new StringTokenizer(br.readLine());
				
				int wheelNum = Integer.parseInt(st.nextToken())-1; 
				int dir = Integer.parseInt(st.nextToken());
				
				
				List<Wheel> moveWheels = new ArrayList<>();
				checkWheel(q, moveWheels, wheelNum, dir);
				moveWheels.add(new Wheel(wheelNum, dir));
				for (Wheel w : moveWheels) {
					move(w);
				}
			}
			
			int answer = calculateAnswer();
			sb.append("#" + t + " " + answer + "\n");
		}
		System.out.println(sb);
	}
	
	private static int calculateAnswer() {
		int sum = 0;
		for (int i = 0; i < 4; i++) {
			if (wheels[i][0] == 1) {
				if (i == 0) sum += 1;
				else if (i == 1) sum += 2;
				else if (i == 2) sum += 4;
				else if (i == 3) sum += 8;
			}
		}
		return sum;
	}

	private static void checkWheel(Queue<Wheel> q, List<Wheel> moveWheels, int wheelNum, int dir) {
		for (int j = 0; j < 2; j++) {
			q.add(new Wheel(wheelNum, dir));
			while (!q.isEmpty()) {
				Wheel wheel = q.poll();
				int wNum = wheel.num;
				int direction = wheel.d;

				int nextWheel = wNum + d[j];
				if (nextWheel < 0 || nextWheel >= 4) break;
				if (j == 0) {//오른쪽
					if (wheels[wNum][2] == wheels[nextWheel][6]) break; //극이 다르다면
					q.add(new Wheel(nextWheel, direction * (-1)));
					moveWheels.add(new Wheel(nextWheel, direction * (-1)));
				} else {//왼쪽
					if (wheels[wNum][6] == wheels[nextWheel][2]) break;
					q.add(new Wheel(nextWheel, direction * (-1)));
					moveWheels.add(new Wheel(nextWheel, direction * (-1)));
				}
			}
		}		
	}

	public static void move(Wheel wheel) {
		int num = wheel.num;
		int d = wheel.d;
		if (d == 1) {//시계방향
			int temp = wheels[num][7];
			for (int i = 7; i > 0; i--) {
				wheels[num][i] = wheels[num][i-1];
			}
			wheels[num][0] = temp;
		} else {//반시계방향
			int temp = wheels[num][0];
			for (int i = 0; i < 7; i++) {
				wheels[num][i] = wheels[num][i+1];
			}
			wheels[num][7] = temp;
		}
	}

}
