package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Ex25631 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] mart = new int[n];
		int[] remain = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			mart[i] = Integer.parseInt(st.nextToken());
			remain[i] = mart[i];
		}
		
		Arrays.sort(mart);
		Arrays.sort(remain);
		
		int remainCount = n;
		for (int i = 0; i < n - 1; i++) {
			for (int j = i + 1; j < n; j++) {
				if (remain[j] > mart[i]) {
					remain[j] -= mart[i];
					remainCount--;
					break;
				}
			}
		}
		System.out.println(remainCount);
	}

}
/*
 * 1 2 3
 * 
 * 1 2 2 4
 * 2 2 3 3 3 4 5
 * 
 * -> 그리디?
 * -> 앞에서부터 하나씩 넣어가면 될듯?
 * -> int[]는 두개로. 원래의 값과 남아있는 공간의 값을 저장하는 용도
 * -> 돌면서 남아있는 공간의 값이 충분하다면 해당 인덱스값 삭제하기.
 * -> 근데 꾸역꾸역 잘 넣는 방법이 있을 것 같은데...
 * */
