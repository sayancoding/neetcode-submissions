class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int el : nums){
            if(map.containsKey(el)) map.put(el, map.get(el)+1);
            else map.put(el, 1);
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>
                ((a,b)-> map.get(a)- map.get(b));

        for(int el : map.keySet()){
            minHeap.add(el);
            if(minHeap.size() > k) minHeap.poll();
        }

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = minHeap.poll();
        }
        return res;

    }
}
