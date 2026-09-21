class Solution {
    public int[] twoSum(int[] nums, int target) {//sachin
       int end = nums.length;
        for(int i = 0; i < nums.length / 2; i++){
            end--;
            int endcount = 1;
            for(int j = i; j < end; j++)
            {
                if(nums[i] + nums[j + 1] == target) return new int[] {i,j + 1};
                if(nums[end] + nums[end - endcount] == target) return new int[] {end - endcount, end};
                endcount++;
            }
        }
        return new int[] {0,0};
    }
}