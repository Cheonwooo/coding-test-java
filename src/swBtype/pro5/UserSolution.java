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
	
	private static int[] group;//�� �׷쿡 ���� �� �ο� ��
	private static Map<Integer, Department> depart;//<�μ�id, <�׷� ��ȣ, �μ� �ο� ��>>
	private static Map<Integer, Integer> parentIdFromChild;//<�ڽ�id, �θ�id>
	private static Map<Integer, LinkedList<Integer>> childIdFromParentId;//<�θ�Id, �ڽĵ�Id>
	
	public void init(int N, int mId[], int mNum[]) {
		group = new int[N];
		depart = new HashMap<>();
		parentIdFromChild = new HashMap<>();
		childIdFromParentId = new HashMap<>();
		
		for (int i = 0; i < N; i++) {
			LinkedList<Integer> child = new LinkedList<>();
			depart.put(mId[i], new Department(i, mNum[i]));
			parentIdFromChild.put(mId[i], -1);//�ֻ��� �θ��� id�� -1
			childIdFromParentId.put(mId[i], child);
			group[i] += mNum[i];
		}
	}

	public int add(int mId, int mNum, int mParent) {
		//mParent�� �̹� 3���� �ڽ��� ���� �ִٸ�
		if (childIdFromParentId.get(mParent).size() == 3) {
			return -1;
		}
		
		int groupId = depart.get(mParent).groupId;//mParent�� �׷�id
		depart.put(mId,  new Department(groupId, mNum));
		
		LinkedList<Integer> child = childIdFromParentId.get(mParent);//mParent�� ���� �ڽ� ����Ʈ ��������
		child.add(mId);
		childIdFromParentId.put(mParent, child);
		
		LinkedList<Integer> newChild = new LinkedList<>();
		childIdFromParentId.put(mId, newChild);
		
		parentIdFromChild.put(mId, mParent);//mId�� �θ�� mParent��� ���� ����
		group[groupId] += mNum;
		
		child = childIdFromParentId.get(mParent);
		int memberCount = getMemberCount(child);//mParent�� ���� ���� �ڽĵ��� �� �ο� �� ���ϱ�
		return memberCount + depart.get(mParent).departMember;
	}
	
	public int getMemberCount(LinkedList<Integer> child) {
		int memberCount = 0;
		
		Queue<Integer> q = new LinkedList<>();
		for (int i = 0; i < child.size(); i++) {
			q.add(child.get(i));
		}
		
		while (!q.isEmpty()) {
			int id = q.poll();//�μ�id
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
		//mId �μ��� ���ų�, ������ �μ����
		if (depart.get(mId) == null || depart.get(mId).groupId == -1) {
			return -1;
		}
		
		LinkedList<Integer> child = childIdFromParentId.get(mId);//mId�� ���� �ڽ� ����Ʈ
		int memberCount = depart.get(mId).departMember;
		if (child.size() != 0) {
			//�ڽ��� �����Ѵٸ� �ڽĵ��� �� �ο� �� ���ϱ�
			memberCount += getMemberCount(child);
		}
		
		int parentId = parentIdFromChild.get(mId);
		child = childIdFromParentId.get(parentId);
		child.remove(child.indexOf(mId));//mParent���� mId����, indexOf ���� �ȵǳ�..?
		childIdFromParentId.put(parentId, child);
		
		//������ mId�� ���� �׷��� �� �ο� ������ mId�� ���� �ο� ����ŭ ����
		Department d = depart.get(mId);
		int groupId = d.groupId;
		group[groupId] -= d.departMember;
		
		child = childIdFromParentId.get(mId);
		//mId�� �ڽ��� ������ �ִٸ� ���� �ڽĵ� ��� ����(mId�� ������ �ִ� �׷� ��ȣ�� -1�� ����)
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
		for (int val : group) {//�� �ο� �� ���ϱ�
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