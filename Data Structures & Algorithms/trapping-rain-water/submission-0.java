class Solution {
    // aux array (with extra space ) - min of (max left , max right)
    public int trap(int[] height) {
        int n = height.length;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];

        int total = 0;

        for(int i = 0; i< n; i++ ){
            if(i == 0) continue;
            leftMax[i] = Math.max(leftMax[i-1],height[i-1]);
        }
        for(int i = n-1; i>= 0; i--){
            if(i == n-1) continue;
            rightMax[i] = Math.max(rightMax[i+1],height[i+1]);
        }

        for(int i = 1; i< n-1; i++){
            int area = Math.min(leftMax[i], rightMax[i]) - height[i];
            total += (area > 0) ? area : 0;
        }

        return total;
    }
}
