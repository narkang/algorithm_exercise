package com.narkang.玩转数据结构.chapter_02;

class Demo{

    public static void main(String[]args){

        Array<Integer> data = new Array();

        System.out.println(data.toString());
        System.out.println(data.getCapacity());
        System.out.println(data.getSize());

        data.addFirst(1);
        data.addFirst(2);
        data.addFirst(3);
        data.addFirst(4);

        data.addLast(5);
        data.addLast(6);

        System.out.println(data.toString());
        System.out.println(data.getCapacity());
        System.out.println(data.getSize());

        System.out.println("--------------");
        data.set(5, 7);
        System.out.println(data.get(5));
        System.out.println(data.toString());

        System.out.println("--------------");
        data.remove(3);
        System.out.println(data.toString());
        data.removeFirst();
        System.out.println(data.toString());
        data.removeLast();
        System.out.println(data.toString());
    }
}
