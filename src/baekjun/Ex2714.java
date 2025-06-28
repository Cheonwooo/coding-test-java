package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Ex2714 {
	
	private static int r, c;
	private static int[] dx = {0, 1, 0, -1};
	private static int[] dy = {1, 0, -1, 0};
	private static int[][] arr;
	private static Map<Integer, Character> map = new HashMap<>();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		map.put(0, ' ');
		for (int i = 0; i < 26; i++) {
			map.put(i+1, (char)(i + 'A'));
		}
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			String message = st.nextToken();
			
			if (r * c < 5) {
				sb.append("\n");
				continue;
			}
			
			arr = new int[r][c];
			
			int index = 0;
			for (int i = 0; i < r; i++) {
				for (int j = 0; j < c; j++) {
					arr[i][j] = message.charAt(index++) - '0';
				}
			}
			
			message = translateMessage(0, 0);
			sb.append(decodeMessage(message) + "\n");
		}
		System.out.println(sb);
	}
	
	private static String translateMessage(int x, int y) {
		String transMessage = String.valueOf(arr[x][y]);
		boolean[][] visited = new boolean[r][c];
		
		visited[x][y] = true;
		int count = 1;
		int dir = 0;
		while (true) {
			if (count == r*c) break;
			
			int nx = x + dx[dir];
			int ny = y + dy[dir];
			
			if (nx < 0 || nx >= r || ny < 0 || ny >= c || visited[nx][ny]) {
				nx = x;
				ny = y;
				dir = (dir + 1) % 4;
				continue;
			}
			
			visited[nx][ny] = true;
			transMessage += String.valueOf(arr[nx][ny]);
			count++;
			x = nx;
			y = ny;
		}
		
		return transMessage;
	}

	private static String decodeMessage(String message) {
		String answer = "";
		
		for (int i = 0; i <= message.length() - 5; i+=5) {
			String subMessage = message.substring(i, i + 5);
			
			int decodeNumber = 0;
			for (int j = subMessage.length() - 1; j >= 0; j--) {
				if (subMessage.charAt(j) == '1') {
					decodeNumber += (int)Math.pow(2, 5-j-1);
				}
			}
			
			answer += map.get(decodeNumber);
		}
		return answer.trim();
	}
}

