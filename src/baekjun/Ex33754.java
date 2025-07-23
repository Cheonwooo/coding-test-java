package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Ex33754 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[2][n];
		List<int[]> zeroPoint = new ArrayList<>();
		for (int i = 0; i < 2; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 0) zeroPoint.add(new int[] {i, j});
			}
		}
		
		if (zeroPoint.size() == 0) {
			System.out.println(2);
			return;
		}
		
		if (zeroPoint.size() == 1) {
			System.out.println(1);
			return;
		}
		
		int answer = 2;
		for (int i = 0; i < zeroPoint.size(); i++) {
			int[] now = zeroPoint.get(i);
			int x = now[0];
			int y = now[1];
			if (x == 0) {
				//첫 번째 행일 경우 
				//왼아 아 오아 확인
				//셋 중 하나라도 있다면 0
				//셋 다 없다면 1
				if (y == n-1) {
					if (arr[x+1][y-1] != 0 && arr[x+1][y] != 0) {
						answer = Math.min(answer, 1);
					} else if (arr[x+1][y-1] == 0 || arr[x+1][y] == 0) {
						answer = Math.min(answer, 0);
					}
				} else {
					if (arr[x+1][y-1] != 0 && arr[x+1][y] != 0 && arr[x+1][y+1] != 0) {
						answer = Math.min(answer, 1);
					} else if (arr[x+1][y-1] == 0 || arr[x+1][y] == 0 || arr[x+1][y+1] == 0) {
						answer = Math.min(answer, 0);
					}
				}
			} else {
				//두 번쨰 행일 경우
				//오위 위 왼위 확인
				//셋 중 하나라도 있다면 0
				//셋 다 없다면 1
				if (y == 0) {
					if (arr[x-1][y] != 0 && arr[x-1][y+1] != 0) {
						answer = Math.min(answer, 1);
					} else if (arr[x-1][y] == 0 || arr[x-1][y+1] == 0) {
						answer = Math.min(answer, 0);
					}
				} else {
					if (arr[x-1][y-1] != 0 && arr[x-1][y] != 0 && arr[x-1][y+1] != 0) {
						answer = Math.min(answer, 1);
					} else if (arr[x-1][y-1] == 0 || arr[x-1][y] == 0 || arr[x-1][y+1] == 0) {
						answer = Math.min(answer, 0);
					}
				}
			}
		}
		System.out.println(answer);
	}
}
