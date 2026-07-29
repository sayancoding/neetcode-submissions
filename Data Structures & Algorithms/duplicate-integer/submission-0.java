class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int el : nums){
            if(set.contains(el)){
                return true;
            }
            else{
                set.add(el);
            }
        }
        return false;
    }
}
