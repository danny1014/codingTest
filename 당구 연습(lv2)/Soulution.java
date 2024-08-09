	public static int[] solution(int m, int n, int startX, int startY, int[][] balls) {
		int[] answer = new int[balls.length];
		for(int i = 0; i < balls.length; i++) {
			answer[i] = findMin(m, n, startX, startY, balls[i][0], balls[i][1]);
		}
		return answer;
	}

	public static int findMin(int m, int n, int x, int y, int tx, int ty) {
		int dis1 = (tx + x) * (tx + x) + (ty - y) * (ty - y);
		int dis2 = (tx - x) * (tx - x) + (ty - (2 * n - y)) * (ty - (2 * n - y));
		int dis3 = (tx - x) * (tx - x) + (ty + y) * (ty + y);
		int dis4 = (tx - (2 * m - x)) * (tx - (2 * m - x)) + (ty - y) * (ty - y);
		int min = Math.min(Math.min(dis3, Math.min(dis1, dis2)), dis4);
		
		if(y == ty) {
			if(x > tx) {
				min = Math.min(Math.min(dis3, dis2), dis4);
			}else{
				min = Math.min(Math.min(dis3, dis2), dis1);
			}
		}
		
		if(x == tx) {
			if(y > ty) {
				min = Math.min(Math.min(dis1, dis2), dis4);
			}else {
				min = Math.min(Math.min(dis1, dis3), dis4);
			}
		}
		return min;
	}
