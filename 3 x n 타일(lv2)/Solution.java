package test;

import java.util.HashMap;
import java.util.Map;

class Solution {
	public static void main(String[] args) {
		System.out.println(solution(1000));
	}
    private static final int MOD = 1000000007;
    private static Map<Integer, Long> memo = new HashMap<>();

    public static long solution(int n) {
        if (n == 2) return 3;
        if (n == 4) return 11;

        // 이미 계산된 값이 있다면 그것을 반환
        if (memo.containsKey(n)) {
            return memo.get(n);
        }

        // 메모이제이션을 통해 값 계산 및 저장
        long answer = 4 * solution(n - 2) - solution(n - 4);
        answer = (answer % MOD + MOD) % MOD;  // 음수 처리

        memo.put(n, answer);  // 계산된 값을 메모에 저장

        return answer;
    }

}
