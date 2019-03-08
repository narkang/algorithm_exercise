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

    /**
     *  在index索引处添加元素
     */
    public void add(int index, T e){

        if(size == data.length){
            throw new IllegalArgumentException("Add failed. Array is full.");
        }

        if(index < 0 || index > size){
            throw new IllegalArgumentException("Add failed. Require index >= 0 and index <= size.");
        }

        for (int i = size - 1; i>=index; i--){
            data[i+1] = data[i];
        }

        data[index] = e;
        size++;
    }

    /**
     *  在所有元素前添加一个新元素
     */
    public void addFirst(T e){
        add(0, e);
    }

    /**
     *  在所有元素后面添加一个新元素
     */
    public void addLast(T e){
        add(size, e);
    }
}