package programmers;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/*
 * ���̵��
 * Set�� ũ�⸦ ���ϱ�
 * �Է¹��� nums�� Set���� ����
 * nums�� ���̰� 1�� ��� result = 1
 * nums�� ���̰� 2�̻��� ��� 
 *  -Set�� size�� 1�� ��� result = 1
 *  -Set�� size�� 2�̻��� ��� 
 *  	-Set.size() > n/2 -> result = n/2
 *  	-Set.size() <= n/2 -> result = Set.size()
 *  
 * �ð����⵵
 * n
 * 
 * �ڷᱸ��
 * nums�� ������ Set<Integer>
 * ������ ������ int
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
