# 数据结构&算法

## 存储结构 

### 顺序存储

- 数组

### 链式存储

- 链表

## 逻辑结构

### 线性结构

- 栈
- 队列

### 非线性结构

- 散列表

	- 数组的一种扩展

	  散列表用的是数组支持按照下标随机访问数据的特性，所以散列表其实就是数组的一种扩展，由数组演化而来。可以说，如果没有数组，就没有散列表。

	- 复杂度分析

		- Time

			- Average 增删查O(1)
			- Worst 增删查O(n)

		- Space

			- Worst O(n)

	- 散列冲突 solutions

		- 开放寻址法
		- 拉链法

	- 散列函数

		- 基本要求

			- 1、计算得到的散列值是一个非负整数；

			  数组的角标是从0开始；

			- 2、如果 key1 = key2，那 hash(key1) == hash(key2)；
			- 3、如果 key1 ≠ key2，那 hash(key1) ≠ hash(key2)。（散列冲突时除外）

		- 著名哈希算法

			- MD5
			- SHA
			- CRC

	- 应用

		- Java

			- HashMap

			  散列表+链表

			- ConcurrentHashMap
			- TreeMap
			- TreadlocalMap
			- LinkedHashMap

			  散列表+链表+双向链表

		- Redis

			- 散列表+跳表

- 树（二维数据结构）

	- 概念

		- 高度(Height)：从叶子节点到根节点，0-->N
		- 深度(Depth)：从根节点到叶子节点, 0-->N
		- 层级(Level)：从根节点到叶子节点，1-->N+1

	- 特点

		- Linked List 是特殊化的tree
		- tree 是特殊化的图Graph

	- 解法

		- 递归(recursion)

		  本质：寻找重复性-->计算机指令集

			- 思维要点

				- 1、不要人肉进行递归（最大误区）
				- 2、找到最近最简方法，将其拆解成可重复解决的问题（重复子问题）

				  最近的理解：想象成 找 最大公约数

				- 3、数学归纳法思维

			- 代码模板

			  递归终结条件
			  处理当前层逻辑
			  下探到下一层
			  清理当前层
			  
			  // Java
			  public void recur(int level, int param) { 
			    // terminator 
			    if (level > MAX_LEVEL) { 
			      // process result 
			      return; 
			    }
			    // process current logic 
			    process(level, param); 
			    // drill down 
			    recur( level: level + 1, newParam); 
			    // restore current status 
			   
			  }

	- 二叉树(Binary Tree)

		- 存储 solution

			- 基于指针或者引用的二叉链式存储法
			- 基于数组的顺序存储法

			  1、下标索引从1开始：
			  	父节点：i/2
			  	左子节点：2*i
			  	右子节点：2*i + 1
			  2、适用于完全二叉树，这样存储空间是最小的。
			  3、优势：不用存储左右子节点的指针，减少内存空间。

		- 遍历

			- 广度优先（Breadth First Search）
			- 深度优先（Depth First Search）

				- 先/前序遍历（Pre-order）

				  private void helper(TreeNode root, List<Integer> res) {
				          if (root != null) {
				              res.add(root.val);
				              helper(root.left, res);
				              helper(root.right, res);
				          }
				      }

				- 中序遍历（In-order）

				  public void helper(TreeNode treedNode, List<Integer> res) {
				          if ( treedNode != null) {
				              helper(treedNode.left, res);
				              res.add(treedNode.val);
				              helper(treedNode.right, res);
				          }
				      }

				- 后序遍历（Post-order）

				  public void helper(TreeNode treedNode, List<Integer> res) {
				      if ( treedNode != null) {
				        helper(treedNode.left, res);
				        helper(treedNode.right, res);
				  			res.add(treedNode.val);
				      }
				    }

		- 形态

			- 二叉搜索树

				- 特点

				  二叉搜索树要求，在树中的任意一个节点，其左子树中的每个节点的值，都要小于这个节点的值，而右子树节点的值都大于这个节点的值。
				  
				  二叉搜索树的中序遍历是 升序遍历

			- 完全二叉树

			  定义：叶子节点都在最底下两层，最后一层的叶子节点都靠左排列，并且除了最后一层，其他层的节点个数都要达到最大

				- 应用场景

					- 堆（Heap）

			- 满二叉树

			  1、叶子节点都在最底层
			  2、特殊的完全二叉树

	- 多路查找树
	- 堆（Heap）常见二叉堆，所以暂放此分支

	  可以迅速找到一堆数中的最大或者最小值的数据结构

		- 二叉堆

			- 特点

				- 完全二叉树：用数组存储
				- 当前节点 >=（<=）左右子节点

			- 分类

				- 大顶堆、大根堆-->API

					- find-max：O(1)
					- delete-max: O(logN)
					- insert(create): O(logN) or O(1)

				- 小顶堆、小根堆

		- 斐波那契堆
		- 其他

- 图（二维数据结构）

  与树的区别：图有环

## 其他

### 位运算

