package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Ex28456 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		Deque<Integer>[] dq = new Deque[n];
		for (int i = 0; i < n; i++) {
			dq[i] = new LinkedList<>();
		}
		
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				dq[i].addLast(Integer.parseInt(st.nextToken()));
			}
		}
		
		int q = Integer.parseInt(br.readLine());
		for (int i = 0; i < q; i++) {
			String[] option = br.readLine().split(" ");
			
			if (option[0].equals("1")) {
				int row = Integer.parseInt(option[1]) - 1;
				dq[row].addFirst(dq[row].pollLast());
			} else {
				Deque<Integer>[] newDq = new Deque[n];
				for (int j = 0; j < n; j++) {
					newDq[j] = new LinkedList<>();
				}
				for (int j = 0; j < n; j++) {
					for (int k = 0; k < n; k++) {
						newDq[k].addFirst(dq[j].pollFirst());
					}
				}
				dq = newDq;
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(dq[i].pollFirst() + " ");
			}
			System.out.println();
		}
	}

}
