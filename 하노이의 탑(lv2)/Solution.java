package test;

import java.util.*;

class Solution {
    public static List<Integer[]> solution(int n) {
        List<Integer[]> moves = new ArrayList<>();
        hanoi(n, 1, 3, 2, moves);  // 원반 n개를 기둥 1에서 3으로, 보조 기둥 2를 사용
        return moves;
    }

    public static void hanoi(int n, int from, int to, int aux, List<Integer[]> moves) {
        if (n == 1) {
            // 가장 작은 원반을 목적지로 이동
            moves.add(new Integer[] { from, to });
            return;
        }

        // 1단계: n-1개의 원반을 보조 기둥(aux)으로 이동
        hanoi(n - 1, from, aux, to, moves);

        // 2단계: 가장 큰 원반을 목적지로 이동
        moves.add(new Integer[] { from, to });

        // 3단계: 보조 기둥의 n-1개의 원반을 목적지로 이동
        hanoi(n - 1, aux, to, from, moves);
    }
}
