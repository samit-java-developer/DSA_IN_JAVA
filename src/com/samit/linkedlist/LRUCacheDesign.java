package com.samit.linkedlist;

import java.util.HashMap;
import java.util.Map;

public class LRUCacheDesign {
    static class LRUNode{
        int key;
        int value;
        LRUNode prev;
        LRUNode next;
        public LRUNode(int key,int value){
            this.key=key;
            this.value=value;
        }
    }
    Map<Integer,LRUNode> map=new HashMap<>();
    int capacity,count;
    LRUNode head,tail;
    public LRUCacheDesign(int capacity){
        this.capacity=capacity;
        this.count=0;
        this.head=new LRUNode(0,0);
        this.tail=new LRUNode(0,0);
        head.next=tail;
        tail.prev=head;
        tail.next=null;
        head.prev=null;
        this.count=0;
    }

    public void deleteNode(LRUNode node){
        node.prev.next=node.next;
        node.next.prev=node.prev;
    }

    public void addToHead(LRUNode node){
        node.next=head.next;
        node.prev=head;
        head.next=node;
        node.next.prev=node;
    }

    public int get(int key){
        if (map.get(key)!=null){
            LRUNode node=map.get(key);
            int result=node.value;
            deleteNode(node);
            addToHead(node);
            return result;
        }else{
            System.out.println("Did not get any value for the key"+key);
        }
        return -1;
    }

    public void set(int key,int value){
        System.out.println("Going to set the (key, "+ "value) : (" + key+","+value+" )");
        if (map.get(key)!=null){
            LRUNode node=map.get(key);
            node.value=value;
            addToHead(node);
            deleteNode(node);
        }else{
            LRUNode node=new LRUNode(key, value);
            map.put(key,node);
            if (count<capacity){
                addToHead(node);
                count++;
            }else{
                map.remove(tail.prev.key);
                deleteNode(tail.prev);
                addToHead(node);
            }
        }
    }

    public static void main(String[] args) {
        LRUCacheDesign cache = new LRUCacheDesign(2);

        // it will store a key (1) with value
        // 10 in the cache.
        cache.set(1, 10);
        // it will store a key (2) with value 20 in the cache.
        cache.set(2, 20);
        System.out.println("Value for the key: 1 is " + cache.get(1)); // returns 10
        // removing key 2 and store a key (3) with value 30 in the cache.
        cache.set(3, 30);
        System.out.println("Value for the key: 2 is " + cache.get(2)); // returns -1 (not found)
        // removing key 1 and store a key (4) with value 40 in the cache.
        cache.set(4, 40);
        System.out.println("Value for the key: 1 is " + cache.get(1)); // returns -1 (not found)
        System.out.println("Value for the key: 3 is " + cache.get(3)); // returns 30
        System.out.println("Value for the key: 4 is " + cache.get(4));
    }
}
