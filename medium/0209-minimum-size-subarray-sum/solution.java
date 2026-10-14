class Solution {
    public int minSubArrayLen(int target, int[] nums) {

        int left = 0;
        int sum = 0;
        int minlen = Integer.MAX_VALUE;

        for (int right = 0; right < nums.length; right++) {

            // Add current element
            sum += nums[right];

            // Shrink while window is valid
            while (sum >= target) {

                int len = right - left + 1;
                minlen = Math.min(minlen, len);

                sum -= nums[left];
                left++;
            }
        }

        if (minlen == Integer.MAX_VALUE)
            return 0;

        return minlen;
    }
}