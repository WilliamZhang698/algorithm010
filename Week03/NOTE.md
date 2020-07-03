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

			- 思维要点

				- 1、不要人肉进行递归（最大误区）
				- 2、找到最近最简方法，将其拆解成可重复解决的问题（重复子问题）
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

## 算法思想

### 分治算法

### 动态规划

- 最近重复性

### 回溯算法

## 搜索

## 查找


## 字符串匹配

## 排序

## 复杂度分析

*XMind - Trial Version*