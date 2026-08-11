class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> monoStack = new Stack<>();
        int[] result = new int[temperatures.length];

        for(int i = 0; i < result.length; i++){
            while(!monoStack.isEmpty() && 
            temperatures[i] > temperatures[monoStack.peek()]){
                int prevIdx = monoStack.pop();
                result[prevIdx] = i - prevIdx;
            }

            monoStack.push(i);
        }

        return result;
    }
}
