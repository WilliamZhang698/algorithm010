import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=1 lang=java
 *
 * [1] 两数之和
 * 标签：哈希映射
 * 解题思路：
 * 暴力求解法：
 * 双指针循环嵌套遍历数组，找到匹配的两个元素角标输出
 * 哈希映射的方式：
 * 循环遍历数组
 *      把对应的元素值与角标存入hashtable，
 *      同时检索target-当前值 是否在hashtable中，
 *          存在，输出即可
 *          不存在，抛出对应异常
 */

// @lc code=start
class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        Map<Integer,Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement),i};
            }
            map.put(nums[i],i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }    
}
// @lc code=end

