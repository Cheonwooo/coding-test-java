package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

/*
 * ���̵�� : TreeSet�� �̿��ؼ� ���İ� �ߺ� ���ÿ� ���
 * Map�� �� ����
 * �ð����⵵�� �ʹ� ū ��� Map�� Ȱ������
 * 
 * �ð����⵵ : n
 * 
 * �ڷᱸ�� : Set(TreeSet), Map, int[]
 */

public class Ex18870 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Set<Integer> set = new TreeSet<>();
		for (int i = 0; i < n; i++) {
			set.add(arr[i]);
		}
		
		int index = 0;
		Map<Integer, Integer> map = new HashMap<>();
		for (int number : set) {
			map.put(number, index);
			index++;
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			sb.append(map.get(arr[i])).append(" ");
		}
		System.out.println(sb);
	}
}
