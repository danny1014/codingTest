package test;

import java.math.BigDecimal;

class Solution {
	public static void main(String[] args) {

		System.out.println(solution(11, 59, 30, 12, 0, 0));
//		System.out.println(solution(0, 0, 0, 23, 59, 59));
	}
	
	public static int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
		int answer = 0;
		int startSec = h1 * 60 * 60 + m1 * 60 + s1;
		int endSec = h2 * 60 * 60 + m2 * 60 + s2;
		double hh = ((double) startSec / 120) % 360;
		double mh = ((double) startSec / 10) % 360;
		double sh = ((double) startSec * 6) % 360;
		boolean hhLeft = true, mhLeft = true;

		if(hh > sh)
			hhLeft = true;
		else
			hhLeft = false;
		
		if(mh > sh)
			mhLeft =true;
		else
			mhLeft =false;


		for (int i = 0; i <= (endSec-startSec)*100; i++) {
			double manuVal = startSec + i * 0.01;
			hh = ( manuVal / 120) % 360;
			mh = ( manuVal / 10) % 360;
			sh = ( manuVal * 6) % 360;
			
			
			if((hhLeft && sh >= hh) || (mhLeft && sh >= mh) || sh == hh || sh == mh) {
				answer++;
			}

			if(sh < hh)
				hhLeft = true;
			else
				hhLeft = false;
			
			if(sh < mh)
				mhLeft =true;
			else
				mhLeft =false;
		}

		return answer;
	}

}
