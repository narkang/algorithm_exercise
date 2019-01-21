package com.narkang.算法

/**
 * 在字符串中找出第一个只出现一次的字符。
 *
 * 由于题目与字符出现的次数相关， 我们是不是
 * 可以统计每个字符在该字符串中出现的次数？要达到这个目的，我们需要一个数据容器来存放每个
 * 字符的出现次数。在这个数据容器中可以根据字符来查找它出现的次数，也就是说这个容器的作用
 * 是把一个字符映射成二个数字。在常用的数据容器中， 哈希表正是这个用途。 为了解决这个问题，
 * 我们可以定义哈希表的键（Key）是字符， 而值(Value ）是该字符出现的次数。同时我们还需要从
 * 头开始扫描字符串两次。第一次扫描字符串时，每扫描到一个字符就在哈希表的对应项中把次数加1 。
 * 接下来第二次扫描时， 每扫描到一个字符就能从哈希表中得到该字符出现的次数。这样第一个只出现
 * 一次的字符就是符合要求的输出。 第一次扫描时，在哈希表中更新一个字符出现的次数的时间是O(n) 。
 * 如果字符串长度为n， 那么第一次扫描的时间复杂度是O(n)。第二次扫描时，同样0(1)能读出一个字符
 * 出现的次数，所以时间复杂度仍然是O(n)。这样算起来，总的时间复杂度是O(n)。
 *
 * https://blog.csdn.net/baidu_34122324/article/details/82891280
 */
fun main(args: Array<String>) {

    var str = "sdfgbsdkfgdfgv"
    printFirstLetter(str)
    println("----------------")
    printFirstLetter2(str)

//    var hashMap = LinkedHashMap<Char, Int>()
//    hashMap['b'] = 1
//    hashMap['a'] = 1
//    hashMap['d'] = 1
//    hashMap['c'] = 1
//    hashMap['f'] = 1
//    hashMap['e'] = 1
//    hashMap['k'] = 1
//    hashMap['j'] = 1
//    hashMap['w'] = 1
//    hashMap['q'] = 1
//    hashMap['p'] = 1
//    hashMap['u'] = 1
//
//    var keys = hashMap.keys
//    keys.forEach(::println)

//    var entries = hashMap.entries
//    for (e in entries) {
//        if(e.value == 1){
//            println("key是${e.key},value是${e.value}")
//        }
//    }
}

fun printFirstLetter(str: String) {

    var hashMap: HashMap<Char, Int> = HashMap()

    //第一次扫描
    for (c in str) {
        if (hashMap.containsKey(c)) {
            val value = hashMap[c]
            hashMap[c] = value!!.plus(1)
        } else {
            hashMap[c] = 1
        }
    }

    //第二次扫描
    var entries = hashMap.entries
    for (e in entries) {
        if(e.value == 1){
            println("第一个第一次出现的字符是${e.key}")
            return
        }
    }
}

//用类似哈希表的方式用来统计字符出现的次数，时间复杂度O(n)
fun printFirstLetter2(str: String){

    var hash = IntArray(255)

    str.forEach {
        hash[it.toInt()] = hash[it.toInt()]!!.plus(1)
    }

    str.forEach {
        if(hash[it.toInt()] == 1){
            println("第一个第一次出现的字符是$it")
            return
        }
    }
}