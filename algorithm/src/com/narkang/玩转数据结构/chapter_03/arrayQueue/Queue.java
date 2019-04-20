package com.narkang.玩转数据结构.chapter_03.arrayQueue;

/**
 * 队列
 * @param <E>
 */
public interface Queue<E> {

    int getSize();

    boolean isEmpty();

    /**
     *  入队
     * @param e
     */
    void enqueue(E e);

    /**
     * 出队
     * @return
     */
    E dequeue();

    E getFront();

}
