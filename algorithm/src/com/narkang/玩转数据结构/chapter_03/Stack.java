package com.narkang.玩转数据结构.chapter_03;

public interface Stack<E> {

    /**
     * 获取以存储元素的大小
     * @return
     */
    int getSize();

    /**
     * 栈是否为空
     * @return
     */
    boolean isEmpty();

    /**
     * push元素
     * @param e
     */
    void push(E e);

    /**
     * pop元素
     * @return
     */
    E pop();

    /**
     * 查看栈顶元素
     * @return
     */
    E peek();
}
