package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


//메모리 121692kb 시간 504ms

public class Ex12738 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		int[] list = new int[arr.length];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int index = 0;
		list[index++] = arr[0];
		
		for (int i = 1; i < arr.length; i++) {
			int temp = Arrays.binarySearch(list, 0, index, arr[i]);
			if (temp < 0) {
				temp = Math.abs(temp) - 1;
			}
			list[temp] = arr[i];
			if (temp == index) {
				index++;
			}
		}
		
		System.out.println(index);
	}

}
