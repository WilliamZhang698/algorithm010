学习笔记

### DP 顺推模板

``` java
    function DP():
        dp = [][] # ⼆维情况
        for i = 0 .. M {
        for j = 0 .. N {
        dp[i][j] = _Function(dp[i’][j’]…)
        }
        }
    return dp[M][N];

```

## 关键点

### 动态规划 和 递归或者分治 没有根本上的区别（关键看有无最优的子结构）
- 拥有共性：找到重复子问题
- 差异性：最优子结构、中途可以淘汰次优解

### 复杂度来源
- 1. 状态拥有更多维度（二维、三维、或者更多、甚至需要压缩）
- 2. 状态方程更加复杂
## 本质：内功、逻辑思维、数学

### 不同路径2 状态转移方程

``` java
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length, m = obstacleGrid[0].length;
        int[] f = new int[m];

        f[0] = obstacleGrid[0][0] == 0 ? 1 : 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (obstacleGrid[i][j] == 1) {
                    f[j] = 0;
                    continue;
                }
                if (j - 1 >= 0 && obstacleGrid[i][j - 1] == 0) {
                    f[j] += f[j - 1];
                }
            }
        }
        
        return f[m - 1];
    }

```

### Atoi 

``` java 

    // Java
public int myAtoi(String str) {
    int index = 0, sign = 1, total = 0;
    //1. Empty string
    if(str.length() == 0) return 0;
    //2. Remove Spaces
    while(str.charAt(index) == ' ' && index < str.length())
        index ++;
    //3. Handle signs
    if(str.charAt(index) == '+' || str.charAt(index) == '-'){
        sign = str.charAt(index) == '+' ? 1 : -1;
        index ++;
    }
    
    //4. Convert number and avoid overflow
    while(index < str.length()){
        int digit = str.charAt(index) - '0';
        if(digit < 0 || digit > 9) break;
        //check if total will be overflow after 10 times and add digit
        if(Integer.MAX_VALUE/10 < total ||            
        	Integer.MAX_VALUE/10 == total && Integer.MAX_VALUE %10 < digit)
            return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        total = 10 * total + digit;
        index ++;
    }
    return total * sign;
}
```

