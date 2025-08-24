package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex22251 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[][] number = new int[10][7];
		number[0] = new int[] {1,1,1,0,1,1,1};
		number[1] = new int[] {0,0,1,0,0,0,1};
		number[2] = new int[] {0,1,1,1,1,1,0};
		number[3] = new int[] {0,1,1,1,0,1,1};
		number[4] = new int[] {1,0,1,1,0,0,1};
		number[5] = new int[] {1,1,0,1,0,1,1};
		number[6] = new int[] {1,1,0,1,1,1,1};
		number[7] = new int[] {0,1,1,0,0,0,1};
		number[8] = new int[] {1,1,1,1,1,1,1};
		number[9] = new int[] {1,1,1,1,0,1,1};
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int p = Integer.parseInt(st.nextToken());
		String x = st.nextToken();
		
		if (k > x.length()) {
			String pre = "";
			for (int i = 0; i < k - x.length(); i++) {
				pre += "0";
			}
			x = pre + x;
		}
		
		int answer = 0;
		for (int i = 1; i <= n; i++) {
			String num = String.valueOf(i);
			
			if (num.length() < k) {
				String pre = "";
				for (int j = 0; j < k - num.length(); j++) {
					pre += "0";
				}
				num = pre + num;
			}
			
			if (num.equals(x)) continue;
			//num과 x 비교
			int count = 0;
			for (int j = 0; j < k; j++) {
				for (int m = 0; m < 7; m++) {
					if (number[num.charAt(j)-'0'][m] != number[x.charAt(j)-'0'][m]) {
						count++;
					}
				}
			}
			
			if (count <= p) {
				answer++;
			}
		}
		System.out.println(answer);
		
	}

}
