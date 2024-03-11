package programmers;

import java.util.LinkedList;
import java.util.Queue;

/*
 * 아이디어
 * queue에 트럭을 넣을 때 (무게,순번)으로 묶어서 넣기
 * 넣기 전
 * 	-q의 사이즈 체크, 사이즈가 다리가 가질 수 있는 최대 차량의 수를 넘으면 안됨
 *  -q내 차량들의 무게 합 체크
 * 넣을 때
 *  -무게의 합을 구하면서 넣기
 *  -순번+1
 * 뺄 때
 *  -순번이 최대 차량의 수를 넘으면 그대로 out
 *  
 *  시간복잡도
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
