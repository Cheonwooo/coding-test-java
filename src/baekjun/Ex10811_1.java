package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/*
 * ���̵�� : Collections.reverse()�� ��ü ����Ʈ�� �������� �ٲٴ� ���̹Ƿ� 
 * ������ �ε����� �־����� ��쿣 �������� �����ϱ� �����. ���� �ݺ������� ���� x
 * �ڸ����� �ϳ��� �ű�°� �ƴ϶� ��ü�� �������� �ٲٴ� ���̱� ������ ��� �ذ��ؾ� �ϴ��� �����
 * ������ �ȳ��� ���� �迭�� ��� list�� �������� �ٲ� ������ �����ϴ� reverseList �ΰ��� ���.
 * 
 * �ð����⵵ : m * 2*n = 10000
 * 
 * �ڷᱸ�� : List
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
