package com.ken.LRU;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    Map<Integer, Node> map;
    //伪节点方便节点位置变更时双向指针的赋值
    Node dummyHead;
    Node dummyTail;
    int capacity; //LRUCache的容量上限

    //初始化缓存
    public LRUCache(int capacity) {
        map = new HashMap<>(capacity);
        this.capacity = capacity;
        dummyHead = new Node();
        dummyTail = new Node();
        dummyHead.next = dummyTail;
        dummyTail.pre = dummyHead;
    }

    //获取缓存元素
    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        Node node = map.get(key);
        removeNode(node);
        moveToHead(node);
        return node.val;
    }
    //插入缓存元素
    public void put(int key, int value) {
        if (!map.containsKey(key)) {
            Node node = new Node(key,value);
            map.put(key, node);
            moveToHead(node);
            if (map.size() > capacity) {
                Node tail = dummyTail.pre;
                removeNode(tail);
                map.remove(tail.key);
            }
        } else {
            Node node = map.get(key);
            node.val = value;
            removeNode(node);
            moveToHead(node);
        }
    }
    //将节点移至头部
    private void moveToHead(Node node) {
        node.next = dummyHead.next;
        node.pre = dummyHead;
        dummyHead.next.pre = node;
        dummyHead.next = node;
    }
    //解除节点在链表中前后的关联
    private void removeNode(Node node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    class Node {
        int key;
        int val;
        Node pre;
        Node next;
        public Node() {}
        public Node(int key,int val) {
            this.key = key;
            this.val = val;
        }
    }
}
