package programmers;

import java.util.PriorityQueue;

public class Ex42884 {

	public static void main(String[] args) {
		int[][] routes = {{-20,-10}, {-18,-14}, {-16,-6}, {-13,-11}, {-8,-2}, {-5,-3},{-2,-1}};
		
		System.out.println(solution(routes));
	}

	public static int solution(int[][] routes) {
        int answer = 1;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
        	if (o1[0] == o2[0]) {
        		return o1[1] - o2[1];
        	}
        	return o1[0] - o2[0];
        });
       
        for (int i = 0; i < routes.length; i++) {
        	pq.offer(routes[i]);
        }
        
        int[] start = pq.poll();
        int endPoint = start[1];
        while (!pq.isEmpty()) {
        	int[] newCar = pq.poll();
        	int newStartPoint = newCar[0];
        	int newEndPoint = newCar[1];
        	
        	if (endPoint >= newStartPoint && endPoint <= newEndPoint) {
        		continue;
        	} else if (endPoint >= newStartPoint && endPoint > newEndPoint) {
        		endPoint = newEndPoint;
        		continue;
        	}
        	
        	answer++;
        	endPoint = newEndPoint;
        }
        
        return answer;
    }
}
