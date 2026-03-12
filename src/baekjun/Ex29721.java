package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Ex29721 {
	
	private static int[] dx = {-2, 0, 2, 0};
	private static int[] dy = {0, 2, 0, -2};

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		List<int[]> chess = new ArrayList<>();
		Set<String> set = new HashSet<>();
		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken())-1;
			int y = Integer.parseInt(st.nextToken())-1;
			
			String key = String.valueOf(x) + " " + String.valueOf(y);
			set.add(key);
			chess.add(new int[] {x, y});
			for (int j = 0; j < 4; j++) {
				int nx = x + dx[j];
				int ny = y + dy[j];
				
				if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
				key = String.valueOf(nx) + " " + String.valueOf(ny);
				if (!set.contains(key)) set.add(key);
			}
		}
		
		System.out.println(set.size() - k);
	}
}
