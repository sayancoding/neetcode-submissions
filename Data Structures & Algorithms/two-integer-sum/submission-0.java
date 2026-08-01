class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> lookup = new HashMap<>();

        for(int i = 0; i<nums.length; i++){
            int rem = target - nums[i];

            if(lookup.containsKey(rem)){
                if(lookup.get(rem) != i)
                    return new int[] {lookup.get(rem),i};
            }
            lookup.putIfAbsent(nums[i], i);
        }

        return new int[] {};
    }
}
