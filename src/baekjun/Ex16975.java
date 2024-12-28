package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 메모리 65384kb, 시간 1120ms

public class Ex16975 {
	
	private static int n, len = 1 << 17;
	private static int size = 1 << 18;
	private static int[] arr;
	private static long[] tree;
	private static long[] lazy;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		
		tree = new long[size];
		lazy = new long[size];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		makeTree();
		
		int m = Integer.parseInt(br.readLine());
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int command = Integer.parseInt(st.nextToken());
			
			if (command == 1) {
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				int value = Integer.parseInt(st.nextToken());
				update(1, 0, len-1, start-1, end-1, value);
				
			} else {
				int index = Integer.parseInt(st.nextToken());
				System.out.println(get(1, 0, len-1, index-1, index-1));
			}
		}
	}
	
	public static void propagate(int idx, int s, int e) {
		if(idx < len){//리프가 아니라면
            lazy[2 * idx] += lazy[idx];
            lazy[2 * idx + 1] += lazy[idx];
        }
        tree[idx] += lazy[idx] * (e - s + 1);
        lazy[idx] = 0;
	}
	
	public static void makeTree() {
		for (int i = 0; i < n; i++) {
			tree[len+i] = arr[i]; 
		}
		
		for (int i = len-1; i >= 1; i--) {
			tree[i] = tree[2*i] + tree[2*i + 1];
		}
	}
	
	public static void update(int idx, int s, int e, int ts, int te, int value) {
		propagate(idx, s, e);
        
        if(s > te || e < ts) return;
        else if(ts <= s && e <= te){
            lazy[idx] = value;
            propagate(idx, s, e);
            return;
        }
        
        int mid = (s + e) / 2;
        
        update(2 * idx, s, mid, ts, te, value);
        update(2 * idx + 1, mid + 1, e, ts, te, value);
        
        tree[idx] = tree[2 * idx] + tree[2 * idx + 1];
	}
	
	public static long get(int idx, int s, int e, int ts, int te) {
		propagate(idx, s, e);
		
		if (s > te || e < ts) return 0;
		else if (ts <= s && e <= te) return tree[idx];
		
		int mid = (s + e) / 2;
		
		long left = get(2*idx, s, mid, ts, te);
		long right = get(2*idx+1, mid + 1, e, ts, te);
		
		return left + right;
	}
}
