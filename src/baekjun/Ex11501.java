package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Ex11501 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			int n = Integer.parseInt(br.readLine());
			int[] arr = new int[n];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			long sum = 0;
			int max = arr[n-1];
			List<Integer> index = new ArrayList<>();
			index.add(n-1);
			//뒤에서 부터 시작
			//끝값이 max
			//max 보다 큰값이 나오면 체크
			for (int i = n-2; i >= 0; i--) {
				if (max < arr[i]) {
					index.add(i);
					max = arr[i];
				}
			}
			
			Collections.sort(index);
			int start = 0;
			for (int i = 0; i < index.size(); i++) {
				for (int j = start; j <= index.get(i); j++) {
					int profit = arr[index.get(i)] - arr[j];
					sum += profit;
				}
				start = index.get(i) + 1;
			}
			
			System.out.println(sum);
		}
	}

}
// 1 1 1 3 1 2 4 1