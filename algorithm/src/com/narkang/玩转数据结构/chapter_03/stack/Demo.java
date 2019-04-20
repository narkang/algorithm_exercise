package com.narkang.玩转数据结构.chapter_03.stack;

/**
 *  栈相关测试代码
 */
public class Demo {

    public static void main(String[] args) {

        ArrayStack<Integer> stack = new ArrayStack<>();

        for (int i = 0; i < 5; i++) {
            stack.push(i);
            System.out.println(stack);
        }

        stack.pop();
        System.out.println(stack);
        System.out.println(stack.peek());
    }

}
