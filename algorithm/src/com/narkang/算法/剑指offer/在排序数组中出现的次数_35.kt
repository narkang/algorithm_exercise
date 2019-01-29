package com.narkang.算法.剑指offer

/**
 * 在排序数组中出现的次数
 * 统计一个数字：在排序数组中出现的次数。
 *举例说明
 *例如输入排序数组｛ 1, 2, 3, 3, 3, 3, 4, 5｝和数字3 ，由于3 在这个数组中出现了4 次，因此输出4 。
 */
/**注意数组是排序的，所以找第一个k和最后一个k的位置就可以了
   二分查找
   （一）找第一个K，二分查找，找到中间的数字mid
   1、mid>k，则k在数组前半段
   2、mid<k，则k在数组后半段
   3、mid = k，判断k是不是第一个，（1）如果中间数字前面的数不是k，则k=mid；（2）如果中间数字前面的一个数是k，则k在前半段
   （二）找最后一个K，二分查找，找到中间的数字mid
   1、mid>k，则k在数组前半段
   2、mid<k，则k在数组后半段
   3、mid = k，判断k是不是最后一个，（1）如果中间数字后面的数不是k，则k=mid；（2）如果中间数字后面的一个数是k，则k在后半段
   */
fun main(args: Array<String>) {

   var array = intArrayOf(1, 2, 3, 3, 3, 3, 4, 5)
   println(getKeyNum(array, 3))

}

fun getKeyNum(array: IntArray, key:Int): Int{
   var keyNum = 0

   if(array.isNotEmpty()){
      var first = getFirstKey(array, 0, array.size, key)
      var end = getLastKey(array, 0, array.size, key)
      keyNum = end - first + 1
   }

   return keyNum
}

fun getFirstKey(array: IntArray, _start: Int, _end: Int, key: Int): Int{

   var start = _start
   var end = _end

   if(start > end){
      return -1
   }

   var midIndex = (start + end) / 2
   //查找最前面的数字
   if(array[midIndex] == key){
      if((midIndex > 0 && array[midIndex - 1] != key) || midIndex == 0){
         return midIndex
      }else{
         end = midIndex - 1
      }
   }else if(array[midIndex] > key){
      end = midIndex - 1
   }else{
      start = midIndex + 1
   }

   return getFirstKey(array, start, end, key)
}


fun getLastKey(array: IntArray, _start: Int, _end: Int, key: Int): Int{

   var start = _start
   var end = _end

   if(start > end){
      return -1
   }

   var midIndex = (start + end) / 2
   //查找最后面的数字
   if(array[midIndex] == key){
      if((midIndex < array.size - 1 && array[midIndex + 1] != key) || midIndex == array.size - 1){
         return midIndex
      }else{
         start = midIndex + 1
      }
   }else if(array[midIndex] > key){
      end = midIndex - 1
   }else{
      start = midIndex + 1
   }

   return getLastKey(array, start, end, key)
}
