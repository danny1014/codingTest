package test;

import java.util.HashSet;
import java.util.Set;

public class Test {
    public static void main(String[] args) {
		int[][] rectangles = {{1, 1, 6, 5},{2, 0, 4, 2}, {2, 4, 5, 7}, {4, 3, 8, 6}, {7, 5, 9, 7}};
        System.out.println(solution(rectangles));
    }

    public static Set<String> disassemble(int[] rectangle) {
        int x1 = rectangle[0];
        int y1 = rectangle[1];
        int x2 = rectangle[2];
        int y2 = rectangle[3];
        Set<String> unitSquares = new HashSet<>();
        for (int x = x1; x < x2; x++) {
            for (int y = y1; y < y2; y++) {
                unitSquares.add(x + ", " + y);
            }
        }
        return unitSquares;
    }

    public static long solution(int[][] rectangles) {
    	long answer = -1;
        Set<String> uniqueUnitSquares = new HashSet<>();

        for (int[] rectangle : rectangles) {
            uniqueUnitSquares.addAll(disassemble(rectangle));
        }
        
        answer = uniqueUnitSquares.size();
        return answer;
    }
}
