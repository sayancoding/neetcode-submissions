class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] prefixProd = new int[nums.length];
        prefixProd[0] = 1;

        for(int i = 1; i<nums.length; i++){
            prefixProd[i] = prefixProd[i-1] * nums[i-1];
        }

        int suffix = 1 ;
        for(int i = nums.length -1; i>=0; i--){
            prefixProd[i] = prefixProd[i]*suffix;
            suffix *= nums[i];
        }

        return prefixProd;
    }
}  
