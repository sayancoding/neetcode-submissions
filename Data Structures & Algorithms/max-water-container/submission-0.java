class Solution {
    public int maxArea(int[] heights) {
        int maxAns = 0;
        int left = 0;
        int right = heights.length -1 ;

        while(left < right){
            int minH = Math.min(heights[left], heights[right]);
            int area = minH * (right - left);
            maxAns = Math.max(maxAns,area);

            if(heights[left] < heights[right]){
                left++;
            }
            else{
                right--;
            }
        }

        return maxAns;
    }
}
