package swBtype.pro5;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

class UserSolution {
	private static class Department {
		int groupId;
		int departMember;

		public Department(int departId, int departMember) {
			this.groupId = departId;
			this.departMember = departMember;
		}
	}
	
	private static int[] group;//각 그룹에 속한 총 인원 수
	private static Map<Integer, Department> depart;//<부서id, <그룹 번호, 부서 인원 수>>
	private static Map<Integer, Integer> parentIdFromChild;//<자식id, 부모id>
	private static Map<Integer, LinkedList<Integer>> childIdFromParentId;//<부모Id, 자식들Id>
	
	public void init(int N, int mId[], int mNum[]) {
		group = new int[N];
		depart = new HashMap<>();
		parentIdFromChild = new HashMap<>();
		childIdFromParentId = new HashMap<>();
		
		for (int i = 0; i < N; i++) {
			LinkedList<Integer> child = new LinkedList<>();
			depart.put(mId[i], new Department(i, mNum[i]));
			parentIdFromChild.put(mId[i], -1);//최상위 부모의 id는 -1
			childIdFromParentId.put(mId[i], child);
			group[i] += mNum[i];
		}
	}

	public int add(int mId, int mNum, int mParent) {
		//mParent가 이미 3개의 자식을 갖고 있다면
		if (childIdFromParentId.get(mParent).size() == 3) {
			return -1;
		}
		
		int groupId = depart.get(mParent).groupId;//mParent의 그룹id
		depart.put(mId,  new Department(groupId, mNum));
		
		LinkedList<Integer> child = childIdFromParentId.get(mParent);//mParent가 가진 자식 리스트 가져오기
		child.add(mId);
		childIdFromParentId.put(mParent, child);
		
		LinkedList<Integer> newChild = new LinkedList<>();
		childIdFromParentId.put(mId, newChild);
		
		parentIdFromChild.put(mId, mParent);//mId의 부모는 mParent라는 정보 저장
		group[groupId] += mNum;
		
		child = childIdFromParentId.get(mParent);
		int memberCount = getMemberCount(child);//mParent가 가진 하위 자식들의 총 인원 수 구하기
		return memberCount + depart.get(mParent).departMember;
	}
	
	public int getMemberCount(LinkedList<Integer> child) {
		int memberCount = 0;
		
		Queue<Integer> q = new LinkedList<>();
		for (int i = 0; i < child.size(); i++) {
			q.add(child.get(i));
		}
		
		while (!q.isEmpty()) {
			int id = q.poll();//부서id
			memberCount += depart.get(id).departMember;
			
			if (childIdFromParentId.get(id).size() != 0) {
				LinkedList<Integer> childList = childIdFromParentId.get(id);
				for (int i = 0; i < childList.size(); i++) {
					q.add(childList.get(i));
				}
			}
		}
		
		return memberCount;
	}

	public int remove(int mId) {
		//mId 부서가 없거나, 삭제된 부서라면
		if (depart.get(mId) == null || depart.get(mId).groupId == -1) {
			return -1;
		}
		
		LinkedList<Integer> child = childIdFromParentId.get(mId);//mId가 가진 자식 리스트
		int memberCount = depart.get(mId).departMember;
		if (child.size() != 0) {
			//자식이 존재한다면 자식들의 총 인원 수 구하기
			memberCount += getMemberCount(child);
		}
		
		int parentId = parentIdFromChild.get(mId);
		child = childIdFromParentId.get(parentId);
		child.remove(child.indexOf(mId));//mParent에서 mId제거, indexOf 쓰면 안되나..?
		childIdFromParentId.put(parentId, child);
		
		//제거한 mId가 속한 그룹의 총 인원 수에서 mId가 가진 인원 수만큼 빼기
		Department d = depart.get(mId);
		int groupId = d.groupId;
		group[groupId] -= d.departMember;
		
		child = childIdFromParentId.get(mId);
		//mId가 자식을 가지고 있다면 하위 자식들 모두 삭제(mId가 가지고 있는 그룹 번호를 -1로 변경)
		if (child.size() != 0) {
			removeDepartment(child, groupId);
		}
		d.groupId = -1;
		depart.put(mId, d);
		return memberCount;
	}
	
	public void removeDepartment(LinkedList<Integer> child, int departId) {
		Queue<Integer> q = new LinkedList<>();
		for (int i = 0; i < child.size(); i++) {
			q.add(child.get(i));
		}
		
		while (!q.isEmpty()) {
			int id = q.poll();
			Department d = depart.get(id);
			group[d.groupId]-= d.departMember;
			
			if (childIdFromParentId.get(id).size() != 0) {
				LinkedList<Integer> childList = childIdFromParentId.get(id);
				for (int i = 0; i < childList.size(); i++) {
					q.add(childList.get(i));
				}
			}
			d.groupId = -1;
			depart.put(id, d);
		}
	}

	public int distribute(int K) {
		int totalCount = 0;
		for (int val : group) {//총 인원 수 구하기
			totalCount += val;
		}
		
		int max = 0;
		if (totalCount <= K) {
			for (int val : group) {
				max = Math.max(val, max);
			}
		} else {
			int left = 1;
			int right = K;
			
			while (left <= right) {
				int middle = (left + right) / 2;
				int sum = 0;
				for (int i = 0; i < group.length; i++) {
					if (group[i] <= middle) {
						sum += group[i];
					} else {
						sum += middle;
					}
				}
				
				if (sum <= K) {
					left = middle+1;
					max = Math.max(max, middle);
				} else {
					right = middle-1;
				}
			}
		}
		return max;
	}
}