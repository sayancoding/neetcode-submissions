class Solution {
    // two pointer - without extra spaec
    public int trap(int[] height) {
        int n = height.length;
        
        int leftMax = 0;
        int rightMax = 0;

        int left = 0; int right = n-1;
        int result = 0;

        while(left < right ){
            if(height[left] < height[right]){
                leftMax = Math.max(leftMax,height[left]);
                result += (leftMax - height[left]);
                left++;
            }
            else{
                rightMax = Math.max(rightMax, height[right]);
                result += (rightMax - height[right]);
                right--;
            }
        }
        return result;
    }
}
