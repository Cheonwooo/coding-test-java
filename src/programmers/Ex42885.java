package programmers;

import java.util.Arrays;

/*
 * ���̵��
 * �������ͷ� �ذ��ϱ�
 * �־��� �����Ը� ������������ ����
 * 2���� ������ �� > �������� �̶�� ū ���� ȥ�ڼ� ��Ʈ�� �¿�� ������ �ɷ� ī��Ʈ
 * 2���� ������ �� <= �������� �̶�� ������ �� �ٲٱ�
 * �� �������� ���� ���ٸ� ī��Ʈ+1
 * �� ������ ���� �����Ǹ� break
 */

public class Ex42885 {

	public static void main(String[] args) {
		int[] people = {10,20,30,40,50,60,70,100,110,120};
		int limit = 100;
		
		System.out.println(solution(people, limit));
	}
	
	public static int solution(int[] people, int limit) {
        Arrays.sort(people);
        
        int left = 0;
        int right = people.length-1;
        int count = 0;
        while (left <= right) {
        	if (left == right) {
        		count++;
        		break;
        	}
   
        	int sum = people[left] + people[right];
        	
        	if (sum > limit) {
        		count++;
        		right--;
        	} else {
        		count++;
        		left++;
        		right--;
        	}
        }
       
        return count;
    }
}
