package programmers;

import java.util.PriorityQueue;

public class Ex17678 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public String solution(int n, int t, int m, String[] timetable) {
        String answer = "";
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for (int i = 0; i < timetable.length; i++) {
            int minute = transMinute(timetable[i]);
            pq.offer(minute);
        }
        
        int arriveTime = 540;
        int lastTime = 0;
        int total = 0;
        
        for (int i = 0; i < n; i++) {
            total = 0;
            
            while (!pq.isEmpty()) {
                int currentTime = pq.peek();
                
                if (currentTime <= arriveTime && total < m) {
                    pq.poll();
                    total++;
                } else break;
                
                lastTime = currentTime - 1;
            }
            arriveTime += t;
        }
        
        if (total < m) lastTime = arriveTime - t;
        
        return transTimeTable(lastTime);
    }
    
    private int transMinute(String time) {
        String[] splitedTime = time.split(":");
        
        int minute = 0;
        minute += Integer.parseInt(splitedTime[0]) * 60;
        minute += Integer.parseInt(splitedTime[1]);
        
        return minute;
    }
    
    private String transTimeTable(int minute) {
        String hour = String.valueOf(minute / 60);
        String min = String.valueOf(minute % 60);
        
        return ((hour.length() == 1) ? "0" + hour : hour) + ":" + ((min.length() == 1 ? "0" + min : min));
    }
}
