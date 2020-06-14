/*
 * @lc app=leetcode.cn id=26 lang=java
 *
 * [26] 删除排序数组中的重复项
 * 
 * 审题：
 * 有序数组
 * 原地删除重复元素
 * 每个元素输出一次
 * 返回新长度
 * 双指针 
 * 快指针，慢指针
 * 当出现不重复的数据时，慢指针前移一步，赋上不重复的值，慢指针继续走直到遍历完；
 * 
 * 暴露出问题：
 * 先写思路
 * 再实现代码
 * 1、审题阶段：没有考虑异常情况，例如：数组是否为空
 * 2、写代码：while循环，没有进行指针的++
 * 3、写完代码：需要考虑特殊情况的数据，看是否需要优化
 *  */

// @lc code=start
class Solution {
    public int removeDuplicates(int[] nums) {
        //异常情况处理
        if (nums == null || nums.length == 0) return 0;
        int i = 0;
        int j = 1;

        while (j < nums.length) {
            if (nums[i] != nums[j] && j - i > 0) {
                nums[++i] = nums[j];
            }
            ++j;
        }
        return ++i;
    }
}
// @lc code=end

