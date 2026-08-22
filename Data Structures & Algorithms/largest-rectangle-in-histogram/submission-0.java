class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] nextSmall = new int[n];
        int[] prevSmall = new int[n];

        for(int i = 0; i<n; i++){
            nextSmall[i] = n;
            prevSmall[i] = -1;
        }

        Stack<Integer> monoStk = new Stack<>();

        for(int i = 0; i<n; i++){
            while(true){
                if(monoStk.isEmpty()){
                    monoStk.push(i);
                    break;
                }

                int idx = monoStk.peek();
                if(heights[i] < heights[idx]){
                    nextSmall[idx] = i;
                    monoStk.pop();
                }
                else{
                    monoStk.push(i);
                    break;
                }
            }
        }

        monoStk.clear();

        for(int i = n-1; i>= 0; i--){
            while(true){
                if(monoStk.isEmpty()){
                    monoStk.push(i);
                    break;
                }

                int idx = monoStk.peek();
                if(heights[i] < heights[idx]){
                    prevSmall[idx] = i;
                    monoStk.pop();
                }
                else{
                    monoStk.push(i);
                    break;
                }
            }
        }

        int result = 0;
        for(int i = 0; i<n; i++){
            result = Math.max(result, heights[i] * (nextSmall[i] - prevSmall[i] - 1));
        }
        return result;
    }
}