- 位运算符

	- 移位运算

	  对移位运算符右侧的参数需要进行模32的运算（按照左侧的操作数类型决定的，例如long类型，需要模64）。
	  eg：1<<35与 1<<3或8是相同的。

		- 左移（左移一位 相当于*2） <<

			- 0011 => 0110

		- 无符号右移 >>>

		  无 符 号 右 移 ： 操 作 符 为 > > > ， 向 右 移 动 ， 右 边 的 舍 弃 掉 ， 左 边 补 0 。

		- 右移（右移一位） >>

		  有 符 号 右 移 ： 操 作 符 为 > > ， 向 右 移 动 ， 右 边 的 舍 弃 掉 ， 左 边 补 什 么 取 决 于 原 来 最 高 位 是 什 么 ， 原 来 是 1 就 补 1 ， 原 来 是 0 就 补 0 ， 将 二 进 制 看 作 整 数 ， 右 移 1 位 相 当 于 除 以 2 。

			- 0110 => 0011

	- 逻辑运算

		- 按位或(只要有一位为1，就为1) |

			- 0011 | 1011 => 1011

		- 按位与(两位都为1才为1) &

			- 0011 & 1011 => 0011

		- 按位取反 ~

			- ~0011 => 1100

		- 按位异或(相异为真，相同为假；不进位加法) ^

			- 0011 ^ 1011 => 1000
			- XOR异或

			  异或：相同为0 ，不同为 1 。也可用 不进位加法 来理解。
			  异或操作的一些特点:
			  x ^ 0 = x
			  x ^ 1s = ~x //注意 1s = ~0
			  x ^ (~x) = 1s
			  x ^ x = 0
			  c = a ^ b => a ^ c = b, b ^ c = a  //交换两个数
			  a ^ b ^ c = a ^ (b ^ c) = (a ^ b) ^ c // associative

- 移位

	- 逻辑移位

		- 逻辑左移和逻辑右移，移出的空位都用0来补

	- 算数移位

		- 无符号型值

			- 算术移位等同于逻辑移位

		- 有符号型值 

			- 算术左移等同于逻辑左移
			- 算术右移补的是符号位，正数补0，负数补1

- 指定位置的位运算

	- 1.将x最右边的n位清零：x&(~0<<n)
	- 2.获取x的第n位值（0或者1）：(x>>n)&1
	- 3.获取x的第n位的幂值：x&(1>>n)
	- 4.仅将第n位置为1：x|(1<<n)
	- 5.仅将第n位置为0：x&(~(1<<n))
	- 6.将x最高位至第n位（含）清零：x&((1<<n)-1)
	- 7.将第n位至第0位（含）清零：x&(~((1<<(n+1))-1))

- 实战位运算要点

	- 判断奇偶

		- x%2==1——>(x&1)==1
		- x%2==0——>(x&1)==0

	- x/2——>x>>1

		- x = x / 2; ——> x = x >>1
		- mid=(left+right)/2;——>mid=(left+right)>>1；

	- 清零最低位的1

		- X=X&(X-1)

	- 得到最低位的1

		- X&-X

	- 结果为0

		- X & ~X

## 算法思想

### 分治算法

### 动态规划

- 概念

	- 最近重复性
	- 可以回退
	- 当前选择最优

- 顺推形式：动态递推

	- DP顺推模板

	  function DP():
	  dp = [][] # ⼆维情况//难点1：状态定义，现实问题定义为一个数组，保存状态；
	  for i = 0 .. M {
	  for j = 0 .. N {
	  dp[i][j] = _Function(dp[i’][j’]…)//难点2：状态转移方程怎么写：相加，小循环，etc
	  }
	  }
	  return dp[M][N];

### 回溯算法

回溯法采用试错的思想，它尝试分步的去解决一个问题。在分步解决问题的过程中，当
它通过尝试发现现有的分步答案不能得到有效的正确的解答的时候，它将取消上一步甚
至是上几步的计算，再通过其它的可能的分步解答再次尝试寻找问题的答案。
回溯法通常用最简单的递归方法来实现，在反复重复上述的步骤后可能出现两种情况：
• 找到一个可能存在的正确的答案
• 在尝试了所有可能的分步方法后宣告该问题没有答案
在最坏的情况下，回溯法会导致一次复杂度为指数时间的计算。

- 可以回退

### 贪心算法

- 特点

	- 不可以回退
	- 当前选择最优

- 应用（解决最优化场景）

  问题可以分解为子问题解决
  子问题的最优解能递推到最终问题的最优解
  子问题最优解称为最优子结构

	- 求图中的最小生成树
	- 求哈夫曼编码
	- 一般作为辅助算法|对结果要求不是很精确的问题
	- 一般能用贪心算法解决的问题，那么贪心算法即是最优解

## 搜索

### 广度优先（breadth first search）

### 深度优先（depth first search）

直观例子：走迷宫，当处于某个岔路口时，选择一条，走不通，回到当初岔路口，继续走。

### 高级搜索

