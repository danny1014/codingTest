class Solution {
    public int solution(String[] friends, String[] gifts) {
		int answer = 0;
		int[][] arr = new int[friends.length][friends.length];
		int[] resultArr = new int[friends.length];
		int[] arr1 = new int[friends.length];

		for (int i = 0; i < gifts.length; i++) {
			String[] strArr = gifts[i].split(" ");
			for (int j = 0; j < friends.length; j++) {
				if (strArr[0].equals(friends[j])) {
					for (int k = 0; k < friends.length; k++) {
						if (strArr[1].equals(friends[k])) {
							arr[j][k] += 1;
						}
					}
				}
			}
		}
		for (int i = 0; i < friends.length; i++) {
			int sum1 = 0, sum2 = 0;
			for (int j = 0; j < friends.length; j++) {
				sum1 += arr[i][j];
			}
			for (int j = 0; j < friends.length; j++) {
				sum2 += arr[j][i];
			}
			
			arr1[i] = sum1-sum2;

		}

		for (int i = 0; i < friends.length; i++) {
			for (int j = 0; j < friends.length; j++) {
				if (arr[i][j] > arr[j][i]) {
					resultArr[i]++;
				} else if (arr[i][j] < arr[j][i]) {
					resultArr[j]++;
				} else {
					if(arr1[i] > arr1[j]) {
						resultArr[i]++;
					}else if(arr1[i] < arr1[j]) {
						resultArr[j]++;
					}
				}
			}
		}
		
		for (int i = 0; i < friends.length; i++) {
			resultArr[i] = resultArr[i]/2;
			System.out.print(resultArr[i] + " ");
			
			if(answer < resultArr[i])
				answer = resultArr[i];
		}
		
		return answer;
    }
}
