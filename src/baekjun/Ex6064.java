package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 아이디어
 * 브루트 포스
 * while문으로 x, y값을 1씩 증가하면서 cnt 증가
 * 만약 x<m, y<n인 구간이 나오면 x=1, y=1로 초기화
 * 
 * 시간복잡도
 * n
 * 
 * 자료구조
 * m,n,x,y,cnt값을 저장할 int
 * 
 */

public class Ex6064 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < t; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			boolean check = false;
			int m = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken())-1;
			int y = Integer.parseInt(st.nextToken())-1;
			
			for (int j = x; j < m*n ; j += m) {
				if (j % n == y) {
					sb.append(j + 1).append("\n");
					check = true;
					break;
				}
			}
			
			if (!check) {
				sb.append(-1).append("\n");
			}
		}
		System.out.println(sb);
	}

}
