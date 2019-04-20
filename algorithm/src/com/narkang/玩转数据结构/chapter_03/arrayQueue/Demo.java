package com.narkang.玩转数据结构.chapter_03.arrayQueue;

public class Demo {

    public static void main(String[] args) {

        ArrayQueue<Integer> queue = new ArrayQueue<>();

        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
            System.out.println(queue);
            if(i % 3 == 2){
                queue.dequeue();
                System.out.println(queue);
            }
        }

    }

}
