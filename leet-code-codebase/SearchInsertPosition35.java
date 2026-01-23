//35. Search Insert Position

class Solution {
    public int searchInsert(int[] nums, int target) {
        int idx = 0;
        for(int i =0; i<nums.length; i++){
            if(nums[i] != target && nums[i] <target){
                idx +=1;

            }
            
        }
        return idx;
    }
}