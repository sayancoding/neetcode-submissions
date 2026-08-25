class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int minSpeed = 1;
        int maxSpeed = 1;
        for(int el : piles){
            maxSpeed = Math.max(maxSpeed, el);
        }

        while(minSpeed < maxSpeed){
            int mid = minSpeed + (maxSpeed - minSpeed) /2;

            if(canEat(piles,h,mid))
                maxSpeed = mid;
            else
                minSpeed = mid+1;
        }

        return minSpeed;
    }

    public static boolean canEat(int[] piles, int h, int k){
        int total = 0;
        for(int el : piles){
            total += (int) Math.ceil((double)el/k);
        }

        return total <= h;
    }
}
