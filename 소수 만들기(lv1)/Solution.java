import java.util.ArrayList;

class Solution {
	static ArrayList<Integer> sum = new ArrayList<>();

	public static int solution(int[] nums) {
		int answer = -1;
		int r = 3;
		int start = 0;
		boolean[] visited = new boolean[nums.length];
		comb1(nums, visited, start, r);
		
		int[] arr = sum.stream().mapToInt(Integer::intValue).toArray();
		
		answer = countPrime(arr);
		return answer;
	}
	
    static void comb1(int[] arr, boolean[] visited, int start, int r) {
        if(r == 0) {
        	sum.add(calSum(arr, visited));
            return;
        } else {
            for(int i = start; i < arr.length; i++) {
                visited[i] = true;
                comb1(arr, visited, i + 1, r - 1);
                visited[i] = false;
            }
        }
    }
	
    static int calSum(int[] arr, boolean[] visited) {
    	int sum = 0;
        for(int i = 0; i < arr.length; i++) {
            if(visited[i] == true) {
            	sum += arr[i];
            }
        }
        return sum;
    }
	
	public static int countPrime(int[] result) {
		int cnt = 0;
		for(int i = 0; i < result.length; i++) {
			int count = 0;
			for(int j = 1; j < result[i]; j++) {
				if(result[i] % j == 0) {
					count++;
				}
			}
			if(count == 1)
				cnt++;
		}
		
		return cnt;
	}
}
