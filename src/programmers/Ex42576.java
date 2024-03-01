package programmers;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/*
 * ���̵��
 * HashMap ���
 * �� �̸����� Map<String, Integer> ����
 * ������ �̸� �Է½� value+1, ������ �Է½� value-1
 * Map�� ��ȯ�ϸ鼭 value���� 1�� Key�� ã��
 * 
 * �ð����⵵
 * 100000 + 99999
 * 
 * �ڷᱸ��
 * ������ ������ ���� ������ Map
 */

public class Ex42576 {

	public static void main(String[] args) {
		String[] participant = {"leo", "kiki", "eden"};
		String[] completion = {"eden", "kiki"};
		
		System.out.println(solution(participant, completion));
	}
	
	private static String solution(String[] participant, String[] completion) {
		String loser = "";
		Map<String, Integer> participants = new HashMap<>();
		
		for (int i = 0; i < participant.length; i++) {
			participants.put(participant[i], participants.getOrDefault(participant[i], 0)+1);
		}
		
		for (int i = 0; i < completion.length; i++) {
			participants.put(completion[i], participants.get(completion[i])-1);
		}
		
		for (Entry<String, Integer> entry : participants.entrySet()) {
			String runner = entry.getKey();
			if (participants.get(runner) == 1) {
				loser = runner;
			}
		}
		return loser;
	}

}
