class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        
        String[] AWord = {"aya", "ye", "woo", "ma"};
        
        for(int i = 0; i < babbling.length; i++){
        	int lengCount = 0;
            for(int j = 0; j < AWord.length; j++){
                if(babbling[i].contains(AWord[j])) {
                	lengCount += AWord[j].length();
                }
            }
            if(lengCount == babbling[i].length()){
                answer++;
            }
        }
        return answer;
    }
}
