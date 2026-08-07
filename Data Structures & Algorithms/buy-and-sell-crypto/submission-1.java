class Solution {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int maxProfit = 0;
        for(int el : prices){
            min = Math.min(min,el);
            maxProfit = Math.max(maxProfit, (el - min) );
        }
        return maxProfit;
    }
}
