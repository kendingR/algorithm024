学习笔记

双向BFS相比BFS，就是以BFS的起点和终点均作为出发点，向中间靠拢，当双方相遇时即求得解。
在具体实现上，不同于BFS用队列来维护每一层要向外搜索的节点，双向BFS通过判断一边搜索到的节点是否在另一边已经搜索过的路径上来判断是否求得解，因此用哈希表的结构来维护从起点和终点出发所走过的路径上的节点会更为恰当。

###### 双向BFS模板：
```
def bidirectionalBFS(startSet, endSet, target){
     step = 0;
     while(!startSet.isEmpty() && !endSet.isEmpty()){
         ++step;
         if(startSet.size > endSet.size()){
             swap(startSet, endSet);
         }
         tempSet = new HashSet();
         for(s: startSet){
             t = process(s);
             if(endSet.contains(t)){
                 return ++step;
             }
             tempSet.add(t);
         }
         startSet = tempSet;
     }
 }
```

