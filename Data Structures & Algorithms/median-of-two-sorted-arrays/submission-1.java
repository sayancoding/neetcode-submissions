class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] small = nums1.length > nums2.length ? nums2 : nums1;
        int[] large = nums1.length < nums2.length ? nums2 : nums1;
        if(nums1.length == nums2.length){
            small = nums1;
            large = nums2;
        }

        int totalLength = nums1.length + nums2.length;

        int left = 0;
        int right = small.length;

        while(left <= right){
            int partitionX = (left + right) /2;
            int partitionY = (totalLength +1) /2 - partitionX;

            int l1 = partitionX == 0 ? Integer.MIN_VALUE : small[partitionX-1]; 
            int r1 = partitionX == small.length ? Integer.MAX_VALUE : small[partitionX];

            int l2 = partitionY == 0 ? Integer.MIN_VALUE : large[partitionY-1]; 
            int r2 = partitionY == large.length ? Integer.MAX_VALUE : large[partitionY];

            if(l1 <= r2 && l2 <= r1){
                if(totalLength % 2 == 0){
                    return (Math.max(l1,l2) + Math.min(r1,r2)) / 2.0;
                }
                else{
                    return Math.max(l1,l2);
                }
            }

            if(l1 > r2)
                right = partitionX - 1;
            else
                left = partitionX + 1;

        }
        return 0;
    }
}
