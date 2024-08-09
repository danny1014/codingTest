import java.util.*;

class Solution {
    static class Event {
        int x;
        int y1, y2;
        boolean isStart;

        Event(int x, int y1, int y2, boolean isStart) {
            this.x = x;
            this.y1 = y1;
            this.y2 = y2;
            this.isStart = isStart;
        }
    }

    public static int solution(int[][] rectangles) {
        List<Event> events = new ArrayList<>();
        Set<Integer> yCoords = new TreeSet<>();

        for (int[] rect : rectangles) {
            int x1 = rect[0], y1 = rect[1], x2 = rect[2], y2 = rect[3];
            events.add(new Event(x1, y1, y2, true));
            events.add(new Event(x2, y1, y2, false));
            yCoords.add(y1);
            yCoords.add(y2);
        }

        events.sort((e1, e2) -> {
            if (e1.x != e2.x)
                return Integer.compare(e1.x, e2.x);
            return Boolean.compare(e1.isStart, e2.isStart);
        });

        List<Integer> yList = new ArrayList<>(yCoords);
        int[] active = new int[yList.size() - 1];
        int prevX = events.get(0).x;
        int totalArea = 0;

        for (Event event : events) {
            int curX = event.x;
            int coveredLength = calculateCoveredLength(active, yList);

            totalArea += (curX - prevX) * coveredLength;
            prevX = curX;

            int y1Index = Collections.binarySearch(yList, event.y1);
            int y2Index = Collections.binarySearch(yList, event.y2);
            for (int i = y1Index; i < y2Index; i++) {
                active[i] += event.isStart ? 1 : -1;
            }
        }

        return totalArea;
    }

    private static int calculateCoveredLength(int[] active, List<Integer> yList) {
        int length = 0;
        for (int i = 0; i < active.length; i++) {
            if (active[i] > 0) {
                length += yList.get(i + 1) - yList.get(i);
            }
        }
        return length;
    }
}
