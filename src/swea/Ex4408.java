package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Ex4408 {
	public static class Room implements Comparable<Room> {
		int start;
		int end;
		
		public Room(int start, int end) {
			this.start = start;
			this.end = end;
		}
		
		public int compareTo(Room other) {
			return this.start - other.start; 
		}
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T =  Integer.parseInt(br.readLine());
		
		for (int t = 1;  t <= T; t++) {
			sb.append("#" + t + " ");
			PriorityQueue<Room> pq = new PriorityQueue<>();
			
			int n = Integer.parseInt(br.readLine());
			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				
				if (start > end) {
					int temp = start;
					start = end;
					end = temp;
				}
				
				pq.offer(new Room(start, end));
			}
			
			Queue<Room> q = new LinkedList<>();
			while (!pq.isEmpty()) {
				q.offer(pq.poll());
			}
			
			int count = 0;
			while (!q.isEmpty()) {
				count++;
				
				Room room = q.poll();
				int start = room.start;
				int end = room.end;
				
				int standardEnd = (start > end ? start : end);
				
				int size = q.size();
				for (int i = 0; i < size; i++) {
					Room nextRoom = q.poll();
					
					int nextStart = nextRoom.start;
					int nextEnd = nextRoom.end;
					
					if (standardEnd%2 == 0 && standardEnd < nextStart && standardEnd < nextEnd) {
						standardEnd = (nextStart > nextEnd ? nextStart : nextEnd);
						continue;
					}
					
					if (standardEnd%2 != 0 && standardEnd+1 < nextStart && standardEnd+1 < nextEnd) {
						standardEnd = (nextStart > nextEnd ? nextStart : nextEnd);
						continue;
					}
					
					q.offer(new Room(nextStart, nextEnd));
				}
			}
			sb.append(count).append("\n");
		}
		System.out.println(sb);
		
		
	}

}
