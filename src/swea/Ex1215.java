package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex1215 {
	private static int[] dx = {0, 1};
	private static int[] dy = {1, 0};

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for (int t = 1; t <= 10; t++) {
			sb.append("#" + t + " ");
			
			int n = Integer.parseInt(br.readLine());
			String[][] arr = new String[8][8];
			
			for (int i = 0; i < 8; i++) {
				String[] words = br.readLine().split("");
				for (int j = 0; j < 8; j++) {
					arr[i][j] = words[j];
				}
			}
			int count = countRow(arr, n) + countColumn(arr, n);
			
			sb.append(count).append("\n");
		}
		System.out.println(sb);
	}
	
	public static int countRow(String[][] arr, int n) {
		int count = 0;
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j <= 8-n; j++) {
				int cx = i;
				int cy = j;
				String str = arr[cx][cy];
				for (int l = 1; l < n; l++) {
					int nx = cx + dx[0];
					int ny = cy + dy[0];
					
					str += arr[nx][ny];
					cx = nx;
					cy = ny;
				}
				if (!checkWord(str)) {
					count++;
				}
			}
		}
		return count;
	}
	
	public static int countColumn(String[][] arr, int n) {
		int count = 0;
		for (int i = 0; i <= 8-n; i++) {
			for (int j = 0; j < 8; j++) {
				int cx = i;
				int cy = j;
				String str = arr[cx][cy];
				for (int l = 1; l < n; l++) {
					int nx = cx + dx[1];
					int ny = cy + dy[1];
					
					str += arr[nx][ny];
					cx = nx;
					cy = ny;
				}
				if (!checkWord(str)) {
					count++;
				}
			}
		}
		return count;
	}
	
	public static boolean checkWord(String str) {
		int left = 0;
		int right = str.length()-1;
		boolean check = false;
		
		while (left < right) {
			if (str.charAt(left) != str.charAt(right)) {
				check = true;
				break;
			}
			
			left++;
			right--;
		}
		
		return check;
	}

}
