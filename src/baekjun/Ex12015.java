package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

//¸Þ¸ô 121284kb, ½Ã°£ 748ms

public class Ex12015 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		
		List<Integer> list = new ArrayList<>();
		list.add(0);
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			
			if (list.get(list.size()-1) < arr[i]) {
				list.add(arr[i]);
			} else {
				int left = 0;
				int right = list.size()-1;

				while (left < right) {
					int mid = (left + right) / 2;
					if (list.get(mid) < arr[i]) {
						left = mid + 1;
					} else {
						right = mid;
					}
				}
				list.set(right, arr[i]);
			}
		}
		
		System.out.println(list.size()-1);
	}

}
