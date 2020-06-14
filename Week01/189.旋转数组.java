import sun.security.util.Length;

/*
 * @lc app=leetcode.cn id=189 lang=java
 *
 * [189] 旋转数组
 * 方法一暴力求解法
 * 每次移动一步，一共移动k步
 * 方法二新开数组（不符合题意）
 * 方法三环状替换
 * 方法四反转
 */

// @lc code=start
class Solution {

    public void rotate(int[] nums, int k) {
        k %= nums.length;

        reversal(nums,0,nums.length-1);
        reversal(nums,0,k-1);
        reversal(nums,k,nums.length-1);
    }

    private void reversal(int[] nums, int start, int end) {
        int temp;
        while(start < end){
            temp = nums[end];
            nums[end] = nums[start];
            nums[start] = temp;
            end--;
            start++;
        }
    }

    



    // public void rotate(int[] nums, int k) {
    //     k %= nums.length;
        
    //     int count = 0;//从第几个位子开始的
    //     //start = 0时，count最大是 k-1
    //     //start = 1时，count最大是 2（k-1），最终等count < nums.length时结束
    //     for(int start = 0; count < nums.length; start++){
    //         int current = start;
    //         int prev = nums[start];

    //         do { 
    //             int next = (current + k) % nums.length;
    //             int temp = nums[next];
    //             nums[next] = prev;
    //             prev = temp;
    //             current = next;
    //             count++;
    //         } while (start != current);
    //     }


    // }
    // public void rotate(int[] nums, int k) {
    //     int[] a = new int[nums.length];

    //     for (int i = 0; i < nums.length; i++) {
    //         a[(i+k) % nums.length] = nums[i];
    //     }
        
    //     for (int i = 0; i < nums.length; i++) {
    //         nums[i] = a[i];
    //     }
    // }
    // public void rotate(int[] nums, int k) {
    //     if (nums == null || k <= 0) {
    //         return;
    //     }
    //     int temp,previous;
    //     for (int j = 0; j < k; j++) {
    //         previous = nums[nums.length -1];
    //         for (int i = 0; i < nums.length; i++) {
    //             temp = nums[i];
    //             nums[i] = previous;
    //             previous = temp;
    //         }
    //     }
    // }
}
// @lc code=end

