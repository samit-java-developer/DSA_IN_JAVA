package com.samit.queue;

import java.util.Arrays;

class Queue<T>{
    int front,size,capacity;
    T[] arr;
    // via not maintaining rear, we calculate rear based on front and size value.
    public Queue(int n){
        this.front=0;
        this.size=0;
        this.capacity=n;
        this.arr=(T[]) new Object[n];
    }

    boolean isFull(Queue queue){
        return queue.size==queue.capacity;
    }

    boolean isEmpty(Queue queue){
        return queue.size==0;
    }

    // method to add an item in the queue
    // to change rear and size
    void enqueue(T item){
        if (isFull(this))
            throw new IllegalStateException("Queue is full");

        int rear=(this.front+this.size)%this.capacity;
        this.arr[rear]=item;
        this.size++;
        System.out.println(item+ " enqueued to queue");
    }

    T dequeue(){
        if (isEmpty(this))
            throw new IllegalStateException("Queue is empty");
        T item=this.arr[this.front];
        this.arr[this.front]=null;
        this.front=(this.front+1)%this.capacity;
        this.size--;
        return item;
    }

    T front() {
        if (isEmpty(this))
            throw new IllegalStateException("Queue is empty");
        return this.arr[this.front];
    }

    T rear() {
        if (isEmpty(this))
            throw new IllegalStateException("Queue is empty");
        return this.arr[this.front+this.size];
    }
}

public class QueueImplementationViaArr {
    public static void main(String[] args) {
        Queue<Integer> queue=new Queue<>(4);
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        System.out.println(Arrays.toString(queue.arr));
        queue.dequeue();
        System.out.println(Arrays.toString(queue.arr));
        queue.enqueue(50);
        System.out.println(Arrays.toString(queue.arr));
        queue.dequeue();
    }
}
