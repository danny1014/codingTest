package test;

public class Test {
	public static void main(String[] args) {
		String[] park1 = { "SOO", "OOO", "OOO" };
		String[] park2 = { "SOO", "OXX", "OOO" };
		String[] park3 = { "OSO", "OOO", "OXO", "OOO" };

		String[] routes1 = { "E 2", "S 2", "W 1" };
		String[] routes2 = { "E 2", "S 2", "W 1" };
		String[] routes3 = { "E 2", "S 3", "W 1" };

		for(int coor : solution(park3, routes3)) {
			System.out.print(coor + " ");
		}
	}

	public static int[] solution(String[] park, String[] routes) {
        int[] answer = {};
        int[] curPos = null;
        int rLength = park.length;
        int cLength = park[0].length();
        
        for(int i = 0; i < rLength; i++) {
        	for(int j = 0; j < cLength; j++) {
        		if(park[i].charAt(j) == 'S') {
        			curPos = new int[]{i, j};
        		}
        	}
        }

        for(int i = 0; i < routes.length; i++) {
        	String[] movement = routes[i].split(" ");
        	char dir = movement[0].charAt(0);
        	int dis = Integer.parseInt(movement[1]);
        	if(dir == 'E') {
        		if(curPos[1] + dis >= cLength || isObstacle(park, curPos, dir, dis)) {
        			continue;
        		}else {
        			curPos[1]+= dis;
        		}
        	}else if (dir == 'W') {
        		if(curPos[1] - dis < 0 || isObstacle(park, curPos, dir, dis)) {
        			continue;
        		}else {
        			curPos[1]-= dis;
        		}
        	}else if (dir == 'S') {
        		if(curPos[0] + dis >= rLength || isObstacle(park, curPos, dir, dis)) {
        			continue;
        		}else {
        			curPos[0] += dis;
        		}
        	}else if (dir == 'N'){
        		if(curPos[0] - dis < 0 || isObstacle(park, curPos, dir, dis)) {
        			continue;
        		}else {
        			curPos[0]-= dis;
        		}
        	}
        	

        }
        return answer = curPos;
    }

	public static boolean isObstacle(String[] park, int[] curPos, char dir , int dis) {
    	if(dir == 'E') {
    		for(int i = 1; i <= dis; i++) {
    			if(park[curPos[0]].charAt(curPos[1] + i) == 'X') {
    				return true;
    			}
    		}
    	}else if (dir == 'W') {
    		for(int i = 1; i <= dis; i++) {
    			if(park[curPos[0]].charAt(curPos[1] - i) == 'X') {
    				return true;
    			}
    		}
    	}else if (dir == 'S') {
    		for(int i = 1; i <= dis; i++) {
    			if(park[curPos[0] + i].charAt(curPos[1]) == 'X') {
    				return true;
    			}
    		}
    	}else {
    		for(int i = 1; i <= dis; i++) {
    			if(park[curPos[0] - i].charAt(curPos[1]) == 'X') {
    				return true;
    			}
    		}
    	}
    	
		return false;
	}

}
