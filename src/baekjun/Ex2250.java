package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

// 메모리 29072kb, 392ms

public class Ex2250 {
	public static class Node implements Comparable<Node> {
		int level;
		int number;
		int parent;
		boolean isLeft;

		public Node(int level, int number, int parent, boolean isLeft) {
			this.level = level;
			this.number = number;
			this.parent = parent;
			this.isLeft = isLeft;
		}
		
		public int compareTo(Node o) {
			return this.level - o.level;
		}

		@Override
		public String toString() {
			return "Node [level=" + level + ", number=" + number + ", parent=" + parent + ", isLeft=" + isLeft + "]";
		}
	}
	
	private static int n, maxLevel = 1;
	private static LinkedList<Integer>[] levelTree;
	private static List<int[]>[] list;
	private static Map<Integer, Integer> nodeCol = new HashMap<>();

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		list = new List[n+1];
		levelTree = new LinkedList[n+1];
		boolean[] isExistParent = new boolean[n+1];
		
		for (int i = 0; i < n+1; i++) {
			list[i] = new ArrayList<>();
			levelTree[i] = new LinkedList<>();
		}
		
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int parentNode = Integer.parseInt(st.nextToken());
			int leftNode = Integer.parseInt(st.nextToken());
			int rightNode = Integer.parseInt(st.nextToken());
			
			list[parentNode].add(new int[] {leftNode, rightNode});
			if (leftNode != -1) isExistParent[leftNode] = true;
			if (rightNode != -1) isExistParent[rightNode] = true;
		}
		
		int startNode = 0;
		for (int i = 1; i < n+1; i++) {
			if (!isExistParent[i]) {
				startNode = i;
				break;
			}
		}
		
		findFirstNodeCol(startNode);
		findAllNodeCol(startNode);
		int[] answer = getMaxWidth();
		System.out.println(answer[0] + " " + answer[1]);
	}
	
	public static void findFirstNodeCol(int startNode) {
		int count = 0;
		Queue<Integer> q = new LinkedList<>();
		
		int left = list[startNode].get(0)[0];
		if (left != -1) {
			q.offer(list[startNode].get(0)[0]);
			count++;
		}
		
		while(!q.isEmpty()) {
			int next = q.poll();
			if (next == -1) break;
			
			int nextLeft = list[next].get(0)[0];
			if (nextLeft != -1) {
				count++;
				q.offer(nextLeft);
			}
			
			int nextRight = list[next].get(0)[1];
			if (nextRight != -1) {
				count++;
				q.offer(nextRight);
			}
		}
		levelTree[1].add(startNode);
		nodeCol.put(startNode, count+1);
	}
	
	public static void findAllNodeCol(int startNode) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		int left = list[startNode].get(0)[0];
		pq.offer(new Node(2, left, startNode, true));
		
		int right = list[startNode].get(0)[1];
		pq.offer(new Node(2, right, startNode, false));
		
		while (!pq.isEmpty()) {
			Node node = pq.poll();

			int level = node.level;
			int number = node.number;
			int parent = node.parent;
			boolean isLeft = node.isLeft;
			
			if (number == -1) continue;

			levelTree[level].add(number);
			maxLevel = Math.max(maxLevel, level);
			int parentCol = nodeCol.get(parent);
			
			if (isLeft) {//왼쪽 자식이라면 오른쪽 자식 수를 계산
				int rightCount = calculateNodeCount(list[number].get(0)[1]);
				nodeCol.put(number, parentCol - rightCount - 1);
			} else {//오른쪽 자식이라면 왼쪽 자식 수를 계산
				int leftCount = calculateNodeCount(list[number].get(0)[0]);
				nodeCol.put(number, parentCol + leftCount + 1);
			}
			
			int nextLeft = list[number].get(0)[0];
			pq.offer(new Node(level+1, nextLeft, number, true));
			int nextRight = list[number].get(0)[1];
			pq.offer(new Node(level+1, nextRight, number, false));
		}
	}
	
	public static int calculateNodeCount(int childNode) {
		int count = 0;
		Queue<Integer> q = new LinkedList<>();
		
		if (childNode != -1) {
			count++;
			q.offer(childNode);
		}
		
		while (!q.isEmpty()) {
			int next = q.poll();
			if (next == -1) break;
			
			int nextLeft = list[next].get(0)[0];
			if (nextLeft != -1) {
				count++;
				q.offer(nextLeft);
			}
			
			int nextRight = list[next].get(0)[1];
			if (nextRight != -1) {
				count++;
				q.offer(nextRight);
			}
		}
		return count;
	}
	
	public static int[] getMaxWidth() {
		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]> () {
			public int compare(int[] o1, int[] o2) {
				if (o1[1] == o2[1]) {
					return o1[0] - o2[0];
				}
				return o2[1] - o1[1];
			}
		});
		
		for (int i = 1; i < maxLevel+1; i++) {
			int max = Integer.MIN_VALUE;
			int min = Integer.MAX_VALUE;
			for (int j = 0; j < levelTree[i].size(); j++) {
				max = Math.max(max, nodeCol.get(levelTree[i].get(j)));
				min = Math.min(min, nodeCol.get(levelTree[i].get(j)));
			}
			
			int result = max - min + 1;
			pq.offer(new int[] {i, result});
		}
		
		return pq.poll();
	}
}
