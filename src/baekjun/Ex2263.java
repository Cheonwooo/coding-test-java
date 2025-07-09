package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex2263 {
	private static int[] inOrder, postOrder, inIndex;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		inOrder = new int[n+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i < n+1; i++) {
			inOrder[i] = Integer.parseInt(st.nextToken());
		}
		
		postOrder = new int[n+1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i < n+1; i++) {
			postOrder[i] = Integer.parseInt(st.nextToken());
		}
		
		inIndex = new int[n+1];
		for (int i = 1; i < n+1; i++) {
			inIndex[inOrder[i]] = i;
		}
		
		makeTree(1, n, 1, n);
		//1. postOder�� �ǳ��� ��Ʈ.
		//2. 1�� ��Ʈ������ inOrder���� index�� ã��
		//3. 2������ ���� index���� �������� �¿� ������.
	}
	
	private static void makeTree(int is, int ie, int ps, int pe) {
		if (ie < is || pe < ps) return;
		int root = postOrder[pe];
		int index = inIndex[root];
		System.out.print(root + " ");
		
		makeTree(is, index-1, ps, ps+index-is-1);
		makeTree(index+1, ie, ps+index-is, pe-1);
	}
}
