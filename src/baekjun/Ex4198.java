package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex4198 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        
        int max = 0;
        for (int i = 0; i < n; i++) {
        	int[] lis = new int[n+1];
        	int[] lds = new int[n+1];
        	
        	int lisCnt = 1;
        	int ldsCnt = 1;
        	
        	int key = arr[i];
        	lis[0] = key;
        	lds[0] = -key;
        	
        	for (int j = i+1; j < n; j++) {
        		int now = arr[j];
        		
        		if (now > key) {
        			lisCnt = getCnt(now, lisCnt, lis);
        		} else {
        			ldsCnt = getCnt(-now, ldsCnt, lds);
        		}
        	}
        	
        	max = Math.max(max, lisCnt + ldsCnt - 1);
        }
        System.out.println(max);
    }
    
    private static int getCnt(int cur, int cnt, int[] arr) {
    	int left = 0;
    	int right = cnt;
    	
    	while (left < right) {
    		int mid = (left + right) / 2;
    		
    		if (arr[mid] >= cur) {
    			right = mid;
    		} else {
    			left = mid + 1;
    		}
    	}
    	arr[right] = cur;
    	if (right == cnt) {
    		return cnt + 1;
    	}
    	return cnt;
    }
}