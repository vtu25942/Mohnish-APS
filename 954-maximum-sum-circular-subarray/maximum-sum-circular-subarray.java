class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int totalSum = 0;
        int maxSum = nums[0], curMax = 0;
        int minSum = nums[0], curMin = 0;

        for (int x : nums) {
            
            curMax = Math.max(x, curMax + x);
            maxSum = Math.max(maxSum, curMax);

            
            curMin = Math.min(x, curMin + x);
            minSum = Math.min(minSum, curMin);

            totalSum += x;
        }

        
        if (maxSum < 0) {
            return maxSum;
        }

       
        return Math.max(maxSum, totalSum - minSum);
    }
}
