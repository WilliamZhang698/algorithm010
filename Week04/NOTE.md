# 深度、广度优先搜索的实现和特性

### 算法是作用于具体数据结构之上的，深度优先搜索算法和广度优先搜索算法都是基于“图”这种数据结构的。这是因为，图这种数据结构的表达能力很强，大部分涉及搜索的场景都可以抽象成“图”。
	
## 搜索 遍历
- 每个节点都要访问一次
- 每个节点仅仅要访问一次
- 对于节点的访问顺序不限
    - 深度优先 depth first search
    - 广度优先 breadth first search
    - 优先级优先？？？--》启发式搜索？？？ 估价函数？？？--》深度学习？？？ 推荐算法，高级搜索算法

### 深度优先 depth first search

- 递归方式(隐含的使用了系统的栈，不需要维护自己的数据结构)

``` java
    void dfs(TreeNode root) {
        //terminator
    if (root == null) {
        return;
    }
    // drill down 
    dfs(root.left);
    dfs(root.right);
}

```
- 非递归 用栈维护一个递归


### 广度优先 breadth first search
- 用队列表示，具象的角度
- 队列 更多的就是一个数组，在java中用到更多的是链表，双端队列deque来表示，python 用数组来表示

``` java
    void bfs(TreeNode root) {
    Queue<TreeNode> queue = new ArrayDeque<>();
    queue.add(root);
    while (!queue.isEmpty()) {
        TreeNode node = queue.poll(); // Java 的 pop 写作 poll()
        if (node.left != null) {
            queue.add(node.left);
        }
        if (node.right != null) {
            queue.add(node.right);
        }
    }
}
```