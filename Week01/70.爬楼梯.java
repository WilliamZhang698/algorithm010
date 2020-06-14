/*
 * @lc app=leetcode.cn id=70 lang=java
 *
 * [70] 爬楼梯
 * 思路：
 * 递归、动态规划
 * f(n) = f(n-1) +f(n-2)
 * 斐波拉契数列
 * 把重复的计算放在缓存中
 *  * 3 = 2 + 1
 * 计算
 * 保存
 */
// @lc code=start
class Solution {
    public int climbStairs(int n){
        int pre = 1, preOfPre = 1, cur = 1;
        
        for (int i = 2; i <= n; i++){
            cur = pre + preOfPre;
            preOfPre = pre;
            pre = cur;
        }
        return cur;
    }
    // public int climbStairs(int n){
    //     int[] dp = new int[n+2];
    //     dp[0] = 1;
    //     dp[1] = 1;
    //     for (int i = 2; i <= n; i++){
    //         dp[i] = dp[i-1] +dp[i-2];
    //     }
    //     return dp[n];
    // }
    // public int climbStairs(int n) {
    //     //因为后面取值的时候是根据n取值的
    //     //如果长度是n的话，就会取值方式是n-1
    //     //所以当n=0时，取值报错了
    //     //所以是n+1
    //     int[] memo = new int[n+1];
    //     return climbStairsMemo(n,memo);
    // }
    // private int climbStairsMemo(int n, int[] memo) {
    //     if (memo[n] > 0) {
    //         return memo[n];
    //     }
    //     if (n == 1) {
    //         memo[1] = 1;
    //         return memo[1];
    //     }
    //     else if (n == 2) {
    //         memo[2] = 2;
    //         return memo[2];
    //     }
    //     else if(n > 2) {
    //         memo[n] = climbStairsMemo(n-1, memo) + climbStairsMemo(n-2, memo);
    //     }
    //     return memo[n];
    // }
}
// @lc code=end

