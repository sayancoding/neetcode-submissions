
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List> map = new HashMap<>();
        int[] mark = new int[26];

        for(String str : strs){
            Arrays.fill(mark, 0);
            for(char ch : str.toCharArray()){
                mark[ch - 'a']++;
            }
            
            String tempKey = "";
            for(int i=0; i<26; i++){
                tempKey += "#"+mark[i];
            }
            
            map.putIfAbsent(tempKey, new ArrayList<String>());
            map.get(tempKey).add(str);
        }

        List<List<String>> result = new ArrayList<>();

        map.values().forEach(el -> result.add(el));

        return result;
    }
}
