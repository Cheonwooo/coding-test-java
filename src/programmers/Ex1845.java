package programmers;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/*
 * 아이디어
 * Set의 크기를 구하기
 * 입력받은 nums를 Set으로 저장
 * nums의 길이가 1인 경우 result = 1
 * nums의 길이가 2이상인 경우 
 *  -Set의 size가 1인 경우 result = 1
 *  -Set의 size가 2이상인 경우 
 *  	-Set.size() > n/2 -> result = n/2
 *  	-Set.size() <= n/2 -> result = Set.size()
 *  
 * 시간복잡도
 * n
 * 
 * 자료구조
 * nums를 저장할 Set<Integer>
 * 정답을 저장할 int
 */

public class Ex1845 {

	public static void main(String[] args) throws IOException{
		
		int[] nums = {3,3,3,2,2,2}; 
		
		if (nums.length == 1) {
			System.out.println(1);
		} else { 
			System.out.println(solution(nums));
		}
	}
	
	private static int solution(int[] nums) {
		int size = nums.length;
		Set<Integer> set = new HashSet<>();
		
		for (int i = 0; i < size; i++) {
			set.add(nums[i]);
		}
		
		return calculateType(size, set);
	}
	
	private static int calculateType(int size, Set<Integer> set) {
		int collectSize = size/2;
		
		if (set.size() <= collectSize) {
			return set.size();
		}
		return collectSize;
	}

}
