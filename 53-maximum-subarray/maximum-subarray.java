public class Solution {
    public int maxSubArray(int[] nums) {
        int maxSoFar = nums[0];
        int currentMax = nums[0];

        for (int i = 1; i < nums.length; i++) {
            // Either start a new subarray at the current element 
            // or extend the existing subarray
            currentMax = Math.max(nums[i], currentMax + nums[i]);
            
            // Update the overall maximum found so far
            maxSoFar = Math.max(maxSoFar, currentMax);
        }

        return maxSoFar;
    }
}
