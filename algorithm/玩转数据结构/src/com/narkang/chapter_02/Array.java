package com.narkang.chapter_02;

class Array<T> {

    private T[] data;  //维护的数据
    private int size;  //维护的数据容量大小

    public Array(int capacity){
        data = (T[]) new Object[capacity];
        size = 0;
    }

    /**
     * 无参构造方法，默认容量大小为10
     */
    public Array(){
        this(10);
    }

    /**
     * 获取容器的长度
     */
    public int getCapacity(){
        return data.length;
    }

    /**
     * 获取数组可以存放元素的个数
     */
    public int getSize(){
        return size;
    }

    /**
     *  返回数组是否为空
     */
    public boolean isEmpty(){
        return size == 0;
    }
}