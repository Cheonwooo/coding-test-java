package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/*
 * 아이디어 : Collections.reverse()는 전체 리스트를 역순으로 바꾸는 것이므로 
 * 지정된 인덱스가 주어지는 경우엔 역순으로 정렬하기 힘들다. 따라서 반복문으로 수행 x
 * 자리값을 하나씩 옮기는게 아니라 전체를 역순으로 바꾸는 것이기 때문에 어떻게 해결해야 하는지 방법이
 * 생각이 안나서 원본 배열을 담는 list와 역순으로 바꾼 값들을 저장하는 reverseList 두개를 사용.
 * 
 * 시간복잡도 : m * 2*n = 10000
 * 
 * 자료구조 : List
 * 
 */

public class Ex10811_1 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		List<Integer> list = new ArrayList<Integer>();
		
		for (int i = 0; i < n; i++) {
			list.add(i+1);
		}
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			
			int p = Integer.parseInt(st.nextToken());
			int q = Integer.parseInt(st.nextToken());
			
			if(p==q) continue;
			
			List<Integer> reverseList = new ArrayList<Integer>();
			
			for(int j = p-1; j < q; j++) {
				reverseList.add(list.get(j));
			}
			
			Collections.reverse(reverseList);
			
			int index = 0;
			for(int j = p-1; j < q; j++,index++) {
				list.set(j, reverseList.get(index));
			}
		}
		
		for (int i = 0; i < n; i++) {
			System.out.print(list.get(i) + " ");
		}
	}

}
