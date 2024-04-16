package programmers;

import java.util.Arrays;

public class Ex43236 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        
        Arrays.sort(rocks);
        
        int left = 1;
        int right =  distance;
        
        while (left <= right) {
        	int mid = (left + right) / 2;
        	int start = 0;
            int removeCnt = 0;
            
            for (int i = 0; i < rocks.length; i++) {
            	if (rocks[i] - start < mid) {
            		removeCnt++;
            	} else {
            		start = rocks[i];
            	}
            }
            if (distance - start < mid) {
            	removeCnt++;
            }
            
            if (removeCnt > n) {
            	right = mid - 1;
            } else {
            	answer = mid;
            	left = mid + 1;
            }
        }
        
        return answer;
    }
	
}
