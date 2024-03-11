package programmers;

import java.util.LinkedList;
import java.util.Queue;

/*
 * ���̵��
 * queue�� Ʈ���� ���� �� (����,����)���� ��� �ֱ�
 * �ֱ� ��
 * 	-q�� ������ üũ, ����� �ٸ��� ���� �� �ִ� �ִ� ������ ���� ������ �ȵ�
 *  -q�� �������� ���� �� üũ
 * ���� ��
 *  -������ ���� ���ϸ鼭 �ֱ�
 *  -����+1
 * �� ��
 *  -������ �ִ� ������ ���� ������ �״�� out
 *  
 *  �ð����⵵
 *  bridge_length * weitght
 * 
 * 
 */

public class Ex42583 {
	
	public static class Truck {
		int weight;
		int sequence;
		
		public Truck(int weight, int sequence) {
			this.weight = weight;
			this.sequence = sequence;
		}
		
		public int getWeight() {
			return weight;
		}
		
		public int getSequence() {
			return sequence;
		}
		
		public void increaseSequence() {
			sequence++;
		}
	}

	public static void main(String[] args) {
		
		int bridge_length = 1;
		int weight = 100;
		int[] truck_weights = {10,10,10,10,10};
		
		System.out.println(solution(bridge_length, weight, truck_weights));
	}
	
	public static int solution(int bridge_length, int weight, int[] truck_weights) {
		Queue<Truck> q = new LinkedList<>();
		Queue<Integer> truckSeq = new LinkedList<>();
		
		for (int i = 0; i < truck_weights.length; i++) {
			truckSeq.add(truck_weights[i]);
		}
		
		int answer = 0;
		int weightSum = 0;
		for (int i = 0; i < truck_weights.length; i++) {
			q.add(new Truck(truck_weights[i], 1));
			
			while (true) {
				answer++;
				weightSum = 0;
				int size = q.size();
				
				if (i == truck_weights.length-1) break;
				
				for (int j = 0; j < size; j++) {
					Truck truck = q.poll();
					
					int truckWeight = truck.getWeight();
					int sequence = truck.getSequence()+1;
					
					if (sequence > bridge_length) {
						continue;
					}
					
					weightSum += truckWeight;
					q.add(new Truck(truckWeight, sequence));
				}
				
				if (weightSum + truck_weights[i+1] <= weight && q.size() < bridge_length) {
					break;
				}
			}
		}
		
		while (!q.isEmpty()) {
			answer++;
			
			int size = q.size();
			
			for (int i = 0; i < size; i++) {
				Truck truck = q.poll();
				
				int truckWeight = truck.getWeight();
				int sequence = truck.getSequence()+1;

				if (sequence > bridge_length) {
					continue;
				}
				q.add(new Truck(truckWeight, sequence));
			}
		}
		return answer;
	}
}
