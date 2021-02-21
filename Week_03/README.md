#递归

运用递归解题的关键就是要**寻找最近重复子问题**。
以题目：二叉树的最小深度为例。求一棵二叉树的最小深度，其最近重复子问题就是求以根节点的左右孩子构成的左右子树的最小深度，然后取其中更小的值+1，就是最终答案。

**递归的代码模板：**

`public void recur(int level, int param) { 
   // 递归的终止条件
   if (level > MAX_LEVEL) { 
     // 结果处理
     return; 
   }
   // 在当前递归层处理逻辑
   process(level, param); 
   // 向下层递归 
   recur(level: level + 1, newParam); 
   // 在某些场景里，底层递归向上返回后需要在上一层做状态的回滚，但这视情况而定，并不是必须的
   restore(param);
 }`
 
 #分治
 分治算法以递归的方式来实现，因此也需要挖掘出问题的最近重复子问题。将一个大问题，拆分成更多子问题，并以同样的方式取解决子问题，最终合并子问题的结果来得到问题的最终结果。
 以题目：Pow(x,n)为例。求2^10可以拆分成求2^5✖2^5。 求2^5可以拆分成求2^2×2^2×2^1。 求2^2可以拆分成求2^1×2^1。因此这道题拆分成子问题后还需要考虑幂的奇偶性。
 **分治的代码模板：** 
 
`public void divide_conquer(problem, param) { 
     // 递归的终止条件即子问题无法再继续拆解了
     if (problem can't be splitted) {
       // 结果处理
       return; 
     }
     //拆分子问题
     data = prepare(problem); 
     subproblems = splitProblem(problem,data);
     //子问题递归
     subResult1 = divide_conquer(subproblems[0],param);
     subResult2 = divide_conquer(subproblems[1],param);
     ...
     //合并结果
     result = mergeResult(subResult1, subResult2...);
     // 在某些场景里，底层递归向上返回后需要在上一层做状态的回滚，但这视情况而定，并不是必须的
     restore(param);
 }`
