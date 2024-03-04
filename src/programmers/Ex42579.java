package programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * ���̵��
 * �帣�� �÷��� �� Map ���� - genrePlays
 *  -> ���Ƚ�� ���� ������ ����
 * �帣/�ε���/�÷��� �� �� �����ؾ���
 *  -> Map<String(�帣), List<playSong(������ȣ, ���Ƚ��)>> - totalPlays 
 *  -> List�� ������ �� ���Ƚ���� ���� ������ 
 *  -> ���Ƚ���� ���ٸ� ������ȣ�� ���� ������ ����
 * genrePlays ��ȸ �ϸ鼭 totalPlays�� Key������ value�� ȣ��
 * value�� ����� 2������ ��� �ٷ� ���, 2���� ū ��� �� �� 2���� ���
 *
 * �ð����⵵
 * 
 */

public class Ex42579 {
	
	public static class PlaySong implements Comparable<PlaySong> {
		int songId;
		int playCount;
		
		public PlaySong(int songId, int playCount) {
			this.songId = songId;
			this.playCount = playCount;
		}
		
		public int getSongId() {
			return songId;
		}
		
		public int getPlayCount() {
			return playCount;
		}
		
		public int compareTo(PlaySong other) {
			if (this.playCount == other.playCount) {
				return Integer.compare(this.songId, other.songId);
			}
			return Integer.compare(other.playCount, this.playCount);
		}
	}

	public static void main(String[] args) {
		String[] genres = {"K-pop", "classic", "pop", "classic", "classic", "pop"};
		int[] plays = {1600, 500, 600, 150, 800, 2500};
		
		List<Integer> list = solution(genres, plays);
		for (int val : list) {
			System.out.print(val + " ");
		}
	}
	
	public static List<Integer> solution(String[] genres, int[] plays) {
		Map<String, Integer> genrePlays = new HashMap<>();
		Map<String, List<PlaySong>> totalPlays = new HashMap<>();
		
		int size = genres.length;
		for (int i=0; i<size; i++) {
			//�帣�� ���Ƚ�� ����
			genrePlays.put(genres[i], genrePlays.getOrDefault(genres[i], 0)+plays[i]);
			
			//�帣�� �ε���,���Ƚ�� ����
			PlaySong playSong = new PlaySong(i, plays[i]);
			
			List<PlaySong> playSongs = totalPlays.get(genres[i]);
			
			//���� �帣�� �ش�Ǵ� Ű�� ������� �ʾҴٸ�
			if (playSongs == null) {
				playSongs = new ArrayList<>();
				totalPlays.put(genres[i], playSongs);
			}
			
			playSongs.add(playSong);
			totalPlays.put(genres[i], playSongs);
		}
		
		//genrePlays�� value���� �������� �������� ����
		List<String> keySet = new ArrayList<>(genrePlays.keySet());
		
		keySet.sort(new Comparator<String>() {
			public int compare(String o1, String o2) {
				return genrePlays.get(o2).compareTo(genrePlays.get(o1));
			}
		});
		
//		for (String key : keySet) {
//			System.out.println(key + " " + genrePlays.get(key));
//		}
//		
//		for (String key : totalPlays.keySet()) {
//			List<PlaySong> songs = totalPlays.get(key);
//			Collections.sort(songs);
//			for (PlaySong song : songs) {
//				System.out.println(song.getSongId() + " " + song.getPlayCount());
//			}
//		}
		
		List<Integer> answer = new ArrayList<>();
		
		for (String key : keySet) {
			List<PlaySong> playSongs = totalPlays.get(key);
			
			//playSongs�� ����� 1�̶�� �� �Ѱ��� �ε����� ���
			//����� 2�̻��̶�� ������ 0,1��° �ε����� ���
			if (playSongs.size() == 1) {
				answer.add(playSongs.get(0).getSongId());
			} else {
				Collections.sort(playSongs);
				
				for (int i = 0; i < 2; i++) {
					answer.add(playSongs.get(i).getSongId());
				}
			}
		}
		
		return answer;
    }

}
