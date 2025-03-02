package programmers;

public class Ex150369 {
	
	private static int total,  deliveryIdx, pickIdx;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        
        total = cap;
        deliveryIdx = pickIdx = n-1;
        
        while (true) {
            if (deliveryIdx == 0 && pickIdx == 0 &&
               deliveries[0] == 0 && pickups[0] == 0) break;
            
            answer += (Math.max(findSpot(deliveries, true), findSpot(pickups, false)) + 1) * 2;
        }
        
        return answer;
    }
    
    public long findSpot(int[] arr, boolean isDelivery) {
        boolean flag = false;
        int count = total;
        int spot = -1;
        
        int idx = isDelivery ? deliveryIdx : pickIdx;
        
        for (int i = idx; i >= 0; i--) {
            if (arr[i] != 0 && !flag) {
                spot = i;
                flag = true;
            }
            
            if (count - arr[i] < 0) {
                arr[i] -= count;
                if (isDelivery) deliveryIdx = i; 
                else pickIdx = i;
                break;
            } else {
                count -= arr[i];
                arr[i] = 0;
                if (isDelivery) deliveryIdx = i; 
                else pickIdx = i;
            }
        }
        return spot;
    }
}
