class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] map1 = new int[26];
        int[] map2 = new int[26];
        int left = 0; int right = s1.length();

        if(s1.length() > s2.length()) return false;

        for(int i = 0; i<s1.length(); i++){
            map1[s1.charAt(i) - 'a']++;
            map2[s2.charAt(i) - 'a']++;
        }

        //1st window check
        if(isMatch(map1,map2)) return true;

        for(int i = 1; i<= s2.length() - s1.length(); i++,right++){
            map2[s2.charAt(i-1) - 'a']--;
            map2[s2.charAt(right) - 'a']++;
            if(isMatch(map1, map2)) return true;
        }

        return false;
    }

    private boolean isMatch(int[] arr1, int[] arr2){
        int i = 0;
        while(i < 26){
            if(arr1[i] != arr2[i]) return false;
            i++;
        }
        return true;
    }
}
