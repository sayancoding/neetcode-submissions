class Solution {
    public String minWindow(String s, String t) {

        if(t.length() > s.length()) return "";

        int[] mapT = new int[128];
        int[] mapS = new int[128];

        for(char ch : t.toCharArray()){
            mapT[ch]++;
        }

        int left = 0; int right = 0; 
        int minLen = Integer.MAX_VALUE;
        int minStart = 0;

        for(; right < s.length(); right++){
            mapS[s.charAt(right)]++;

            while(isValid(mapT,mapS)){
                int currLen = right - left + 1;
                if(currLen < minLen){
                    minStart = left;
                    minLen = currLen;
                }

                char c = s.charAt(left);
                mapS[c]--;
                left++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, (minStart + minLen));

    }

    private boolean isValid(int[] mapT,int[] mapS){
        for(int i = 0; i<128; i++){
            if(mapT[i] > mapS[i]) return false;
        }
        return true;
    }
}
