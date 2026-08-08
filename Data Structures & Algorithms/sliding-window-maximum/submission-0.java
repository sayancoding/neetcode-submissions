class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(
            Collections.reverseOrder()
        );
        int[] result = new int[nums.length - k + 1];
        int i = 0;

        for(; i<k ; i++)
            maxHeap.add(nums[i]);

        result[0] = maxHeap.peek();
        maxHeap.remove(nums[0]);

        // slide-window start from 1 -> (n-k+1)
        for(; i<nums.length; i++){
            maxHeap.add(nums[i]);
            result[i-k+1] = maxHeap.peek();
            maxHeap.remove(nums[i-k+1]);
        }

        return result;
    }
}
