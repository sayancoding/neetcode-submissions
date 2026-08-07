class Solution {
    public int characterReplacement(String s, int k) {
        int[] counter = new int[26];
        int maxFreq = 0;
        int maxWindow = 0;
        int left = 0; int right = 0;
        while(right < s.length()){
            //update freq of each char
            counter[s.charAt(right) - 'A']++;

            //maxFreq update
            maxFreq = Math.max(maxFreq, (counter[s.charAt(right) - 'A']));
            int currentWindow = right - left + 1;

            //sliding window - modify
            if(currentWindow - maxFreq > k){
                counter[s.charAt(left) - 'A']--;
                left++;
            }
            currentWindow = right - left + 1;
            maxWindow = Math.max(currentWindow, maxWindow);
            right++;
        }

        return maxWindow;
    }
}
