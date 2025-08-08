package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Ex20006 {
	
	private static class Player implements Comparable<Player>{ 
		int level;
		String id;

		public Player(int level, String id) {
			this.level = level;
			this.id = id;
		}
		
		public int compareTo(Player o) {
			return this.id.compareTo(o.id);
		}
	}
	
	private static class Room implements Comparable<Room> {
		int seq;
		int level;
		List<Player> player;

		public Room(int seq, int level, List<Player> player) {
			this.seq = seq;
			this.level = level;
			this.player = player;
		}

		public int compareTo(Room o) {
			return this.seq - o.seq;
		}
	}
	
	private static Queue<Room> waitingRoom = new LinkedList<>();
	private static PriorityQueue<Room> rooms = new PriorityQueue<>();
	private static PriorityQueue<Room> finish = new PriorityQueue<>();

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int p = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int index = 1;//순서
		for (int i = 0; i < p; i++) {
			st = new StringTokenizer(br.readLine());
			
			int l = Integer.parseInt(st.nextToken());
			String n = st.nextToken();
			int roomSize = rooms.size();
			
			while (!rooms.isEmpty()) {
				Room room = rooms.poll();
				List<Player> tempPlayer = room.player;
				if (tempPlayer.size() < m && l >= room.level - 10 && l <= room.level + 10) {
					tempPlayer.add(new Player(l, n));
					Room newRoom = new Room(room.seq, room.level, tempPlayer);
					if (tempPlayer.size() == m) {
						finish.add(newRoom);
					} else {
						rooms.add(newRoom);
					}
					break;
				}
				waitingRoom.add(room);
			}
			
			//맨 처음 생성된 방이 없거나 들어가는 방이 없는 경우
			if (waitingRoom.size() == roomSize) {
				List<Player> player = new ArrayList<>();
				player.add(new Player(l, n));
				rooms.add(new Room(index++, l, player));
			}
			
			//대기에 있던 방들 원래 방으로
			while (!waitingRoom.isEmpty()) {
				rooms.add(waitingRoom.poll());
			}
		}
		
		while (!finish.isEmpty()) {
			rooms.add(finish.poll());
		}
		
		while (!rooms.isEmpty()) {
			Room room = rooms.poll();
			List<Player> player = room.player;
			Collections.sort(player);
			if (player.size() != m) {
				System.out.println("Waiting!");
				for (Player pp : player) {
					System.out.println(pp.level + " " + pp.id);
				}
			} else {
				System.out.println("Started!");
				for (Player pp : player) {
					System.out.println(pp.level + " " + pp.id);
				}
			}
		}
	}
}

/*
 * PQ + q?
 * -10 ~ +10을 어떻게 해결하지?
 * PQ를 사용하면 Q를 사용해야함
 */