- 启发式搜索（Heuristic Search (A*)）

	- 代码模板

		- A* search代码模板

		  A* search
		  def AstarSearch(graph, start, end):
		  pq = collections.priority_queue() # 优先级 —> 估价函数
		  pq.append([start])
		  visited.add(start)
		  while pq:
		  node = pq.pop() # can we add more intelligence here ?
		  visited.add(node)
		  process(node)
		  nodes = generate_related_nodes(node)
		  unvisited = [node for node in nodes if node not in visited]
		  pq.push(unvisited)

		- 基于 BFS 代码模板

		  def BFS(graph, start, end):
		  queue = []
		  queue.append([start])
		  visited.add(start)
		  while queue:
		  node = queue.pop() # can we add more intelligence here ?
		  visited.add(node)
		  process(node)
		  nodes = generate_related_nodes(node)
		  queue.push(nodes)

	- 估价函数

		- 启发式函数： h(n)，它用来评价哪些结点最有希望的是一个我们要找的结点，h(n) 会返回一个非负实数,也可以认为是从结点n的目标结点路径的估计成本。
		- 启发式函数是一种告知搜索方向的方法。它提供了一种明智的方法来猜测哪个邻居结点会导向一个目标。

- 并查集（Disjoint Set）

	- 基本操作

	  • makeSet(s)：建立一个新的并查集，其中包含 s 个单元素集合。
	  • unionSet(x, y)：把元素 x 和元素 y 所在的集合合并，要求 x 和 y 所在
	  的集合不相交，如果相交则不合并。
	  • find(x)：找到元素 x 所在的集合的代表，该操作也可以用于判断两个元
	  素是否位于同一个集合，只要将它们各自的代表比较一下就可以了。

	- 场景

		- 组团、配对问题

## 查找

### 二分查找

- 前提

  必须是有序的

	- 1、目标函数单调性（单调递增或者递减）
	- 2、存在上下界（bounded）
	- 3、能够通过索引访问（index accessible）

- 代码实现

  最简单的情况：
  1、就是有序数组
  2、不存在重复元素

	- 迭代方式（内含3个易错点）

	  public int bsearch(int[] a, int n, int value) {
	   int low = 0;
	   int high = n - 1;
	  
	   while (low <= high) {
	    int mid = (low + high) / 2;
	    if (a[mid] == value) {
	     return mid;
	    } else if (a[mid] < value) {
	     low = mid + 1;
	    } else {
	     high = mid - 1;
	    }
	   }
	  
	   return -1;
	  }

		- 1. 循环退出条件

		  注意是 low<=high，而不是 low<high。

		- 2.mid 的取值

		  实际上，mid=(low+high)/2 这种写法是有问题的。因为如果 low 和 high 比较大的话，两者之和就有可能会溢出。改进的方法是将 mid 的计算方式写成 low+(high-low)/2。更进一步，如果要将性能优化到极致的话，我们可以将这里的除以 2 操作转化成位运算 low+((high-low)>>1)。因为相比除法运算来说，计算机处理位运算要快得多。

		- 3.low 和 high 的更新

		  low=mid+1，high=mid-1。注意这里的 +1 和 -1，如果直接写成 low=mid 或者 high=mid，就可能会发生死循环。比如，当 high=3，low=3 时，如果 a[3]不等于 value，就会导致一直循环不退出。

	- 递归方式

	  // 二分查找的递归实现
	  public int bsearch(int[] a, int n, int val) {
	   return bsearchInternally(a, 0, n - 1, val);
	  }
	  
	  private int bsearchInternally(int[] a, int low, int high, int value) {
	   if (low > high) return -1;
	  
	   int mid = low + ((high - low) >> 1);
	   if (a[mid] == value) {
	    return mid;
	   } else if (a[mid] < value) {
	    return bsearchInternally(a, mid+1, high, value);
	   } else {
	    return bsearchInternally(a, low, mid-1, value);
	   }
	  }

- 应用场景的局限性

	- 1、依赖顺序表结构，eg:数组
	- 2、有序数据，针对动态数据不适用，需要维护有序性
	- 3、数据量太小不适合，与遍历时间相仿，但是如果比较功能耗时的话，可以考虑使用二分
	- 4、数据量太大不适用，因为需要在内存分配连续的大容量数组

## 字符串匹配

### 字典树(Trie)

字典树，又称单词查找树或者键树，是一种树形结构。典型应用是用于统计和排序大量的字符串（但不仅限于字符串），所以经常被搜索引擎系统用于文本词频统计。
优点：最大限度地减少无谓的字符串比较，查询效率比哈希表高。

- 基本性质

  1. 结点本身不存完整单词；
  2. 从根结点到某一结点，路径上经过的字符连接起来，为该结点对应的
  字符串；
  3. 每个结点的所有子结点路径代表的字符都不相同。

- 数据结构
- 核心思想

  Trie 树的核心思想是空间换时间。
  利用字符串的公共前缀来降低查询时间的开销以达到提高效率的目的。

### 字符串匹配算法

- 1. 暴力法（brute force） - O(mn)
- 2. Rabin-Karp 算法
- 3. KMP 算法
- Boyer-Moore 算法

## 排序

## 复杂度分析

