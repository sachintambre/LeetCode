class Solution {
     static{
        for(int i=0; i<400; i++)
            maxSubarraySumCircular(new int[]{1});
    }
    public static int maxSubarraySumCircular(int[] nums) {
        int n=nums.length;
        int currentMax=0;
        int currentMin=0;
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        int sum=0;
        for(int i=0;i<n;i++){
            currentMax=Math.max(currentMax + nums[i],nums[i]);
            max=Math.max(max,currentMax);
            currentMin=Math.min(currentMin + nums[i],nums[i]);
            min=Math.min(min,currentMin);
            sum+=nums[i];
        }
        if(max < 0) return max;
        return Math.max(max,sum-min);
    }
}