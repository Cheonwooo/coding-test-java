package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex19637 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] arr = new int[n+1];
		String[] name = new String[n+1];
		
		arr[0] = 0;
		for (int i = 1; i < n+1; i++) {
			st = new StringTokenizer(br.readLine());
			String designation = st.nextToken();
			int power = Integer.parseInt(st.nextToken());
			
			arr[i] = power;
			name[i] = designation;
		}
		name[0] = name[1];
		
		for (int j = 0; j < m; j++) {
			int po = Integer.parseInt(br.readLine());
			int left = 0;
			int right= n;

			while (left <= right) {
				int mid = (left + right) / 2;
				
				if (po > arr[mid]) {
					left = mid + 1;
				} else {
					right = mid - 1;
				}
			}
			sb.append(name[left] + "\n");
		}
		System.out.println(sb);
	}

}
